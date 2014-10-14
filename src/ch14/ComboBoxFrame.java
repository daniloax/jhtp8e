// Figura 14.21: ComboBoxFrame.java
// JComboBox que exibe uma lista de nomes de imagem

package ch14;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxFrame extends JFrame {
	
	private JComboBox imagesJComboBox; // caixa de combinação para armazenar nomes de ícones
	private JLabel label; // rótulo para exibir ícone selecionado
	
	private static final String[] names = { "bug1.GIF", "bug2.GIF", "travelbug.gif", "buganim.gif" };
	private Icon[] icons = {
			new ImageIcon(getClass().getResource(names[0])),
			new ImageIcon(getClass().getResource(names[1])),
			new ImageIcon(getClass().getResource(names[2])),
			new ImageIcon(getClass().getResource(names[3])),
		};
	
	// construtor ComboBoxFrame adiciona JComboBox ao JFrame
	public ComboBoxFrame() {
		
		super("Testing JComboBox");
		setLayout(new FlowLayout()); // configura o layout de frame
		
		imagesJComboBox = new JComboBox(names); // configura JComboBox
		imagesJComboBox.setMaximumRowCount(3); // exibe três linhas
		
		imagesJComboBox.addItemListener(
				
				new ItemListener() { // classe interna anônima
					
					// trata evento JComboBox
					public void itemStateChanged (ItemEvent event) {
						
						// determina o item selecionado
						if (event.getStateChange() == ItemEvent.SELECTED)
							label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
						
					} // fim do método itemStateChanged
					

				} // fim da classe interna anônima
				
			); // fim da chamada para addItemListener
		
		add(imagesJComboBox); // adiciona combobox ao frame
		label = new JLabel(icons[0]); // exibe primeiro ícone
		add(label); // adiciona rótulo ao JFrame
		
	} // fim do construtor ComboBoxFrame

} // fim da classe ComboBoxFrame
