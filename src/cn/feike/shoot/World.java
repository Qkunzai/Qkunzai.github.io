package cn.feike.shoot;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends JPanel{
	private FlyingObject[] flyingObjects;//������(��:��С�ɻ�,�۷��)
	private Bullet[] bullets;//�ӵ�����
	private Hero hero;//Ӣ�۷ɻ�
	private Sky sky;//һƬ���
	private long nextTime;//��һʱ�̵�ʱ��
	private long nextShootTime;//��һʱ���ӵ������ʱ��
	private Timer timer;//��ʱ��
	
	/** �Ʒֱ���*/
	private int score = 0;//����
	private int life = 3;//��
	private int fireType = 1;//�ӵ���ʼʱΪ��ǹ
	
	/** ��Ϸ��״̬*/
	public static final int READY = 0;//��ʼ״̬
	public static final int RUNNING = 1;//����״̬
	public static final int PAUSE = 2;//��ͣ״̬
	public static final int GAME_OVER = 3;//����״̬
	private int state = READY;//��Ϸ״̬
	
	/** ���ؿ�ʼ,��ͣ,������������Ƭ */
	private static BufferedImage pause;//��ͣ
	private static BufferedImage ready;//��ʼ
	private static BufferedImage gameOver;//����
	
	static{
		try {
			String png = "cn/feike/shoot/start.png";
			ready = ImageIO.read(World.class.getClassLoader().getResourceAsStream(png));
			png = "cn/feike/shoot/pause.png";
			pause = ImageIO.read(World.class.getClassLoader().getResourceAsStream(png));
			png = "cn/feike/shoot/gameover.png";
			gameOver = ImageIO.read(World.class.getClassLoader().getResourceAsStream(png));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public World() {
		flyingObjects = new FlyingObject[]{};//��ʼ������������
		bullets = new Bullet[]{};//��ʼ���ӵ�����
		hero = new Hero();//��ʼ��Ӣ�۷ɻ�
		sky = new Sky();//��ʼ��һƬ���
		nextTime = System.currentTimeMillis()+1000;//��ʼ����һ���ϵͳʱ��
	}
	//nextOne��������ʱ(1/24��)����һ��
	public void nextOne(){
		//��������һ��,��ȡһ�µ�ǰʱ��.
		long now = System.currentTimeMillis();//��ȡ��ǰϵͳʱ��ĺ�����
		if(now>=nextTime){
			nextTime = now + 1000;//���Ʒ�����ĳ���ʱ����,��ÿ��һ�����һ��������
			FlyingObject obj = randomOne();//����randomOne����,�������һ��������
			flyingObjects = Arrays.copyOf(flyingObjects, flyingObjects.length+1);//��������
			flyingObjects[flyingObjects.length-1]=obj;//������ɵķ�����ŵ�������ȥ
		}
	}
	private static FlyingObject randomOne(){
		int n = (int)(Math.random()*10);//[0,10)
		//����������������Ĵ�СҲ���Ե�����ͬ������ĳ�������
		switch(n){
		case 0 : return new Bee();
		case 1 : 
		case 2 : return new BigPlane();
		case 3 : 
		case 4 : return new BigPlaneAward();
		default : return new Airplane();//�������
		}
	}
	@Override
	public void paint(Graphics g) {
		sky.paint(g);//�������,������ͼƬ
		hero.paint(g);//����Ӣ�۷ɻ�
		for(FlyingObject fly : flyingObjects){
			fly.paint(g);//����ÿ��������
		}
		for(Bullet bullet : bullets){
			bullet.paint(g);//����ÿ���ӵ�
		}
		//��ӷ���,����,�ӵ����͵���ʾ
		g.drawString("SCORE:"+score, 20, 30);
		g.drawString("LIFE:"+life, 20, 50);
		g.drawString("FIRE:"+fireType, 20, 70);
		
		switch(state){
		case PAUSE : g.drawImage(pause, 0, 0, null);
		case READY : g.drawImage(ready, 0, 0, null);
		case GAME_OVER : g.drawImage(gameOver, 0, 0, null);
		}
	}
	//��World�����һ����ʱ����������ʱ���ķ���.ÿ1/24��һ������
	public void action(){
		timer = new Timer();//��ʼ��һ����ʱ��
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if(state == RUNNING){
					nextOne();//ÿ(1/24��)����һ��������
					move();//����������ƶ�
					shoot();//�����װ��shoot����
					duangDuang();//��ײ����
					removeObjects();//���շ���
					heroLifeCircle();//Ӣ�۵���������
				}
				repaint();//���»���JPanel
			}
		}, 0,1000/24);//��0��ʼ,���Ϊ(1/24)��
		//�������ļ������������ļ���
		MouseAdapter l = new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(state == RUNNING){
					int x = e.getX();
					int y = e.getY();
					hero.move(x,y);//�����ƶ���x,y����.
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(state == RUNNING){
					state = PAUSE;
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(state == PAUSE){
					state = RUNNING;
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(state == READY){
					state = RUNNING;
				}
				if(state == GAME_OVER){//��Ϸ�������в������á�
					score = 0;
					life = 3;
					fireType = 1;
					hero = new Hero();
					bullets = new Bullet[0];
					flyingObjects = new FlyingObject[0];
					state = READY;
				}
			}
		};
		//�����������뵽��ǰ�������
		addMouseListener(l);
		addMouseMotionListener(l);
	}
	/** Ӣ�۵�һ��(��������)*/
	public void heroLifeCircle(){
		//���������Ӣ�۵���ײ
		if(hero.isActive()){
			for(FlyingObject plane : flyingObjects){
				if(plane.isActive()&&plane.duang(hero)){
					plane.goDead();
					hero.goDead();
				}
			}
		}
		if(hero.canRemove()){
			if(life>0){
				life--;
				hero = new Hero();//����һ��Ӣ��
				//�峡,���˵�˲��,����ײӢ�۲���,��ײ����.
				for(FlyingObject plane : flyingObjects){
					if(plane.isActive()&&plane.duang(hero)){
						plane.goDead();
					}
				}
			}else{
				//��Ϸ����
				state = GAME_OVER;
			}
		}
	}
	/**
	 * ɾ����û���õ��ӵ��ͷɻ�
	 */
	public void removeObjects(){
		//ɾ�����������ӵ�
		Bullet[] ary = {};//��ʼ��һ���ӵ�����
		for(Bullet b : bullets){
			if(b.canRemove()){
				continue;//���Ե�Ҫɾ�����ӵ�
			}
			ary = Arrays.copyOf(ary, ary.length+1);//��������
			ary[ary.length-1] = b;//��û��ɾ�����ӵ�������ӵ�������ȥ
		}
		bullets = ary;//bullets�������õ�ary������,����ԭ��������
		//ɾ���������ķɻ�
		FlyingObject[] arr = {};//��ʼ��һ������������
		for(FlyingObject obj : flyingObjects){
			if(obj.canRemove()){
				continue;//���Ե������ķ�����
			}
			arr = Arrays.copyOf(arr, arr.length+1);//��������
			arr[arr.length-1] = obj;////��û��ɾ���ķ�������ӵ�������ȥ
		}
		flyingObjects = arr;
	}
	/**
	 * ��world���������ײ��ⷽ��
	 */
	public void duangDuang(){
		for(FlyingObject plane : flyingObjects){
			if(plane.isActive()){
				if(shootByBullet(plane)){
					plane.hit();
				if(plane.isDead()){
					//�Ʒ�,��ȡ����
					if(plane instanceof Enemy){
						Enemy enemy = (Enemy)plane;
						int s = enemy.getScore();
						score += s;
					}
					if(plane instanceof Award){
						Award award =(Award)plane;
						int awd = award.getAward();
						if(awd == Award.LIFE){
							life++;
						}else if(awd == Award.FIRE){
							fireType = 1;
						}else if(awd == Award.DOUBLE_FIRE){
							fireType = 2;
						}
					}
				}
				}
			}
			
		}
	}
	public boolean shootByBullet(FlyingObject plane){
		for(Bullet bullet : bullets){
			if(bullet.duang(plane)){
				bullet.hit();
				return true;
			}
		}
		return false;
	}
	/**
	 * ������Ʒ�������ʱ����ʱ����
	 * ����Ӣ�۷ɻ�����ӵ����ٶ�
	 */
	public void shoot(){
		//��������һ��,��ȡһ�µ�ǰʱ��.
		long now = System.currentTimeMillis();//��ȡ��ǰϵͳʱ��ĺ�����
		if(now>nextShootTime){
			nextShootTime=now + 500;//���뷢��һ��
			Bullet[] arr = hero.shoot(fireType);//�ӵ��������
			bullets = Arrays.copyOf(bullets, bullets.length+arr.length);
			System.arraycopy(arr, 0, bullets, bullets.length-arr.length, arr.length);
		}
	}
	/**
	 * ����������ƶ�
	 */
	private void move() {
		//ÿ���������ƶ�һ��,���»���JPanel����
		for(FlyingObject fly : flyingObjects){
			fly.move();
		}
		//ÿ���ӵ����ƶ�
		for(Bullet bullet : bullets){
			bullet.move();
		}
		sky.move();//����ƶ�
		hero.move();//Ӣ�۷ɻ��ƶ�
	}
	public static void main(String[] args) {
		World world = new World();//����һ��world���
		JFrame frame = new JFrame();//����һ������
		frame.setSize(400, 680);//���ڴ�С
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ��ڼ��رճ���
		frame.setLocationRelativeTo(null);//�ô��ھ���
		frame.add(world);//��world���ӵ�JFrame������ȥ
		frame.setVisible(true);//���ڿɼ�
		
		world.action();//������ʱ��
	}
}
