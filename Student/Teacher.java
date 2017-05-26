public class Teacher
{
	String zykm;//专业科目
	double gz;//工资
	String name;//姓名
	int age;//年龄
	String sex;//性别
	//执行器参数传递
	public Teacher(String zykm,double gz,String name,int age,String sex){
		this.zykm=zykm;
		this.gz=gz;
		this.name=name;
		this.age=age;
		this.sex=sex;
	}

	//显示方法
	public void jsb(){
		System.out.println("专业科目:"+zykm+"\t工资:"+gz+"\t姓名:"+name+"\t年龄:"+age+"\t性别:"+sex);
	}
}
