import java.util.*;
public class Menu1
{
	static Scanner sc = new Scanner(System.in);
	public static void menu(){
		System.out.println("========��ѡ��Ҫ����Ĳ˵�======");
		System.out.println("======1.������˵�======");
		System.out.println("======2.�������˵�======");
		System.out.println("======3.�˳��˵�==========");
		int a = sc.nextInt();
		switch(a){
			case 1: Ruku.menu2();
			break;
			case 2: Kuncun.menu3();
			break;
			case 3: System.exit(0);
			break;
			default: System.out.println("������������������");
			menu();
			break;
		}
	}
}