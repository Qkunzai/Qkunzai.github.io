public class Nar
{
	public static void main (String args[]){
		int a,b,c,d;
		for(a=100;a<=1000;a++){
			b=a%10;
			c=a/10%10;
			d=a/100;
			if(d*d*d+c*c*c+b*b*b==a){
				System.out.print("ˮ�ɻ�����"+a);
				System.out.print("\n");
			}
		}
	}
}

// ������������� һ����print ʹ��printʱ�뻻��ʱ ��Ҫ��ӻ��з�\n����\t��
// ���������ʹ��printlnʱ���������һ������ʱ���Զ����в���Ҫ��ӻ��з���