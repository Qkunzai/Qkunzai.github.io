public class Teacher
{
	String zykm;//רҵ��Ŀ
	double gz;//����
	String name;//����
	int age;//����
	String sex;//�Ա�
	//ִ������������
	public Teacher(String zykm,double gz,String name,int age,String sex){
		this.zykm=zykm;
		this.gz=gz;
		this.name=name;
		this.age=age;
		this.sex=sex;
	}

	//��ʾ����
	public void jsb(){
		System.out.println("רҵ��Ŀ:"+zykm+"\t����:"+gz+"\t����:"+name+"\t����:"+age+"\t�Ա�:"+sex);
	}
}
