package cn.feike.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class FlyingObject {
	protected double x;//物体的x坐标
	protected double y;//物体的y坐标
	protected double width;//物体的宽
	protected double heigth;//物体的高
	protected BufferedImage image;//当前正在显示的图片
	protected int index = 0;//图片数组下标序号,子类中使用
	protected double step;//飞行物每次(1/24秒)移动的距离
	protected int life;//命
	protected int state;//飞行物的状态
	public static final int ACTIVE=0;//活着状态
	public static final int DEAD=1;//死亡状态
	public static final int REMOVE=2;//回收状态
	
	//默认构造器
	public FlyingObject() {
		life = 1;
		state = ACTIVE;
	}
	//有参构造器
	public FlyingObject(double width,double heigth){
		this();//调用无参数的构造器,必须写在第一行.
		this.x = (int)(Math.random()*(480-width));
		this.y = -heigth;
		this.width = width;
		this.heigth = heigth;
		step = Math.random()*3+0.8;//初始化step为[0.8,3.8)之间的数
	}
	//重写toString方法
	public String toString() {
		return x+","+y+","+width+","+heigth+","+image;
	}
	//重写paint,方便子类对象的使用
	public void paint(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);//绘制图片
	}
	//飞行物移动的move方法
	/**
	 * 重构了move,方法实现播放销毁动画功能
	 */
	public void move(){
		if(state == ACTIVE){
			y += step;
			return ;
		}
		if(state == DEAD){
			//从子类对象中获取下一张照片
			BufferedImage img = nextImage();
			if(img == null){
				state = REMOVE;//没有照片则回收
			}else{
				image = img;//否则把子类的图片传给image
			}
			//越界则销毁
			if(y>=825){
				state = REMOVE;
			}
		}
	}
	/** 
	 * 子类中必须有的方法,返回下一个要播放的照片引用,
	 * 如果返回null表示没有可播放的照片了.
	 */
	protected abstract BufferedImage nextImage();
	/**
	 * 飞行物被打了一下
	 */
	public void hit(){
		if(life>0){
			life--;
		}
		if(life==0){
			state = DEAD;
		}
	}
	/**
	 * 碰撞检测的方法
	 * 检测物体的位置是否在碰撞的范围内.
	 * (子弹是否在飞行物的碰撞范围内)
	 */
	public boolean duang(FlyingObject obj){
		//this(x,y,w,h)
		//obj(x,y,w,h)
		double x1 = this.x - obj.width;
		double x2 = this.x + this.width;
		double y1 = this.y - obj.width;
		double y2 = this.y + this.heigth;
		return x1<obj.x&&obj.x<x2&&y1<obj.y&&obj.y<y2;
	}
	/** 重构FlyingObject,添加了状态检查方法 */
	/** 检查飞行物死了吗 */
	public boolean isDead(){
		return state == DEAD;
	}
	/** 检查飞行物是否活动的 */
	public boolean isActive(){
		return state == ACTIVE;
	}
	/** 检查飞行是否可以被删除*/
	public boolean canRemove(){
		return state == REMOVE;
	}
	/** 飞行物添加"去死"方法*/
	public void goDead(){
		if(isActive()){
			state = DEAD;
		}
	}
}
