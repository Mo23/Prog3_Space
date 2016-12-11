package WormInvader;

import javax.swing.ImageIcon;

public class EnemyShot extends NormalFunctions {
	public int dmg;

	/**
	 * Erzeugt einen neuen Schuss.
	 * @param x X-Wert für die Koordinate
	 * @param y Y-Wert für die Koordinate
	 * @param schaden Wert um den Schaden zu setzen.
	 */
	public EnemyShot(int x, int y, int schaden) {
		this.dmg = schaden;
		this.x = x;
		this.y = y;
		ImageIcon img = new ImageIcon(this.getClass().getClassLoader()
				.getResource("images/wurmschuss_bild.png"));
		setImage(img.getImage());
	}

}
