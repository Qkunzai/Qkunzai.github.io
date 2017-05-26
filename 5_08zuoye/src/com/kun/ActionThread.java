package com.kun;
import java.lang.*;

public class ActionThread implements Runnable {

	@Override
	public void run() {
		int a = 0;
		try {
			while(true){
			a = (int) (Math.random()*95+5);
			Thread.sleep(500);
			System.out.print(a);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
