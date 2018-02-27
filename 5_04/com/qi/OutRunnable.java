package com.qi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class OutRunnable implements Runnable {
	private java.util.List<Socket> list = new ArrayList<Socket>();
	private String dd;
	public OutRunnable(List<Socket> list){
		this.list=list;
	}
	public OutRunnable(String dd){
		this.dd=dd;
	}

	@Override
	public void run() {
	
		
		
	}

}
