import java.util.*;
public class Password
{
	public static void main(String[] args){
		int dc=0,tc=0,ec=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("�������������"+" , "+"������ĸ��ͷ");
		//
		//while(true){
			String le=sc.next();
			char [] a=le.toCharArray();
			for(int i=0;i<le.length();i++)
			System.out.println(a[i]);
		//	if(le.length()<=5 || le.length()>=12)
		//		System.out.println("����������");
		for(int i=0;i<le.length();i++){
			if(a[i]>=48 && a[i]<=57){
					dc=1;
					if(a[i]>='A' && a[i]<='Z' || a[i]>='a' && a[i]<='z')
						tc=1;
					if(a[i]>='!' && a[i]<='@')
						ec=1;
				continue;
			}	
		//	if(a[i]>='A' && a[i]<='Z' || a[i]>='a' && a[i]<='z'){
			//		dc=2;
			//	if(a[i]>=33 && a[i]<=64){
			//		dc=1;
			//		break;
			//	}
				//continue;
			//}
		}
		//}
			if(dc==1 && tc==1 && ec==1)
				System.out.println("ǿ");
			if(dc==1 && tc==1)
				System.out.println("�е�");
			if(dc==1)
				System.out.println("��");
			if(dc==1 && ec==1)
				System.out.println("�е�");
		}
	}