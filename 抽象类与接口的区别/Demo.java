abstract class Ab{
	int i=100;
	abstract void eat();
}
class Ac extends Ab{
	public void eat(){ 
		i++;
		System.out.println("Œ“œ≤ª∂≥‘"+i);
	}
}
public class Demo
{
	public static void  main(String[] ab1){
		Ab a = new Ac();
		a.eat();
	}
}