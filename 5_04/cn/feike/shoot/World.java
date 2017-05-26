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
	private FlyingObject[] flyingObjects;//飞行物(如:大小飞机,蜜蜂等)
	private Bullet[] bullets;//子弹数组
	private Hero hero;//英雄飞机
	private Sky sky;//一片天空
	private long nextTime;//下一时刻的时间
	private long nextShootTime;//下一时刻子弹射击的时间
	private Timer timer;//定时器
	
	/** 计分变量*/
	private int score = 0;//分数
	private int life = 3;//命
	private int fireType = 1;//子弹初始时为单枪
	
	/** 游戏的状态*/
	public static final int READY = 0;//开始状态
	public static final int RUNNING = 1;//运行状态
	public static final int PAUSE = 2;//暂停状态
	public static final int GAME_OVER = 3;//结束状态
	private int state = READY;//游戏状态
	
	/** 加载开始,暂停,结束的三张照片 */
	private static BufferedImage pause;//暂停
	private static BufferedImage ready;//开始
	private static BufferedImage gameOver;//结束
	
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
		flyingObjects = new FlyingObject[]{};//初始化飞行物数组
		bullets = new Bullet[]{};//初始化子弹数组
		hero = new Hero();//初始化英雄飞机
		sky = new Sky();//初始化一片天空
		nextTime = System.currentTimeMillis()+1000;//初始化下一秒的系统时间
	}
	//nextOne方法被定时(1/24秒)调用一次
	public void nextOne(){
		//方法调用一次,获取一下当前时间.
		long now = System.currentTimeMillis();//获取当前系统时间的毫秒数
		if(now>=nextTime){
			nextTime = now + 1000;//控制飞行物的出场时间间隔,即每隔一秒出场一个飞行物
			FlyingObject obj = randomOne();//调用randomOne方法,随机生成一个飞行物
			flyingObjects = Arrays.copyOf(flyingObjects, flyingObjects.length+1);//数组扩容
			flyingObjects[flyingObjects.length-1]=obj;//随机生成的飞行物放到数组中去
		}
	}
	private static FlyingObject randomOne(){
		int n = (int)(Math.random()*10);//[0,10)
		//这个上面这个随机数的大小也可以调整不同飞行物的出场概率
		switch(n){
		case 0 : return new Bee();
		case 1 : 
		case 2 : return new BigPlane();
		case 3 : 
		case 4 : return new BigPlaneAward();
		default : return new Airplane();//概率最高
		}
	}
	@Override
	public void paint(Graphics g) {
		sky.paint(g);//画出天空,即背景图片
		hero.paint(g);//画出英雄飞机
		for(FlyingObject fly : flyingObjects){
			fly.paint(g);//绘制每个飞行物
		}
		for(Bullet bullet : bullets){
			bullet.paint(g);//绘制每个子弹
		}
		//添加分数,生命,子弹类型的显示
		g.drawString("SCORE:"+score, 20, 30);
		g.drawString("LIFE:"+life, 20, 50);
		g.drawString("FIRE:"+fireType, 20, 70);
		
		switch(state){
		case PAUSE : g.drawImage(pause, 0, 0, null);
		case READY : g.drawImage(ready, 0, 0, null);
		case GAME_OVER : g.drawImage(gameOver, 0, 0, null);
		}
	}
	//在World中添加一个定时器和启动定时器的方法.每1/24秒一个动作
	public void action(){
		timer = new Timer();//初始化一个定时器
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if(state == RUNNING){
					nextOne();//每(1/24秒)生成一个飞行物
					move();//各种物体的移动
					shoot();//射击封装到shoot方法
					duangDuang();//碰撞方法
					removeObjects();//回收方法
					heroLifeCircle();//英雄的声明周期
				}
				repaint();//重新绘制JPanel
			}
		}, 0,1000/24);//从0开始,间隔为(1/24)秒
		//创建鼠标的监听即开启鼠标的监听
		MouseAdapter l = new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(state == RUNNING){
					int x = e.getX();
					int y = e.getY();
					hero.move(x,y);//传递移动的x,y坐标.
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
				if(state == GAME_OVER){//游戏结束所有参数重置。
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
		//将监听器加入到当前的面板中
		addMouseListener(l);
		addMouseMotionListener(l);
	}
	/** 英雄的一生(生命周期)*/
	public void heroLifeCircle(){
		//检查飞行物和英雄的碰撞
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
				hero = new Hero();//新生一个英雄
				//清场,死了的瞬间,再碰撞英雄不死,碰撞物死.
				for(FlyingObject plane : flyingObjects){
					if(plane.isActive()&&plane.duang(hero)){
						plane.goDead();
					}
				}
			}else{
				//游戏结束
				state = GAME_OVER;
			}
		}
	}
	/**
	 * 删除掉没有用的子弹和飞机
	 */
	public void removeObjects(){
		//删除掉废弃的子弹
		Bullet[] ary = {};//初始化一个子弹数组
		for(Bullet b : bullets){
			if(b.canRemove()){
				continue;//忽略掉要删除的子弹
			}
			ary = Arrays.copyOf(ary, ary.length+1);//数组扩容
			ary[ary.length-1] = b;//把没有删掉的子弹重新添加到数组中去
		}
		bullets = ary;//bullets变量引用到ary数组上,抛弃原来的引用
		//删除掉废弃的飞机
		FlyingObject[] arr = {};//初始化一个飞行物数组
		for(FlyingObject obj : flyingObjects){
			if(obj.canRemove()){
				continue;//忽略掉废弃的飞行物
			}
			arr = Arrays.copyOf(arr, arr.length+1);//数组扩容
			arr[arr.length-1] = obj;////把没有删掉的飞行物添加到数组中去
		}
		flyingObjects = arr;
	}
	/**
	 * 在world里面添加碰撞检测方法
	 */
	public void duangDuang(){
		for(FlyingObject plane : flyingObjects){
			if(plane.isActive()){
				if(shootByBullet(plane)){
					plane.hit();
				if(plane.isDead()){
					//计分,获取奖励
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
	 * 射击控制方法被定时器定时调用
	 * 控制英雄飞机射击子弹的速度
	 */
	public void shoot(){
		//方法调用一次,获取一下当前时间.
		long now = System.currentTimeMillis();//获取当前系统时间的毫秒数
		if(now>nextShootTime){
			nextShootTime=now + 500;//半秒发射一发
			Bullet[] arr = hero.shoot(fireType);//子弹射击类型
			bullets = Arrays.copyOf(bullets, bullets.length+arr.length);
			System.arraycopy(arr, 0, bullets, bullets.length-arr.length, arr.length);
		}
	}
	/**
	 * 各种物体的移动
	 */
	private void move() {
		//每个飞行物移动一下,重新绘制JPanel方法
		for(FlyingObject fly : flyingObjects){
			fly.move();
		}
		//每个子弹的移动
		for(Bullet bullet : bullets){
			bullet.move();
		}
		sky.move();//天空移动
		hero.move();//英雄飞机移动
	}
	public static void main(String[] args) {
		World world = new World();//创建一个world面板
		JFrame frame = new JFrame();//创建一个窗口
		frame.setSize(400, 680);//窗口大小
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口即关闭程序
		frame.setLocationRelativeTo(null);//让窗口居中
		frame.add(world);//把world面板加到JFrame窗口里去
		frame.setVisible(true);//窗口可见
		
		world.action();//启动定时器
	}
}
