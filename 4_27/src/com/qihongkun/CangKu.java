package com.qihongkun;

public class CangKu {
	public static final int MAXNUM=100;	//定义一个全局常量
	private int num = 0;	
	//存货方法
	public void cunHuo(int num){
		if(num+getNum()>MAXNUM){
			System.out.println("库存已满，等待取货");
				try {
					//库存满时该线程等待
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}else{
			//库存未满时将入库数与库存相加，将库存数进行重新赋值
			System.out.println("当前库存为:"+getNum());
			setNum(num + getNum());
			System.out.println("存入后库存为："+getNum()+"本次存入"+num);
		}
		//下一条线程唤醒上一条线程
		notify();
	}
	//取货方法
	public void quHuo(int num){
		if(getNum()<=num){
			System.out.println("库存不足等待送货");
			try {
				//库存不足时该线程等待
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			//当库存充足时取货之后再将取货后的值进行重新赋值
			System.out.println("取货前库存为"+getNum());
			setNum(getNum()-num);
			System.out.println("取走后库存为："+getNum()+"取走数为:"+num);
		}
		//下一条线程运行时唤醒上一条线程
		notify();
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
