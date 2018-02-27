import java.util.*;
public class Ruku
{
	static Shangpin[] ruku = new Shangpin [100];
	static	Scanner sc = new Scanner(System.in);
	static Add ad = new Add();
	public static void menu2(){
			System.out.println("========请选择要进行的操作=========");
			System.out.println("==========1.查询库存商品===========");
			System.out.println("==========2.查询某商品的类型=======");
			System.out.println("==========3.入库信息录入===========");
			System.out.println("==========4.返回主菜单=============");
			int a = sc.nextInt();
			switch(a){
				case 1:Select.kcsp();
				break;
				case 2:Select.kcsl();
				break;
				case 3:ad.add();
				break;
				case 4:Menu1.menu();
				default: System.out.println("输入有误请重新输入");
				menu2();
				break;
			}
	}
}