package cn.feike.shoot;

import java.awt.Graphics;

public class BigPlaneAward extends BigPlane implements Award{


	public void paint(Graphics g){
		super.paint(g);//���ظ����paint����
		//�ڴ�ɻ��������һ�����
		g.drawRect((int)x, (int)y, (int)width, (int)heigth);
	}
	public int getAward() {
		return DOUBLE_FIRE;//��ȡ˫������
	}
	
}
