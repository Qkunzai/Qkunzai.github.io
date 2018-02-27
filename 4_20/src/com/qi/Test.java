package com.qi;

import java.io.*;

public class Test {

	public static void main(String[] args) {
		
		File file = new File(".");
		Demo de = new Demo(".java");
		String [] a = file.list(de);
		for(String a1:a){
			System.out.println(a1);
		}
		
	}

}
