public class Beishu2
{
	public static void main(String[] args){
		int x,y=0;
		for(x=1;x<=100;x++){
			if(x%3==0){
				System.out.println("��3������������"+x);
				y++;
				if(y==5){
					break;
				}
			}
		}
	}
}