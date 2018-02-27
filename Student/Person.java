public class Person
{
	public static void main(String[] args){
		ArtMan a1 = new ArtMan();
		a1.show();
		NormalMan a2 = new NormalMan();
		a2.show();
	}
}
abstract class PersonDemo
{
	abstract void eat();
	abstract void set();
}
class ArtMan extends PersonDemo
{
	public void eat(){
		System.out.println("��������Է�");
	}
	public void set(){
		System.out.println("����������·");
	}
	public void show(){
		eat();
		set();
	}
}
class NormalMan extends PersonDemo
{
	public void set(){
		System.out.println("��ͨ������·");
	}
	public void eat(){
		System.out.println("��ͨ����Է�");
	}
	public void show(){
		eat();
		set();
	}
}