package cn.feike.shoot;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Bee extends FlyingObject {
	private int n;// 用于控制蜜蜂的动画效果
	private int direction;// 定义direction,用来定义蜜蜂的出场移动方向
	private static BufferedImage[] imgs;// 定义一个唯一的图片素材
	// 静态代码块用于获取图片资源
	static {
		imgs = new BufferedImage[5];
		try {
			for (int i = 0; i < imgs.length; i++) {
				String png = "cn/feike/shoot/bee" + i + ".png";// 获取图片路径
				imgs[i] = ImageIO.read(Bee.class.getClassLoader().getResourceAsStream(png));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 初始化蜜蜂
	public Bee() {
		super(60, 50);
		this.image = imgs[0];
		direction = Math.random() > 0.5 ? -2 : 2;// 初始化蜜蜂的移动方向,各占50%的概率.
	}
	@Override
	public void move() {
		super.move();// y += step;即把y坐标交个父类来处理
		if (state == ACTIVE) {
			x += direction;
			// 如果蜜蜂移动到右边边界,则反方向移动
			if (x >= 480 - width) {
				direction = -2;
			}
			// 如果蜜蜂移动到左边边界,则反方向移动
			if (x < 0) {
				direction = 2;
			}
		}
		// 蜜蜂的动漫效果
		n++;
		int i = n % 2;// 用来控制蜜蜂的扇翅膀的速度
		this.image = imgs[i];// 来回切换图片,显示出动画的效果.
	}
	/**
	 * 播放下一张图片
	 */
	@Override
	protected BufferedImage nextImage() {
		index++;
		if (index >= imgs.length) {
			return null;// 如果下标大于等于数组长度,无图可播,返回null.
		}
		return imgs[index];
	}
}
