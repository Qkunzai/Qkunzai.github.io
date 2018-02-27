package com.qi;

import java.awt.Graphics;
import java.awt.event.MouseListener;

import javax.swing.JComponent;


public class QiPan extends JComponent implements MouseListener{

	
	
	public void paint(Graphics g){
		
		for(int i=0;i<30;i++){
			g.drawLine(20, 0, , );
		}
		
		
		
		
		this.repaint();//»æ»­
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
