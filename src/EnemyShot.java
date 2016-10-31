import javax.swing.ImageIcon;

public class EnemyShot extends NormalFunctions {

	public EnemyShot(int x, int y) {
		this.x = x;
		this.y = y;
		ImageIcon img = new ImageIcon(
				"images/wurmschuss_bild.png");
		setImage(img.getImage());
	}

}
