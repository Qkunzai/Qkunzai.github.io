package com.qi;

public class Test {

	public static void main(String[] args) {
		
		boolean flag = false;
		int i=0;
		int number = 'A';
		float y = 0x123;
		long a = 0x1231;
		if(flag || i>100){
			System.out.println("1");
		}else if(!!flag & i+0>8){
			System.out.println("2");
		}else{
			System.out.println("3");
		}
		System.out.println(number);
		System.out.println(y);
		System.out.println(a);
		System.out.println(1+2+"java"+3+4);
		System.out.println("------------------");
		for(i++;i++<10;i++);
			System.out.println(++i);
		System.out.println("------------------");
		for(int i1=0;i1<3;i1++){
			switch(i1){
			case 1:
				System.out.println("a");break;
			case 0:
				System.out.println("b");break;
			default:
				System.out.println("c");
			case 2:
				System.out.println("d");
			}
		}
		System.out.println("------------------");
//		int x[] =null;
//		int[] k = new int[]{1,2,3};
//		int[] l={1,2,3};
//		int[] m={};
//		String[] s = new String[]{"1","2","3"};
//		String[] s1 = new String[3];
		System.out.println("------------------");

		long s = aa(2,10);
		System.out.println(s);
	}
	public static long aa(int a,int b){
		long s = 0;
		int x = a;
		for(int i=0;i<b;i++){
			a = a*10+x;
			s = s+a;
		}
		return s = a ;
	}

}
//class A{}
//	public class B{
//	//	private A[] = {new A(), new A(),new A()};
//		private A[]  a = new A[]{new A(),new A(),new A()};
//	}











