package VirenSchleuder;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	final private int WIDTH = 1200;
	final private int HEIGTH = 720;

	public static GameFrame gameboard;
	public SpielPanel framespiel;

	public GameFrame() {

		this.add(framespiel = new SpielPanel());
		this.setTitle("VirenSchleuder");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGTH);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);

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