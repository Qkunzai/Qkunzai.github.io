package com.qi;

public class Student {
	private String name;
	private int age;
	public Student(){}
	public Student(String name,int age){
		this.setName(name);
		this.setAge(age);
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
	//覆写Object的hashCode()方法
	public int hashCode(){
		final int i =31;
		int s =1;
		s = i*s+age;
		s = i*s+((name == null)?0:name.hashCode());
		return s;
	}
	//覆写Object的Equals方法()
	public boolean equals(Object o){
		//如果当前属性值与传过来的属性相同
		if(this == o){
			return true;
		}
		//如果传过来的属性是空值
		if(o == null){
			return false;
		}
		//如果传输过来的类与当前类相同
		if(getClass()!=o.getClass()){
			return false;
		}
		//将传输过来的类进行强制转换为Student类型
		Student ce = (Student)o;
		//如果 当前的age字段属性值与传过来的对象age字段属性值不同则返回false
		if(age != ce.age)
			return false;
		//如果当前name字段值为空时
		if(name == null){
			//而传过来的对象name字段不为空时证明，两对象不想等，返回false
			if(ce.name != null)
				return false;
		}else if(!name.equals(ce.name))		//否则如果当前字段属性值与传输过来的字段值不相同时返回false
			return false;
		//其他情况全部返回true
		return true;
	}	
}



















