package com.qiho;

	class Ac extends Thread{
		public void run(){
			int i=0;
			while(i<50){
				i++;
				System.out.println("Ac="+i);
			}
			System.out.println("Ac最终结果是:"+i);
		}
	}

