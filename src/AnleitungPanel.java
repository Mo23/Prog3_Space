import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;


public class AnleitungPanel extends JPanel {
	JTextField text = new JTextField("sss");
	
	public AnleitungPanel(){
		this.setLayout(null);
		this.setSize(1200, 720);
		setFocusable(true);
		Dimension dimension = new Dimension(1200, 720);
		this.setBackground(Color.CYAN);  // set background color for this JPanel
		this.setVisible(false);
		text.setBounds(200, 200, 200, 200);
		this.add(text);
		text.setVisible(true);
	}
}
