import java.util.*;
public class ExceptionDemo2{
	Scanner sc = new Scanner(System.in);
		public static void main(String[] ar){
			ExceptionDemo2 ed = new ExceptionDemo2();
			try{
				ed.add();
			}catch(StringIndexOutOfBoundsException a){
				System.out.println("�����������������");
				ed.add();
			}
		}
	public void add() throws StringIndexOutOfBoundsException{
		char sex = sc.next().charAt(1);
	}
}