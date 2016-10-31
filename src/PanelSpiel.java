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

	final private int computerX = 7;
	final private int computerY = 0;
	private boolean running = false; // Still need to be Implemented
	protected int FIXED_HP = 100;
	public Spieler spieler = new Spieler(550, 625, FIXED_HP);
	public ArrayList<Enemy> enemylist;
	public Shot shot = new Shot(spieler.getX(), spieler.getY());
	public Sound sound = new Sound();
	protected Dimension dimension;
	public TAdapter adapter;
	public boolean dispose = false;
	public short score = 0;
	public Thread gamerunning;
	public int stoppinganimations = 0;
	public Random random = new Random();

	public PanelSpiel() {
		addKeyListener(adapter = new TAdapter());
		setFocusable(true);
		dimension = new Dimension(WIDTH, HEIGHT);
		setBackground(Color.BLACK); // set background color for this JPanel
		// running=true;

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GREEN);

		if (!this.running) {
			initGame(g);
		} else {
			animations(g);
		}

		SwingUtilities.invokeLater(act());
		if (shot.fired == true) {
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

	public void initGame(Graphics g) {
		initComputer();
		DrawPlayer(g);
		DrawComputer(g);
		DrawEnemyShot(g);
		running = true;
		// //DEBUGING

	}

	public void initComputer() {
		enemylist = new ArrayList<Enemy>();

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				Enemy gegner = new Enemy((computerX + 120 * j),
						(computerY + 80 * i));
				gegner.fired = false;
				enemylist.add(gegner);
			}
		}
	}

	public void DrawStatus(Graphics g) {

		g.drawString("Lebenspunkte: " + Integer.toString(spieler.HP), 0, 680);
		g.drawString("Score: " + Integer.toString(this.score), 1110, 680);

		g.drawString("Lebenspunktegegner: " + enemylist.get(0).HP, 200, 200);

	}

	public void DrawPlayer(Graphics g) {
		g.drawImage(spieler.getImage(), spieler.getX(), spieler.getY(), this);
	}

	public void DrawComputer(Graphics g) {
		Iterator<Enemy> it = enemylist.iterator();

		while (it.hasNext()) {
			Enemy computer = (Enemy) it.next();
			g.drawImage(computer.getImage(), computer.getX(), computer.getY(),
					this);
		}

	}

	public void DrawShot(Graphics g) {
		g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
	}

	public void DrawEnemyShot(Graphics g) {

		int size_a = enemylist.size();
		for (int i = 0; i < size_a; i++) {
			Enemy e = enemylist.get(i);
			EnemyShot b = e.geteshot();
			if(e.fired)
			g.drawImage(b.getImage(), b.getX(), b.getY() + 20, this);
		}

		/*
		 * Iterator<Enemy>ashot = computer.iterator(); while(ashot.hasNext()){
		 * Enemy e = (Enemy) ashot.next();
		 * 
		 * EnemyShot b = e.geteshot();
		 * 
		 * g.drawImage(b.getImage(), b.getX(), b.getY()+20, this);
		 * 
		 * 
		 * }
		 */

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
				if (shot.getY() > 0)
					shot.setXY(shot.getX(), shot.getY() - 1);
				else {
					shot.fired = false;
				}

				int size_a = enemylist.size();

				for (int i = 0; i < size_a; i++) {
					Enemy e = enemylist.get(i);
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
				/*
				 * Iterator<Enemy> eshotupdate = computer.iterator();
				 * 
				 * while(eshotupdate.hasNext()){
				 * 
				 * stoppinganimations = random.nextInt(3); Enemy e = (Enemy)
				 * eshotupdate.next(); EnemyShot a = e.geteshot();
				 * 
				 * if(a.getY()<1200 && stoppinganimations==0){ a.setXY(a.getX(),
				 * a.y+1);
				 * 
				 * repaint(); } else if(a.getY()>=1200){
				 * 
				 * a.setXY(e.getX(), e.getY());
				 * 
				 * } }
				 */
			}

		};
		gamerunning.start();
		return gamerunning;
	}



	private class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			
			if (KeyEvent.VK_SPACE == e.getKeyCode() && shot.fired == false) {
				shot.setXY(spieler.getX(), spieler.getY() - 40);
				shot.fired = true;
			}

		}

		public void keyPressed(KeyEvent e) {
			spieler.keyPressed(e);
			if(KeyEvent.VK_A == e.getKeyCode() || KeyEvent.VK_D == e.getKeyCode())
				spieler.keyPressed(e);

			
			if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {

				GameFrame.gameboard.setVisible(false);
				Startscreen.startpanel.setVisible(true);
				Startscreen.startscreen.setVisible(true);
				sound.playCompleted = true;

			}

		}
	}
}