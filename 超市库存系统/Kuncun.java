import java.util.*;
public class Kuncun
{
	static Scanner sc = new Scanner(System.in);
	static Add ad = new Add();
	public static void menu3(){
			System.out.println("======�������Ӧ���������в���========");
			System.out.println("======1.������Ϣ��ѯ==========");
			System.out.println("======2.������Ϣ��¼==========");
			System.out.println("======3.����ѳ������Ʒ��¼==");
			int a = sc.nextInt();
			switch(a){
				case 1:Select.ckxx();
				break;
				case 2:ad.add2();
				break;
				case 3:Delete.spjl();
				break;
				default: System.out.println("������������������");
				menu3();
				break;
			}
	}
}