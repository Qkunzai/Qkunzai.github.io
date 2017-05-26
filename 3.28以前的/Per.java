public class Per{
	public static void main(String args[]){
		int i,y,s;
		for(i=1;i<=1000;i++){
			s=1;
			for(y=2;y<i;y++){
				if(i%y==0){
					s=s+y;
				}
			}
			if(i==s){
				System.out.print("ÍêÊýÊÇ\t"+i);
			}
		}
	}
}