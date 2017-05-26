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

	public boolean isHei=true;//判断棋子颜色
	java.util.List<QiZi> list = new ArrayList<QiZi>();//保存棋子在棋盘的位置
	private int dangQianX=0;//保存X轴的位置
	private int dangQianY=0;//保存Y轴的位置
	public boolean  isWin=true;//胜利后变为false停止绘画
	public WuZiQi(){
		this.addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
			super.paint(g);
			g.setFont(new Font("",1,30));
			//画棋盘线
			for(int i=-1;i<10;i++){
				int a = (i*50+70);
				g.drawLine(20, a, 520, a);
				g.drawLine(a, 20, a, 520);
			}
			//画棋子 
			for(QiZi q:list){
				if(q.getX()!=0){
					g.setColor(q.getColor());
					g.fillOval(q.getX(),q.getY() , QiZi.SIZE, QiZi.SIZE);
				}
			}
			//判断输赢的规则
			guiZe(g);
	}
	public void mouseClicked(MouseEvent e) {
				//鼠标点击在XY轴相交点上
				int x=e.getX();
				int y=e.getY();
				double xs = Math.round((x-20)/50.0);
				double ys = Math.round((y-20)/50.0);
				x = ((int) xs)*50+5;
				y = ((int) ys)*50+5;
				dangQianX=x;
				dangQianY=y;
				//避免重复绘制棋子
				boolean isHave = false;
				//鼠标点击出现棋子
				for(QiZi q:list){
					//当前点击与已存储的位置有相同时将isHave改为true，避免重复落子
					if(q.getX()==x && q.getY()==y){
						isHave=true;
					}
				}
				//为非错误时证明该落点无棋子
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
						//用户触发绘制
						this.repaint();
					}
				}
	}

	/**
	 * 用当前的位置加向东或西的位置来判断同一直线上有多少颗相同 的棋子来判断输赢
	 */
	public void guiZe(Graphics g){
			int dong=0;
			int nan = 0;
			int dongbei=0;
			int xibei=0;
			/**
			 * 以下为东方向
			 */
			for(int nowX=dangQianX,i = 0; i<5 && nowX<=520; i++,nowX+=50){
				QiZi q = fanHui(nowX,dangQianY);
				//当点击坐标不为空值时
				if(q!=null){
					//System.out.println(isHei);
					//点击释放的瞬间会改变isHei的值所以需要取反
					if(isHei!=true){
						if(q.getColor()==Color.BLACK){
							dong++;
						}else{
							break;		//当中间出现白棋之后就跳出循环进行重新计算
						}
					}
					if(isHei!=false){
						if(q.getColor()==Color.WHITE){
							dong++;
						}else{
							break;	//当中间出现黑棋之后就跳出循环进行重新计算
						}
					}
				}else{
					break;
				}
				
			}
			/**
			 * 西方向，固定第一次点击的棋子，必须减去自身才能计算出向西的棋子有多少，不然会重新计算该棋子，也就是不会计算两次
			 */
			for(int nowX=dangQianX-50,i = 0; i<5 && nowX>=0; i++,nowX-=50){
				QiZi q = fanHui(nowX,dangQianY);
				//当点击位置不为空时
				if(q!=null){
					if(isHei!=true){
						if(q.getColor()==Color.BLACK){
							dong++;		//黑子计算加1
						}else{
							break;	//当有白字出现时跳出循环进行重新计算
						}
					}
					if(isHei!=false){
						if(q.getColor()==Color.WHITE){
							dong++;		//白字计算加1
						}else{
							break;		//当有黑子出现时跳出循环进行重新计算
						}
					}
				}else{
					break;
				}
				
			}
			/**
			 * 南方向判断输赢
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
			 * 北方向判断输赢,减去一个坐标的意义在于，减去自身，否则最先开始点击的位置会被计算两次
			 */
			for(int nowY=dangQianY-50,i=0;i<5 && nowY>=0;i++,nowY-=50){
				QiZi qiZi = fanHui(dangQianX,nowY);
				//点击的坐标不为空时
				if(qiZi!=null){
					//因为点击之后就会把isHei变量立即进行复制所以进行取反操作
					if(isHei!=true){
						if(qiZi.getColor()==Color.BLACK){
							nan++;
						}else{
							break;		//只有当 nan变量到五时才会计算出最终结果，如果被阻挡就会跳出循环进行重新计算
						}
					}
					//因为点击之后就会把isHei变量立即进行复制所以进行取反操作
					if(isHei!=false){
						if(qiZi.getColor()==Color.WHITE){
							nan++;
						}else{
							break;		//只有当 nan变量到五时才会计算出最终结果，如果被阻挡就会跳出循环进行重新计算
						}
					}
				}else{
					break;
				}
			}
			/**
			 *东北、西南判断输赢方法，东北、西南判断时 X轴与Y轴一个进行  ++ 一个进行 --
			 */
			//判断东北的线
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
			//判断西南的线
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
			 * 西北、东南判断输赢  西北、东南判断输赢时 X轴与Y轴同时进行++或--
			 */
			//西北判断方法
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
			//东南判断方法
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
			 * 输出判断输赢的语句或界面
			 */
			if(isHei!=true&&dong>=5 ||isHei!=true && nan>=5 || isHei!=true && dongbei>=5 || isHei!=true && xibei>=5){
				//System.out.println("黑方胜利");
				isWin=false;
				g.drawString("黑方获胜", 200, 25);
			}
			if(isHei!=false&&dong>=5 ||isHei!=false && nan>=5 || isHei!=false && dongbei>=5 || isHei!=false && xibei>=5){
//				System.out.println("白方胜利");
				isWin=false;
				g.drawString("白方获胜", 200, 25);
			}
	}
	/**
	 * 避免在同一位置重复落子
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
