public class Phone2
{
	public static void main(String[] args){
		//�ֻ���
		System.out.println();
		System.out.println("�ֻ��۸���ɫ��Ϣ��");
		Phone a=new Phone("��Ϊ",3000,"��ɫ");
		a.shou();	//����Phone�ڵ�shou����

		Phone b=new Phone("С��",1999,"��ɫ");
		b.shou();

		Phone c=new Phone("ƻ��",6900,"��ɫ");
		c.shou();

		Phone d=new Phone("LG",3500,"��ɫ");
		d.shou();
		System.out.println();

		//ѧ����
		System.out.println("ѧ����Ϣ");
		Student student1 = new Student("����",18,"��","C����","����");
		student1.say();		//����Student�ڵ�say����

		Student student2 = new Student("����",18,"��","C����","����");
		student2.say();

		Student student3 = new Student("����",18,"��","C����","����");
		student3.say();

		Student student4 = new Student("����",18,"��","C����","����");
		student4.say();

		Student student5 = new Student("����",18,"��","C����","����");
		student5.say();

		Student student6 = new Student("����",18,"��","C����","����");
		student6.say();

		Student student7 = new Student("����",18,"��","C����","����");
		student7.say();

		Student student8 = new Student("����",18,"��","C����","����");
		student8.say();
		//����
		System.out.println();
		System.out.println("�г���");
		Huo t = new Huo("T1","4/1",220.00,"����","�Ϻ�");
		t.lcb();	//����Huo�е�lcb����

		Huo h = new Huo("H1","4/2",45.30,"�ൺ","����");
		h.lcb();

		Huo g = new Huo("G1","4/3",289.00,"��ׯ","����");
		g.lcb();

		Huo g2 = new Huo("G1","4/4",450.00,"�ൺ","����");
		g2.lcb();

		//��ʦ��
		System.out.println();
		Teacher q = new Teacher("PHP",5000.00,"����",25,"��");
		q.jsb();		//����Teacher�е�jsb����
		Teacher q1 = new Teacher("C����",5500.00,"����",30,"��");
		q1.jsb();
		Teacher q2 = new Teacher("HTML",4500.00,"����",23,"Ů");
		q2.jsb();
		

		//������
		System.out.println();
		Dian[] das = new Dian [5];
		Dian da1 = new Dian("����","������",5400.00);	 //�ȴ���һ����ַ
		das[0] = da1;	//����ַ�����ݸ��Ƶ�����Ԫ����
		Dian da2 = new Dian("����","����",4999.00);
		das[1] = da2;
		//	ѭ�����
		for(int i=0;i<2;i++){
			das[i].diannao();
		}
		// ѧУ��
		System.out.println();
		School sc = new School("����һ��","��ׯ�ֵ�","3000ƽ",3500);
		sc.dc();
		School sc1 = new School("�������","000","2500ƽ",3000);
		sc1.dc();
		School sc2 = new School("��������","789","3500ƽ",2900);
		sc2.dc();
		School sc3 = new School("���겹У","14613","4000ƽ",3210);
		sc3.dc();
	}
}