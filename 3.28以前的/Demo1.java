public class Demo1
{
	
	public static void main(String []args){
	
		int a=1;
		int b=2;
		c(a,b);
		System.out.println("a="+a+"b="+b);
	
	}
	private static void c(int a,int b){
		int d=a;
		a=b;
		b=d;
		System.out.println("a="+a+"b="+b);
	}
}