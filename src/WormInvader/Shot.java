package WormInvader;

import javax.swing.ImageIcon;

/**
 * @author maurice
 *
 */
public class Shot extends NormalFunctions {
	public ImageIcon img;
	public int dmg;

	/**
	 * Konstruktor eines Schusses des Spielers, mit seinen Koordinaten.
	 * @param x
	 * @param y
	 */
	public Shot(int x, int y) {
		this.dmg = 20;
		this.setXY(x, y);
		img = new ImageIcon(this.getClass().getClassLoader()
				.getResource("images/Spielerschuss_bild.png"));

		setImage(img.getImage());

	}

}
