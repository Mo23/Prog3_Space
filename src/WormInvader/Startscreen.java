package WormInvader;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Startscreen extends JFrame {

	final private short WIDTH = 1200;
	final private short HEIGTH = 720;
	final public static Font font = new Font("Ubuntu", Font.BOLD, 40);
	final public static Color color = new Color(255,200,160);
	public static Startscreen startscreen;
	public static StartPanel startpanel;
	public static AnleitungPanel anleitungpanel;
	public static EinstellungPanel einstellungspanel;
	public boolean startedgame;
	public Thread gamestart;
	private static Thread startgame;

	public Startscreen() {
		this.startedgame = false;
		add(anleitungpanel = new AnleitungPanel());

		add(einstellungspanel = new EinstellungPanel());
		add(startpanel = new StartPanel());
		setTitle("WormInvader");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGTH);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

	}

	public static void main(String[] args) {

		startgame = new Thread();
		{

			startscreen = new Startscreen();

		}
		;

		startgame.start();

	}
}
