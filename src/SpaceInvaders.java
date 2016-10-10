import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SpaceInvaders extends JFrame{
	final private int WIDTH = 1200;
	final private int HEIGHT = 700;
	
	private Drawing board;
	public Virusk virus = new Virusk(550,650);
	public Computer gegner = new Computer(600,100);
	public Shot shot = new Shot(gegner.getX(),gegner.getY());
	public SpaceInvaders()
    {
    	
    	addKeyListener(new TAdapter());
    	board = new Drawing();
    	Container cp = getContentPane();
    	
    	board.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    	setContentPane(board);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setTitle("Space Invaders");
        setVisible(true);
    }
    
    private class Drawing extends JPanel{
    	public void paintComponent(Graphics g) {
            super.paintComponent(g);     // paint parent's background
            setBackground(Color.BLACK);  // set background color for this JPanel
            g.setColor(Color.GREEN);
            DrawPlayer(g);
            DrawComputer(g);
            DrawShot(g);
        
           
           
    	
    }}
    
    public void DrawPlayer(Graphics g){
    	g.drawImage(virus.getImage(), virus.x, virus.y, this);
    }
    public void DrawComputer(Graphics g){
    	g.drawImage(gegner.getImage(), gegner.getX(), gegner.getY(), this);
    }
    public void DrawShot(Graphics g){
    	g.drawImage(shot.getImage(), gegner.getX(), gegner.getY(), this);
    }
    private class TAdapter extends KeyAdapter {
    	 public void keyReleased(KeyEvent e) {
             virus.keyReleased(e);
         }
    	 public void keyPressed(KeyEvent e) {

             virus.keyPressed(e);
             
             repaint();
    	
    }}

    public static void main(String[] args) {
    	 SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
                new SpaceInvaders(); // Let the constructor do the job
                
             }
          });
    	 
    }
}