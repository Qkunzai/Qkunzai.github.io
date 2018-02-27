package com.qi;

public class CunKuan implements Runnable{
	private Bank bank;
	private int money;
	public CunKuan(Bank bank,int money){
		this.setBank(bank);
		this.setMoney(money);
	}
	public void run(){
		while(true){
			synchronized (bank){
				try {
					//暂时让线程挂起一秒
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//将存款数传到Bank类的cunKuan方法中
				bank.cunKuan(money);
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
