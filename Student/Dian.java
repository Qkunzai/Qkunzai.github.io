public class Dian
{
	String dname;//����Ʒ��
	String xh;//�����ͺ�
	double price;//�۸�

	//ִ����
	public Dian(String dname,String xh,double price){
		this.dname=dname;
		this.xh=xh;
		this.price=price;
	}
	//������
	public void diannao(){
		System.out.println("����Ʒ��"+dname+"\t�����ͺ�"+xh+"\t�۸�"+price);
	}
}