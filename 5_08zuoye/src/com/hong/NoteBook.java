package com.hong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.*;

public class NoteBook extends JFrame {
	public NoteBook(){
		this.setLayout(null);
		//ʵ����һ���ı���
		JTextArea area = new JTextArea();
		area.setBounds(0, 0, 900, 670);
		area.setText("");
		System.out.println(area.getText());
		area.setBackground(new Color(255,250,109));
		area.setFont(new Font("",0,17));
		this.add(area);
		//����һ�������˵�
		JMenuBar bar = new JMenuBar();
		JMenu jMenu = new JMenu();
		//��ѡ�˵�ѡ��
		jMenu.setText("�ļ�");
		JMenuItem  item = new JMenuItem();
		//�ڲ��˵�ѡ��
		item.setText("����");
		item.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//�����Ǵ�������ļ�
				new Thread(new Threads()).start();
			}
		});
		//�½��ڲ��˵�
		JMenuItem item2 = new JMenuItem();
		item2.setText("�½�");
		item2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//�½��ǽ��ı����ݴ�������Test�ļ���
				File file = new File("Test.txt");
				FileWriter fileWriter=null;
//				Scanner sc = new Scanner(System.in);
				try {
					fileWriter = new FileWriter(file);
					fileWriter.write(area.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		//���˵�һ��һ�����
		jMenu.add(item);
		jMenu.add(item2);
		bar.add(jMenu);
		this.setJMenuBar(bar);
		//��������ʾ����
		this.setBounds(500,170,930,670);
		this.setVisible(true);
		this.setTitle("���±�");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new NoteBook();
	}

}
