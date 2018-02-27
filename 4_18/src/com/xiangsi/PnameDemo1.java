 package com.xiangsi;

import java.util.Comparator;

public class PnameDemo1 implements Comparator {
	
	public int compare(Object o,Object o1){
		Student s =(Student) o;
		Student s1 = (Student)o1;
		if(s1.getAge()<s.getAge()){
			return 1;
		}
		if(s1.getAge()>s.getAge()){
			return 2;
		}
		return 0;
	}

}
