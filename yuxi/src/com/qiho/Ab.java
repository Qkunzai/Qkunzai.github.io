package com.qiho;

class Ab extends Thread{
	public void run(){
		int i=0;
		while(i<50){
			i++;
			System.out.println("Ab="+i);
		}
		System.out.println("Ab最终结果是:"+i);
	}
}