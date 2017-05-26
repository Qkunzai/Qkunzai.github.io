class EnumClass 
{
	public static void main(String[] args) 
	{
		/*EnumDemo ed = EnumDemo.ON;
		System.out.println(ed);//拿的是定义的值
		System.out.println(ed.name());//返回枚举的实例名称
		System.out.println(ed.ordinal());//返回当前实例的索引
		EnumDemo[] ed2 = ed.values();//将枚举类定义成数组
		for(EnumDemo e:ed2){
			System.out.println(e);
		}*/

		EnumDemo1 ed = EnumDemo1.RED;
		System.out.println(ed.getName());

	}
}
//定义枚举类
/*enum EnumDemo{
	// String ON = "ON";
	ON,OFF
}*/
//枚举类的构造方法
enum EnumDemo1{
	RED("红色"),GREEN("绿色"),BLUE("蓝色");
	private String name;
	private EnumDemo1(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public String toString(){
		return this.name;	
	}
}
























