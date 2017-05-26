package com.qi;

import java.io.*;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

class Demo extends UserInterface {
	static Scanner sc = new Scanner(System.in);

//	public static void main(String[] args) {
//		//菜单选择页
//		System.out.println("---1.登录---");
//		System.out.println("---2.注册---");
//			int a = sc.nextInt();
//			switch(a){
//			case 1:
//				dengLu();
//				break;
//			case 2:
//				System.out.println("请按照以下方式进行注册，等号前不允许有空格");
//				System.out.println("用户名:username=用户名");
//				System.out.println("密码:password=密码");
//				fangFa();
//				break;
//			default:
//				System.out.println("输入错误，已退出");
//				System.exit(0);
//				break;
//			}
//	}
	//登录方法
	public  void dengLu(JTextArea j,JPasswordField jf){	
		Properties properties = new Properties();
		Enumeration enumm = null;
		try {
			//获取配置文件
			properties.load(new FileInputStream("src/com/qi/qqqqq.properties"));
			//将配置文件内容进行遍历
			enumm = properties.propertyNames();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("请输入您的账号以回车结束");
//		String str = "";
//		String str1 = "";
//		str = sc.next();
		//遍历方法
		while(enumm.hasMoreElements()){
			//将得到的内容转化为字符串型进行循环比较
			String strkey = (String)enumm.nextElement();
			//进行key值的比较，key值为username时进行下一步
			if(strkey.equals("username"))
				//将输入的内容与文件内的value值进行比较，值相同则进行下一步
			if(j.getText().equals(properties.getProperty(strkey))){
//				System.out.println("请输入密码");
//				str1 = sc.next();
			}
			//进行key值比较，key值为password时进行下一步
			if(strkey.equals("password"))
				//进行value值的比较
				if(jf.getText().equals(properties.getProperty(strkey))){
					//当输入的数据与比较值相同是跳出循环
					break;
				}
		}
		JLabel jLabel = new JLabel();
		jLabel.setText("登录成功！");
		jLabel.setBounds(500, 500, 1000, 1000);
		super.add(jLabel);
	}
	public static void fangFa(){
		File file = new File("src/com/qi/qqqqq.properties");
		//判断此文件是否存在存在不创建，不存在则创建新文件
		if(!file.exists()){
			try{
				file.createNewFile();
			}catch (IOException e) {
				e.printStackTrace();
			 }
		}
		//写入新内容
		System.out.println("请输入用户名与密码");
		FileWriter fw = null;
		//写入新的内容不覆盖的方法
		try {
			fw = new FileWriter(file,true);
				for(int i =0;i<2;i++)
				{
					String input = sc.next();
					if("".equals(fw)){
						fw.write(input);
					}else{
						fw.write(input+"\n");
					 }
					fw.flush();
				}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//关闭流
				fw.close();
			}catch (IOException e) {
				e.printStackTrace();
			 }
		}
		//输出配置文件
		Properties properties = new Properties();
		Enumeration enumm = null;
		try {
			properties.load(new FileInputStream("src/com/qi/qqqqq.properties"));
			//得到配置文件名字
			enumm = properties.propertyNames();
			while(enumm.hasMoreElements()){
				//将得到的内容转化为字符串型进行输出
				String strkey = (String)enumm.nextElement();
				String strvalue = properties.getProperty(strkey);
				System.out.println("请记住您自己的账号与密码");
				System.out.println("下次注册时请按照以下方式注册");
				System.out.println("用户名:username=用户名");
				System.out.println("密码:password=密码");
				System.out.println(strkey+"="+strvalue);
			}
		} catch (Exception e) {
			//将抛出的异常进行打印输出
			e.printStackTrace();
		}
	}

}
