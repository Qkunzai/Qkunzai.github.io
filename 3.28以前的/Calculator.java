import java.util.Scanner;
public class Calculator
{
	public static void main(String[] args){
		System.out.println("请输入一个数字");
		Scanner  sc = new Scanner(System.in);
		int a=sc.nextInt();		//输入数字a
		System.out.println("请再输入一个数字");
		int b=sc.nextInt();		//输入数字b
		System.out.println("和为"+(a+b));
		System.out.println("乘积为"+(a*b));
		if(b==0){
			System.out.println("除数不能为零");
		}else{
			System.out.println("商为"+((double)a/b));
		}
		System.out.println("余为"+(a-b));
	}
}