package ch14;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame {
	
	private JButton plainJButton; // botão apenas com texto
	private JButton fancyJButton; // botão com ícones
	
	// ButtonFrame adiciona JButtons ao JFrame
	public ButtonFrame() {
		
		super("Testing Buttons");
		setLayout(new FlowLayout()); // configura o layout de frame
		
		plainJButton = new JButton("Plain Button"); // botão com texto
		add(plainJButton); // adiciona plainJButton ao JFrame
		
		Icon bug1 = new ImageIcon(getClass().getResource("bug1.GIF"));
		Icon bug2 = new ImageIcon(getClass().getResource("bug2.GIF"));
		fancyJButton = new JButton("Fancy Button", bug1); // configura a imagem
		fancyJButton.setRolloverIcon(bug2); // configura a imagem de rollover
		add(fancyJButton); // adiciona fancyJButton ao JFrame
		
		// cria novo ButtonHandler para tratamento de evento de botão
		ButtonHandler handler = new ButtonHandler();
		fancyJButton.addActionListener(handler);
		plainJButton.addActionListener(handler);
		
	} // fim do construtor ButtonFrame
	
	// classe interna para tratamento de evento de botão
	private class ButtonHandler implements ActionListener {
		
		// trata evento de botão
		public void actionPerformed(ActionEvent event) {
			
			JOptionPane.showMessageDialog(ButtonFrame.this, String.format("You pressed: %s", event.getActionCommand()));
			
		} // fim do método actionPerformed
		
	} // fim da classe ButtonHandler private interna

} // fim da classe ButtonFrame
