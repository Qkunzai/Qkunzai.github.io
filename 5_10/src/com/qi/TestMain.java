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
//		�����ݴ���ת��ΪJPanel
		JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);
        //�Ѱѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ���� 
        this.getLayeredPane().add(jLabel, new Integer(Integer.MIN_VALUE)); 
        //
		JButton button = new JButton("��ʼ��Ϸ");
		button.setBounds(45, 640, 120, 40);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qi.setBounds(100, 70, 550, 550);
				qi.setBackground(new Color(255,174,0));
			}
		});
		this.add(button);
		JButton button2 = new JButton("�˳���Ϸ");
		button2.setBounds(645, 640, 120, 40);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					System.exit(0);
			}
		});
		JButton button3 = new JButton("���¿�ʼ");
		button3.setBounds(245, 640, 120, 40);
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qi.isWin=true;	//�����ʤ��¼
				qi.list.clear();	//����������ӵļ�¼��
				qi.repaint();	//���»�������
				
			}
		});
		JButton button4 = new JButton("����");
		button4.setBounds(445,640,120,40);
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = qi.list.size();	//��ȡlist���ϵĴ洢��������󳤶�
				qi.list.remove(a-1);	//��Ϊ���㿪ʼ�������Լ�һ
				System.out.println(qi.isHei);
				if(qi.isHei!=true){		//�����֮�����ӱ�ɰף�����һ�������ӱ�ɺ�ɫ
					qi.isHei=true;
				}else if(qi.isHei!=false){
					qi.isHei=false;		//�����֮�����ӱ�ɺڣ�����һ�������ӱ�ɰ�ɫ
				}
				qi.repaint();			//������ٺ����»�������
			}
		});
		this.add(button4);
		this.add(button3);
		this.add(button2);
		this.setBounds(550, 100, 800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("������");
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
