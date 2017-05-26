package cn.feike.shoot;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Hero extends FlyingObject {
	private int n =0;//���ڿ���Ӣ�۷ɻ��Ķ���Ч��
	private int index = 1;//Ӣ�۷ɻ�ͼƬ�Ǵӵ�2��ʼ��(�����1�ͳ�2��)
	private static BufferedImage[] imgs;// ����һ��Ψһ��ͼƬ�ز�
	// ��̬��������ڻ�ȡͼƬ��Դ
	static {
		imgs = new BufferedImage[6];
		try {
			for (int i = 0; i < imgs.length; i++) {
				String png = "cn/feike/shoot/hero" + i + ".png";//��ȡͼƬ·��
				imgs[i] = ImageIO.read(Hero.class.getClassLoader().getResourceAsStream(png));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//��ʼ��Ӣ�۷ɻ�
	public Hero() {
		this.width = 97;
		this.heigth = 124;
		this.x = (480-width)/2;
		this.y =500;
		this.image = imgs[0];
	}
	@Override
	public void move() {
		if(isActive()){
			n++;
			int i = n%2;//�����i��ֵ�������л���ͼƬ(i=n%2)���л��ٶȿ���(i=n/2%2)
			this.image = imgs[i];//�����л�ͼƬ,��ʾ��������Ч��.
		}
		if(isDead()){
			//�������ȡ��һ����Ƭ
			BufferedImage img = nextImage();
			if(img==null){
				state = REMOVE;
			}else{
				image = img;
			}
		}
			}
	/**
	 * �ٴ���дmove����,����Ӣ�۷ɻ���������ƶ�
	 */
	public void move(int x,int y){
		this.x = x-width/2;
		this.y = y-heigth/2;
	}
	/**
	 * ��hero������������
	 */
	public Bullet[] shoot(int type){
		int x = (int)(this.x+width/2-8/2);//�ӵ��ĳ�����xλ��
		int y = (int)(this.y-30);//�ӵ��ĳ�����yλ��
		if(type == 1){//��ǹ����
			return new Bullet[]{
					new Bullet(x,y)//����һ���ӵ�
			};
		}
		if(type == 2){
			return new Bullet[]{
					new Bullet(x-30, y),//��һ���ӵ�ԭ������λ�������ƶ�30
					new Bullet(x+30,y)//�ڶ����ӵ�ԭ������λ�������ƶ�30
			};
		}
		return new Bullet[0];
	}
	/**
	 * ������һ��ͼƬ
	 */
	
	@Override
	protected BufferedImage nextImage() {
		index++;
		if(index >= imgs.length){
			return null;//����±���ڵ������鳤��,��ͼ�ɲ�,����null.
		}
		return imgs[index];
	}
}
