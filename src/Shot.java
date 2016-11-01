import javax.swing.ImageIcon;

public class Shot extends NormalFunctions {
	public ImageIcon img;
	public int dmg;

	public Shot(int x, int y) {
		if (this.weapon == 0) {
			dmg=100;
		} else if (this.weapon == 1) {
			dmg=200;
		} else if (this.weapon == 2) {
			dmg=300;
		} else if (this.weapon == 3) {
			dmg=400;
		}
		this.setXY(x, y);
		this.img = new ImageIcon("images/Spielerschuss_bild.png");
		setImage(img.getImage());

	}

}
