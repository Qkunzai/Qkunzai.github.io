package zuoye;

public class StringBufferTest {

	public static void main(String[] args) {
		//aaab();
		aaac();
	}
	static void aaab(){
		//����һ���ַ���
		StringBuffer aa = new StringBuffer("abcde");
		for(int i=1;i<6;i+=2){
			//�������������ַ����ַ����ȱ�Ϊ8
			aa.insert(i, ',');
			//i++;
		}
		//��Ϊ���������������ַ�����e����0��ʼ�ĵ�7��
		aa.deleteCharAt(7);
		System.out.println(aa.toString());
	}
	static void aaac(){
		int [] a = {1,2,3,4,5};
		//����һ�����ַ�������
		StringBuffer ss = new StringBuffer("");
		//��int�������ӵ����ַ���������
		for(int i=0;i<5;i++){
			ss.append(a[i]);
		}
		//���붺�ţ���Ϊ�����������������ַ������ȼ���
		for(int  i =1;i<8;i+=2){
			ss.insert(i,',');
		}
		//����ַ���
		System.out.println(ss.toString());
	}

}
