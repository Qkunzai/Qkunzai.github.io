package zuoye;
import java.util.*;
public class CaiPiao {
	static Scanner sc = new Scanner(System.in);
	static int suanFa(){
		return (int)(Math.random()*20);
	}
	
	public static void main(String[] args){
		System.out.println("-----��ƱС��Ϸ-----");
		System.out.println();
		int jk=0;
		//����һ������Ϊ5������������suanFa()�������ص��������
		int[] a = new int[5];
		for(int i =0;i<5;i++){
			a[i]=suanFa()+1;
			//�������ֲ��ظ�
			if(i!=0){
			if(a[i]==a[i-1]){
				a[i]=suanFa()+1;
			}
			}
		}
		//�Ӽ�������������������бȽ�
		System.out.println("-----����1-20��ѡ�������ȯ������,�Կո����,�Իس�����ȷ��-----");
		int[] b = new int[5];
		try{
		for(int i =0;i<5;i++){
			b[i] = sc.nextInt();
		}
		}catch(Exception e){
			System.out.println("����������Ϸ��ֹ����������");
			System.exit(0);
		}
		//������ѡ��ĺ���
		for(int i=0;i<5;i++){
			System.out.print("���ѡ��ĺ���Ϊ:\n");
			System.out.println(b[i]);
		}
		System.out.println();
		//������������뷵�ص����ֽ���ѭ���Ƚ�
		for(int i =0;i<5;i++){
			for(int j=0;j<5;j++){
				if(a[i]==b[j]){
					jk++;
				}
			}
		}
		//����н�����
		System.out.println("���ڵ��н�������");
		for(int i=0;i<5;i++){
			System.out.print(a[i]+"\t");
		}
		//ѡ���н��Ľ���
		switch(jk){
		case 1:System.out.println("��ϲ�����Ƚ���һƿ���ͣ�");
		break;
		case 2:System.out.println("��ϲ����ĵȽ�����ƿ���ͣ�");
		break;
		case 3:System.out.println("��ϲ������Ƚ�����ƿ���ͣ�");
		break;
		case 4:System.out.println("��ϲ��ö��Ƚ�����ƿ���ͣ�");
		break;
		case 5:System.out.println("��ϲ���һ�Ƚ�������500��Ԫ��");
		break;
		default:System.out.println("�Բ���,δ�н�,�ٽ�������");
		System.exit(0);
		break;
		}
	}
}
