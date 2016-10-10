import java.awt.Image;


public class Commons {
	
	private Image image;
	protected int x;
	protected int y;
	
	public Image setImage(Image bild) {
        this.image = bild;
        return this.image;
    }
	
	public Image getImage() {
       return this.image;
   }

	 public void setXY(int x, int y){
		
			  this.x=x;
		  	  this.y=y;
		 
	  }
}
