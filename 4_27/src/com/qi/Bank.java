package com.qi;

public class Bank {
	
	private int deposit;	//账户余额
	private String name;	//账户名称

	public Bank(int deposit,String name){
		this.deposit=deposit;
		this.name=name;
	}
	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//取款方法
	public void quKuan(int num){
		/**
		 * 当取款金额大于账户余额时，暂停该线程
		 */
		if(num>deposit){
			System.out.println("余额不足"+num+"元,账户余额为："+deposit);
			try {
				//线程等待
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			deposit = deposit - num;
			System.out.println("取款成功！本次取出金额为:"+num+"账户余额为"+deposit);
		}
		/**
		 * 唤醒线程
		 */
		notify();
	}
	//存款方式
	public void cunKuan(int num){
		/**
		 * 存款金额加上账户余额
		 */
		deposit = num+deposit;
		System.out.println("本次存入金额为:"+num+"元，账户余额为:"+deposit);
	}
}
