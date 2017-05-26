package com.qi;

public class Main {

	public static void main(String[] args) {
		
		Bank bank = new Bank(4000,"qi");
		/**
		 * 实例化三个QuKuan的对象
		 */
		QuKuan kuan1 = new QuKuan(bank, 3000);
		QuKuan kuan2 = new QuKuan(bank, 2000);
		QuKuan kuan3 = new QuKuan(bank, 500);
		/**
		 * 实例化两个CunKuan的对象
		 */
		CunKuan cunKuan1 = new CunKuan(bank,1000);
		CunKuan cunKuan2 = new CunKuan(bank,500);
		/**
		 * 启动所有实例化的线程
		 */
		new Thread(kuan1).start();
		
		new Thread(kuan1).setPriority(5);		//更改kuan1的优先级
		
		new Thread(kuan2).start();
		
		new Thread(kuan2).setPriority(5);		//更改kuan2的优先级
		
		new Thread(kuan3).start();
		new Thread(cunKuan1).start();
		new Thread(cunKuan2).start();
	}
}
