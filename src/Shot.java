import javax.swing.ImageIcon;


public class Shot extends Commons{
	
	
	public Shot(int x,int y){
		this.setXY(x, y);
		ImageIcon  img =  new ImageIcon("/home/maurice/Schreibtisch/shipgedreht.png");
		  setImage(img.getImage());
		
	}

}
