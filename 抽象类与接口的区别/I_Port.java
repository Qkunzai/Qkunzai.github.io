interface P_Port{
	String i = "�׷�";
	void eat();
}
class A implements P_Port{
	public void eat(){
		System.out.println("��ϲ����"+i);
	} 
}
public class I_Port
{
	public static void main(String[] a){
		P_Port p = new A();
		p.eat();
	}
}