import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Spieler extends NormalFunctions {

	@SuppressWarnings("unused")
	private Image image;
	public int dxA = 0;
	public int dxD = 0;
	private int wSc1 = 30;
	private int wSc2 = 50;
	private int wSc3 = 70;
	public int HP;
	public ImageIcon img;
	public boolean move = false;

	public Spieler(int startx, int starty, int hp) {
		this.HP = hp;
		this.x = startx;
		this.y = starty;
		img = new ImageIcon("images/computer_bild.png");
		setImage(img.getImage());
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_1 && PanelSpiel.logik.getScore() > wSc1
				&& PanelSpiel.logik.weapon < 2) {
			PanelSpiel.logik.weapon = 2;
			PanelSpiel.logik.getShot().dmg = 50;
			PanelSpiel.logik
					.setScore((short) (PanelSpiel.logik.getScore() - wSc1));
			PanelSpiel.logik.getShot().img = new ImageIcon(
					"images/Spielerschuss1_bild.png");
			PanelSpiel.logik.getShot().setImage(
					PanelSpiel.logik.getShot().img.getImage());
		} else if (key == KeyEvent.VK_2 && PanelSpiel.logik.getScore() > wSc2
				&& PanelSpiel.logik.weapon < 3) {
			PanelSpiel.logik.weapon = 3;
			PanelSpiel.logik
					.setScore((short) (PanelSpiel.logik.getScore() - wSc2));
			PanelSpiel.logik.getShot().dmg = 80;
			PanelSpiel.logik.getShot().img = new ImageIcon(
					"images/Spielerschuss2_bild.png");
			PanelSpiel.logik.getShot().setImage(
					PanelSpiel.logik.getShot().img.getImage());
		} else if (key == KeyEvent.VK_3 && PanelSpiel.logik.getScore() > wSc3
				&& PanelSpiel.logik.weapon < 4) {
			PanelSpiel.logik.weapon = 4;
			PanelSpiel.logik
					.setScore((short) (PanelSpiel.logik.getScore() - wSc3));
			PanelSpiel.logik.getShot().dmg = 90;
			PanelSpiel.logik.getShot().img = new ImageIcon(
					"images/Spielerschuss3_bild.png");
			PanelSpiel.logik.getShot().setImage(
					PanelSpiel.logik.getShot().img.getImage());
		}

		if (key == KeyEvent.VK_A) {
			dxA = -1;
		}

		if (key == KeyEvent.VK_D) {
			dxD = 1;

		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_A) {
			dxA = 0;
		}

		if (key == KeyEvent.VK_D) {
			dxD = 0;

		}
	}

}
