package com.qihongkun;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * 实例化仓库类
		 */
		CangKu cangKu = new CangKu();
		/**
		 * 实例化三个存货的线程
		 */
		CunHuo cunHuo1 = new CunHuo(cangKu,10);
		CunHuo cunHuo2 = new CunHuo(cangKu,40);
		CunHuo cunHuo3 = new CunHuo(cangKu,20);
		/**
		 * 实例化三个取货的线程
		 */
		QuHuo quHuo1 = new QuHuo(cangKu,5);
		QuHuo quHuo2 = new QuHuo(cangKu,10);
		QuHuo quHuo3 = new QuHuo(cangKu,60);
		/**
		 * 同时启动所有线程
		 */
		new Thread(cunHuo1).start();
		new Thread(cunHuo2).start();
		new Thread(cunHuo3).start();
		new Thread(quHuo1).start();
		new Thread(quHuo2).start();
		new Thread(quHuo3).start();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
