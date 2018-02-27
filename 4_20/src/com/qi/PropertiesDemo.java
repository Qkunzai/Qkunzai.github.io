package com.qi;

import java.io.*;
import java.util.*;

public class PropertiesDemo {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException, IOException{
		Properties pps = new Properties();
		pps.load(new FileInputStream("E:/JAVA学习资料/javazuo/4_19zuoye/src/com/qi/Test.properties"));
		Enumeration enum1 = pps.propertyNames();//得到配置文件的名字
		while(enum1.hasMoreElements()) {
		String strKey = (String) enum1.nextElement();
		String strValue = pps.getProperty(strKey);
		System.out.println(strKey + "=" + strValue);
		}
		//实例化一个file对象
		File file = new File("src/com/qi/test.txt");
		//创建一个新的文件
		//file.createNewFile();
		//判断这个文件是否存在,存在则删除
		if(file.exists()){
			file.delete();
		}
		//返回文件名和返回文件的绝对路径和返回文件的相对路径名和返回上一级目录的名称
		System.out.println("name"+file.getName());
		System.out.println("name"+file.getAbsolutePath());
		System.out.println("name"+file.getCanonicalPath());
		System.out.println("name"+file.getParent());
		//打印出所有目录下的文件，可用到递归方法
		//fondFile(file);
		//测试应用程序是否可以执行此抽象路径名 的文件
		//返回true
		//System.out.println(file.canExecute());
		//测试应用程序是否可以读取此抽象路径名的文件
		//返回true
		//与路径写的是否正确有关
		//System.out.println(file.canRead());
		// 测试应用程序是否可以修改此抽象路径名表示的文件
		//返回true
		//System.out.println(file.canWrite());
		//文件的读取信息
		FileReader fileReader = new FileReader(file);
		char [] a = new char[100];//属于一个缓冲读取区
		 char c = (char)fileReader.read(a);
		 for(char c1:a){
			 System.out.println(c1);
		 }
		 //信息的全部读取
		FileReader fileReader1 = new FileReader(file);
		char [] a1 = new char[100];//属于一个缓冲读取区
		int len = 0;
		String oc = "";
		while((len = fileReader1.read(a1)) != -1){
			String ss = new String(a1,0,len);
			oc+=ss;
		}
		System.out.println(oc);
		 //文件的信息写入
		System.out.println("请输入需要保存的内容");
		//加上true后再次输入会从最后一个字节后开始输入，不会覆盖
		 FileWriter fileWriter = new FileWriter(file,true);
		 Writer out = (Writer)fileWriter;
		 // Writer out = new BufferedWriter(new OutputStreamWriter(System.out));
		 String input = sc.next();
		 //使用转义符进行换行
		 out.write(input+"\n");
		 //刷新缓冲区数据
		 fileWriter.flush();
		 //写入后需要关闭，关闭时会进行刷新
		 fileWriter.close(); 
	}
	public static void fondFile(File f){
		File[] f1 = f.listFiles();
		if(f.isDirectory()){
			for(File s:f1){
				fondFile(s);
			}
		}else{
			System.out.println("path="+f.getAbsolutePath());
		}
	}
}
	