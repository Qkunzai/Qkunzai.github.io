import java.util.*;
public class Menu1
{
	static Scanner sc = new Scanner(System.in);
	public static void menu(){
		System.out.println("========请选择要进入的菜单======");
		System.out.println("======1.进入库存菜单======");
		System.out.println("======2.进入出库菜单======");
		System.out.println("======3.退出菜单==========");
		int a = sc.nextInt();
		switch(a){
			case 1: Ruku.menu2();
			break;
			case 2: Kuncun.menu3();
			break;
			case 3: System.exit(0);
			break;
			default: System.out.println("输入有误请重新输入");
			menu();
			break;
		}
	}
}