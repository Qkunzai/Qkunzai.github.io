package com.qi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class HongLvDeng extends Frame {
		boolean flag = true;
	public HongLvDeng(){
		this.setLayout(null);	//布局格式为空
		//实例化一个按钮
		JButton button = new JButton();
		button.setText("开始");
		button.setBounds(200, 400, 100, 40);
		this.add(button);		//将按钮添加到当前窗口内
		//显示文本框
		JTextArea area = new JTextArea();
		area.setBounds(300, 200, 400, 400);
		area.setText("");
		this.add(area);
		//显示字
		JLabel jLabel = new JLabel();
		jLabel.setBounds(350, 130, 300, 30);
		jLabel.setFont(new Font("",1,30));
		this.add(jLabel);
		//开始按钮事件
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						if(button.getText().equals("开始"))
						{
							flag = true;
						}else{
							flag = false;
						}
						button.setText("停止");
							while(flag){
								jLabel.setText("红灯停");
								area.setBackground(Color.RED);
								try {
									Thread.sleep(3000);		//红色等待是3秒
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								jLabel.setText("绿灯行");
								area.setBackground(Color.GREEN);
								try {
									Thread.sleep(3000);		//绿色等待3秒
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								jLabel.setText("黄灯到了等一等");
								area.setBackground(Color.YELLOW);	//黄色等待1秒
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						}
					}
				}).start();
			}
		});
		//将窗口显示在桌面
		this.setBounds(400,250,1000,800);
		this.setVisible(true);
//		this.setBackground(new Color(0,0,0));
		this.setTitle("红绿灯");//更换软件标题
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
				
		new HongLvDeng();
		
	}

}
