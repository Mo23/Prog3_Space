package VirenSchleuder;

import java.awt.Image;

public class NormalFunctions {

	private Image image;
	protected int x;
	protected int y;
	protected boolean fired = false;

	public void setImage(Image bild) {
		this.image = bild;

	}

	public Image getImage() {
		return this.image;
	}

	public void setXY(int x, int y) {

		this.x = x;
		this.y = y;

	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

}
