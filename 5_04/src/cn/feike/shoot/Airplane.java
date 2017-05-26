package cn.feike.shoot;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Airplane extends FlyingObject {
	private static BufferedImage[] imgs;// ����һ��Ψһ��ͼƬ�ز�
	// ��̬��������ڻ�ȡͼƬ��Դ
	static {
		imgs = new BufferedImage[5];
		try {
			for (int i = 0; i < imgs.length; i++) {
				String png = "cn/feike/shoot/airplane" + i + ".png";//��ȡͼƬ·��
				imgs[i] = ImageIO.read(Airplane.class.getClassLoader().getResourceAsStream(png));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Airplane() {
		super(49, 36);// ��ʼ��С�ɻ�
		this.image = imgs[0];
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
