import javax.swing.ImageIcon;

public class Enemy extends NormalFunctions {
	private int dmg = 10;
	private EnemyShot eshot;
	
	public int dmg_factor = 0;
	public ImageIcon img;
	public boolean visible = true;
	public int HP;

	public Enemy(int x, int y) {
		if (Startscreen.startscreen.einstellungspanel.difficult == 0) {
			HP = 100;
			eshot = new EnemyShot(x, y, (dmg));
		} else if (Startscreen.startscreen.einstellungspanel.difficult == 1) {
			HP = 200;
			eshot = new EnemyShot(x, y, (dmg * 2));
		} else if (Startscreen.startscreen.einstellungspanel.difficult == 2) {
			HP = 300;
			eshot = new EnemyShot(x, y, (dmg * 3));

		}
		this.x = x;
		this.y = y;
		img = new ImageIcon("images/wurm_bild.png");
		setImage(img.getImage());

	}

	public EnemyShot geteshot() {
		return this.eshot;
	}

}
