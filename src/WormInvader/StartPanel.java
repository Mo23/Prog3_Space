package WormInvader;

import java.awt.Color;
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
	final private ImageIcon img = new ImageIcon(this.getClass()
			.getClassLoader().getResource("images/background.png"));

	public StartPanel() {

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
		ButtonStartGame.setBorderPainted(false);
		ButtonZurueck.setBorderPainted(false);
		ButtonAnleitung.setBorderPainted(false);
		ButtonEinstellung.setBorderPainted(false);
		ButtonZurueck.setFont(Startscreen.font);
		ButtonAnleitung.setFont(Startscreen.font);
		ButtonStartGame.setFont(Startscreen.font);
		ButtonEinstellung.setFont(Startscreen.font);
		ButtonZurueck.setBackground(Startscreen.color);
		ButtonAnleitung.setBackground(Startscreen.color);
		ButtonStartGame.setBackground(Startscreen.color);
		ButtonEinstellung.setBackground(Startscreen.color);
		ButtonStartGame.setBounds(460, 140, 300, 60);
		ButtonAnleitung.setBounds(460, 220, 300, 60);
		ButtonEinstellung.setBounds(460, 300, 300, 60);
		ButtonZurueck.setBounds(460, 380, 300, 60);
		ButtonAnleitung.setVisible(true);
		ButtonStartGame.setVisible(true);
		ButtonEinstellung.setVisible(true);
		ButtonZurueck.setVisible(true);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img.getImage(), 0, 0, this);

	}

}
