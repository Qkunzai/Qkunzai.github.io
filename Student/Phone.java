 public class Phone
{
	String pName;//Ʒ����
	int price;//�۸�
	String color;//��ɫ
 public Phone(String pName,int price,String color){
	this.pName=pName;
	this.price=price;
	this.color=color;
}
 public void shou(){
	System.out.println("Ʒ��:"+pName+"\t�۸�:"+price+"\t��ɫ��"+color);
 }
}