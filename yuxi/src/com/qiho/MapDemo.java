package com.qiho;

import java.util.*;

public class MapDemo {

	public static void main(String[] args) {
		/**
		//map��Ԫ��������ѯ
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put(1,"����");
		map.put(2,"�ھ�");
		//���Ԫ��ʱ�����������ͬ�ļ�����ô����ӵ�ֵ�ͻḲ��ԭ�м���Ӧ��ֵ(value)
		//����put�����᷵�ر����ǵ�ֵ
		map.put(2, "����");
		System.out.println(map);
		//��ȡmap���������е�ֵ
		Collection<Object> collection = map.values();
		System.out.println("map�����е�valueֵΪ");
		System.out.println(collection);
		//ͨ��key������ѯvalueֵ
//		containsKey()����
//		 containsKey(Object key)
//                      �����ӳ���������ָ������ӳ���ϵ���򷵻� true
		int key=2;
		if(map.containsKey(key))
			//����ͨ��get()�����ķ���ֵ���ж�һ�����Ƿ����
			System.out.println("����:"+map.get(key));
		//��ѯ2������ִ治���������������
		System.out.println("containsKey:"+map.containsKey(2));
		//map��Ԫ�ص�ɾ�������
		//entrySet()����
		//Iterator it = map.entrySet().iterator();
//		while(it.hasNext()){
//			Map.Entry e = (Map.Entry)it.next();
//			System.out.println("key:"+e.getKey()+"values:"+e.getValue());
//		}
		//keySet()�������б���
//		Set m = map.keySet();
//		Iterator iterator = (Iterator) m.iterator();
//		while( iterator.hasNext()){
//			Integer s = (Integer)iterator.next();
//			System.out.println(s);
//		}
		//for each���б���
		for(Object m:map.keySet()){
			System.out.println(map.get(m));
			
		}
		//ɾ������ӳ������
//		map.clear();
//		System.out.println(map.get(1));
		//ɾ��һ������
//		map.remove(2);
//		System.out.println(map);
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		 * Collection�������ʹ��
		 * 
		 * */
		//����������
		Collection<Integer>  c = new HashSet<Integer>();
		//�򼯺��������Ԫ��
		c.add(156);
		c.add(266);
		c.add(266);
		c.add(154);
		//ɾ��Ԫ��
		//c.clear();
		//ɾ������Ԫ��
		c.remove(266);
		//�ж��Ƿ������Ԫ��
		//System.out.println(c.contains(266));
		System.out.println();
		//c.add("java");
		//�������ͬһ����ֱ����Ӵ�ӡʱ���׳�����ת���쳣
		//�����´���һ�������࣬��c�������е�Ԫ�ش洢��e���ϵ��У���ӡ���
		Collection<Object> e = new ArrayList<Object>();
		e.addAll(c);
		//�ж��Ƿ��������Ԫ�ؼ���
		//System.out.println(e.containsAll(c));
		System.out.println();
		e.add("java");
		//��������ת��ΪObject�������������
		Object[] l = e.toArray();
		//for(int i=0;i<l.length;i++){
			//System.out.print(l[i]+"--");
		//}
		//�ж�Ԫ�ؼ����Ƿ�Ϊ��
		Collection<Object> on = new ArrayList<Object>();
		//System.out.println(on.isEmpty());
		
		
		
		//���ϵı�������ӡ�����������
		Collection<Object> ccn = new ArrayList<Object>();
		ccn.add("java");
		ccn.add("����");
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
		//��ʹ��while��ѭ�����  
		/*while(it.hasNext()){
			System.out.print(it.next());
		}*/
		//�������
		System.out.println(ccn.size());
		//�Ѽ���ת����Object���͵�����
		Object[] ap = ccn.toArray();
		for(int i =0;i<ap.length;i++){
			System.out.println(ap[i]);
		}
		/**
	 	//���洢�Ĳ��ظ����ݽ��д�ӡ���
		System.out.println(c);
		//���洢�Ĳ��ظ����ݽ��������ӡ���
		Set s = new TreeSet(c);
		System.out.println(s);
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
		
		
		
		
	}
}
