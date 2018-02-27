package com.xiangsi;

import java.util.*;

public class TrreSetDemo {

	public static void main(String[] args) {
		
		PnameDemo pd = new PnameDemo();
		Set ts = new TreeSet(pd);
		ts.add(new Student("小明",19,110));
		ts.add(new Student("小红",18,110));
		ts.add(new Student("小新",25,200));
		ts.add(new Student("阿和",25,200));
		ts.add(new Student("小何",25,200));
		/*PnameDemo1 pd2 = new PnameDemo1();
		Set ts2 = new TreeSet(pd2);
		ts2.addAll(ts);*/
		Iterator it = ts.iterator();
		while(it.hasNext()){
			Student s = (Student)it.next();
			System.out.println(s.getName()+"----"+s.getAge()+"----"+s.getGender());
		}
	}

}
