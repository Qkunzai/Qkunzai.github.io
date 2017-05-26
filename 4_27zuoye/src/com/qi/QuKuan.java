package com.qi;

public class QuKuan implements Runnable {
	private Bank bank;
	private int money;
	public QuKuan(Bank bank,int money){
		this.setBank(bank);
		this.setMoney(money);
	}
	public void run(){
			while(true){
				/**
				 * 同步锁,每次只允许一个线程进行访问，等上一个线程执行完后下一个线程再继续执行
				 */
				synchronized (bank) {
					try {
						//让线程暂时挂起一秒
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					  }
					/**
					 * 将取款数传输到Bank类的quKuan方法中去
					 */
					bank.quKuan(money);
				}	
		}
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
}
