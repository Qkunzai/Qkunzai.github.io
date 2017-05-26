package com.xiangsi;

import java.util.*;

public class PnameDemo implements Comparator {
	

	public int compare(Object o1, Object o2){
		Student s = (Student) o1;
		Student s1 = (Student)o2;
		if(s.getGender()>s1.getGender()){
			return 1;
		}
		if(s.getGender()<s1.getGender()){
			return -1;
		}
		if(s.getGender()==s1.getGender()){
			if(s.getAge()>=s1.getAge()){
				return 1;
			}
			if(s.getAge()<=s1.getAge()){
				return -1;
			}
			else{
				return 1;
			}
		}
		return 0;
	}
}
