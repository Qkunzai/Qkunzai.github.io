package com.qi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TestMain extends JFrame {
	
	public TestMain(){
		this.setLayout(null);
		Icon icon = new ImageIcon("src/timg.jpg");
		WuZiQi qi = new WuZiQi();
		this.add(qi);
		
		JLabel jLabel = new JLabel();
		jLabel.setBounds(100, 70, 550, 550);
		jLabel.setIcon(icon);
		this.add(jLabel);
//		把内容窗格转换为JPanel
		JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);
        //把把背景图片添加到分层窗格的最底层作为背景 
        this.getLayeredPane().add(jLabel, new Integer(Integer.MIN_VALUE)); 
        //
		JButton button = new JButton("开始游戏");
		button.setBounds(45, 640, 120, 40);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qi.setBounds(100, 70, 550, 550);
				qi.setBackground(new Color(255,174,0));
			}
		});
		this.add(button);
		JButton button2 = new JButton("退出游戏");
		button2.setBounds(645, 640, 120, 40);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					System.exit(0);
			}
		});
		JButton button3 = new JButton("重新开始");
		button3.setBounds(245, 640, 120, 40);
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qi.isWin=true;	//清除获胜记录
				qi.list.clear();	//清除棋盘棋子的记录点
				qi.repaint();	//重新绘制棋盘
				
			}
		});
		JButton button4 = new JButton("悔棋");
		button4.setBounds(445,640,120,40);
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = qi.list.size();	//获取list集合的存储的棋子最大长度
				qi.list.remove(a-1);	//因为由零开始计算所以减一
				System.out.println(qi.isHei);
				if(qi.isHei!=true){		//鼠标点击之后棋子变成白，撤销一步把棋子变成黑色
					qi.isHei=true;
				}else if(qi.isHei!=false){
					qi.isHei=false;		//鼠标点击之后棋子变成黑，撤销一步把棋子变成白色
				}
				qi.repaint();			//坐标减少后重新绘制棋盘
			}
		});
		this.add(button4);
		this.add(button3);
		this.add(button2);
		this.setBounds(550, 100, 800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("五子棋");
		this.setVisible(true);
		
		
	}
	
	
	
	




	public static void main(String[] args) {
		//Socket socket;
		try {
			//socket = new Socket("192.168.199.161",8000);
			new TestMain();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
