/*
��ͬͼ�ε��ܳ�
Graph�����һ�����ܳ��ĳ��󷽷�
Բ
������
*/
import java.util.*;
public class Geometry
{
	public static void main(String[] a){
		//Yuan a1 = new Yuan();
		//a1.zhouChang();
			new Son();
	}
}
class Father
{
	public Father(){
		System.out.println("....");
	}
}
class Son extends Father
{

}
abstract class Graph
{
	abstract void zhouChang();
}
class Yuan extends Graph
{
	Scanner sc = new Scanner(System.in);
	public void zhouChang(){
		double c=0;
		System.out.println("������Բ��ֱ��");
		int z = sc.nextInt();
		c = z*3.14;
		System.out.println("Բ���ܳ�:"+c);
	}
}
class SanJiao extends Graph
{
	Scanner sc = new Scanner(System.in);
	public void zhouChang(){
	System.out.println("�����������ε������߳�");
	int a = sc.nextInt();
	int b = sc.nextInt();
	int c = sc.nextInt();
	int d = a+b+c;
	System.out.println("���ǵ��ܳ���:"+d);
	}
}