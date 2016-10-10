import javax.swing.ImageIcon;


public class Computer extends Commons {
	
	public Computer(int x, int y){
		this.x=x;
		this.y=y;
		ImageIcon  img =  new ImageIcon("/home/maurice/Schreibtisch/system-computer-icon--metronome-iconset--cornmanthe3rd-14.png");
		setImage(img.getImage());

	}

}
