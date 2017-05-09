# GUI是可视化窗口 
  #
- 以下代码为一个简单的猜数字小游戏




```
package com.kun;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class SuiJiShu extends Frame {
	boolean flge =true;
	Scanner scanner = new Scanner(System.in);
	public SuiJiShu(){
		this.setLayout(null);
		//停止以后输出的话
		JLabel jLabel2 = new JLabel();
		jLabel2.setBounds(600, 450, 200, 30);
		this.add(jLabel2);
		//返回随机数的文本框
		JTextArea area1= new JTextArea();
		area1.setBounds(100, 100, 30, 30);
		area1.setBackground(new Color(255,250,109));
		this.add(area1);
		//用户输入的数字
		JTextArea area = new JTextArea();
		area.setText("");
		area.setBounds(600, 400, 120, 40);
		area.setBackground(new Color(255,250,109));
		this.add(area);
		//开始与停止按钮
		JButton button = new JButton();
		button.setText("开始");
		button.setBounds(200, 200, 120, 50);
//		button.setBackground(new Color(255,255,255));
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable(){
					public void run() {
						while(flge){
							int a1=(int)(Math.random()*95+5);
							area1.setText(""+a1);
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}).start();
			}
		});
		this.add(button);
		
		//停止按钮
		JButton button1 = new JButton();
		button1.setText("停止");
		button1.setBounds(300, 200, 120, 50);
//		button1.setBackground(new Color(255,255,0));
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				flge=false;
				//比较结果
				if(area.getText().equals(area1.getText())){
					jLabel2.setText("猜中数字："+area1.getText());
				}else{
					jLabel2.setText("猜错了，正确数字为:"+area1.getText());
				}
			}
		});
		this.add(button1);
		//显示一句话
		JLabel jLabel = new JLabel();
		jLabel.setText("请在下框中输入一个数字");
		jLabel.setBounds(600, 350, 200, 30);
		this.add(jLabel);
		//将窗口体显示出来
		this.setBounds(500,170,930,670);
		this.setVisible(true);
		this.setTitle("随机数字比较小游戏");
	}
	public static void main(String[] args) {
			new SuiJiShu();
	}

}

```
