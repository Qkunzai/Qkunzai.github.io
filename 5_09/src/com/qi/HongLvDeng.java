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
		this.setLayout(null);	//���ָ�ʽΪ��
		//ʵ����һ����ť
		JButton button = new JButton();
		button.setText("��ʼ");
		button.setBounds(200, 400, 100, 40);
		this.add(button);		//����ť��ӵ���ǰ������
		//��ʾ�ı���
		JTextArea area = new JTextArea();
		area.setBounds(300, 200, 400, 400);
		area.setText("");
		this.add(area);
		//��ʾ��
		JLabel jLabel = new JLabel();
		jLabel.setBounds(350, 130, 300, 30);
		jLabel.setFont(new Font("",1,30));
		this.add(jLabel);
		//��ʼ��ť�¼�
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						if(button.getText().equals("��ʼ"))
						{
							flag = true;
						}else{
							flag = false;
						}
						button.setText("ֹͣ");
							while(flag){
								jLabel.setText("���ͣ");
								area.setBackground(Color.RED);
								try {
									Thread.sleep(3000);		//��ɫ�ȴ���3��
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								jLabel.setText("�̵���");
								area.setBackground(Color.GREEN);
								try {
									Thread.sleep(3000);		//��ɫ�ȴ�3��
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								jLabel.setText("�ƵƵ��˵�һ��");
								area.setBackground(Color.YELLOW);	//��ɫ�ȴ�1��
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
		//��������ʾ������
		this.setBounds(400,250,1000,800);
		this.setVisible(true);
//		this.setBackground(new Color(0,0,0));
		this.setTitle("���̵�");//�����������
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
				
		new HongLvDeng();
		
	}

}
