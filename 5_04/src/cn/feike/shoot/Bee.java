package cn.feike.shoot;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Bee extends FlyingObject {
	private int n;// ���ڿ����۷�Ķ���Ч��
	private int direction;// ����direction,���������۷�ĳ����ƶ�����
	private static BufferedImage[] imgs;// ����һ��Ψһ��ͼƬ�ز�
	// ��̬��������ڻ�ȡͼƬ��Դ
	static {
		imgs = new BufferedImage[5];
		try {
			for (int i = 0; i < imgs.length; i++) {
				String png = "cn/feike/shoot/bee" + i + ".png";// ��ȡͼƬ·��
				imgs[i] = ImageIO.read(Bee.class.getClassLoader().getResourceAsStream(png));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��ʼ���۷�
	public Bee() {
		super(60, 50);
		this.image = imgs[0];
		direction = Math.random() > 0.5 ? -2 : 2;// ��ʼ���۷���ƶ�����,��ռ50%�ĸ���.
	}
	@Override
	public void move() {
		super.move();// y += step;����y���꽻������������
		if (state == ACTIVE) {
			x += direction;
			// ����۷��ƶ����ұ߽߱�,�򷴷����ƶ�
			if (x >= 480 - width) {
				direction = -2;
			}
			// ����۷��ƶ�����߽߱�,�򷴷����ƶ�
			if (x < 0) {
				direction = 2;
			}
		}
		// �۷�Ķ���Ч��
		n++;
		int i = n % 2;// ���������۷���ȳ����ٶ�
		this.image = imgs[i];// �����л�ͼƬ,��ʾ��������Ч��.
	}
	/**
	 * ������һ��ͼƬ
	 */
	@Override
	protected BufferedImage nextImage() {
		index++;
		if (index >= imgs.length) {
			return null;// ����±���ڵ������鳤��,��ͼ�ɲ�,����null.
		}
		return imgs[index];
	}
}
