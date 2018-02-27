package com.hong;

import java.io.IOException;

public class MyThread implements Runnable {
	private	XieRu xieRu;
	public MyThread(XieRu xieRu){
		this.xieRu=xieRu;
	}
	public void run(){
		try {
			if(xieRu.getName().equals("一")){
			xieRu.fangFa();
			}
			if(xieRu.getName().equals("二")){
				xieRu.fangFa2();
			}
			if(xieRu.getName().equals("三")){
				xieRu.fangFa3();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
