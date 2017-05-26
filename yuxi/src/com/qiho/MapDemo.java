package com.qiho;

import java.util.*;

public class MapDemo {

	public static void main(String[] args) {
		/**
		//map的元素添加与查询
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put(1,"亲戚");
		map.put(2,"邻居");
		//添加元素时，如果出现相同的键，那么后添加的值就会覆盖原有键对应的值(value)
		//并且put方法会返回被覆盖的值
		map.put(2, "家人");
		System.out.println(map);
		//获取map集合中所有的值
		Collection<Object> collection = map.values();
		System.out.println("map集合中的value值为");
		System.out.println(collection);
		//通过key键来查询value值
//		containsKey()方法
//		 containsKey(Object key)
//                      如果此映射包含对于指定键的映射关系，则返回 true
		int key=2;
		if(map.containsKey(key))
			//可以通过get()方法的返回值来判断一个键是否存在
			System.out.println("存在:"+map.get(key));
		//查询2这个数字存不存在与这个集合内
		System.out.println("containsKey:"+map.containsKey(2));
		//map的元素的删除与遍历
		//entrySet()方法
		//Iterator it = map.entrySet().iterator();
//		while(it.hasNext()){
//			Map.Entry e = (Map.Entry)it.next();
//			System.out.println("key:"+e.getKey()+"values:"+e.getValue());
//		}
		//keySet()方法进行遍历
//		Set m = map.keySet();
//		Iterator iterator = (Iterator) m.iterator();
//		while( iterator.hasNext()){
//			Integer s = (Integer)iterator.next();
//			System.out.println(s);
//		}
		//for each进行遍历
		for(Object m:map.keySet()){
			System.out.println(map.get(m));
			
		}
		//删除所有映射内容
//		map.clear();
//		System.out.println(map.get(1));
		//删除一条数据
//		map.remove(2);
//		System.out.println(map);
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		 * Collection集合类的使用
		 * 
		 * */
		//创建集合类
		Collection<Integer>  c = new HashSet<Integer>();
		//向集合类内添加元素
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
		//如果不是同一类型直接添加打印时会抛出类型转换异常
		//可再新创建一个集合类，将c集合所有的元素存储到e集合当中，打印输出
		Collection<Object> e = new ArrayList<Object>();
		e.addAll(c);
		//判断是否包含整个元素集合
		//System.out.println(e.containsAll(c));
		System.out.println();
		e.add("java");
		//将集合类转换为Object类的数组进行输出
		Object[] l = e.toArray();
		//for(int i=0;i<l.length;i++){
			//System.out.print(l[i]+"--");
		//}
		//判断元素集合是否为空
		Collection<Object> on = new ArrayList<Object>();
		//System.out.println(on.isEmpty());
		
		
		
		//集合的遍历，打印输出所有数据
		Collection<Object> ccn = new ArrayList<Object>();
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
		//把集合转换成Object类型的数组
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
