package com.qi;

import java.awt.Color;

public class QiZi {
	
	private int x;
	private int y;
	private Color color;
	public static final int SIZE = 30;
	public QiZi(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
}
