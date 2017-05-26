public class MultiTable{
	public static void main(String args[]){
	  int a,b,c;
	  for(a=1;a<10;a++){
		c=0;
		for(b=1;b<=a;b++){
			c=a*b;
			System.out.print(a+"*"+b+"="+c+"\t");
		}
		System.out.print("\n");
	  }
    }
  }

  // 当想让前一个变量与后一个变量有联系时必须用连接符号‘+’进行连接