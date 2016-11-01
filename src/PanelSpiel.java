import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class PanelSpiel extends JPanel {

	private boolean running = false; // Still need to be Implemented
	
	private TAdapter adapter; //Tastatureingabe Adapter
	public Thread gamerunning;
	// Variablen zur Verlangsamung.
	private Random random = new Random();
	private int stoppinganimations = 0;
	
	public Logikadapter logik;

	public PanelSpiel() {
		addKeyListener(adapter = new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK); // set background color for this JPanel
		logik = new Logikadapter();
		running=true;

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GREEN);

		if (running) {
			animations(g);}
		

		SwingUtilities.invokeLater(act());
		if (logik.getShot().fired == true) {
			DrawShot(g);
		}

	}


	public void animations(Graphics g) {
		g.setColor(Color.cyan);
		DrawPlayer(g);
		DrawComputer(g);
		DrawEnemyShot(g);
		DrawStatus(g);

	}





	public void DrawStatus(Graphics g) {

		g.drawString("Lebenspunkte: " + Integer.toString(logik.getSpieler().HP), 0, 680);
		g.drawString("Score: " + Integer.toString(logik.getScore()), 1110, 680);

		g.drawString("Lebenspunktegegner: " + logik.getEnemylist().get(0).HP, 200, 200);

	}

	public void DrawPlayer(Graphics g) {
		g.drawImage(logik.getSpieler().getImage(), logik.getSpieler().getX(), logik.getSpieler().getY(), this);
	}

	public void DrawComputer(Graphics g) {
		Iterator<Enemy> it = logik.getEnemylist().iterator();

		while (it.hasNext()) {
			Enemy computer = (Enemy) it.next();
			g.drawImage(computer.getImage(), computer.getX(), computer.getY(),
					this);
		}

	}

	public void DrawShot(Graphics g) {
		g.drawImage(logik.getShot().getImage(), logik.getShot().getX(), logik.getShot().getY(), this);
	}

	public void DrawEnemyShot(Graphics g) {

		int size_a = logik.getEnemylist().size();
		for (int i = 0; i < size_a; i++) {
			Enemy e = logik.getEnemylist().get(i);
			EnemyShot b = e.geteshot();
			if(e.fired)
			g.drawImage(b.getImage(), b.getX(), b.getY() + 20, this);
		}
	}

	public Runnable act() {
		gamerunning = new Thread() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					gamerunning.sleep(3);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (logik.getShot().getY() > 0)
					logik.getShot().setXY(logik.getShot().getX(), logik.getShot().getY() - 1);
				else {
					logik.getShot().fired = false;
				}

				int size_a = logik.getEnemylist().size();

				for (int i = 0; i < size_a; i++) {
					Enemy e = logik.getEnemylist().get(i);
					EnemyShot a = e.geteshot();

					stoppinganimations = random.nextInt(10);
					int startshot = random.nextInt(8000);
							
						if(startshot==0)
							e.fired=true;
					if (a.getY() < 1200 && stoppinganimations == 0 && e.fired) {
						a.setXY(a.getX(), a.y + 2);

					} else if (a.getY() >= 1200) {

						a.setXY(e.getX(), e.getY());

					}
				}
				repaint();
			
			}

		};
		gamerunning.start();
		return gamerunning;
	}



	private class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			
			if (KeyEvent.VK_SPACE == e.getKeyCode() && logik.getShot().fired == false) {
				logik.getShot().setXY(logik.getSpieler().getX(), logik.getSpieler().getY() - 40);
				logik.getShot().fired = true;
			}

		}

		public void keyPressed(KeyEvent e) {
				logik.getSpieler().keyPressed(e);

			
			if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {

				GameFrame.gameboard.setVisible(false);
				Startscreen.startpanel.setVisible(true);
				Startscreen.startscreen.setVisible(true);
				logik.getSound().playCompleted = true;

			}

		}
	}
}