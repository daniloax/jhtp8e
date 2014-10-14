// Figura 14.23: ListFrame.java
// JList que exibe um lista de cores
package ch14;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListFrame extends JFrame {
	
	private JList colorJList; // lista para exibir as cores
	private static final String[] colorNames = {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yelow"};
	private static final Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	
	// construtor ListFrame adiciona JScroolPane que contém JList ao JFrame
	public ListFrame() {
		
		super("List Test");
		setLayout(new FlowLayout()); // configura o layout de frame
		
		colorJList = new JList(colorNames); // cria com colorNames
		colorJList.setVisibleRowCount(5); // exibe cinco linhas de uma vez
		
		// não permite múltiplas seleções
		colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// adiciona um JScrollPane que comtém JList ao Frame
		add(new JScrollPane(colorJList));
		
		colorJList.addListSelectionListener(
				
				new ListSelectionListener() { // classe interna anônima
					
					// trata eventos de seleção de lista
					public void valueChanged(ListSelectionEvent event) {
						
						getContentPane().setBackground(colors[colorJList.getSelectedIndex()]);
						
					} // fim do método valueChanged
				
				} // fim da classe interna anônima
				
			); // fim da chamada para addListSelectionListener
		
	} // fim do construtor ListFrame
	
} // fim da classe ListFrame
