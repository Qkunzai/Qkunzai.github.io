import java.util.*;
public class Kuncun
{
	static Scanner sc = new Scanner(System.in);
	static Add ad = new Add();
	public static void menu3(){
			System.out.println("======请输入对应数字来进行操作========");
			System.out.println("======1.出库消息查询==========");
			System.out.println("======2.出库信息记录==========");
			System.out.println("======3.清除已出库的商品记录==");
			int a = sc.nextInt();
			switch(a){
				case 1:Select.ckxx();
				break;
				case 2:ad.add2();
				break;
				case 3:Delete.spjl();
				break;
				default: System.out.println("输入有误请重新输入");
				menu3();
				break;
			}
	}
}