import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Spieler extends NormalFunctions {

	@SuppressWarnings("unused")
	private Image image;
	public int dx = 0;

	public Spieler(int startx, int starty, int hp) {
		this.HP = hp;
		this.x = startx;
		this.y = starty;
		ImageIcon img = new ImageIcon("/home/maurice/Schreibtisch/computer.png");
		setImage(img.getImage());

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_A) {
			dx = -4;
			if (this.x > 0)
				this.setXY(this.x + this.dx, this.y);
		}

		if (key == KeyEvent.VK_D) {
			dx = 4;
			if (this.x < 1098)
				this.setXY(this.x + this.dx, this.y);

		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}

}
