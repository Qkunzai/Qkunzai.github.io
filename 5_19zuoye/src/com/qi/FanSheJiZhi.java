package com.qi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class FanSheJiZhi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class<?> calss1 = null;
		Class<?> calss2 = null;
		try {
			calss1 = Class.forName("com.qi.LLQTest");
			calss2 = new LLQTest().getClass();
			System.out.println("������    "+calss1.getName());
			System.out.println("������    "+calss2.getName());
			Class<?> class1 = null;
			class1 = Class.forName("com.qi.A");
			//ʵ����Ĭ�Ϲ��췽��������set����
			A a = (A) class1.newInstance();
			a.setAge(100);
			a.setName("������");
			System.out.println(a);
			//ȡ�����еĹ��캯����ʹ�ù��캯����ֵ
			Constructor<?> cons[] = class1.getConstructors();
			//�鿴ÿ�����췽����Ҫ�Ĳ���
			for(int i=0;i < cons.length; i++){
				Class<?> clazzs[] = cons[i].getParameterTypes();
				System.out.print("cons["+i+"] (");
				for(int j=0;j<clazzs.length;j++){
					if(j == clazzs.length  -1)
					System.out.print(clazzs[j].getName());
					else
						System.out.print(clazzs[j].getName() + ",");
				
				}
				System.out.println(")");
			}
		Class class2 = Class.forName("com.qi.LLQTest");
		//�������е�public�����������丸��ģ����û�з��������ؿ�����
		Method method[] = class2.getMethods();
		for(int i=0 ; i < method.length; ++i){
			//��ȡ��������ֵ����
			Class<?> returnType = method[i].getReturnType();
			//���ط���������ע����Ϣ
			Class<?> para[] = method[i].getParameterTypes();
			//��ȡ���������η�������ֵ��ͨ��Modifier����н��
			int temp = method[i].getModifiers();
			System.out.print(Modifier.toString(temp) + "");	//������������η�
			System.out.print(returnType.getName() + "");	//��������ֵ������
			System.out.print(method[i].getName() + "");	//�������з���������
			System.out.println();
			for (int j = 0; j < para.length; ++j){
				System.out.print(para[j].getName() + "" + "arg" + j);
				if(j < para.length-1){
					System.out.print(",");
				}
			}
			Class<?> exce[] = method[i].getExceptionTypes();
			if(exce.length > 0){
				
				System.out.print(") throws");
				for (int k = 0; k< exce.length; ++k){
					System.out.print(exce[k].getName() + "");
					if (k < exce.length - 1){
						System.out.print(",");
					}
				}
				
			}else{
				System.out.print(")");
			}
			System.out.println();
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
class A{
	private String name;
	private int age;
	public A(){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		super();
	}
	public A(String name){
		super();
		this.name = name;
	}
	public A(String name,int age){
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	//��ӡʱֱ�����toString();
	public String toString() {
		return "A [name=" + name + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
