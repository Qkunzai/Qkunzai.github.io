public class Student 
{
	String name; //姓名
	int age; //年龄
	String sex;//性别
	String zy;//专业
	String ah;//爱好

	public Student(String name,int age,String sex,String zy,String ah){
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.zy=zy;
		this.ah=ah;
	}
	public void say(){
		System.out.println("姓名："+name+"\t年龄:"+age+"\t性别:"+sex+"\t专业:"+zy+"\t爱好:"+ah);
	}
}