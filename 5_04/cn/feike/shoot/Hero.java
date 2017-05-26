package cn.feike.shoot;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Hero extends FlyingObject {
	private int n =0;//用于控制英雄飞机的动画效果
	private int index = 1;//英雄飞机图片是从第2开始的(下面加1就成2了)
	private static BufferedImage[] imgs;// 定义一个唯一的图片素材
	// 静态代码块用于获取图片资源
	static {
		imgs = new BufferedImage[6];
		try {
			for (int i = 0; i < imgs.length; i++) {
				String png = "cn/feike/shoot/hero" + i + ".png";//获取图片路径
				imgs[i] = ImageIO.read(Hero.class.getClassLoader().getResourceAsStream(png));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//初始化英雄飞机
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
			int i = n%2;//用这个i的值来控制切换的图片(i=n%2)的切换速度快于(i=n/2%2)
			this.image = imgs[i];//来回切换图片,显示出动画的效果.
		}
		if(isDead()){
			//从子类获取下一张照片
			BufferedImage img = nextImage();
			if(img==null){
				state = REMOVE;
			}else{
				image = img;
			}
		}
			}
	/**
	 * 再次重写move方法,用于英雄飞机随着鼠标移动
	 */
	public void move(int x,int y){
		this.x = x-width/2;
		this.y = y-heigth/2;
	}
	/**
	 * 在hero上添加射击方法
	 */
	public Bullet[] shoot(int type){
		int x = (int)(this.x+width/2-8/2);//子弹的出场的x位置
		int y = (int)(this.y-30);//子弹的出场的y位置
		if(type == 1){//单枪发射
			return new Bullet[]{
					new Bullet(x,y)//创建一颗子弹
			};
		}
		if(type == 2){
			return new Bullet[]{
					new Bullet(x-30, y),//第一个子弹原出场的位子向左移动30
					new Bullet(x+30,y)//第二个子弹原出场的位子向右移动30
			};
		}
		return new Bullet[0];
	}
	/**
	 * 播放下一张图片
	 */
	
	@Override
	protected BufferedImage nextImage() {
		index++;
		if(index >= imgs.length){
			return null;//如果下标大于等于数组长度,无图可播,返回null.
		}
		return imgs[index];
	}
}
