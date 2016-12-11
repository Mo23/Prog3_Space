package WormInvader;

import java.util.ArrayList;
import java.util.Random;

public class Logikadapter {

	final private int computerX = 7;
	final private int computerY = 0;
	final private int FIXED_HP = 100;

	private Spieler spieler = new Spieler(550, 625, FIXED_HP);
	private Shot shot = new Shot(spieler.getX(), spieler.getY());
	private ArrayList<Enemy> enemylist;
	private Sound sound;
	private Thread updates;
	private short score = 0;
	private Random random = new Random();
	private int stoppinganimations = 0;
	private int weapon = 1;

	/**
	 * Konstruktor eines neuen Logikadapters.
	 */
	public Logikadapter() {
		this.initComputer();
		this.sound = new Sound();

	}

	/**
	 * Neuer Thread zum aktualisieren des Spielfeldes.
	 * @return gibt ein Zugriff auf den Thread zurück.
	 */
	public Runnable act() {
		updates = new Thread() {
			public void run() {
				movePlayerShot();
				moveEnemyShot();
				movePlayer();
				if (spieler.HP <= 0) {
					GameFrame.gameboard.framespiel.runninglost = false;
					sound.playCompleted = true;
				} else if (enemylist.size() <= 0) {
					GameFrame.gameboard.framespiel.runningwon = false;
				}

			}
		};
		updates.start();
		return updates;
	}

	/**
	 * Erzeugt eine ArrayList von Gegner mit Koordinaten.
	 */
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
	 * Methode die den Spieler im Rahmen des Spielfeld 
	 * weitersetzt, falls die notwendigen Paramter gesetzt.
	 */
	public void movePlayer() {
		if (spieler.getX() < 1100) {
			spieler.setXY(spieler.x + spieler.dxD, spieler.y);
		}
		if (spieler.getX() > 0) {
			spieler.setXY(spieler.x + spieler.dxA, spieler.y);
		}
	}

	/**
	 * Methode die den Schuss kontinuirlich bewegt.
	 */
	public void movePlayerShot() {
		if (shot.getY() > 0 && shot.fired) {
			shot.setXY(shot.getX(), shot.getY() - 4);
			checkIfWormHit();
		} else {
			shot.fired = false;
		}
	}

	/**
	 * Überprüft ob ein Schuss vom Spieler einen Wurm getroffen hat und setzt ggf. HP herunter.
	 */
	public void checkIfWormHit() {
		int size_t = enemylist.size();
		for (int i = 0; i < size_t; i++) {
			Enemy e = enemylist.get(i);
			if (shot.x < (e.x + e.img.getIconWidth() / 2)
					&& shot.x >= (e.x - e.img.getIconWidth() / 2)
					&& shot.y >= (e.y - e.img.getIconHeight() / 2)
					&& shot.y < (e.y + e.img.getIconHeight() / 2)) {
				shot.fired = false;
				e.HP -= shot.dmg;
				if (e.HP <= 0) {
					score += 20;
					enemylist.remove(i);
				}
				break;
			}
		}

	}

	/**
	 * Bewegt die Schüsse der Gegner mit Verzögerung und prüft, ob der Spieler getroffen wurde.
	 */
	public void moveEnemyShot() {
		int size_a = enemylist.size();

		for (int i = 0; i < size_a; i++) {
			Enemy e = enemylist.get(i);
			EnemyShot a = e.geteshot();

			stoppinganimations = random.nextInt(2);
			int startshot = random.nextInt(6000);

			if (startshot == 0)
				e.fired = true;
			if (a.getY() < 1200 && e.fired && stoppinganimations == 0) {
				a.setXY(a.getX(), a.y + 2);

				ckeckIfPlayerHit(e, a);
			} else if (a.getY() >= 1200) {

				a.setXY(e.getX(), e.getY());

			}
		}
	}

	/**
	 * @param e Gegner
	 * @param a Schuss dieses Gegner
	 * Berechnet die Koordinaten und setzt ggf. HP des Spieler herunter.
	 */
	public void ckeckIfPlayerHit(Enemy e, EnemyShot a) {
		if (a.x < (spieler.x + spieler.img.getIconWidth() / 2)
				&& a.x >= (spieler.x - spieler.img.getIconWidth() / 2)
				&& a.y >= (spieler.y - spieler.img.getIconHeight() / 2)
				&& a.y < (spieler.y + spieler.img.getIconHeight() / 2)) {
			e.fired = false;
			spieler.HP -= a.dmg;
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

	/**
	 * @return the weapon
	 */
	public int getWeapon() {
		return weapon;
	}

	/**
	 * @param weapon
	 *            the weapon to set
	 */
	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}

}
