import javax.swing.ImageIcon;

public class Enemy extends NormalFunctions {

	public Enemy(int x, int y) {
		if (this.difficult == 0) {
			this.HP = 100;
		} else if (this.difficult == 1) {
			this.HP = 200;
		} else {
			this.HP = 300;
		}
		this.x = x;
		this.y = y;
		ImageIcon img = new ImageIcon(
				"/home/maurice/Schreibtisch/shipgedreht.png");
		setImage(img.getImage());

	}

}
