import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Virusk extends Commons{

	 public int xstart=550;
	 public int ystart=550;
	 private Image image;
	 public int dx=0;

	
  public Virusk(int startx, int starty){
	  this.x=startx;
	  this.y=starty;
	  ImageIcon  img =  new ImageIcon("/home/maurice/Schreibtisch/ship.png");
	  setImage(img.getImage());

 
  }

  
  public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();

      
	if (key == KeyEvent.VK_LEFT)
      {
          dx = -4;
          if(this.x>0)
          this.setXY(this.x+this.dx, this.y);
      }

      if (key == KeyEvent.VK_RIGHT)
      {
          dx = 4;
          if(this.x<1098)
          this.setXY(this.x+this.dx, this.y);
          

      }
  } 
public void keyReleased(KeyEvent e) {
	int key = e.getKeyCode();

    
	if (key == KeyEvent.VK_LEFT)
    {
        dx = 0;
    }

    if (key == KeyEvent.VK_RIGHT)
    {
        dx = 0;
    }
}
	
}

