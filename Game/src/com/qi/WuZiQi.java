package com.qi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class WuZiQi {
	JFrame window01 = null;//������
	JButton jButton1 = null;//��ʼ
	JButton jButton2 = null;//���¿�ʼ
	JButton jButton3 = null;//����
	JLabel jLabel2 = null;//��ʾ��Ϣ����Ϸ�Ƿ��ѿ�ʼ����Ϸ�������ǰ������Ϣ��
	JComponent component2 = null;//��ǰ������Ϣ���е�����
	String sss = "��Ϸδ��ʼ��";//��ʾ����
	JComponent component = null;//����
	boolean color;//��Ϸ�ߵ�������ɫ��true��ʾ�ڣ�false��ʾ��
	boolean dColor = true;//��ǰ������ɫ(����ǵ�����)
	boolean jieGuo = false;//��Ϸ״̬��true--->����������false--->���ڽ���
	boolean zhuangTai = true;//��Ϸ״̬��
	List<Pieces> pieces = new ArrayList<Pieces>();//�������
	Socket socket = null;//���ӷ�����
	public static void main(String[] args) {
		new WuZiQi().playGame();
//		new WuZiQi().mainWindow();
	}
	/**
	 * �����Ծ������Ծ�
	 */
	public void playGame(){
		JFrame f1 = new JFrame("���������Ծ�");
		f1.setLayout(null);
		JLabel jLabel = new JLabel("��������Ϸ����ţ�");
		jLabel.setFont(new Font("΢���ź�", 0, 20));
		JTextField field = new JTextField();
		JButton f2button_2 = new JButton("����");
		jLabel.setBounds(60, 20, 200, 30);
		field.setBounds(60, 65, 200, 30);
		f2button_2.setBounds(180,110,80,25);
		f1.add(jLabel);
		f1.add(field);
		f1.add(f2button_2);
		f1.setBounds(0,0,340,230);
		f1.setVisible(true);
		//����
		f2button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//���ӷ�����
				try {
					socket = new Socket("192.168.199.161", 8000);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				//�жϿ�ֵ
				if(field.getText().equals(null)||field.getText().equals("")){
					JOptionPane.showMessageDialog(null, "����Ų���Ϊ�գ�", "��ʾ",0);
					return;
				}
				PrintWriter printWriter;
				try {
					//������ŷ��͸�������
					printWriter = new PrintWriter(socket.getOutputStream());
					printWriter.write(field.getText()+"\n");
					printWriter.flush();
					//������������Ϣ
					int a = 2;
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					a = bufferedReader.read();
					//��ʾ��Ϣ
					if(a==2){
						JOptionPane.showMessageDialog(null, "�÷��䲻���ڣ���Ϊ���½�����ʼ��Ϸ�ɣ�", "��ʾ",1);
						color = true;//����
						zhuangTai = false;
					}else if(a==1){
						JOptionPane.showMessageDialog(null, "�ɹ����뷿�䣬��ʼ��Ϸ�ɣ�", "��ʾ",1);
						color = false;//����
						zhuangTai = true;
					}else if(a==0){
						JOptionPane.showMessageDialog(null, "�÷��������ˣ����������뷿��ţ�", "��ʾ",0);
						return;
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				//������Ϸ��
				mainWindow();
				//�رս��뷿�䴰��
				f1.dispose();
			}
		});
		
	}
	/**
	 * ������
	 */
	public void mainWindow(){
		window01 = new JFrame("������");
		window01.setLayout(null);
		jButton1 = new JButton("��ʼ��Ϸ");
		jButton1.setBounds(10, 10, 90, 30);
		window01.add(jButton1);
		jButton2 = new JButton("���¿�ʼ");
		jButton2.setBounds(110, 10, 90, 30);
		window01.add(jButton2);
		jButton3 = new JButton("����");
		jButton3.setBounds(210, 10, 90, 30);
		window01.add(jButton3);
		/**
		 * ������ʾ��Ϣ
		 */
		component2 = new JComponent() {
			public void paint(Graphics g) {
				g.setColor(new Color(255, 189, 136));
				g.fillRect(0, 0, 540, 50);
				if(dColor){
					g.setColor(new Color(0, 0, 0));
				}else{
					g.setColor(new Color(255, 255, 255));
				}
				g.fillOval(10, 10, 30, 30);
				g.setColor(new Color(0, 0, 0));
				g.setFont(new Font("����",0,20));
				g.drawString(sss, 50, 32);
			}
		};
		component2.setBounds(310, 0, 540, 50);
		window01.add(component2);
		
		/**
		 * ��������
		 */
		component = new JComponent() {
			public void paint(Graphics g) {
				//������̱���ɫ
				g.setColor(new Color(245, 131, 65));
				g.fillRect(0, 0, 850, 850);
				//������������
				for(int i = 0;i<=21;i++){
					int a = i*40+20;
					//�����������ɫ
					g.setColor(new Color(0,0,0));
					g.drawLine(20,a,820,a);
					g.drawLine(a,20,a,820);
				}
				//��������
				for(Pieces p:pieces){
					//��ȡ������ɫ
					if(p.isB()){
						g.setColor(new Color(0, 0, 0));
					}else{
						g.setColor(new Color(255, 255, 255));
					}
					//��������
					g.fillOval(p.getX(), p.getY(),p.WITCH, p.WITCH);
				}
				//���
				if(pieces.size()>0){
					Pieces p2 = pieces.get(pieces.size()-1);
					g.setColor(new Color(200, 0, 0));
					g.fillOval(p2.getX()+10, p2.getY()+10,10,10);
				}
			}
		};
		component.setBounds(10, 50, 840, 840);
		window01.add(component);
		window01.setBounds(0, 0, 880, 950);
		window01.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window01.setVisible(true);
		/**
		 * �������ִ��
		 */
		component.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				//�жϱ����Ƿ���������������(true)�Ͳ�������
				if(zhuangTai||jieGuo){
					return;
				}
				//��ȡ����
				int xx = e.getX();
				int yy = e.getY();
				//�������Ӷ���
				Pieces pi = new Pieces(xx, yy,color);
				//�ж��Ƿ�������ӣ��������򴴽�
				if(pp(pi.getX(),pi.getY())!=null){
					return;
				}
				//��������
				ObjectOutputStream objectOutputStream;
				try {
					objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
					objectOutputStream.writeObject(pi);
					objectOutputStream.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
		//���ܷ���������
		new Thread(new Runnable() {
			public void run() {
				while(true){
					Pieces ppi = null;
					try {
						ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
						ppi = (Pieces)inputStream.readObject();
						pieces.add(ppi);
						//����
						component.repaint();
	
						sss ="x = "+((ppi.getX()-5)/40+1) +"   y = "+((ppi.getY()-5)/40+1)+"   ";
						//�ж�ʤ��
						if(result(ppi,1)||result(ppi,2)||result(ppi,3)||result(ppi,4)){
							sss= "��Ϸ������"+"��ϲ"+(ppi.isB()? "����":"����")+"Ӯ�ˣ�";
							jieGuo = true;
							jButton1.setText("��ʼ��Ϸ");
						}
						dColor = ppi.isB();//��ȡ��ǰ������ɫ
						zhuangTai = !zhuangTai;
						component2.repaint();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				
			}
		}).start();
		//��ʾ�˾���Ϸ�ߵĺڰ���
		JOptionPane.showMessageDialog(null, "����������ɫΪ"+(color?"��ɫ":"��ɫ")+"��", "��ʾ",0);
	}
	/**
	 * ͨ��x��y���������ӣ�����з��ظ�����,û�з���null
	 *
	 */
	public Pieces pp(int x,int y){
		for(Pieces p:pieces){
			if(p.getX()==x&&p.getY()==y){
				return p;
			}
		}
		return null;
	}
	/**
	 *�ж�ʤ��
	 */
	public boolean result(Pieces s,int h){
		int sum = 1;
		int x = s.getX();
		int y = s.getY();
		for(int i = 0;i<=4;i++){
			if(h==1){//�ж�"����"
				x-=40;
			}else if(h==2){//�ж�"|"
				y-=40;
			}else if(h==3){//�ж�"/"
				x-=40;
				y+=40;
			}else if(h==4){//�ж�"\"
				x-=40;
				y-=40;
			}
			//�ж���ɫ
			if(pp(x,y)!=null&&s.isB()==pp(x,y).isB()){
				sum++;
			}else{
				break;
			}
			
		}
		x = s.getX();
		y = s.getY();
		for(int i = 0;i<=4;i++){
			if(h==1){//�ж�"����"
				x+=40;
			}else if(h==2){//�ж�"|"
				y+=40;
			}else if(h==3){//�ж�"/"
				x+=40;
				y-=40;
			}else if(h==4){//�ж�"\"
				x+=40;
				y+=40;
			}
			//�ж���ɫ
			if(pp(x,y)!=null&&s.isB()==pp(x,y).isB()){
				sum++;
			}else{
				break;
			}
		}
		String cs = null;
		if(h==1){//�ж�"����"
			cs="��";
		}else if(h==2){//�ж�"|"
			cs="��";
		}else if(h==3){//�ж�"/"
			cs="��б";
		}else if(h==4){//�ж�"\"
			cs="��б";
		}
		sss += cs+"="+sum+"   ";
		//System.out.println("x="+s.getX()+"\ty="+s.getY()+"\tcolot="+s.isB()+"\t"+c+"="+sum);
		if(sum>=5){
			return true;
		}else{
			return false;
		}
	}
}
