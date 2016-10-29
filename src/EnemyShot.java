import javax.swing.ImageIcon;


public class EnemyShot extends NormalFunctions{
	
	public EnemyShot(int x, int y){
		this.x=x;
		this.y=y;
		ImageIcon img = new ImageIcon(
				"/home/maurice/Schreibtisch/shipgedreht.png");
		setImage(img.getImage());
	}

}
