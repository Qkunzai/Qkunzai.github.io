public class Dian
{
	String dname;//电脑品牌
	String xh;//电脑型号
	double price;//价格

	//执行器
	public Dian(String dname,String xh,double price){
		this.dname=dname;
		this.xh=xh;
		this.price=price;
	}
	//方法体
	public void diannao(){
		System.out.println("电脑品牌"+dname+"\t电脑型号"+xh+"\t价格"+price);
	}
}