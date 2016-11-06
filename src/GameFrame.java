import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	final private int WIDTH = 1200;
	final private int HEIGTH = 720;

	public static GameFrame gameboard;
	public PanelSpiel framespiel;

	public GameFrame() {
		add(framespiel = new PanelSpiel());
		setTitle("VirenSchleuder");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGTH);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

	}

	public static void spielstart() {

		Thread thread = new Thread() {
			public void run() {
				gameboard = new GameFrame();

			}
		};

		thread.start();

	}

}