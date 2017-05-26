package cn.feike.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class FlyingObject {
	protected double x;//�����x����
	protected double y;//�����y����
	protected double width;//����Ŀ�
	protected double heigth;//����ĸ�
	protected BufferedImage image;//��ǰ������ʾ��ͼƬ
	protected int index = 0;//ͼƬ�����±����,������ʹ��
	protected double step;//������ÿ��(1/24��)�ƶ��ľ���
	protected int life;//��
	protected int state;//�������״̬
	public static final int ACTIVE=0;//����״̬
	public static final int DEAD=1;//����״̬
	public static final int REMOVE=2;//����״̬
	
	//Ĭ�Ϲ�����
	public FlyingObject() {
		life = 1;
		state = ACTIVE;
	}
	//�вι�����
	public FlyingObject(double width,double heigth){
		this();//�����޲����Ĺ�����,����д�ڵ�һ��.
		this.x = (int)(Math.random()*(480-width));
		this.y = -heigth;
		this.width = width;
		this.heigth = heigth;
		step = Math.random()*3+0.8;//��ʼ��stepΪ[0.8,3.8)֮�����
	}
	//��дtoString����
	public String toString() {
		return x+","+y+","+width+","+heigth+","+image;
	}
	//��дpaint,������������ʹ��
	public void paint(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);//����ͼƬ
	}
	//�������ƶ���move����
	/**
	 * �ع���move,����ʵ�ֲ������ٶ�������
	 */
	public void move(){
		if(state == ACTIVE){
			y += step;
			return ;
		}
		if(state == DEAD){
			//����������л�ȡ��һ����Ƭ
			BufferedImage img = nextImage();
			if(img == null){
				state = REMOVE;//û����Ƭ�����
			}else{
				image = img;//����������ͼƬ����image
			}
			//Խ��������
			if(y>=825){
				state = REMOVE;
			}
		}
	}
	/** 
	 * �����б����еķ���,������һ��Ҫ���ŵ���Ƭ����,
	 * �������null��ʾû�пɲ��ŵ���Ƭ��.
	 */
	protected abstract BufferedImage nextImage();
	/**
	 * �����ﱻ����һ��
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
	 * ��ײ���ķ���
	 * ��������λ���Ƿ�����ײ�ķ�Χ��.
	 * (�ӵ��Ƿ��ڷ��������ײ��Χ��)
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
	/** �ع�FlyingObject,�����״̬��鷽�� */
	/** �������������� */
	public boolean isDead(){
		return state == DEAD;
	}
	/** ���������Ƿ��� */
	public boolean isActive(){
		return state == ACTIVE;
	}
	/** �������Ƿ���Ա�ɾ��*/
	public boolean canRemove(){
		return state == REMOVE;
	}
	/** ���������"ȥ��"����*/
	public void goDead(){
		if(isActive()){
			state = DEAD;
		}
	}
}
