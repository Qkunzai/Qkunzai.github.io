import java.util.*;
public class Ruku
{
	static Shangpin[] ruku = new Shangpin [100];
	static	Scanner sc = new Scanner(System.in);
	static Add ad = new Add();
	public static void menu2(){
			System.out.println("========��ѡ��Ҫ���еĲ���=========");
			System.out.println("==========1.��ѯ�����Ʒ===========");
			System.out.println("==========2.��ѯĳ��Ʒ������=======");
			System.out.println("==========3.�����Ϣ¼��===========");
			System.out.println("==========4.�������˵�=============");
			int a = sc.nextInt();
			switch(a){
				case 1:Select.kcsp();
				break;
				case 2:Select.kcsl();
				break;
				case 3:ad.add();
				break;
				case 4:Menu1.menu();
				default: System.out.println("������������������");
				menu2();
				break;
			}
	}
}