package cn.feike.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sky extends FlyingObject{
	private double y1;//定义第二个y坐标,用于控制背景的移动
	private static BufferedImage img;//定义一个唯一的图片素材
	//静态代码块用于获取图片资源
	static{
		String png = "cn/feike/shoot/background.png";//获取图片路径
		try {
			img = ImageIO.read(Sky.class.getClassLoader().getResourceAsStream(png));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//初始化天空
	public Sky() {
		this.x = 0;
		this.y = 0;
		this.width=480;
		this.heigth=825;
		this.image = img;
		this.step = 1;//初始化图片移动的速度
		y1 = -heigth;//初始化第二张图片的位置
	}
	
	@Override
	public void move() {
		y++;
		y1++;
		if(y>=heigth){
			y = -heigth;//如果第一张图移动出下边界位置,则返回顶部
		}
		if(y1>=heigth){
			y1 = -heigth;//如果第二张图移动出下边界位置,则返回顶部
		}
	}
	//重写了paint,用于绘制两张背景图片的位置.
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
