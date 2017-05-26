
package cn.feike.shoot;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends FlyingObject{
	private static BufferedImage img;//����һ��Ψһ��ͼƬ�ز�
	//��̬��������ڻ�ȡͼƬ��Դ
	static{
		String png = "cn/feike/shoot/bullet.png";//��ȡͼƬ·��
		try {
			img = ImageIO.read(Bullet.class.getClassLoader().getResourceAsStream(png));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//��ʼ���ӵ�,��Ϊ�ӵ�����Ӣ�۷ɻ�һ����,������Ҫ������������.
	public Bullet(int x,int y) {
		this.x = x;
		this.y = y;
		width = 8;
		heigth = 14;
		this.image = img;
	}
	//��д�ӵ�move����,�ӵ��Ǵ��������ƶ�
	@Override
	public void move() {
		if(state == ACTIVE){
			y -= 8;
			if(y<=-heigth){
				state = REMOVE;
			}
		}
	}
	@Override
	protected BufferedImage nextImage() {
		return null;
	}
	public void hit(){
		state = REMOVE;//�ӵ�ײ��������
	}
}
