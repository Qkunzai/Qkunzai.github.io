public class Beishu{
	public static void main(String[] args){
		int x,y=0;
		for(x=1;x<=100;x++){
			if(x%3==0){
				System.out.println("被3整除的数字有"+x);
				y++;
			}
		}
		System.out.println("一共有"+y+"个数字");
	}	
}