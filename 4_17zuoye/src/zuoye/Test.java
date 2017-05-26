package zuoye;

public class Test {
	public static void main(String[] args){
	suan();
	} 
	static int suan(){
		int a =10;
		int b = 0,c=0;
		try{
			c=a/b;
			return 0;
		}catch(Exception e){
			System.out.println("´íÎó");
		}finally{
			System.out.println("Ê§°Ü");
		}
		return c;
	}
}
