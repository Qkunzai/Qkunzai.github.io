package com.qiho;

public class Demo extends Thread {

	public static void main(String[] args) {	
		Demo demo = new Demo();
		demo.setPriority(10);
		
		Ac ace = new Ac();		
		try {
			ace.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//开始该线程并运行内部的run方法
		
		//更改ace的线程优先级
		ace.setPriority(5);
		//ace线程的优先级
		//System.out.println(ace.getPriority());
		//更改线程的优先级
		Ab ab = new Ab();
		ab.setPriority(5);
		ace.start();
		demo.start();
		ab.start();
		//使用Runnable接口启动线程
	
	}
	public void run(){
		int i =0;
		while(i<50){
			i++;
			System.out.println("Demo="+i);
		}
		System.out.println("Demo最终结果是:"+i);
		
	}


}
