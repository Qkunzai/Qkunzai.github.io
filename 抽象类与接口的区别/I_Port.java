interface P_Port{
	String i = "Ã×·¹";
	void eat();
}
class A implements P_Port{
	public void eat(){
		System.out.println("ÎÒÏ²»¶³Ô"+i);
	} 
}
public class I_Port
{
	public static void main(String[] a){
		P_Port p = new A();
		p.eat();
	}
}