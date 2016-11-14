import javax.swing.ImageIcon;

public class Shot extends NormalFunctions {
	public ImageIcon img;
	public int dmg;

	public Shot(int x, int y) {
		this.dmg = 200;
		this.setXY(x, y);
		this.img = new ImageIcon("images/Spielerschuss_bild.png");
		setImage(img.getImage());

	}

}
