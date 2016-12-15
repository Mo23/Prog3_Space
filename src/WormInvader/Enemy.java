package WormInvader;

import javax.swing.ImageIcon;

/**
 * @author maurice
 *
 */
public class Enemy extends NormalFunctions {
	private int dmg = 10;
	private EnemyShot eshot;

	public int dmg_factor = 0;
	public ImageIcon img;
	public boolean visible = true;
	public int HP = 100;

	/**
	 * Kosntruktor zum erzeugen eines neuen Gegner mit gegebenen Koordinaten und
	 * dem Schwierigkeitsgrad.
	 * 
	 * @param x
	 *            X-Wert auf dem Panel
	 * @param y
	 *            Y-Wert auf dem Panel
	 */
	@SuppressWarnings("static-access")
	public Enemy(int x, int y) {
		if (Startscreen.einstellungspanel.difficult == 0) {
			HP *= 1;
			eshot = new EnemyShot(x, y, (dmg));
		} else if (Startscreen.einstellungspanel.difficult == 1) {
			HP *= 2;
			eshot = new EnemyShot(x, y, (dmg * 2));
		} else if (Startscreen.einstellungspanel.difficult == 2) {
			HP *= 3;
			eshot = new EnemyShot(x, y, (dmg * 3));

		}
		this.x = x;
		this.y = y;

		img = new ImageIcon(this.getClass().getClassLoader().getResource("images/wurm_bild2.png"));
		setImage(img.getImage());

	}

	/**
	 * Getter für den Schuss des Gegners.
	 * 
	 * @return EnemyShot
	 */
	public EnemyShot geteshot() {
		return this.eshot;
	}

}
