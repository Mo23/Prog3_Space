package WormInvader;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author maurice
 *
 */
@SuppressWarnings("serial")
public class AnleitungPanel extends JPanel {
	private JTextArea textFeldAnleitung;
	final private JButton zurueck = new JButton("Zurück");
	final private ImageIcon img = new ImageIcon(this.getClass()
			.getClassLoader().getResource("images/background.png"));

	/**
	 * Standkonstruktor zur Erzeugung des Panels mit Inhalt.
	 */
	public AnleitungPanel() {
		
		this.setLayout(null);
		this.setSize(1200, 720);
		this.setFocusable(true);
		this.setBackground(Color.CYAN); // set background color for this JPanel
		this.setVisible(false);
		this.textFeldAnleitung = new JTextArea(readdata(this.getClass()
				.getClassLoader().getResourceAsStream("images/Anleitung.txt")));

		this.createinput();

	}

	/**
	 * Methode zum einlesen des Textfeldes und Umwandlung in einen String mit
	 * Formatierung.
	 * 
	 * @param inputStream
	 * @return String
	 * 
	 */
	private static String readdata(InputStream inputStream) {

		String back = null;

		BufferedReader in = null;
		try {
			InputStreamReader is = new InputStreamReader(inputStream);
			in = new BufferedReader(is);

			String zeile = null;
			while ((zeile = in.readLine()) != null) {
				if (back == null) {
					back = zeile;
				} else {
					back += (zeile + "\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
				}
		}
		return back;
	}

	/**
	 * Methode zum setzen der Inhaltelemente des Anleitungspanels.
	 */
	private void createinput() {
		textFeldAnleitung.setBackground(Color.CYAN);
		textFeldAnleitung.setEditable(false);
		textFeldAnleitung.setFocusable(false);
		textFeldAnleitung.setOpaque(false);

		textFeldAnleitung.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		textFeldAnleitung.setForeground(Color.WHITE);
		textFeldAnleitung.setBounds(150, 150, 1200, 350);
		zurueck.setBounds(450, 500, 300, 60);
		zurueck.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Startscreen.anleitungpanel.setVisible(false);
				Startscreen.startpanel.setVisible(true);

			}
		});
		this.add(textFeldAnleitung);
		this.add(zurueck);
		zurueck.setBorderPainted(false);
		zurueck.setFont(Startscreen.font);
		zurueck.setBackground(Startscreen.color);
		zurueck.setVisible(true);
		textFeldAnleitung.setVisible(true);

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img.getImage(), 0, 0, this);

	}
}
