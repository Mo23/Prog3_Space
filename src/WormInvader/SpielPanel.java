package WormInvader;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SpielPanel extends JPanel {

	public boolean runninglost = false;
	public boolean runningwon = false;
	public Thread gamerunning;
	public static Logikadapter logik;
	private final ImageIcon gewonnen = new ImageIcon(this.getClass()
			.getClassLoader().getResource("images/spielgewonnen.png"));
	private final ImageIcon verloren = new ImageIcon(this.getClass()
			.getClassLoader().getResource("images/spielverloren.png"));
	boolean times = false;
	boolean onetime = false;
	long timeend;
	final public Font font = new Font("Ubuntu", Font.BOLD, 20);
	final private int displaynewWeapon = 1250;
	final private int displaynewWeapony = 640;

	public SpielPanel() {

		this.addKeyListener(new TLogik());
		this.setFocusable(true);
		this.setBackground(Color.BLACK); // set background color for this JPanel
		logik = new Logikadapter();
		runningwon = true;
		runninglost = true;

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GREEN);

		if (runningwon && runninglost) {
			animations(g);
		} else {
			if (!runningwon) {
				DrawEndWon(g);
			} else {
				DrawEndLost(g);
			}
		}

		SwingUtilities.invokeLater(act());
		SwingUtilities.invokeLater(logik.act());
		if (logik.getShot().fired == true) {
			DrawShot(g);
		}

	}

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

	public void animations(Graphics g) {
		DrawPlayer(g);
		DrawComputer(g);
		DrawEnemyShot(g);
		DrawStatus(g);

	}

	public void DrawEndWon(Graphics g) {

		g.drawImage(gewonnen.getImage(), 0, 0, this);
	}

	public void DrawEndLost(Graphics g) {

		g.drawImage(verloren.getImage(), 0, 0, this);

	}

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

				g.drawString("Waffensystem 1 ist verfügbar", 0, displaynewWeapony);
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
				g.drawString("Waffensystem 2 ist verfügbar", 0, displaynewWeapony);
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
				g.drawString("Waffensystem 3 ist verfügbar", 0, displaynewWeapony);
			}
		}
	}

	public void DrawPlayer(Graphics g) {

		g.drawImage(logik.getSpieler().getImage(), logik.getSpieler().getX(),
				logik.getSpieler().getY(), this);
	}

	public void DrawComputer(Graphics g) {
		int size_a = logik.getEnemylist().size();

		for (int i = 0; i < size_a; i++) {
			Enemy computer = logik.getEnemylist().get(i);
			g.drawImage(computer.getImage(), computer.getX(), computer.getY(),
					this);
		}

	}

	public void DrawShot(Graphics g) {
		g.drawImage(logik.getShot().getImage(), logik.getShot().getX(), logik
				.getShot().getY(), this);
	}

	public void DrawEnemyShot(Graphics g) {

		int size_a = logik.getEnemylist().size();
		for (int i = 0; i < size_a; i++) {
			Enemy e = logik.getEnemylist().get(i);
			EnemyShot b = e.geteshot();
			if (e.fired)
				g.drawImage(b.getImage(), b.getX(), b.getY(), this);
		}
	}

	private class TLogik extends KeyAdapter {

		public synchronized void keyReleased(KeyEvent e) {

			logik.getSpieler().keyReleased(e);

		}

		public synchronized void keyPressed(KeyEvent e) {
			if (GameFrame.gameboard.framespiel.runninglost == true
					&& GameFrame.gameboard.framespiel.runninglost == true) {
				logik.getSpieler().keyPressed(e);
				if (KeyEvent.VK_SPACE == e.getKeyCode()
						&& logik.getShot().fired == false) {
					logik.getShot().setXY(logik.getSpieler().getX(),
							logik.getSpieler().getY() - 40);
					logik.getShot().fired = true;
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