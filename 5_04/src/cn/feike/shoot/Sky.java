package cn.feike.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sky extends FlyingObject{
	private double y1;//����ڶ���y����,���ڿ��Ʊ������ƶ�
	private static BufferedImage img;//����һ��Ψһ��ͼƬ�ز�
	//��̬��������ڻ�ȡͼƬ��Դ
	static{
		String png = "cn/feike/shoot/background.png";//��ȡͼƬ·��
		try {
			img = ImageIO.read(Sky.class.getClassLoader().getResourceAsStream(png));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//��ʼ�����
	public Sky() {
		this.x = 0;
		this.y = 0;
		this.width=480;
		this.heigth=825;
		this.image = img;
		this.step = 1;//��ʼ��ͼƬ�ƶ����ٶ�
		y1 = -heigth;//��ʼ���ڶ���ͼƬ��λ��
	}
	
	@Override
	public void move() {
		y++;
		y1++;
		if(y>=heigth){
			y = -heigth;//�����һ��ͼ�ƶ����±߽�λ��,�򷵻ض���
		}
		if(y1>=heigth){
			y1 = -heigth;//����ڶ���ͼ�ƶ����±߽�λ��,�򷵻ض���
		}
	}
	//��д��paint,���ڻ������ű���ͼƬ��λ��.
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
		g.drawImage(image, (int)x, (int)y1, null);
	}
	@Override
	protected BufferedImage nextImage() {
		return null;
	}
}
