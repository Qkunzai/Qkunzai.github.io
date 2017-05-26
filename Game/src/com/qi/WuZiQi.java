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
	JFrame window01 = null;//主窗口
	JButton jButton1 = null;//开始
	JButton jButton2 = null;//重新开始
	JButton jButton3 = null;//悔棋
	JLabel jLabel2 = null;//提示信息（游戏是否已开始，游戏结果，当前棋子信息）
	JComponent component2 = null;//当前棋子信息条中的棋子
	String sss = "游戏未开始！";//提示内容
	JComponent component = null;//棋盘
	boolean color;//游戏者的棋子颜色，true表示黑，false表示白
	boolean dColor = true;//当前棋子颜色(红点标记的棋子)
	boolean jieGuo = false;//游戏状态。true--->比赛结束；false--->正在进行
	boolean zhuangTai = true;//游戏状态。
	List<Pieces> pieces = new ArrayList<Pieces>();//存放棋子
	Socket socket = null;//连接服务器
	public static void main(String[] args) {
		new WuZiQi().playGame();
//		new WuZiQi().mainWindow();
	}
	/**
	 * 创建对局与加入对局
	 */
	public void playGame(){
		JFrame f1 = new JFrame("创建与加入对局");
		f1.setLayout(null);
		JLabel jLabel = new JLabel("请输入游戏房间号：");
		jLabel.setFont(new Font("微软雅黑", 0, 20));
		JTextField field = new JTextField();
		JButton f2button_2 = new JButton("进入");
		jLabel.setBounds(60, 20, 200, 30);
		field.setBounds(60, 65, 200, 30);
		f2button_2.setBounds(180,110,80,25);
		f1.add(jLabel);
		f1.add(field);
		f1.add(f2button_2);
		f1.setBounds(0,0,340,230);
		f1.setVisible(true);
		//进入
		f2button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//连接服务器
				try {
					socket = new Socket("192.168.199.161", 8000);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				//判断空值
				if(field.getText().equals(null)||field.getText().equals("")){
					JOptionPane.showMessageDialog(null, "房间号不能为空！", "提示",0);
					return;
				}
				PrintWriter printWriter;
				try {
					//将房间号发送给服务器
					printWriter = new PrintWriter(socket.getOutputStream());
					printWriter.write(field.getText()+"\n");
					printWriter.flush();
					//服务器返回信息
					int a = 2;
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					a = bufferedReader.read();
					//提示信息
					if(a==2){
						JOptionPane.showMessageDialog(null, "该房间不存在，已为您新建，开始游戏吧！", "提示",1);
						color = true;//黑棋
						zhuangTai = false;
					}else if(a==1){
						JOptionPane.showMessageDialog(null, "成功进入房间，开始游戏吧！", "提示",1);
						color = false;//白棋
						zhuangTai = true;
					}else if(a==0){
						JOptionPane.showMessageDialog(null, "该房间已满人，请重新输入房间号！", "提示",0);
						return;
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				//进入游戏！
				mainWindow();
				//关闭进入房间窗口
				f1.dispose();
			}
		});
		
	}
	/**
	 * 主窗口
	 */
	public void mainWindow(){
		window01 = new JFrame("五子棋");
		window01.setLayout(null);
		jButton1 = new JButton("开始游戏");
		jButton1.setBounds(10, 10, 90, 30);
		window01.add(jButton1);
		jButton2 = new JButton("重新开始");
		jButton2.setBounds(110, 10, 90, 30);
		window01.add(jButton2);
		jButton3 = new JButton("悔棋");
		jButton3.setBounds(210, 10, 90, 30);
		window01.add(jButton3);
		/**
		 * 操作提示信息
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
				g.setFont(new Font("黑体",0,20));
				g.drawString(sss, 50, 32);
			}
		};
		component2.setBounds(310, 0, 540, 50);
		window01.add(component2);
		
		/**
		 * 绘制内容
		 */
		component = new JComponent() {
			public void paint(Graphics g) {
				//填充棋盘背景色
				g.setColor(new Color(245, 131, 65));
				g.fillRect(0, 0, 850, 850);
				//绘制棋盘线条
				for(int i = 0;i<=21;i++){
					int a = i*40+20;
					//填充棋盘线条色
					g.setColor(new Color(0,0,0));
					g.drawLine(20,a,820,a);
					g.drawLine(a,20,a,820);
				}
				//绘制棋子
				for(Pieces p:pieces){
					//获取棋子颜色
					if(p.isB()){
						g.setColor(new Color(0, 0, 0));
					}else{
						g.setColor(new Color(255, 255, 255));
					}
					//绘制棋子
					g.fillOval(p.getX(), p.getY(),p.WITCH, p.WITCH);
				}
				//红点
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
		 * 鼠标点击后执行
		 */
		component.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				//判断比赛是否结束，如果结束了(true)就不再下棋
				if(zhuangTai||jieGuo){
					return;
				}
				//获取坐标
				int xx = e.getX();
				int yy = e.getY();
				//创建棋子对象
				Pieces pi = new Pieces(xx, yy,color);
				//判断是否存在棋子，不存在则创建
				if(pp(pi.getX(),pi.getY())!=null){
					return;
				}
				//发送棋子
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
		//接受服务器返回
		new Thread(new Runnable() {
			public void run() {
				while(true){
					Pieces ppi = null;
					try {
						ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
						ppi = (Pieces)inputStream.readObject();
						pieces.add(ppi);
						//绘制
						component.repaint();
	
						sss ="x = "+((ppi.getX()-5)/40+1) +"   y = "+((ppi.getY()-5)/40+1)+"   ";
						//判断胜负
						if(result(ppi,1)||result(ppi,2)||result(ppi,3)||result(ppi,4)){
							sss= "游戏结束，"+"恭喜"+(ppi.isB()? "黑棋":"白棋")+"赢了！";
							jieGuo = true;
							jButton1.setText("开始游戏");
						}
						dColor = ppi.isB();//获取当前棋子颜色
						zhuangTai = !zhuangTai;
						component2.repaint();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				
			}
		}).start();
		//提示此局游戏者的黑白棋
		JOptionPane.showMessageDialog(null, "您的棋子颜色为"+(color?"黑色":"白色")+"！", "提示",0);
	}
	/**
	 * 通过x，y坐标找棋子，如果有返回该棋子,没有返回null
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
	 *判断胜负
	 */
	public boolean result(Pieces s,int h){
		int sum = 1;
		int x = s.getX();
		int y = s.getY();
		for(int i = 0;i<=4;i++){
			if(h==1){//判断"——"
				x-=40;
			}else if(h==2){//判断"|"
				y-=40;
			}else if(h==3){//判断"/"
				x-=40;
				y+=40;
			}else if(h==4){//判断"\"
				x-=40;
				y-=40;
			}
			//判断颜色
			if(pp(x,y)!=null&&s.isB()==pp(x,y).isB()){
				sum++;
			}else{
				break;
			}
			
		}
		x = s.getX();
		y = s.getY();
		for(int i = 0;i<=4;i++){
			if(h==1){//判断"——"
				x+=40;
			}else if(h==2){//判断"|"
				y+=40;
			}else if(h==3){//判断"/"
				x+=40;
				y-=40;
			}else if(h==4){//判断"\"
				x+=40;
				y+=40;
			}
			//判断颜色
			if(pp(x,y)!=null&&s.isB()==pp(x,y).isB()){
				sum++;
			}else{
				break;
			}
		}
		String cs = null;
		if(h==1){//判断"——"
			cs="横";
		}else if(h==2){//判断"|"
			cs="竖";
		}else if(h==3){//判断"/"
			cs="左斜";
		}else if(h==4){//判断"\"
			cs="右斜";
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
