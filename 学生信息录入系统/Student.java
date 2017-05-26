public class Student
{
	public  int id; //学生id
	public  String name;//学生姓名
	private int age;    //学生年龄
	private char sex;   //学生性别
	public Student(int id,String name,int age,char sex){
		this.id=id;						//this是表示是属于这个类的字段
		this.name=name;					//执行器将在Procedure中输入的值赋给当前类的字段
		this.age=age;
		this.sex=sex;
	}
	public void shu(){
		//输出这些字段
		System.out.println("学生id:"+id+"\t姓名:"+name+"\t年龄:"+age+"\t性别:"+sex);
	}
	//学生年龄为私有型所以创建一个公共型方法来修改年龄的属性值
	public void getage(int age){
		this.age=age;
	}
	//同上		修改性别的方法
	public void getsex(char sex){
		this.sex=sex;
	}
}