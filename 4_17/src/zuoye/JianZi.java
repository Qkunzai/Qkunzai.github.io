package zuoye;
import java.util.*;
public class JianZi {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		boolean flag = true;
		//����yunSuan()�����п����׳����쳣
		try{
		yunSuan();
		}catch(InputMismatchException w){
			System.out.println("�Բ��𣬲��������������������ַ�����Ϸ��ֹ��");
		}
		//����ѭ��ѡ���Ƿ����������Ϸ
		while(flag){
		try{
		System.out.println("----����ѡ��1,�˳�ѡ��2");
		int b = sc.nextInt();
		switch(b){
		case 1:yunSuan();
		break;
		case 2:System.exit(0);
		System.out.println("�����˳���Ϸ");
		flag = false;//��ѡ���˳���Ϸʱ�˳�ѭ��
		break;
		default:System.out.println("���������˳���Ϸ");
		System.exit(0);
		break;
		}
		}catch(InputMismatchException w){
			System.out.println("�Բ��𣬲��������������������ַ�����Ϸ��ֹ��");
		}
		}
	}
	//�������һ�����ֵ�yunSuan()�����������бȽ�
	static int suanFa(){
		return (int)(Math.random()*3+1);
	}
	//�׳�һ���쳣����main�������д���
	static void yunSuan() throws InputMismatchException{
	System.out.println("----С��Ϸ:��ȭ----");
	System.out.println("----������һ��������ѡ��  1.����  2.��  3.ʯͷ----");
	System.out.println("----�����1��2��3��������ֿ����˳���Ϸ----");
	int a = sc.nextInt();
	int c = 0;
	//ѡ��˵�
	switch(a){
	/**
	 * �����ѡ��1ʱ
	 * ���suanFa()�������ص�������1����ƽ��
	 * �����2���ʤ��
	 * �����3�����ʤ��
	 * 
	 * 
	 * �����ѡ��2ʱ
	 * suanFa()��������������1�����ʤ��
	 * suanFa()��������������2����ƽ��
	 * suanFa()��������������3�������ʤ��
	 * 
	 * 
	 * �����ѡ��3ʱ
	 * suanFa()��������������1�����ʤ��
	 * suanFa()��������������2����ƽ��
	 * suanFa()��������������3���ǵ���ʤ��
	 * 
	 * �����1 2 3�������������˳���Ϸ
	 * */
	case 1:System.out.println("���:����");
	System.out.println();
	c = suanFa();
	if(c==1){
		System.out.println("����:���� ");
		System.out.println();
		System.out.println("ƽ��");
	}else if(c==2){
		System.out.println("����:��");
		System.out.println();
		System.out.println("���ʤ����");
	}else{
		System.out.println("����:ʯͷ");
		System.out.println();
		System.out.println("����ʤ����");
	}
	break;
	case 2:System.out.println("���:��");
	System.out.println();
	c = suanFa();
	if(c==1){
		System.out.println("����:����");
		System.out.println();
		System.out.println("����ʤ����");
	}else if(c==2){
		System.out.println("����:��");
		System.out.println();
		System.out.println("ƽ��");
	}else{
		System.out.println("����:ʯͷ");
		System.out.println();
		System.out.println("���ʤ����");
	}
	break;
	case 3:System.out.println("���:ʯͷ");
	System.out.println();
	c = suanFa();
	if(c==1){
		System.out.println("����:����");
		System.out.println();
		System.out.println("���ʤ����");
	}else if(c==2){
		System.out.println("����:��");
		System.out.println();
		System.out.println("����ʤ����");
	}else{
		System.out.println("����:ʯͷ");
		System.out.println();
		System.out.println("ƽ��");
	}
	break;
	default:System.out.println("�Բ����޴�ѡ��˳���Ϸ");
	System.exit(0);
	break;
	}
	}
}
