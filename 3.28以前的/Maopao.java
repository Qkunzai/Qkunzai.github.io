import java.util.*;
public class Maopao
{
	public static void main(String [] args){
		int []a = new int [10];
		int d;
		Scanner sc=new Scanner(System.in);
		//循环输入
		for(int i=0;i<10;i++){
			a[i]=sc.nextInt();
		}
		//大数降低位置，小数上升
		//循环比较八次
		//如果循环十次的话会运行11次就会超出数组长度，从而报错
		for(int i=0;i<9;i++){
			for(int c=0;c<9-i;c++){
				if(a[c]>a[c+1]){
					//使用了空杯子换值的方法
					d=a[c];
					a[c]=a[c+1];
					a[c+1]=d;
				}
			}
		}
		//循环输出
		/*for(int i=0;i<10;i++){
			System.out.println(""+a[i]);
		}*/
		int b=Arrays.binarySearch(a,20);
		System.out.println(b);
	}
}