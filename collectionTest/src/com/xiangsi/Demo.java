package com.xiangsi;

import java.util.*;
public class Demo {

	public static  void main(String[] args) {
			Collection<Integer>  c = new HashSet<Integer>();
			c.add(156);
			c.add(266);
			c.add(266);
			c.add(154);
			//删除元素
			//c.clear();
			//删除单个元素
			c.remove(266);
			//判断是否包含此元素
			//System.out.println(c.contains(266));
			System.out.println();
			//c.add("java");
			//如果直接添加打印时会抛出类型转换异常
			//可再新创建一个集合类，将c集合所有的元素存储到e集合当中，打印输出
			Collection<Comparable> e = new ArrayList<Comparable>();
			e.addAll(c);
			//判断是否包含整个元素集合
			//System.out.println(e.containsAll(c));
			System.out.println();
			e.add("java");
			Object[] l = e.toArray();
			//for(int i=0;i<l.length;i++){
				//System.out.print(l[i]+"--");
			//}
			//判断元素集合是否为空
			Collection on = new ArrayList();
			//System.out.println(on.isEmpty());
			
			
			
			//集合的遍历，打印输出所有数据
			Collection ccn = new ArrayList();
			ccn.add("java");
			ccn.add("联盟");
			//???
			//Iterator it = ccn.iterator();
			/*if(it.hasNext()){
				System.out.print(it.next()+"");
			}
			if(it.hasNext()){
				System.out.print(it.next());
			}
			if(it.hasNext()){
				System.out.println(it.next());
			}
			if(it.hasNext()){
				System.out.println(it.next());
			}
			if(it.hasNext()){
				System.out.println(it.next());
			}
			if(it.hasNext()){
				System.out.println(it.next());
			}*/
			//可使用while死循环输出  
			/*while(it.hasNext()){
				System.out.print(it.next());
			}*/
			//长度输出
			System.out.println(ccn.size());
			//把集合转换成数组
			Object[] ap = ccn.toArray();
			for(int i =0;i<ap.length;i++){
				System.out.println(ap[i]);
			}
			/**
		 	//将存储的不重复数据进行打印输出
			System.out.println(c);
			//将存储的不重复数据进行升序打印输出
			Set s = new TreeSet(c);
			System.out.println(s);
			*/
			
	}

}
