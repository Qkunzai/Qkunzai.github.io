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
			System.out.println("类名称    "+calss1.getName());
			System.out.println("类名称    "+calss2.getName());
			Class<?> class1 = null;
			class1 = Class.forName("com.qi.A");
			//实例化默认构造方法，调用set辅助
			A a = (A) class1.newInstance();
			a.setAge(100);
			a.setName("何礼赞");
			System.out.println(a);
			//取得所有的构造函数，使用构造函数赋值
			Constructor<?> cons[] = class1.getConstructors();
			//查看每个构造方法需要的参数
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
		//返回所有的public方法，包括其父类的，如果没有方法，返回空数组
		Method method[] = class2.getMethods();
		for(int i=0 ; i < method.length; ++i){
			//获取方法返回值类型
			Class<?> returnType = method[i].getReturnType();
			//返回方法参数的注解信息
			Class<?> para[] = method[i].getParameterTypes();
			//获取方法的修饰符，返回值可通过Modifier类进行解读
			int temp = method[i].getModifiers();
			System.out.print(Modifier.toString(temp) + "");	//解读方法的修饰符
			System.out.print(returnType.getName() + "");	//方法返回值的类型
			System.out.print(method[i].getName() + "");	//返回所有方法的名称
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
	//打印时直接输出toString();
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
