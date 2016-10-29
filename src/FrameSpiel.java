import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class FrameSpiel extends JPanel {

	final private int computerX = 7;
	final private int computerY = 0;
	private boolean running = false; // Still need to be Implemented
	protected int FIXED_HP = 100;
	public Spieler spieler = new Spieler(550, 625, FIXED_HP);
	public ArrayList<Enemy> computer;
	public Shot shot = new Shot(spieler.getX(), spieler.getY());
	public Sound sound = new Sound();
	protected Dimension dimension;
	public TAdapter adapter;
	public boolean dispose = false;
	public short score = 0;
	public Thread gamerunning;

	public FrameSpiel() {
		addKeyListener(adapter = new TAdapter());
		setFocusable(true);
		dimension = new Dimension(WIDTH, HEIGHT);
		setBackground(Color.BLACK); // set background color for this JPanel
		//running=true;

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GREEN);
		
if(!this.running){
			initGame(g);}

			SwingUtilities.invokeLater(act());
		animations(g);
		
			
		if (shot.fired == true) {
			DrawShot(g);
		}
	

	}
	public void animations(Graphics g){
		DrawPlayer(g);
		DrawComputer(g);
		DrawEnemyShot(g);
		
	}

	public void initGame(Graphics g) {
		initComputer();
		DrawPlayer(g);
		DrawComputer(g);
		DrawEnemyShot(g);
		g.setColor(Color.cyan);
		g.drawString("Lebenspunkte: " + Integer.toString(spieler.HP), 0, 680);
		g.drawString("Score: " + Integer.toString(this.score), 1110, 680);
		running = true;
		g.drawString("Lebenspunktegegner: "+computer.get(0).HP, 200, 200);
		// //DEBUGING

	}

	public void initComputer() {
		computer = new ArrayList<Enemy>();

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				Enemy gegner = new Enemy((computerX + 120 * j),
						(computerY + 80 * i));
				gegner.fired=false;
				computer.add(gegner);
			}
		}
	}

	public void DrawPlayer(Graphics g) {
		g.drawImage(spieler.getImage(), spieler.getX(), spieler.getY(), this);
	}

	public void DrawComputer(Graphics g) {
		Iterator<Enemy> it = computer.iterator();
		
		while (it.hasNext()) {
			Enemy computer = (Enemy) it.next();
			g.drawImage(computer.getImage(), computer.getX(), computer.getY(),
					this);
		}

	}

	public void DrawShot(Graphics g) {
		g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
	}
	public void DrawEnemyShot(Graphics g){
		
		Iterator<Enemy>ashot = computer.iterator();
		System.out.println("Ich war hier");
		while(ashot.hasNext()){
			Enemy e = (Enemy) ashot.next();
			
			EnemyShot b = e.geteshot();
			
            g.drawImage(b.getImage(), b.getX(), b.getY()+20, this); 
			
			
		}
		
	}

	public Runnable act() {
		gamerunning = new Thread() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					gamerunning.sleep(3);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (shot.getY() > 0)
					shot.setXY(shot.getX(), shot.getY() - 1);
				else {
					shot.fired = false;
				}
				
				Iterator<Enemy> eshotupdate = computer.iterator();
				
				while(eshotupdate.hasNext()){
					int i=0;
					Enemy e = (Enemy) eshotupdate.next();
					EnemyShot a = e.geteshot();

					System.out.println("Hier war ich auch");
					System.out.println(a.getY());
					if(a.getY()<1200 && (i%20000)==0){
					a.setXY(a.getX(), a.y+10);
					i++;
					}
					else{
						a.setXY(a.getX(), e.getY());
					}
					System.out.println(a.getY());
			}
				
				repaint();}

			
		};
		gamerunning.start();
		return gamerunning;
	}
	
	public void updateanimations(){
		
		
		
		
	}

	private class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			spieler.keyReleased(e);

		}

		public void keyPressed(KeyEvent e) {

			spieler.keyPressed(e);

			if (KeyEvent.VK_SPACE == e.getKeyCode() && shot.fired == false) {
				shot.setXY(spieler.getX(), spieler.getY() - 40);
				shot.fired = true;
			}
			if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {
				
				GameBoard.gameboard.setVisible(false);
				Startscreen.startpanel.setVisible(true);
				Startscreen.startscreen.setVisible(true);
				sound.playCompleted = true;

			}

			

		}
	}
}