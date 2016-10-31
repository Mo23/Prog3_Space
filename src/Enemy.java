import javax.swing.ImageIcon;

public class Enemy extends NormalFunctions {
	public static int dmg_factor;
	private int dmg = 20;
	private EnemyShot eshot;

	public Enemy(int x, int y) {
		if (this.difficult == 0) {
			this.HP = 100;
			this.dmg *= dmg_factor;
		} else if (difficult == 1) {
			this.HP = 200;

			this.dmg *= dmg_factor;
		} else if (this.difficult == 2) {
			this.HP = 300;

			this.dmg *= dmg_factor;
		}
		this.x = x;
		this.y = y;
		ImageIcon img = new ImageIcon(
				"images/wurm_bild.png");
		setImage(img.getImage());
		eshot = new EnemyShot(x, y);

	}

	public EnemyShot geteshot() {
		return this.eshot;
	}

}
