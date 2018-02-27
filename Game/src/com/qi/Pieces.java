package com.qi;

import java.io.Serializable;

public class Pieces implements Serializable{
	private int x;
	private int y;
	private boolean b;
	public final int WITCH = 30;
	public Pieces(){}
	public Pieces(int x,int y,boolean b){
		this.setX(x);
		this.setY(y);
		this.setB(b);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		if((x-20)%40>=20){
			x = x+40-(x-20)%40-WITCH/2;
		}else{
			x = x-(x-20)%40-WITCH/2;
		}
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		if((y-20)%40>=20){
			y = y+40-(y-20)%40-WITCH/2;
		}else{
			y = y-(y-20)%40-WITCH/2;
		}
		this.y = y;
	}
	public boolean isB() {
		return b;
	}
	public void setB(boolean b) {
		this.b = b;
	}

}
