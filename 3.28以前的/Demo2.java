public class Demo2
{
	
	public static void main(String[] args){
	
		int [] a = new int []{9,80,60};
		int t;
		System.out.println("第一个数="+a[0]+"第二个数="+a[1]+"第三个数="+a[2]);
		b(a,0,1,2);
		System.out.println("第一个数="+a[0]+"第二个数="+a[1]+"第三个数="+a[2]);
	}
	private static void b(int [] a,int b,int c,int d){
		for(int e=0;e<2;e++){
			if(a[b]<a[c]){
				int i=a[b];
				a[b]=a[c];
				a[c]=i;
			}else if(a[c]<a[d]){
				int i=a[c];
					a[c]=a[d];
					a[d]=i;


			}
		}
	}


}