import java.util.*;
public class Paixu
{
	public static void main(String[] args){
		int []a= new int [10];
		int y=9;
		Scanner sc=new Scanner(System.in);
		//ѭ������
		for(int i=0;i<10;i++){
			a[i] = sc.nextInt(); 
		}
		for(int x=0;x<10;x++){
			while(a[x]<a[y]&&){
				y--;
			}
			a[x]=a[y];
		}
	}
}