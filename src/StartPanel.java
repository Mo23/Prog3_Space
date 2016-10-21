import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class StartPanel extends JPanel{
	private JButton ButtonStartGame = new JButton("Spiel starten");
	private JButton ButtonAnleitung = new JButton("Anleitung");
	private JButton ButtonEinstellung = new JButton("Einstellung");
	private JButton ButtonZurueck = new JButton("Zurück");
	public StartPanel(){
		this.setLayout(null);
		setFocusable(true);
		//dimension = new Dimension(1200, 720);
		setBackground(Color.CYAN);  // set background color for this JPanel
		this.setVisible(true);
		ButtonStartGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Startscreen.startpanel.setVisible(false);
				Startscreen.startscreen.dispose();
				GameBoard.spielstart();
				
			}
		});
	ButtonAnleitung.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Startscreen.startpanel.setVisible(false);
				Startscreen.anleitungpanel.setVisible(true);
				
			}
		});
	ButtonEinstellung.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Startscreen.startpanel.setVisible(false);
			Startscreen.einstellungspanel.setVisible(true);
			
		}
	});
	ButtonZurueck.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Startscreen.startpanel.setVisible(false);
			
		}
	});
		this.add(ButtonEinstellung);
		this.add(ButtonStartGame);
		this.add(ButtonAnleitung);
		this.add(ButtonZurueck);
		ButtonZurueck.setBounds(520, 260, 150, 20);
		ButtonAnleitung.setBounds(520, 180, 150, 20);
		ButtonStartGame.setBounds(520, 140, 150, 20);
		ButtonEinstellung.setBounds(520, 220, 150, 20);
		ButtonAnleitung.setVisible(true);
		ButtonStartGame.setVisible(true);
		ButtonEinstellung.setVisible(true);
		ButtonZurueck.setVisible(true);
	}
	
	
	
}

