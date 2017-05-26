package com.qi;

public class MyThread extends Thread{
	/**
	 * 定义一个窗口类来接受窗口类传来的内容，利用run方法来进行运行窗口类内的卖票的方法
	 */
	ChuangKou chuangKou;
	public MyThread(ChuangKou chuangKou){
		this.chuangKou=chuangKou;
	}
	
	public void run(){
		chuangKou.maiPiao();
	}
}
