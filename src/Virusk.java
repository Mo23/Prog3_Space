import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Virusk extends JPanel{

	 public int x=550;
	 public int y=550;
	 private Image image;
	 public int dx=0;
	public Image setImage(Image bild) {
         this.image = bild;
         return this.image;
     }
	public Image getImage() {
        return this.image;
    }
	
  public Virusk(){
 
	  
	  ImageIcon  img =  new ImageIcon("/home/maurice/Schreibtisch/ship.png");
	  setImage(img.getImage());

 
  }
  public void setXY(int x, int y){
	  this.x=x;
	  this.y=y;
  }
  
  public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();

      
	if (key == KeyEvent.VK_LEFT)
      {
          dx = -4;
      }

      if (key == KeyEvent.VK_RIGHT)
      {
          dx = 4;
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

