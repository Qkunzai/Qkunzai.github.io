package com.xiangsi;

import java.util.*;
public class Demo {

	public static  void main(String[] args) {
			Collection<Integer>  c = new HashSet<Integer>();
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
			//���ֱ����Ӵ�ӡʱ���׳�����ת���쳣
			//�����´���һ�������࣬��c�������е�Ԫ�ش洢��e���ϵ��У���ӡ���
			Collection<Comparable> e = new ArrayList<Comparable>();
			e.addAll(c);
			//�ж��Ƿ��������Ԫ�ؼ���
			//System.out.println(e.containsAll(c));
			System.out.println();
			e.add("java");
			Object[] l = e.toArray();
			//for(int i=0;i<l.length;i++){
				//System.out.print(l[i]+"--");
			//}
			//�ж�Ԫ�ؼ����Ƿ�Ϊ��
			Collection on = new ArrayList();
			//System.out.println(on.isEmpty());
			
			
			
			//���ϵı�������ӡ�����������
			Collection ccn = new ArrayList();
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
			//�Ѽ���ת��������
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
