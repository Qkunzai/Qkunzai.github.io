public class ExceptionDemo{
	public static void main(String[] ar){
			
			ExceptionDemo ed = new ExceptionDemo();
			ed.add();
	}
	public void add(){
		int a = 0;
		int b = 1;
		int c = 0;
		try{
			c=b/a;
		}catch(Exception e){
			System.out.println("数学函数错误，被除数不能为零");
		}
	}
}