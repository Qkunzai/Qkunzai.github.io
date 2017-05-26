package com.qi;

public class Main {

	public static void main(String[] args) {
		
		for(int i=0;i<20;i++){
			new Thread(new TestShiWu()).start();
			new Thread(new TestShiWu2()).start();
		}
		

	}

}
