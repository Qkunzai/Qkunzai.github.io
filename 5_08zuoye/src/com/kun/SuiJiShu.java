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
		//ֹͣ�Ժ�����Ļ�
		JLabel jLabel2 = new JLabel();
		jLabel2.setBounds(600, 450, 200, 30);
		this.add(jLabel2);
		//������������ı���
		JTextArea area1= new JTextArea();
		area1.setBounds(100, 100, 30, 30);
		area1.setBackground(new Color(255,250,109));
		this.add(area1);
		//�û����������
		JTextArea area = new JTextArea();
		area.setText("");
		area.setBounds(600, 400, 120, 40);
		area.setBackground(new Color(255,250,109));
		this.add(area);
		//��ʼ��ֹͣ��ť
		JButton button = new JButton();
		button.setText("��ʼ");
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
		
		//ֹͣ��ť
		JButton button1 = new JButton();
		button1.setText("ֹͣ");
		button1.setBounds(300, 200, 120, 50);
//		button1.setBackground(new Color(255,255,0));
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				flge=false;
				//�ȽϽ��
				if(area.getText().equals(area1.getText())){
					jLabel2.setText("�������֣�"+area1.getText());
				}else{
					jLabel2.setText("�´��ˣ���ȷ����Ϊ:"+area1.getText());
				}
			}
		});
		this.add(button1);
		//��ʾһ�仰
		JLabel jLabel = new JLabel();
		jLabel.setText("�����¿�������һ������");
		jLabel.setBounds(600, 350, 200, 30);
		this.add(jLabel);
		//����������ʾ����
		this.setBounds(500,170,930,670);
		this.setVisible(true);
		this.setTitle("������ֱȽ�С��Ϸ");
	}
	public static void main(String[] args) {
			new SuiJiShu();
	}

}
