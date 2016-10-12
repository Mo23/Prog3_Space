import javax.swing.JFrame;

		@SuppressWarnings("serial")
		public class GameBoard extends JFrame{

			final private int WIDTH = 1200;
			final private int HEIGTH = 720;
		    public GameBoard()
		    {
		        add(new FrameSpiel());
		        setTitle("Space Invaders");
		        setDefaultCloseOperation(EXIT_ON_CLOSE);
		        setSize(WIDTH, HEIGTH);
		        setLocationRelativeTo(null);
		        setVisible(true);
		        setResizable(false);
		    }

		    public static void main(String[] args) {
		   	 Thread thread = new Thread(){
				 public void run(){
					 new GameBoard();
				 }
			 };
	            
			 thread.start();
		    	
		    }

			
		}