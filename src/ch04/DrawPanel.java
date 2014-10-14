package ch04;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		for (int i = 0; i < (getWidth() + getHeight()) / 2; i += 10)
			g.drawLine(0, i, i, getHeight());				
			
	}

}
