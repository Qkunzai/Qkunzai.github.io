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
			System.out.println("第一条边="+a+"第二条边="+b+"第三条边="+c);
		}else{
			throw new IllegalArgumentException ("因为有两边相加小于第三边所以不能构成三角形");
		 }
	}
}