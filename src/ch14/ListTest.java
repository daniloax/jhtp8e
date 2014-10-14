// Figura 14.24: ListTest.java
// Selecionando as cores de uma JList.
package ch14;

import javax.swing.JFrame;

public class ListTest {

	public static void main(String[] args) {
		
		ListFrame listFrame = new ListFrame(); // cria ListFrame
		listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listFrame.setSize(350, 150); // configura o tamanho do frame
		listFrame.setVisible(true); // exibe o frame

	} // fim de main

} // fim da classe ListTest
