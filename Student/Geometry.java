/*
求不同图形的周长
Graph类包含一个求周长的抽象方法
圆
三角形
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
		System.out.println("请输入圆的直径");
		int z = sc.nextInt();
		c = z*3.14;
		System.out.println("圆的周长:"+c);
	}
}
class SanJiao extends Graph
{
	Scanner sc = new Scanner(System.in);
	public void zhouChang(){
	System.out.println("请输入三角形的三条边长");
	int a = sc.nextInt();
	int b = sc.nextInt();
	int c = sc.nextInt();
	int d = a+b+c;
	System.out.println("三角的周长是:"+d);
	}
}