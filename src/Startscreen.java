import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Startscreen extends JFrame {
	public static Startscreen startscreen;
	public static StartPanel startpanel;
	final private short WIDTH=1200;
	final private short HEIGTH=720;
	public boolean startedgame;
	public Thread gamestart;
	public Startscreen(){
			this.startedgame=false;
			add(startpanel =new StartPanel());
	        setTitle("VirenSchleuder");
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize(WIDTH, HEIGTH);
	        setLocationRelativeTo(null);
	        setVisible(true);
	        setResizable(false);
	}

	
	public static void main(String[] args){
		startscreen = new Startscreen();
		
	}
	}