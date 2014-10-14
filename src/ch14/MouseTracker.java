// Figura 14.29: MouseTracker.java
// Testando MouseTrackerFrame.
package ch14;

import javax.swing.JFrame;

public class MouseTracker {

	public static void main(String[] args) {
		
		MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame();
		mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mouseTrackerFrame.setSize(300, 100); // configura o tamanho do frame
		mouseTrackerFrame.setVisible(true); // exibe o frame

	} // fim de main

} // fim da classe MouseTracker
