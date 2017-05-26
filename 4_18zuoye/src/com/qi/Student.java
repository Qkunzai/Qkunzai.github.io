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
	//��дObject��hashCode()����
	public int hashCode(){
		final int i =31;
		int s =1;
		s = i*s+age;
		s = i*s+((name == null)?0:name.hashCode());
		return s;
	}
	//��дObject��Equals����()
	public boolean equals(Object o){
		//�����ǰ����ֵ�봫������������ͬ
		if(this == o){
			return true;
		}
		//����������������ǿ�ֵ
		if(o == null){
			return false;
		}
		//���������������뵱ǰ����ͬ
		if(getClass()!=o.getClass()){
			return false;
		}
		//����������������ǿ��ת��ΪStudent����
		Student ce = (Student)o;
		//��� ��ǰ��age�ֶ�����ֵ�봫�����Ķ���age�ֶ�����ֵ��ͬ�򷵻�false
		if(age != ce.age)
			return false;
		//�����ǰname�ֶ�ֵΪ��ʱ
		if(name == null){
			//���������Ķ���name�ֶβ�Ϊ��ʱ֤������������ȣ�����false
			if(ce.name != null)
				return false;
		}else if(!name.equals(ce.name))		//���������ǰ�ֶ�����ֵ�봫��������ֶ�ֵ����ͬʱ����false
			return false;
		//�������ȫ������true
		return true;
	}	
}



















