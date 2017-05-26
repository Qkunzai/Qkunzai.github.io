package com.qi;

public class ChuangKou {
	//定义票数为静态变量只能被引用一次
	private static Piao piao = new Piao(50);
	private String name;
	public ChuangKou(String name){
		this.name = name;
	}
	public void maiPiao(){
		int a=0,b=0,c=0;
		while(true){
			int num = piao.getNum();
			--num;
			piao.setNum(num);
			//当票数为零时跳出循环
			if(num<1){
				
				System.out.println(name+"票已售尽");
				break;
			}	
			if(name.equals("窗口1")){
				//当运行的线程为窗口1时a就加1
				a++;
			}
			if(name.equals("窗口2")){
				//当运行的线程为窗口2时b就加1
				b++;
			}
			if(name.equals("窗口3")){
				//当运行的线程为窗口3时c就加1
				c++;
			}	
			System.out.println(name+"票卖了第"+num+"张");

		}
		/**
		 * 判断传来的窗口是几号窗口然后进行判断每个窗口卖出的票总数
		 */
		if(name.equals("窗口1")){
			System.out.println("窗口1卖了"+a+"张");
		}
		if(name.equals("窗口2")){
			System.out.println("窗口2卖了"+b+"张");
		}
		if(name.equals("窗口3")){
			System.out.println("窗口3卖了"+c+"张");
		}
	}

}
