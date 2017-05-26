package cn.feike.shoot;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class BigPlane extends FlyingObject{
	private static BufferedImage[] imgs;// ����һ��Ψһ��ͼƬ�ز�
	// ��̬��������ڻ�ȡͼƬ��Դ
	static {
		imgs = new BufferedImage[5];
		try {
			for (int i = 0; i < imgs.length; i++) {
				String png = "cn/feike/shoot/Bigplane" + i + ".png";//��ȡͼƬ·��
				imgs[i] = ImageIO.read(BigPlane.class.getClassLoader().getResourceAsStream(png));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public BigPlane() {
		super(69,99);//��ʼ����ɻ�
		this.image = imgs[0];
		life = 3;
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
