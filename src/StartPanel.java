import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class StartPanel extends JPanel{
	private Dimension dimension;
	JButton button1 = new JButton("Spiel starten");
	public StartPanel(){
		setFocusable(true);
		dimension = new Dimension(WIDTH, HEIGHT);
		setBackground(Color.BLACK);  // set background color for this JPanel
		this.setVisible(true);
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Startscreen.startpanel.setVisible(false);
				Startscreen.startscreen.dispose();
				GameBoard.spielstart();
				
			}
		});
		this.add(button1);
		button1.setVisible(true);
		
	}
	
}

