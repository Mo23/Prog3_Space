import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EinstellungPanel extends JPanel {
	private JButton leicht = new JButton("Leicht");
	private JButton mittel = new JButton("Mittel");
	private JButton schwer = new JButton("Schwer");
	private JButton zurueck = new JButton("Zurück");

	public EinstellungPanel() {
		this.setLayout(null);
		this.setSize(1200, 720);
		setFocusable(true);
		this.setBackground(Color.CYAN); // set background color for this JPanel
		this.setVisible(false);
		createInput();
	}

	public void createInput() {
		zurueck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Startscreen.einstellungspanel.setVisible(false);
				Startscreen.startpanel.setVisible(true);

			}
		});
		leicht.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		mittel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		schwer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		this.add(leicht);
		this.add(mittel);
		this.add(schwer);
		this.add(zurueck);
		leicht.setBounds(550, 200, 100, 30);
		mittel.setBounds(550, 250, 100, 30);
		schwer.setBounds(550, 300, 100, 30);
		zurueck.setBounds(550, 350, 100, 30);

		leicht.setVisible(true);
		mittel.setVisible(true);
		schwer.setVisible(true);
		zurueck.setVisible(true);

	}
}
