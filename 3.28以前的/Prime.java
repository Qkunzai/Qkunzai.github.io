public class Prime{
	public static void main(String args[]){
		int i,x,y=10;
		for(i=100;i<=1000;i++){
			for(x=2;x<i;x++){
				if(i%x==0){
						y=1;
						break;
				}else{
						y=0;
					}
			}
			if(y==0){
			System.out.print("������\t"+i);
			}
		}
	}
}