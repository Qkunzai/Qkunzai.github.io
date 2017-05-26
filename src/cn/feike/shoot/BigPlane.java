package cn.feike.shoot;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class BigPlane extends FlyingObject{
	private static BufferedImage[] imgs;// 定义一个唯一的图片素材
	// 静态代码块用于获取图片资源
	static {
		imgs = new BufferedImage[5];
		try {
			for (int i = 0; i < imgs.length; i++) {
				String png = "cn/feike/shoot/Bigplane" + i + ".png";//获取图片路径
				imgs[i] = ImageIO.read(BigPlane.class.getClassLoader().getResourceAsStream(png));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public BigPlane() {
		super(69,99);//初始化大飞机
		this.image = imgs[0];
		life = 3;
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
