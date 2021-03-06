import java.util.*;			//调用util包的全部类
public class Procedure
{	//定义成员变量
	//成员变量可以在全局使用
	// static的作用是静态类 生命周期只有在定义的类内
	static Scanner sc = new Scanner(System.in);		//调用util包中的Scanner类
	static int  i=0;								//定义一个静态变量i
	static Student[] st = new Student [100];		//将st定义为数组来储存输入的数据 输入的数据会传送到Student内
	static boolean fg=true;							//定义一个布尔值fg初始值为true
	static boolean flge = true;						//定义一个布尔值fgle初始值为true
	static int dy=0;								//定义一个变量dy
	public static void main(String[] args){
		//以main函数入口进入主菜单
		menu1();
	}
//主菜单一列
public static void menu1()
{	//菜单界面
	System.out.println("=====请输入数字,选择要使用的应用=====");
	System.out.println("=====1.添加学生信息======");
	System.out.println("=====2.修改学生信息======");
	System.out.println("=====3.查询学生信息======");
	System.out.println("=====4.删除学生信息======");
	System.out.println("=====5.退出操作系统======");
	//选择各功能应用
	int flag = sc.nextInt();
	//利用分支结构进入功能选项
	switch(flag){
		case 1:add();
			   break;
		case 2:update();
			   break;
		case 3:select();
			   break;
		case 4:delete();
			   break;
		case 5:System.exit(0);
			   break;
		default:System.out.println("输入错误请重新输入!");
				menu1();
	}

}
//录入信息应用
public static void add()
{			//录入信息输入
			char sex = '女';
			System.out.println("录入学生信息");
			System.out.print("请输入学生id:");
			int id = sc.nextInt();
			System.out.print("请输入学生姓名:");
			String name = sc.next();
			System.out.print("请输入学生年龄:");
			int age = sc.nextInt();
			System.out.print("请输入学生性别:");
				try{
					sex = sc.next().charAt(0);
				}catch(StringIndexOutOfBoundsException a){
					System.out.println("输入错误请重新输入");
					add();
				 }
			//利用循环给数组赋值进行储存
			Student b = new Student(id,name,age,sex);
			st[i++]=b;
			//添加成功后的选择
			System.out.println("添加成功");
			System.out.println("请选择一下选项");
			System.out.println("=====1.继续输入======");
			System.out.println("=====2.返回菜单======");
			int a = sc.nextInt();
			if(a==1){
				add();

			}else{

				menu1();
			}
}
//修改已储存的学生信息
public static void update(){
	System.out.println("请输入想要修改的学生姓名:");
	//输入想要查询的学生姓名
	String xg = sc.next();
	//利用对数组的循环比值来找到对应的人
	for(int i=0;i<st.length;i++){
		if(st[i]!=null){			//当这个数组元素不为空时
			if(xg.equals(st[i].name)){		//当输入的数据与所查询的数据相同时
				System.out.println("请选择想要修改的数据");
				System.out.println("1.姓名 2.性别 3.年龄");
				int dy = sc.nextInt();		//1.输入数字来选择自己想要修改的选项
				if(dy==3){
					System.out.print("请输入修改的属性值:");
					int age = sc.nextInt();		//输入想要修改的属性值
					st[i].getage(age);		//调用Student类内的方法getage
					System.out.println("修改成功");
					menu1();
				}else if(dy==2){		//注释同1
					System.out.println("请输入修改的属性值:");
					char sex = sc.next().charAt(0);
					st[i].getsex(sex);
					System.out.println("修改成功");
					menu1();
				}else if(dy==1){		//注释同1
					System.out.println("请输入修改的属性值:");
					st[i].name = sc.next();
					System.out.println("修改成功");
					menu1();
				}
			}
		}
	}

}
//查询应用
public static void select(){
	System.out.println("请按照输入数字来进行操作");
	System.out.println("=====1.显示所有输入的学生信息======");
	System.out.println("=====2.输入学生id来查询学生信息======");
	//输入数字来选择查询的类型
	int pd = sc.nextInt();
	//输出所有已保存的数据
	if(pd==1){
		for(Student s:st){
			if(s!=null)
			s.shu();
		}
		//定义一个布尔值，进行循环
		boolean nn=true;
		while(nn){
			//选择进入查询应用的选项
			System.out.println("请选择进入的菜单");
			System.out.println("1.返回到查询菜单");
			System.out.println("2.返回到主菜单");
			//输入进入选项1或2 输入1，2以外的数字会进入else内容
			int i = sc.nextInt();
				if(i==1){
						select();
				}
				else if(i==2){
						menu1();
				}else{
						System.out.println("输入有误，请重新输入");
				}
		}
	}else if(pd==2){		//选项2内容以学生id来查询具体的学生信息
		int id1=0,t=0;
		System.out.print("请输入学生id:");
		id1 = sc.nextInt();
		for(Student s:st){		//进行循环比值
			if(s!=null && id1 == s.id){		//当这个元素不为空并且输入的id数据与元素内容相同时
				s.shu();					//调用Student中的shu()方法
				boolean nn = true;			//定义一个布尔值来创建一个循环
				while(nn){					//当nn的返回值为true时进行循环
				System.out.println("请选择进入的菜单");
				System.out.println("1.返回到查询菜单");
				System.out.println("2.返回到主菜单");
				int i = sc.nextInt();		//输入一个数字来进行选择进入的应用
					if(i==1){
						select();
					}
					else if(i==2){
						menu1();
					}else{
						System.out.println("输入有误，请重新输入");
					}
				}
			}else if(id1!=s.id && s==null){				//当这个数组元素不等于id且数组元素为空时
				System.out.println("查询不到该学生信息,请输入数字选择进入的菜单");
				System.out.println("======1.返回到主菜单======");
				System.out.println("======2.返回到查询菜单======");
				int sr = sc.nextInt();
				switch(sr){
					case 1:menu1();
					break;
					case 2:select();
					break;
					default: System.out.print("输入有误即将返回菜单:"); menu1();
					break;
				}
			}
		}
	}
}
//删除已储存的学生信息
public static void delete(){
		System.out.println("请输入想要删除的学生id:");
		//输入学生id
		int xg = sc.nextInt();
		//进行循环比值，来比较各个元素中的内容
		for(int i=0;i<st.length;i++){
			if(st[i]!=null)		//当这个元素不为空时
				if(xg==st[i].id){		//当输入的数据与元素数据相同时
						st[i]=null;		//给元素重新赋值为null(空)
						System.out.println("删除成功，即将返回主菜单");
						menu1();
			}
		}		
}
}