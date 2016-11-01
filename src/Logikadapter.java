import java.util.ArrayList;


public class Logikadapter {

	final private int computerX = 7;
	final private int computerY = 0;
	protected int FIXED_HP = 100;
	

	public Spieler spieler = new Spieler(550, 625, FIXED_HP);
	public Shot shot = new Shot(spieler.getX(), spieler.getY());
	public ArrayList<Enemy> enemylist;
	
	public Logikadapter(){
		this.initComputer();
		
	}
	
	public void initComputer() {
		enemylist = new ArrayList<Enemy>();

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				Enemy gegner = new Enemy((computerX + 120 * j),
						(computerY + 80 * i));
				gegner.fired = false;
				enemylist.add(gegner);
			}
		}
	}
	
	/**
	 * @return the enemylist
	 */
	public ArrayList<Enemy> getEnemylist() {
		return enemylist;
	}

	/**
	 * @return the fIXED_HP
	 */
	public int getFIXED_HP() {
		return FIXED_HP;
	}

	/**
	 * @param fIXED_HP the fIXED_HP to set
	 */
	public void setFIXED_HP(int fIXED_HP) {
		FIXED_HP = fIXED_HP;
	}

	/**
	 * @return the spieler
	 */
	public Spieler getSpieler() {
		return spieler;
	}

	/**
	 * @return the shot
	 */
	public Shot getShot() {
		return shot;
	}

}
