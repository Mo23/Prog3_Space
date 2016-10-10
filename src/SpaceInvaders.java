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
	
	private Drawing board;
	public Virusk virus = new Virusk(550,650);
	final private int WIDTH = 1200;
	final private int HEIGHT = 700;
	
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
        
           
           
    	
    }}
    
    public void DrawPlayer(Graphics g){
    	g.drawImage(virus.getImage(), virus.x, virus.y, this);
    }
    
    private class TAdapter extends KeyAdapter {
    	 public void keyReleased(KeyEvent e) {
             virus.keyReleased(e);
         }
    	 public void keyPressed(KeyEvent e) {

             virus.keyPressed(e);
             
             virus.setXY(virus.x+virus.dx, virus.y);
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