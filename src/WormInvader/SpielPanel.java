package WormInvader;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author maurice
 *
 */
@SuppressWarnings("serial")
public class SpielPanel extends JPanel {

	public boolean runninglost = false;
	public boolean runningwon = false;
	private Thread gamerunning;
	public static Logikadapter logik;
	private final ImageIcon gewonnen = new ImageIcon(this.getClass()
			.getClassLoader().getResource("images/spielgewonnen.png"));
	private final ImageIcon verloren = new ImageIcon(this.getClass()
			.getClassLoader().getResource("images/spielverloren.png"));
	private boolean times = false;
	private boolean onetime = false;
	private long timeend;
	final public Font font = new Font("Ubuntu", Font.BOLD, 20);
	final private int displaynewWeapon = 1250;
	final private int displaynewWeapony = 640;

	/**
	 * Konstruiert neues Spielpanel.
	 */
	public SpielPanel() {

		this.addKeyListener(new TLogik());
		this.setFocusable(true);
		this.setBackground(Color.BLACK); // set background color for this JPanel
		logik = new Logikadapter();
		runningwon = true;
		runninglost = true;

	}

	/* 
	 * Überschriebene Paint-Methode zum zeichnen der gewünschten Inhalte.
	 */
	public void paint(Graphics g) {
		super.paint(g);

		if (runningwon && runninglost) {
			animations(g);
		} else {
			if (!runningwon) {
				DrawEndWon(g);
				gamerunning.stop();
			} else {
				DrawEndLost(g);
				gamerunning.stop();
			}
		}

		SwingUtilities.invokeLater(act());
		SwingUtilities.invokeLater(logik.act());

		if (logik.getShot().fired == true) {
			DrawShot(g);
		}

	}

	/**
	 * @return Den erstellten Thread.
	 * Führt in einem neuen Thread repaint aus, um das Spiel zu erneuern.
	 */
	public Runnable act() {
		gamerunning = new Thread() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					gamerunning.sleep(8);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				repaint();

			}

		};
		gamerunning.start();
		return gamerunning;
	}

	/**
	 * @param g
	 * Beeinhaltet alle Methoden, die während des Spiels aufjedenfall neu gezeichnet werden müssen.
	 */
	public void animations(Graphics g) {
		DrawPlayer(g);
		DrawWorms(g);
		DrawEnemyShot(g);
		DrawStatus(g);

	}

	/**
	 * @param g
	 * Zeichnet das Endimage des Spiels, wenn gewonnen wurde.
	 */
	public void DrawEndWon(Graphics g) {

		g.drawImage(gewonnen.getImage(), 0, 0, this);
	}

	/**
	 * @param g
	 * Zeichnet das Endimage des Spiels, wenn verloren wurde.
	 */
	public void DrawEndLost(Graphics g) {

		g.drawImage(verloren.getImage(), 0, 0, this);

	}

	/**
	 * @param g
	 * Zeichnet alle Statusbars im Spiel.
	 */
	public void DrawStatus(Graphics g) {

		g.setColor(Startscreen.color);
		g.setFont(font);
		g.drawString(
				"Lebenspunkte: " + Integer.toString(logik.getSpieler().HP), 0,
				700);
		g.drawString("Aktuelle Waffe: " + logik.getSpieler().getWeaponname(),
				0, 670);
		g.drawString("Score: " + Integer.toString(logik.getScore()), 1100, 700);

		checkWeaponAvailable(g);

	}

	/**
	 * @param g
	 * Methode zum Überprüfen, ob eine neue Waffe verfügbar ist und gibt dann eine Nachricht aus.
	 */
	private void checkWeaponAvailable(Graphics g) {
		if (logik.getScore() >= logik.getSpieler().getwSc1()
				&& logik.getWeapon() == 1) {

			if (!onetime) {
				timeend = System.currentTimeMillis() + displaynewWeapon;
				onetime = true;
			}
			if (timeend <= System.currentTimeMillis()) {
				times = true;

			}
			if (!times) {
				g.setColor(Startscreen.color.brighter());

				g.drawString("Waffensystem 1 ist verfügbar", 0,
						displaynewWeapony);
			}

		}
		if (logik.getScore() >= logik.getSpieler().getwSc2()
				&& logik.getWeapon() == 2) {

			if (onetime) {
				timeend = System.currentTimeMillis() + displaynewWeapon;
				onetime = false;
				times = false;
			}
			if (timeend <= System.currentTimeMillis())
				times = true;
			if (!times) {
				g.setColor(Startscreen.color.brighter());
				g.drawString("Waffensystem 2 ist verfügbar", 0,
						displaynewWeapony);
			}
		}
		if (logik.getScore() >= logik.getSpieler().getwSc3()
				&& logik.getWeapon() == 3) {
			if (!onetime) {
				timeend = System.currentTimeMillis() + displaynewWeapon;
				onetime = true;
				times = false;
			}
			if (timeend <= System.currentTimeMillis())
				times = true;
			if (!times) {
				g.setColor(Startscreen.color.brighter());
				g.drawString("Waffensystem 3 ist verfügbar", 0,
						displaynewWeapony);
			}
		}
	}

	/**
	 * @param g
	 * Zeichnet den Spieler.
	 */
	public void DrawPlayer(Graphics g) {

		g.drawImage(logik.getSpieler().getImage(), logik.getSpieler().getX(),
				logik.getSpieler().getY(), this);
	}

	/**
	 * @param g
	 * Zeichnet die Gegenerischen Würmer.
	 */
	public void DrawWorms(Graphics g) {
		int size_a = logik.getEnemylist().size();

		for (int i = 0; i < size_a; i++) {
			Enemy computer = logik.getEnemylist().get(i);
			g.drawImage(computer.getImage(), computer.getX(), computer.getY(),
					this);
		}

	}

	/**
	 * @param g
	 * Zeichnet den Spielerschuss.
	 */
	public void DrawShot(Graphics g) {
		g.drawImage(logik.getShot().getImage(), logik.getShot().getX(), logik
				.getShot().getY(), this);
	}

	/**
	 * @param g
	 * Zeichnet die Schüsse der Würmer
	 */
	public void DrawEnemyShot(Graphics g) {

		int size_a = logik.getEnemylist().size();
		for (int i = 0; i < size_a; i++) {
			Enemy e = logik.getEnemylist().get(i);
			EnemyShot b = e.geteshot();
			if (e.fired)
				g.drawImage(b.getImage(), b.getX(), b.getY(), this);
		}
	}

	/**
	 * @author maurice
	 * Klasse zur Interaktion mit der Tastatur
	 *
	 */
	private class TLogik extends KeyAdapter {

		/* (non-Javadoc)
		 * Methode zum erfassen von losgelassenen Tasten.
		 */
		public synchronized void keyReleased(KeyEvent e) {

			logik.getSpieler().keyReleased(e);

		}

		/* (non-Javadoc)
		 * Methode zum erfassen von gedrückten Tasten.
		 */
		public synchronized void keyPressed(KeyEvent e) {
			if (GameFrame.gameboard.framespiel.runninglost == true
					&& GameFrame.gameboard.framespiel.runninglost == true) {
				logik.getSpieler().keyPressed(e);
				if (KeyEvent.VK_SPACE == e.getKeyCode()
						&& logik.getShot().fired == false) {
					logik.getShot().setXY(logik.getSpieler().getX(),
							logik.getSpieler().getY() - 40);
					logik.getShot().fired = true;
					Sound fire = new Sound(1);
				}
			}

			if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {

				GameFrame.gameboard.setVisible(false);
				Startscreen.startpanel.setVisible(true);
				Startscreen.startscreen.setVisible(true);
				logik.getSound().playCompleted = true;

			}
		}

	}

}