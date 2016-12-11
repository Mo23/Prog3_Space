package WormInvader;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartPanel extends JPanel {
	final private JButton ButtonStartGame = new JButton("Spiel starten");
	final private JButton ButtonAnleitung = new JButton("Anleitung");
	final private JButton ButtonEinstellung = new JButton("Einstellung");
	final private JButton ButtonZurueck = new JButton("Zurück");
	final private ImageIcon img;
	
	public StartPanel() {
		img = new ImageIcon(this.getClass().getClassLoader()
				.getResource("images/background.png"));
		this.setLayout(null);
		this.setFocusable(true);
		
		this.setVisible(true);
	
		ButtonStartGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Startscreen.startpanel.setVisible(false);
				Startscreen.startscreen.setVisible(false);
				GameFrame.spielstart();

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


	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img.getImage(),0,0,this);
		
	}

}
