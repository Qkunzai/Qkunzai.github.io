package com.qihongkun;

public class QuHuo implements Runnable {

	private CangKu cangKu;	//定义一个仓库类
	private int num;	//取货数量
	public QuHuo(CangKu cangKu,int num){
		this.setNum(num);
		this.setCangKu(cangKu);
	}
	//覆写run方法
	public void run(){
		while(true)
			//同步锁，只有当该线程运行完之后再运行下一条线程
		synchronized(cangKu){
			try {
				//挂起两秒
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//将取货数量传输到仓库类中进行运算
			cangKu.quHuo(num);
		}
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public CangKu getCangKu() {
		return cangKu;
	}
	public void setCangKu(CangKu cangKu) {
		this.cangKu = cangKu;
	}
}
