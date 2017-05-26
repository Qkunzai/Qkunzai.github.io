import java.util.*;
public class Add extends Ruku
{
	static Scanner sc = new Scanner(System.in);
	static int i=0;
	public static void add(){
		System.out.println("请输入商品名称");
		String sname = sc.next();
		System.out.println("请输入商品价格");
		double price = sc.nextDouble();
		System.out.println("请输入商品数量");
		int number = sc.nextInt();
		System.out.println("请输入入库日期");
		String time = sc.next();
		System.out.println("请输入商品类型");
		String type = sc.next();
		Shangpin b = new Shangpin(sname,price,number,time,type);
		ruku[i++] = b;
		boolean flge=true;
		while(flge){
			System.out.println("添加成功，请选择1.继续添加  2.返回主菜单");
			int a = sc.nextInt();
				switch(a){
				case 1:add();
				flge = false;
				break;
				case 2:Menu1.menu();
				flge = false;
				break;
				default:System.out.println("输入错误请重新输入");
			}
		}
	}
	public static void add2(){
		System.out.println("请输入商品名称");
		String sname = sc.next();
		System.out.println("请输入商品价格");
		double price = sc.nextDouble();
		System.out.println("请输入商品数量");
		int number = sc.nextInt();
		System.out.println("请输入出库日期");
		String time = sc.next();
		System.out.println("请输入商品类型");
		String type = sc.next();
		Shangpin b = new Shangpin(sname,price,number,time,type);
		ruku[i++] = b;
	}
}