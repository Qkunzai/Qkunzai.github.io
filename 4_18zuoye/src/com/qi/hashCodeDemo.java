package com.qi;

import java.util.*;
public class hashCodeDemo {
	public static void main(String[] args){
		
		Student st = new Student("何逍遥",19);
		Student st1 = new Student("何逍遥",19);
		//判断st与st1是否相等
		System.out.println(st.equals(st1));
		List se = new ArrayList();
		se.add(st);
		se.add(st1);
		System.out.println("长度"+se.size());
		Set se1 = new HashSet();
		System.out.println("hashCode:"+se.hashCode());
		System.out.println("hashCode:"+se.hashCode());
		se1.add(st);
		se1.add(st1);
		System.out.println("长度为"+se1.size());
	}

}
