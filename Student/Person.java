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
		System.out.println("文艺青年吃饭");
	}
	public void set(){
		System.out.println("文艺青年走路");
	}
	public void show(){
		eat();
		set();
	}
}
class NormalMan extends PersonDemo
{
	public void set(){
		System.out.println("普通青年走路");
	}
	public void eat(){
		System.out.println("普通青年吃饭");
	}
	public void show(){
		eat();
		set();
	}
}