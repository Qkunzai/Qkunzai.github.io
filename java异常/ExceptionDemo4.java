import java.util.*;
public class ExceptionDemo4{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] ar){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			ExceptionDemo4 ed = new ExceptionDemo4();
			try{
			ed.sanjiao(a,b,c);
			}catch(IllegalArgumentException i){
				i.printStackTrace();
			}
	}
	void sanjiao(int a,int b,int c){
		if(a+b > c && a+c > b && b+c > a){
			System.out.println("��һ����="+a+"�ڶ�����="+b+"��������="+c);
		}else{
			throw new IllegalArgumentException ("��Ϊ���������С�ڵ��������Բ��ܹ���������");
		 }
	}
}