package com.qihongkun;

public class CunHuo implements Runnable {
	private int num;//存货数
	private CangKu cangKu;//仓库类的数据
	public CunHuo(CangKu cangKu,int num){
		setCangKu(cangKu);
		setNum(num);
	}

	@Override
	public void run() {
		while(true)
			//同步锁，当上一个线程运行完后再运行下一线程
		synchronized (cangKu) {
			try {
				//将该线程挂起两秒
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//将存货数传输到仓库类内
			cangKu.cunHuo(num);
		}
	}

	public CangKu getCangKu() {
		return cangKu;
	}

	public void setCangKu(CangKu cangKu) {
		this.cangKu = cangKu;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
