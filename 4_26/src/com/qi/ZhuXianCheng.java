package com.qi;

public class ZhuXianCheng {

	public static void main(String[] args) {
		/**
		 * 实例化三个窗口类
		 */
		ChuangKou chuangKou1 = new ChuangKou("窗口1");
		ChuangKou chuangKou2 = new ChuangKou("窗口2");
		ChuangKou chuangKou3 = new ChuangKou("窗口3");
		/**
		 * 通过实例化MyThread类来传进窗口类的数据
		 */
		MyThread myThread1 = new MyThread(chuangKou1);
		MyThread myThread2 = new MyThread(chuangKou2);
		MyThread myThread3 = new MyThread(chuangKou3);
		/**
		 * 同时运行这三个线程
		 */
		myThread1.start();
		//myThread1.setPriority(10);
		myThread2.start();
		//myThread1.setPriority(2);
		myThread3.start();
		//myThread1.setPriority(2);
	}

}
