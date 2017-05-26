package zuoye;

public class StringBufferTest {

	public static void main(String[] args) {
		//aaab();
		aaac();
	}
	static void aaab(){
		//创建一个字符串
		StringBuffer aa = new StringBuffer("abcde");
		for(int i=1;i<6;i+=2){
			//插入三个逗号字符后字符长度变为8
			aa.insert(i, ',');
			//i++;
		}
		//因为插入了三个逗号字符所以e是由0开始的第7个
		aa.deleteCharAt(7);
		System.out.println(aa.toString());
	}
	static void aaac(){
		int [] a = {1,2,3,4,5};
		//定义一个空字符串对象
		StringBuffer ss = new StringBuffer("");
		//将int类型连接到空字符串对象内
		for(int i=0;i<5;i++){
			ss.append(a[i]);
		}
		//插入逗号，因为插入三个逗号所以字符串长度加三
		for(int  i =1;i<8;i+=2){
			ss.insert(i,',');
		}
		//输出字符串
		System.out.println(ss.toString());
	}

}
