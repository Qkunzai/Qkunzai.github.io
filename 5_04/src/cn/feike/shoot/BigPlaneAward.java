package cn.feike.shoot;

import java.awt.Graphics;

public class BigPlaneAward extends BigPlane implements Award{


	public void paint(Graphics g){
		super.paint(g);//重载父类的paint方法
		//在大飞机外面加上一个框框
		g.drawRect((int)x, (int)y, (int)width, (int)heigth);
	}
	public int getAward() {
		return DOUBLE_FIRE;//获取双倍奖励
	}
	
}
