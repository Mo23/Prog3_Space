package VirenSchleuder;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Spieler extends NormalFunctions {

	@SuppressWarnings("unused")
	private Image image;
	private int wSc1 = 30;
	private int wSc2 = 50;
	private int wSc3 = 70;
	public int dxA = 0;
	public int dxD = 0;
	public int HP;
	public ImageIcon img;
	public boolean move = false;
	private String weaponname="Einfacher Schuss";

	public Spieler(int startx, int starty, int hp) {
		this.HP = hp;
		this.x = startx;
		this.y = starty;
		img = new ImageIcon(this.getClass().getClassLoader().getResource("images/computer_bild.png"));
		
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
			PanelSpiel.logik.getShot().img = new ImageIcon(this.getClass().getClassLoader().getResource("images/Spielerschuss1_bild.png"));

			
			PanelSpiel.logik.getShot().setImage(
					PanelSpiel.logik.getShot().img.getImage());
			PanelSpiel.logik.getSpieler().weaponname="Doppelter Schuss";
		} else if (key == KeyEvent.VK_2 && PanelSpiel.logik.getScore() > wSc2
				&& PanelSpiel.logik.weapon < 3) {
			PanelSpiel.logik.weapon = 3;
			PanelSpiel.logik
					.setScore((short) (PanelSpiel.logik.getScore() - wSc2));
			PanelSpiel.logik.getShot().dmg = 80;
			PanelSpiel.logik.getShot().img = new ImageIcon(this.getClass().getClassLoader().getResource("images/Spielerschuss2_bild.png"));
			PanelSpiel.logik.getShot().setImage(
					PanelSpiel.logik.getShot().img.getImage());

			PanelSpiel.logik.getSpieler().weaponname="Dreifacher Schuss";
		} else if (key == KeyEvent.VK_3 && PanelSpiel.logik.getScore() > wSc3
				&& PanelSpiel.logik.weapon < 4) {
			PanelSpiel.logik.weapon = 4;
			PanelSpiel.logik
					.setScore((short) (PanelSpiel.logik.getScore() - wSc3));
			PanelSpiel.logik.getShot().dmg = 90;
			PanelSpiel.logik.getShot().img = new ImageIcon(this.getClass().getClassLoader().getResource("images/Spielerschuss3_bild.png"));
			PanelSpiel.logik.getShot().setImage(
					PanelSpiel.logik.getShot().img.getImage());

			PanelSpiel.logik.getSpieler().weaponname="Vierfacher Schuss";
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
	 * @param weaponname the weaponname to set
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
