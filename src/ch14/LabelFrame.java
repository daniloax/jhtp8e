// Figura 14.6: LabelFrame.java
// Demonstrando a classe JLabel

package ch14;

import java.awt.FlowLayout; // especifica como os componentes sao organizados

import javax.swing.Icon; // interface utilizada para manipular imagens
import javax.swing.ImageIcon; // carrega imagens
import javax.swing.JFrame; // fornece recursos básicos de janela
import javax.swing.JLabel; // exibe texto e imagens
import javax.swing.SwingConstants; // constantes comuns utilizadas com Swing

public class LabelFrame extends JFrame {
	
	private JLabel label1; // JLabel apenas com texto
	private JLabel label2; // JLabel construído com texto e ícone
	private JLabel label3; // JLabel com texto e ícone adicionados
	
	// construtor LabelFrame adiciona JLabels a JFrame
	public LabelFrame() {
		
		super("Testing JLabel");
		setLayout(new FlowLayout()); // configura o layout de frame
		
		label1 = new JLabel("Label with text"); // Construtor JLabel com um argumento de string
		label1.setToolTipText("This is label1");
		add(label1); // adiciona label1 ao JFrame 
		
		Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
		label2 = new JLabel("Label with text and icon", bug, SwingConstants.LEFT); // Construtor JLabel com string, icon e argumentos de alinhamento
		label2.setToolTipText("This is label2");
		add(label2); // adiciona label1 ao JFrame
		
		label3 = new JLabel(""); // Construtor JLabel sem argumentos
		label3.setText("Label with icon and text at bottom");
		label3.setIcon(bug); // adiciona o icone ao bottom
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("This is label3");
		add(label3); // adiciona label3 ao JFrame
		
	} // fim do construtor de LabelFrame

} // fim da classe LabelFrame