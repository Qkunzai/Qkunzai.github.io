package com.hong;

import java.io.*;
public class XieRu{
	private String name;
	public XieRu(String name){
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 方法一写入从0到百分之三十的内容
	 */
	public void fangFa(){
		//实例化文件
		File file  = new File("src/com/hong/hongkun.txt");
		FileReader fileReader = null;
		try {
			//将文件读入
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//定义一个字符串对象用来储存读入的数据
		StringBuffer sss = new StringBuffer();
		int len = 0;
		char[] chars = new char[1024] ;
		try {
			while((len = fileReader.read(chars))!=-1){
				//从文件的开始到三分之一处结束
				sss.append(new String(chars,0,(len/3)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//关闭输入流
		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//实例化需要复制进入的文件
		File file1 = new File("src/com/hong/qihongkun.txt");
		//如果该文件不存在则创建文件
		if(!file1.exists()){
			try {
				file1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//将文件写入
		FileWriter output=null;
		try {
			output = new FileWriter(file1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//将读入的文件赋给一个新的字符串
		String bbb =sss.toString();
		//将字符串进行写入
		try {
			output.write(bbb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			//关闭流
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//实例化一个输出流
		FileReader fileReader2=null;
		try {
			fileReader2 = new FileReader(file1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int len1 = 0;
		char[] ccc = new char[1024];
		StringBuffer ss = new StringBuffer();
		//将内容进行输出出去
		try {
			while((len = fileReader2.read(ccc))!=-1){
				ss.append(new String(ccc,0,len));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//输出文件内容
		System.out.println(ss.toString());
	}
	/**
	 *方法二写入百分之三十到百分之六十
	 * @throws IOException
	 */
	public void fangFa2() throws IOException{
		File file  = new File("src/com/hong/hongkun.txt");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuffer sss = new StringBuffer();
		int len = 0;
		char[] chars = new char[1024] ;
		while((len = fileReader.read(chars))!=-1){
			sss.append(new String(chars,(len/3),(len/3+len/3)));
		}
		fileReader.close();
		File file1 = new File("src/com/hong/qihongkun.txt");
		if(!file1.exists()){
			file1.createNewFile();
		}
		FileWriter output = new FileWriter(file1);
		String bbb =sss.toString();
		output.write(bbb);
		output.close();
		FileReader fileReader2 = new FileReader(file1);
		int len1 = 0;
		char[] ccc = new char[1024];
		StringBuffer ss = new StringBuffer();
		while((len = fileReader2.read(ccc))!=-1){
			ss.append(new String(ccc,0,len));
		}
	}
	/**
	 * 方法三写入百分之六十到最后
	 * @throws IOException
	 */
	public void fangFa3() throws IOException{
		File file  = new File("src/com/hong/hongkun.txt");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuffer sss = new StringBuffer();
		int len = 0;
		char[] chars = new char[1024] ;
		while((len = fileReader.read(chars))!=-1){
			sss.append(new String(chars,(len/3+len/3),len));
		}
		fileReader.close();
		File file1 = new File("src/com/hong/qihongkun.txt");
		if(!file1.exists()){
			file1.createNewFile();
		}
		FileWriter output = new FileWriter(file1);
		String bbb =sss.toString();
		output.write(bbb);
		output.close();
		FileReader fileReader2 = new FileReader(file1);
		int len1 = 0;
		char[] ccc = new char[1024];
		StringBuffer ss = new StringBuffer();
		while((len = fileReader2.read(ccc))!=-1){
			ss.append(new String(ccc,0,len));
		}
	}
}
