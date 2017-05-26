package com.qi;

public class B extends A{

	protected String value = "456";
	public static void prt(){
//		System.out.println("2");
	}
	public B(){
//		System.out.println("B");
	}
	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.getValue());
	}

}
class A{
	protected String value = "123";
	public String getValue(){
		return value;
	}
	public static void prt(){
//		System.out.println("1");
	}
	public A(){
//		System.out.println("A");
	}
}