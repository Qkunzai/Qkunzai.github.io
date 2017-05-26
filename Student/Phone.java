 public class Phone
{
	String pName;//品牌名
	int price;//价格
	String color;//颜色
 public Phone(String pName,int price,String color){
	this.pName=pName;
	this.price=price;
	this.color=color;
}
 public void shou(){
	System.out.println("品牌:"+pName+"\t价格:"+price+"\t颜色："+color);
 }
}