package WormInvader;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author maurice
 *
 */
@SuppressWarnings("serial")
public class EinstellungPanel extends JPanel {
	final private JButton leicht = new JButton("Leicht");
	final private JButton mittel = new JButton("Mittel");
	final private JButton schwer = new JButton("Schwer");
	public int difficult = 0;
	final private ImageIcon img = new ImageIcon(this.getClass()
			.getClassLoader().getResource("images/background.png"));

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
		leicht.setBorderPainted(false);
		mittel.setBorderPainted(false);
		schwer.setBorderPainted(false);
		leicht.setFont(Startscreen.font);
		mittel.setFont(Startscreen.font);
		schwer.setFont(Startscreen.font);
		leicht.setBackground(Startscreen.color);
		mittel.setBackground(Startscreen.color);
		schwer.setBackground(Startscreen.color);
		leicht.setBounds(460, 200, 300, 60);
		mittel.setBounds(460, 280, 300, 60);
		schwer.setBounds(460, 360, 300, 60);

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
		g.drawImage(img.getImage(), 0, 0, this);

	}
}
