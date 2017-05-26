import java.util.Scanner;
public class Calculator2
{
	public static void main(String[] args){
		System.out.println("请输入两个数字进行计算");
		Scanner d=new Scanner(System.in);
		System.out.println("请输入第一个数字");
		int a=d.nextInt();
		System.out.println("请输入一个运算符号");
		String c=d.next();
		System.out.println("请输入第二个数字");
		int b=d.nextInt();
		if(c.equals("+")){
			 System.out.println("结果为"+(a+b));
		}else if(c.equals("-")){
			 System.out.println("结果为"+(a-b));
		}else if(c.equals("*")){
			 System.out.println("结果为"+(a*b));
		}else if(c.equals("/")){
			if(b==0){
			 System.out.println("被除数不能为0");
			}
			 System.out.println("结果为"+(a/b));
		}
	}
}