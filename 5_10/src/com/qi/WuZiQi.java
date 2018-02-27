package com.qi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class WuZiQi extends JComponent implements MouseListener {
	@Override
	public String toString() {
		return "WuZiQi [isHei=" + isHei + ", list=" + list + ", dangQianX="
				+ dangQianX + ", dangQianY=" + dangQianY + ", isWin=" + isWin
				+ "]";
	}

	public boolean isHei=true;//�ж�������ɫ
	java.util.List<QiZi> list = new ArrayList<QiZi>();//�������������̵�λ��
	private int dangQianX=0;//����X���λ��
	private int dangQianY=0;//����Y���λ��
	public boolean  isWin=true;//ʤ�����Ϊfalseֹͣ�滭
	public WuZiQi(){
		this.addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
			super.paint(g);
			g.setFont(new Font("",1,30));
			//��������
			for(int i=-1;i<10;i++){
				int a = (i*50+70);
				g.drawLine(20, a, 520, a);
				g.drawLine(a, 20, a, 520);
			}
			//������ 
			for(QiZi q:list){
				if(q.getX()!=0){
					g.setColor(q.getColor());
					g.fillOval(q.getX(),q.getY() , QiZi.SIZE, QiZi.SIZE);
				}
			}
			//�ж���Ӯ�Ĺ���
			guiZe(g);
	}
	public void mouseClicked(MouseEvent e) {
				//�������XY���ཻ����
				int x=e.getX();
				int y=e.getY();
				double xs = Math.round((x-20)/50.0);
				double ys = Math.round((y-20)/50.0);
				x = ((int) xs)*50+5;
				y = ((int) ys)*50+5;
				dangQianX=x;
				dangQianY=y;
				//�����ظ���������
				boolean isHave = false;
				//�������������
				for(QiZi q:list){
					//��ǰ������Ѵ洢��λ������ͬʱ��isHave��Ϊtrue�������ظ�����
					if(q.getX()==x && q.getY()==y){
						isHave=true;
					}
				}
				//Ϊ�Ǵ���ʱ֤�������������
				if(!isHave){
					QiZi qiZi = new QiZi(x, y);
					if(isHei==true){
						qiZi.setColor(Color.BLACK);
						isHei = false;
					}else if(isHei==false){
						qiZi.setColor(Color.WHITE);
						isHei = true;
					}
					if(isWin==true){
						list.add(qiZi);
						//�û���������
						this.repaint();
					}
				}
	}

	/**
	 * �õ�ǰ��λ�ü��򶫻�����λ�����ж�ͬһֱ�����ж��ٿ���ͬ ���������ж���Ӯ
	 */
	public void guiZe(Graphics g){
			int dong=0;
			int nan = 0;
			int dongbei=0;
			int xibei=0;
			/**
			 * ����Ϊ������
			 */
			for(int nowX=dangQianX,i = 0; i<5 && nowX<=520; i++,nowX+=50){
				QiZi q = fanHui(nowX,dangQianY);
				//��������겻Ϊ��ֵʱ
				if(q!=null){
					//System.out.println(isHei);
					//����ͷŵ�˲���ı�isHei��ֵ������Ҫȡ��
					if(isHei!=true){
						if(q.getColor()==Color.BLACK){
							dong++;
						}else{
							break;		//���м���ְ���֮�������ѭ���������¼���
						}
					}
					if(isHei!=false){
						if(q.getColor()==Color.WHITE){
							dong++;
						}else{
							break;	//���м���ֺ���֮�������ѭ���������¼���
						}
					}
				}else{
					break;
				}
				
			}
			/**
			 * �����򣬹̶���һ�ε�������ӣ������ȥ������ܼ���������������ж��٣���Ȼ�����¼�������ӣ�Ҳ���ǲ����������
			 */
			for(int nowX=dangQianX-50,i = 0; i<5 && nowX>=0; i++,nowX-=50){
				QiZi q = fanHui(nowX,dangQianY);
				//�����λ�ò�Ϊ��ʱ
				if(q!=null){
					if(isHei!=true){
						if(q.getColor()==Color.BLACK){
							dong++;		//���Ӽ����1
						}else{
							break;	//���а��ֳ���ʱ����ѭ���������¼���
						}
					}
					if(isHei!=false){
						if(q.getColor()==Color.WHITE){
							dong++;		//���ּ����1
						}else{
							break;		//���к��ӳ���ʱ����ѭ���������¼���
						}
					}
				}else{
					break;
				}
				
			}
			/**
			 * �Ϸ����ж���Ӯ
			 */
			for(int nowY=dangQianY,i=0;i<5&&nowY<=520;nowY+=50,i++){
				QiZi qiZi = fanHui(dangQianX,nowY);
				if(qiZi!=null){
					if(isHei!=true){
						if(qiZi.getColor()==Color.BLACK){
							nan++;
						} else{
							break;
						}
					}
					if(isHei!=false){
						if(qiZi.getColor()==Color.WHITE){
							nan++;
						}else{
							break;
						}
					}
				}else{
					break;
				}
			}
			/**
			 * �������ж���Ӯ,��ȥһ��������������ڣ���ȥ�����������ȿ�ʼ�����λ�ûᱻ��������
			 */
			for(int nowY=dangQianY-50,i=0;i<5 && nowY>=0;i++,nowY-=50){
				QiZi qiZi = fanHui(dangQianX,nowY);
				//��������겻Ϊ��ʱ
				if(qiZi!=null){
					//��Ϊ���֮��ͻ��isHei�����������и������Խ���ȡ������
					if(isHei!=true){
						if(qiZi.getColor()==Color.BLACK){
							nan++;
						}else{
							break;		//ֻ�е� nan��������ʱ�Ż��������ս����������赲�ͻ�����ѭ���������¼���
						}
					}
					//��Ϊ���֮��ͻ��isHei�����������и������Խ���ȡ������
					if(isHei!=false){
						if(qiZi.getColor()==Color.WHITE){
							nan++;
						}else{
							break;		//ֻ�е� nan��������ʱ�Ż��������ս����������赲�ͻ�����ѭ���������¼���
						}
					}
				}else{
					break;
				}
			}
			/**
			 *�����������ж���Ӯ�����������������ж�ʱ X����Y��һ������  ++ һ������ --
			 */
			//�ж϶�������
			for(int nowX = dangQianX, nowY = dangQianY,i=0; nowX<=520 && nowY>=0 && i<5;i++,nowX+=50,nowY-=50){
				QiZi qiZi = fanHui(nowX,nowY);
				if(qiZi!=null){
					if(isHei!=true){
						if(qiZi.getColor()==Color.BLACK){
							dongbei++;
						}else{
							break;
						}
					}
					if(isHei!=false){
						if(qiZi.getColor()==Color.WHITE){
							dongbei++;
						}else{
							break;
						}
					}
				}else{
						break;
					}
			}
			//�ж����ϵ���
			for(int nowX = dangQianX-50, nowY = dangQianY+50,i=0; nowX<=520 && nowY>=0 && i<5;i++,nowX-=50,nowY+=50){
				QiZi qiZi = fanHui(nowX,nowY);
				if(qiZi!=null){
					if(isHei!=true){
						if(qiZi.getColor()==Color.BLACK){
							dongbei++;
						}else{
							break;
						}
					}
					if(isHei!=false){
						if(qiZi.getColor()==Color.WHITE){
							dongbei++;
						}else{
							break;
						}
					}
				}else{
					break;
				}
			}
			/**
			 * �����������ж���Ӯ  �����������ж���Ӯʱ X����Y��ͬʱ����++��--
			 */
			//�����жϷ���
			for(int nowX = dangQianX,nowY = dangQianY,i=0;nowX>=0 && nowY<=520 && i<5;i++,nowX-=50,nowY-=50){
				QiZi qiZi = fanHui(nowX,nowY);
				if(qiZi!=null){
					if(isHei!=true){
						if(qiZi.getColor()==Color.BLACK){
							xibei++;
						}else{
							break;
						}
					}
					if(isHei!=false){
						if(qiZi.getColor()==Color.WHITE){
							xibei++;
						}else{
							break;
						}
					}
				}else{
					break;
				}
			}
			//�����жϷ���
			for(int nowX = dangQianX+50,nowY = dangQianY+50,i=0;nowX>=0 && nowY<=520 && i<5;i++,nowX+=50,nowY+=50){
				QiZi qiZi = fanHui(nowX,nowY);
				if(qiZi!=null){
					if(isHei!=true){
						if(qiZi.getColor()==Color.BLACK){
							xibei++;
						}else{
							break;
						}
					}
					if(isHei!=false){
						if(qiZi.getColor()==Color.WHITE){
							xibei++;
						}else{
							break;
						}
					}
				}else{
					break;
				}
			}
			/**
			 * ����ж���Ӯ���������
			 */
			if(isHei!=true&&dong>=5 ||isHei!=true && nan>=5 || isHei!=true && dongbei>=5 || isHei!=true && xibei>=5){
				//System.out.println("�ڷ�ʤ��");
				isWin=false;
				g.drawString("�ڷ���ʤ", 200, 25);
			}
			if(isHei!=false&&dong>=5 ||isHei!=false && nan>=5 || isHei!=false && dongbei>=5 || isHei!=false && xibei>=5){
//				System.out.println("�׷�ʤ��");
				isWin=false;
				g.drawString("�׷���ʤ", 200, 25);
			}
	}
	/**
	 * ������ͬһλ���ظ�����
	 * @param x
	 * @param y
	 * @return
	 */
	public QiZi fanHui(int x,int y){
		for(QiZi q:list){
			if(q.getX()==x && q.getY()==y){
				return q;
			}
		}
		return null;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
