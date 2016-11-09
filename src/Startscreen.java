import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Startscreen extends JFrame {

	final private short WIDTH = 1200;
	final private short HEIGTH = 720;
	public static Startscreen startscreen;
	public static StartPanel startpanel;
	public static AnleitungPanel anleitungpanel;
	public static EinstellungPanel einstellungspanel;
	public boolean startedgame;
	public Thread gamestart;

	public Startscreen() {
		this.startedgame = false;
		this.
		add(anleitungpanel = new AnleitungPanel());
		add(einstellungspanel = new EinstellungPanel());
		add(startpanel = new StartPanel());
		// anleitungpanel.setVisible(false);
		setTitle("VirenSchleuder");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGTH);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args) {
		startscreen = new Startscreen();

	}
}
