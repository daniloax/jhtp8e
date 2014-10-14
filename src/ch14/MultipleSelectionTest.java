// Figura 14.26: MultipleSelectionTest.java
// Testando MultipleSelectionFrame.
package ch14;

import javax.swing.JFrame;

public class MultipleSelectionTest {

	public static void main(String[] args) {
		
		MultipleSelectionFrame multipleSelectionFrame = new MultipleSelectionFrame();
		multipleSelectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		multipleSelectionFrame.setSize(350, 150); // configura o tamanho do frame
		multipleSelectionFrame.setVisible(true); // exibe o frame

	} // fim de main

} // fim da classe MultipleSelectionTest
