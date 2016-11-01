import java.util.ArrayList;

public class Logikadapter {

	final private int computerX = 7;
	final private int computerY = 0;
	final private int FIXED_HP = 100;
	private short score = 0;

	private Spieler spieler = new Spieler(550, 625, FIXED_HP);
	private Shot shot = new Shot(spieler.getX(), spieler.getY());
	private ArrayList<Enemy> enemylist;
	private Sound sound = new Sound();

	public Logikadapter() {
		this.initComputer();

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
