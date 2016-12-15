package WormInvader;

import java.awt.Image;

/**
 * @author maurice
 *
 */
public class NormalFunctions {

	private Image image;
	protected int x;
	protected int y;
	protected boolean fired = false;

	/**
	 * Setzt das aktuelle Bild.
	 * 
	 * @param bild
	 */
	public void setImage(Image bild) {
		this.image = bild;

	}

	/**
	 * @return Das aktuelle Bild.
	 */
	public Image getImage() {
		return this.image;
	}

	/**
	 * @param x
	 *            X-Wert des Objekts
	 * @param y
	 *            >-Wert des Objekts
	 */
	public void setXY(int x, int y) {

		this.x = x;
		this.y = y;

	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return X-Wert
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * @return Y-Wert
	 */
	public int getY() {
		return this.y;
	}

}
