package ch14;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CheckBoxFrame extends JFrame {
	
	private JTextField textField; // exibe o texto na alteração de fontes
	private JCheckBox boldCheckBox; // para selecionar estilo negrito | remover a seleção do estilo negrito
	private JCheckBox italicCheckBox; // para selecionar estilo itálico | remover a seleção do estilo itálico
	
	public CheckBoxFrame() {
		
		super("JCheckBox Test");
		setLayout(new FlowLayout()); // configura o layout de frame
		
		// configura JTextField e sua fonte
		textField = new JTextField("Watch the font style change", 20);
		textField.setFont(new Font("Serif", Font.PLAIN, 14));
		add(textField); // adiciona textField ao JFrame
		
		boldCheckBox = new JCheckBox("Bold"); // cria caixa de seleção para negrito
		italicCheckBox = new JCheckBox("Italic"); // cria caixa de seleção para itálico
		add(boldCheckBox); // adiciona caixa de seleção de estilo negrito ao JFrame
		add(italicCheckBox); // adiciona caixa de seleção de itálico ao JFrame
		
		// listeners registradores para JCheckBoxes
		CheckBoxHandler handler = new CheckBoxHandler();
		boldCheckBox.addItemListener(handler);
		italicCheckBox.addItemListener(handler);
		
	}
	
	// classe interna private para tratamento de evento ItemListener
	private class CheckBoxHandler implements ItemListener {
		
		// responde aos eventos de caixa de seleção
		public void itemStateChanged(ItemEvent event) {
			
			Font font = null; // armazena a nova Font
			
			// determina que CheckBoxes estão marcadas e cria Font
			if (boldCheckBox.isSelected() && italicCheckBox.isSelected())
				font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
			
			else if (boldCheckBox.isSelected())
				font = new Font("Serif", Font.BOLD, 14);
			
			else if (italicCheckBox.isSelected())
				font = new Font("Serif", Font.ITALIC, 14);
			
			else
				font = new Font("Serif", Font.PLAIN, 14);
			
			textField.setFont(font); // configura a fonte do textField
			
		} // fim do método itemStateChanged
		
	} // fim da classe CheckBoxHandler interna private

} // fim da classe CheckBoxFrame
