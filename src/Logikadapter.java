import java.util.ArrayList;
import java.util.Random;

public class Logikadapter {

	final private int computerX = 7;
	final private int computerY = 0;
	final private int FIXED_HP = 100;
	private short score = 0;

	private Spieler spieler = new Spieler(550, 625, FIXED_HP);
	private Shot shot = new Shot(spieler.getX(), spieler.getY());
	private ArrayList<Enemy> enemylist;
	private Sound sound = new Sound();
	private Thread updates;

	// Variablen zur Verlangsamung.
	private Random random = new Random();
	private int stoppinganimations = 0;

	public Logikadapter() {
		this.initComputer();

	}

	public Runnable act() {
		updates = new Thread() {
			public void run() {
				movePlayerShot();
				moveEnemyShot();
			}
		};
		updates.start();
		return updates;
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

	public void movePlayerShot() {
		if (shot.getY() > 0)
			shot.setXY(shot.getX(), shot.getY() - 1);
		else {
			shot.fired = false;
		}
	}

	public void moveEnemyShot() {
		int size_a = enemylist.size();

		for (int i = 0; i < size_a; i++) {
			Enemy e = enemylist.get(i);
			EnemyShot a = e.geteshot();

			stoppinganimations = random.nextInt(10);
			int startshot = random.nextInt(8000);

			if (startshot == 0)
				e.fired = true;
			if (a.getY() < 1200 && stoppinganimations == 0 && e.fired) {
				a.setXY(a.getX(), a.y + 2);

			} else if (a.getY() >= 1200) {

				a.setXY(e.getX(), e.getY());

			}
		}
	}

	/**
	 * @return the enemylist
	 */
	public ArrayList<Enemy> getEnemylist() {
		return enemylist;
	}

	/**
	 * @return the fIXED_HP
	 */
	public int getFIXED_HP() {
		return FIXED_HP;
	}

	/**
	 * @return the spieler
	 */
	public Spieler getSpieler() {
		return spieler;
	}

	/**
	 * @return the shot
	 */
	public Shot getShot() {
		return shot;
	}

	/**
	 * @return the score
	 */
	public short getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(short score) {
		this.score = score;
	}

	/**
	 * @return the sound
	 */
	public Sound getSound() {
		return sound;
	}

	/**
	 * @param sound
	 *            the sound to set
	 */
	public void setSound(Sound sound) {
		this.sound = sound;
	}

}
