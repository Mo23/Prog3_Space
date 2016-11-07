import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AnleitungPanel extends JPanel {
	private JTextArea text;
	private JButton zurueck = new JButton("Zurück");
	private String dataname = "test.txt";

	public AnleitungPanel() {
		this.setLayout(null);
		this.setSize(1200, 720);
		setFocusable(true);
		this.setBackground(Color.CYAN); // set background color for this JPanel
		this.setVisible(false);
		text = new JTextArea(readdata(dataname));
		createinput();

	}

	private String readdata(String name) {
		File file = new File(name);
		String back = null;
		if (!file.canRead() || !file.isFile())
			System.exit(0);

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(name));
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

	private void createinput() {
		text.setBackground(Color.CYAN);
		text.setEditable(false);
		text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		text.setBounds(0, 0, 1200, 650);
		zurueck.setBounds(550, 650, 100, 30);
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
