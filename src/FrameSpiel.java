import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FrameSpiel extends JPanel{


	final private int computerX =7;
	final private int computerY = 0;
	private boolean running=false;		//Still need to be Implemented
	protected int FIXED_HP=100;
	public Spieler virus = new Spieler(550,650,FIXED_HP);
	public ArrayList<Computer> computer;
	public Shot shot = new Shot(virus.getX(),virus.getY());
	public Sound sound = new Sound();
	protected Dimension dimension;


		public FrameSpiel(){
			addKeyListener(new TAdapter());
			setFocusable(true);
			dimension = new Dimension(WIDTH, HEIGHT);
			setBackground(Color.BLACK);  // set background color for this JPanel
			
		}

		public void paint(Graphics g) {
			super.paint(g);
            g.setColor(Color.GREEN);
            
            initComputer();
            initGame(g);

    }
    
    public void initGame(Graphics g) {
   	 	DrawPlayer(g);
        DrawComputer(g);
        DrawShot(g);
        g.setColor(Color.cyan);
   	 	g.drawString("Lebenspunkte: "+Integer.toString(virus.HP), 0, 650);
   	 
   }
   public void initComputer(){
       computer = new ArrayList<Computer>();

       for (int i=0; i < 4; i++) {
           for (int j=0; j < 10; j++) {
               Computer gegner = new Computer((computerX + 120*j), (computerY + 80*i),FIXED_HP);
              
               computer.add(gegner);
           }
       }
   }
    
    public void DrawPlayer(Graphics g){
    	g.drawImage(virus.getImage(), virus.getX(), virus.getY(), this);
    }
    public void DrawComputer(Graphics g) 
    {
        Iterator<Computer> it = computer.iterator();

        while (it.hasNext()) {
            Computer computer = (Computer) it.next();
            g.drawImage(computer.getImage(), computer.getX(),  computer.getY(), this);
        }   
        
    }
    public void DrawShot(Graphics g){
    	g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
    }
    private class TAdapter extends KeyAdapter {
    	 public void keyReleased(KeyEvent e) {
             virus.keyReleased(e);
          
            	 
         }
    	 public void keyPressed(KeyEvent e) {

             virus.keyPressed(e);
            
             shot.setXY(shot.getX(), shot.getY()-5);		//Müll richtig implementieren
             if(KeyEvent.VK_SPACE==e.getKeyCode()){
            	 shot.setXY(virus.getX()+20,virus.getY()-30);
             }
             if(KeyEvent.VK_ESCAPE== e.getKeyCode()){
             //    dispose(); 
                 sound.playCompleted =true;
                 //System.exit(ABORT); Schließt sofort und verschwindet nicht nur!!
             }
             repaint();
    	
    }}
}