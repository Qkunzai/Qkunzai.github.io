package com.qi;

import java.util.*;
public class hashCodeDemo {
	public static void main(String[] args){
		
		Student st = new Student("����ң",19);
		Student st1 = new Student("����ң",19);
		//�ж�st��st1�Ƿ����
		System.out.println(st.equals(st1));
		List se = new ArrayList();
		se.add(st);
		se.add(st1);
		System.out.println("����"+se.size());
		Set se1 = new HashSet();
		System.out.println("hashCode:"+se.hashCode());
		System.out.println("hashCode:"+se.hashCode());
		se1.add(st);
		se1.add(st1);
		System.out.println("����Ϊ"+se1.size());
	}

}
