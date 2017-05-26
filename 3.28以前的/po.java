public class po{
	public static void main(String[] args){
		int b=0;
		for(int a=1;a<=100000;a++){
			b=b+a;
		}
		System.out.println("一至十万的和是"+(long)b);
	}
}