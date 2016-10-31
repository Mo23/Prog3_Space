import javax.swing.ImageIcon;

public class Shot extends NormalFunctions {
	ImageIcon img;

	public Shot(int x, int y) {
		if (this.weapon == 0) {

		} else if (this.weapon == 1) {

		} else if (this.weapon == 2) {

		} else if (this.weapon == 3) {

		}
		this.setXY(x, y);
		this.img = new ImageIcon("images/Spielerschuss_bild.png");
		setImage(img.getImage());

	}

}
