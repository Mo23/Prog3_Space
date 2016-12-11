package WormInvader;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EinstellungPanel extends JPanel {
	final private JButton leicht = new JButton("Leicht");
	final private JButton mittel = new JButton("Mittel");
	final private JButton schwer = new JButton("Schwer");
	final private JButton zurueck = new JButton("Zurück");
	public int difficult = 0;
	final private ImageIcon img = new ImageIcon(this.getClass().getClassLoader()
			.getResource("images/background.png"));

	/**
	 * Überschriebener Standardkonstruktor zum erstellen des Layouts.
	 */
	public EinstellungPanel() {
		this.setLayout(null);
		this.setSize(1200, 720);
		this.setFocusable(true);
		this.setBackground(Color.CYAN); // set background color for this JPanel
		this.setVisible(false);
		this.createInput();
	}

	/**
	 * Erzeugt den Inhalt des Pänels.
	 */
	public void createInput() {

		leicht.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				difficult = 0;
				goback();

			}
		});
		mittel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				difficult = 1;
				goback();

			}
		});
		schwer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				difficult = 2;
				goback();

			}
		});
		this.add(leicht);
		this.add(mittel);
		this.add(schwer);
		leicht.setBackground(Color.pink);
		mittel.setBackground(Color.pink);
		schwer.setBackground(Color.pink);
		leicht.setBounds(550, 200, 100, 30);
		mittel.setBounds(550, 250, 100, 30);
		schwer.setBounds(550, 300, 100, 30);

		leicht.setVisible(true);
		mittel.setVisible(true);
		schwer.setVisible(true);

	}

	/**
	 * Methode zum wechseln zwischen den Panels.
	 */
	private void goback() {

		Startscreen.einstellungspanel.setVisible(false);
		Startscreen.startpanel.setVisible(true);
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img.getImage(),0,0,this);
		
	}
}
