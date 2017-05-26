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
		//实例化一个文本框
		JTextArea area = new JTextArea();
		area.setBounds(0, 0, 900, 670);
		area.setText("");
		System.out.println(area.getText());
		area.setBackground(new Color(255,250,109));
		area.setFont(new Font("",0,17));
		this.add(area);
		//创建一个三级菜单
		JMenuBar bar = new JMenuBar();
		JMenu jMenu = new JMenu();
		//首选菜单选项
		jMenu.setText("文件");
		JMenuItem  item = new JMenuItem();
		//内部菜单选项
		item.setText("保存");
		item.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//保存是创建这个文件
				new Thread(new Threads()).start();
			}
		});
		//新建内部菜单
		JMenuItem item2 = new JMenuItem();
		item2.setText("新建");
		item2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//新建是将文本内容传输进这个Test文件中
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
		//将菜单一级一级添加
		jMenu.add(item);
		jMenu.add(item2);
		bar.add(jMenu);
		this.setJMenuBar(bar);
		//将窗口显示出来
		this.setBounds(500,170,930,670);
		this.setVisible(true);
		this.setTitle("记事本");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new NoteBook();
	}

}
