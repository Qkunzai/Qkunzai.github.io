public class Factorial
{
	public static void main(String[] args){
		int sum=0,b,c;
		for(int a=1;a<=10;a++){
				for(b=1,c=1;b<=a;b++){
					c=c*b;
					System.out.println(""+c);
				}	
			sum=sum+c;
		}
		System.out.println("1至10的阶乘结果是"+sum);
	}
}