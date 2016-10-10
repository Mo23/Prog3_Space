import javax.swing.ImageIcon;


public class Computer extends NormalFunctions {
	
	public Computer(int x, int y,int hp){
		this.HP = hp;
		this.x=x;
		this.y=y;
		ImageIcon  img =  new ImageIcon("/home/maurice/Schreibtisch/shipgedreht.png");
		setImage(img.getImage());

	}

}
