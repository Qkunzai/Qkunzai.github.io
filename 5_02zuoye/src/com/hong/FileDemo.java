package com.hong;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileDemo {

	public static void main(String[] args) {
		XieRu ru1 = new XieRu("一");
		XieRu ru2 = new XieRu("二");
		XieRu ru3 = new XieRu("三");
		MyThread myThread1 = new MyThread(ru1);
		MyThread myThread2 = new MyThread(ru2);
		MyThread myThread3 = new MyThread(ru3);
		new Thread(myThread1).start();
		new Thread(myThread2).start();
		new Thread(myThread3).start();
	}

}
