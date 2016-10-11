import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameBoard extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final private int WIDTH = 1200;
	final private int HEIGHT = 700;
	final private int computerX =7;
	final private int computerY = 0;
	protected int FIXED_HP=100;
	private Drawing board;
	public Spieler virus = new Spieler(550,650,FIXED_HP);
	public ArrayList<Computer> computer;
	public Shot shot = new Shot(virus.getX(),virus.getY());
	public Sound sound = new Sound();
	@SuppressWarnings("unused")
	private Container cp;

	//public Shot shot = new Shot(gegner.getX(),gegner.getY());
	public GameBoard() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
		
    	addKeyListener(new TAdapter());
    	board = new Drawing();
    	cp = getContentPane();
    	
    	board.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    	setContentPane(board);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setTitle("Virenschleuder");
        setVisible(true);
        
        
    }
    
    private class Drawing extends JPanel{
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
            super.paintComponent(g);     // paint parent's background
            setBackground(Color.BLACK);  // set background color for this JPanel
            g.setColor(Color.GREEN);
            
            initComputer();
            initGame(g);
           
            
            
           
           
    	
    }}
    
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
    	g.drawImage(virus.getImage(), virus.x, virus.y, this);
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
            	 new Shot(virus.getX()+20,virus.getY()-30);
             }
             if(KeyEvent.VK_ESCAPE== e.getKeyCode()){
                 dispose(); 
                 sound.playCompleted =true;
                 //System.exit(ABORT); Schließt sofort und verschwindet nicht nur!!
             }
             repaint();
    	
    }}
  
  

	
    
   

    public static void main(String[] args) {
    	 SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
                try {
					new GameBoard();
				
		            
					
				} catch (UnsupportedAudioFileException | IOException
						| LineUnavailableException e) {
					
					e.printStackTrace();
				}
          
                
             }
          });
         
         
    
    	
    


}}