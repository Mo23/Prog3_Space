import javax.swing.JFrame;

		@SuppressWarnings("serial")
		public class GameBoard extends JFrame{

			final private int WIDTH = 1200;
			final private int HEIGTH = 720;
			public FrameSpiel framespiel;
			public static GameBoard gameboard;
			
		    public GameBoard()
		    {
		        add(framespiel =new FrameSpiel());
		        setTitle("VirenSchleuder");
		        setDefaultCloseOperation(EXIT_ON_CLOSE);
		        setSize(WIDTH, HEIGTH);
		        setLocationRelativeTo(null);
		        setVisible(true);
		        setResizable(false);
		        
		    }

		    public static void spielstart() {
		    	
		    	 Thread thread = new Thread(){
				 public void run(){
				 gameboard= new GameBoard();
					 
				 }
			 };
	            
			 thread.start();
		    	
		    }
		    

			
		}