import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AnleitungPanel extends JPanel {
	JLabel text = new JLabel("sss");
	JButton zurueck = new JButton("Zurück");
	public AnleitungPanel(){
		this.setLayout(null);
		this.setSize(1200, 720);
		setFocusable(true);
		this.setBackground(Color.CYAN);  // set background color for this JPanel
		this.setVisible(false);
		text.setBounds(200, 200, 200, 200);
		zurueck.setBounds(550, 600, 100, 30);
		zurueck.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				Startscreen.anleitungpanel.setVisible(false);
				Startscreen.startpanel.setVisible(true);
				
			}
		});
		this.add(text);
		this.add(zurueck);
		zurueck.setVisible(true);
		text.setVisible(true);
	}
}
