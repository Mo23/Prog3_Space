package VirenSchleuder;
import javax.swing.ImageIcon;

public class EnemyShot extends NormalFunctions {
	public int dmg;

	public EnemyShot(int x, int y, int d) {
		this.dmg = d;
		this.x = x;
		this.y = y;
		ImageIcon img = new ImageIcon(this.getClass().getResource("resources/images/wurmschuss_bild.png"));
		setImage(img.getImage());
	}

}
