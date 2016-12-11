package WormInvader;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteOrder;

import javax.imageio.ImageIO;
import javax.imageio.stream.IIOByteBuffer;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

public class Spieler extends NormalFunctions {

	@SuppressWarnings("unused")
	private Image image;
	final private int wSc1 = 30;
	final private int wSc2 = 50;
	final private int wSc3 = 70;
	final private int w1dmg = 50;
	final private int w2dmg = 80;
	final private int w3dmg = 100;
	public int dxA = 0;
	public int dxD = 0;
	public int HP;
	public ImageIcon img;
	public BufferedImage bimg;
	public boolean move = false;
	private String weaponname = "Einfacher Schuss";

	public Spieler(int startx, int starty, int hp) {
		this.HP = hp;
		this.x = startx;
		this.y = starty;
		img = new ImageIcon(this.getClass().getClassLoader()
				.getResource("images/computer_bild.png"));

		setImage(img.getImage());
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_1 && SpielPanel.logik.getScore() >= wSc1
				&& SpielPanel.logik.getWeapon() < 2) {
			SpielPanel.logik.setWeapon(2);
			SpielPanel.logik.getShot().dmg = w1dmg;
			SpielPanel.logik
					.setScore((short) (SpielPanel.logik.getScore() - wSc1));
			SpielPanel.logik.getShot().img = new ImageIcon(this.getClass()
					.getClassLoader()
					.getResource("images/Spielerschuss1_bild.png"));

			SpielPanel.logik.getShot().setImage(
					SpielPanel.logik.getShot().img.getImage());
			SpielPanel.logik.getSpieler().weaponname = "Doppelter Schuss";
		} else if (key == KeyEvent.VK_2 && SpielPanel.logik.getScore() >= wSc2
				&& SpielPanel.logik.getWeapon() < 3) {
			SpielPanel.logik.setWeapon(3);
			SpielPanel.logik
					.setScore((short) (SpielPanel.logik.getScore() - wSc2));
			SpielPanel.logik.getShot().dmg = w2dmg;
			SpielPanel.logik.getShot().img = new ImageIcon(this.getClass()
					.getClassLoader()
					.getResource("images/Spielerschuss2_bild.png"));
			SpielPanel.logik.getShot().setImage(
					SpielPanel.logik.getShot().img.getImage());

			SpielPanel.logik.getSpieler().weaponname = "Dreifacher Schuss";
		} else if (key == KeyEvent.VK_3 && SpielPanel.logik.getScore() >= wSc3
				&& SpielPanel.logik.getWeapon() < 4) {
			SpielPanel.logik.setWeapon(4);
			SpielPanel.logik
					.setScore((short) (SpielPanel.logik.getScore() - wSc3));
			SpielPanel.logik.getShot().dmg = w3dmg;
			SpielPanel.logik.getShot().img = new ImageIcon(this.getClass()
					.getClassLoader()
					.getResource("images/Spielerschuss3_bild.png"));
			SpielPanel.logik.getShot().setImage(
					SpielPanel.logik.getShot().img.getImage());

			SpielPanel.logik.getSpieler().weaponname = "Vierfacher Schuss";
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

	/**
	 * @return the weaponname
	 */
	public String getWeaponname() {
		return weaponname;
	}

	/**
	 * @param weaponname
	 *            the weaponname to set
	 */
	public void setWeaponname(String weaponname) {
		this.weaponname = weaponname;
	}

	/**
	 * @return the wSc1
	 */
	public int getwSc1() {
		return wSc1;
	}

	/**
	 * @return the wSc2
	 */
	public int getwSc2() {
		return wSc2;
	}

	/**
	 * @return the wSc3
	 */
	public int getwSc3() {
		return wSc3;
	}

}
