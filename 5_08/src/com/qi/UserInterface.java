package com.qi;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class UserInterface extends Frame {
	
	
	
	
		public UserInterface(){
//			Demo demo = new Demo();
			this.setLayout(null);
			Icon icon = new ImageIcon("1.jpg");		//实例化一个图片
			JLabel jLabel = new JLabel();
			jLabel.setText("简易登录界面");
			jLabel.setBounds(350, 60, 400, 220);//设置这段话在窗口内的位置
			jLabel.setForeground(new Color(0,0,0));		//设置字体颜色
			jLabel.setFont(new Font("", 1, 35));
			this.add(jLabel);//将这段话加入到窗口内
			
			
			JLabel jLabel2 = new JLabel();
			jLabel2.setText("用户账号");
			jLabel2.setBounds(360, 160, 400, 220);//设置这段话的位置
			jLabel2.setForeground(new Color(0,0,0));	//设置字体颜色
			jLabel2.setFont(new Font("", 1, 15));
			this.add(jLabel2);//将这段话加入到窗口内
			
			
			JLabel jLabel3 = new JLabel();
			jLabel3.setText("用户密码");
			jLabel3.setBounds(360, 218, 400, 220);//设置这句话的位置
			jLabel3.setForeground(new Color(0,0,0));  //设置字体颜色
			jLabel3.setFont(new Font("", 1, 15));
			this.add(jLabel3);//将这段话加入到窗口内
			//登录验证后显示的内容
			JLabel jLabel4 = new JLabel();
			jLabel4.setBounds(100, 30, 200, 200);
			jLabel4.setForeground(Color.RED);
			//输入账号
			JTextArea area = new JTextArea();
			area.setText("请输入您的账号");
			area.setBounds(430,260,140,20);
			area.setBackground(new Color(146,139,139));	//设置文本框的背景颜色
			this.add(area);
			//输入密码
			JPasswordField area1 = new JPasswordField();
			area1.setBounds(430,320,140,20);
			area1.setBackground(new Color(146,139,139)); //设置密码框的背景颜色
			this.add(area1);
			//登录按钮显示
			JButton button = new JButton();
			button.setText("登录");
			button.setFont(new Font("",1,20));
			button.setBounds(340, 400, 300, 50);
			button.setBackground(new Color(63,93,170));	//设置按钮的颜色
			//按钮事件
			button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					new Thread(new Runnable() {
						
						@Override
						public void run() {
								Properties properties = new Properties();
								Enumeration enumm = null;
								try {
									//获取配置文件
									properties.load(new FileInputStream("src/qqqqq.properties"));
									//将配置文件内容进行遍历
									enumm = properties.propertyNames();
								} catch (Exception e) {
									e.printStackTrace();
								}
								//遍历方法
								while(enumm.hasMoreElements()){
									//将得到的内容转化为字符串型进行循环比较
									String strkey = (String)enumm.nextElement();
									//进行key值的比较，key值为username时进行下一步
									if(strkey.equals("username"))
										//将输入的内容与文件内的value值进行比较，值相同则进行下一步
									if(area.getText().equals(properties.getProperty(strkey))){
										//进行key值比较，key值为password时进行下一步
										if(strkey.equals("password"))
											//进行value值的比较
											if(area1.getText().equals(properties.getProperty(strkey))){
												//当输入的数据与比较值相同是跳出循环
												jLabel4.setText("登录成功！");
												jLabel4.setFont(new Font("",1,30));
												break;
											}else{
												jLabel4.setText("登录失败！");
												jLabel4.setFont(new Font("",1,30));
												break;
											}
									}else{
										jLabel4.setText("登录失败！");
										jLabel4.setFont(new Font("",1,30));
										break;
									}
								}
								
						}
					});
				}
				
			});
			this.add(button);
			this.add(jLabel4);	//将验证后的字添加进窗口
			
			
			
			
			//显示窗口
			this.setBounds(500,170,930,670);
			this.setVisible(true);
			this.setBackground(new Color(255,250,109));	//设置窗口的背景颜色
		}
	
	
	
	public static void main(String[] args){
		
		new UserInterface();
		
		
	}
}

