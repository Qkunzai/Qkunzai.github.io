import java.util.Scanner;
public class Calculator2
{
	public static void main(String[] args){
		System.out.println("�������������ֽ��м���");
		Scanner d=new Scanner(System.in);
		System.out.println("�������һ������");
		int a=d.nextInt();
		System.out.println("������һ���������");
		String c=d.next();
		System.out.println("������ڶ�������");
		int b=d.nextInt();
		if(c.equals("+")){
			 System.out.println("���Ϊ"+(a+b));
		}else if(c.equals("-")){
			 System.out.println("���Ϊ"+(a-b));
		}else if(c.equals("*")){
			 System.out.println("���Ϊ"+(a*b));
		}else if(c.equals("/")){
			if(b==0){
			 System.out.println("����������Ϊ0");
			}
			 System.out.println("���Ϊ"+(a/b));
		}
	}
}