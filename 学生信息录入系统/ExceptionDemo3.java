import java.util.*;
public class ExceptionDemo3
{
	int [] a = new int [5];
	Scanner sc = new Scanner(System.in);
	public static void main(String[] ar){
		ExceptionDemo3 ed = new ExceptionDemo3();
			ed.sum();
	}
	public void	sum(){
		try{
			for(int i = 0; i<5;i++){
				a[i] = sc.nextInt();
			}
		}catch(Exception e){
			System.out.println("ÇëÊäÈëÕûÊý");
		}
	}
}