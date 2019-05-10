package Environment;

import java.awt.EventQueue;

public class GameEnvironment {

	public String shipName = "";
	public String location = "";
	public int shipSheildLevel = 100;
	
	
	public void setShipName(String newshipName) {
		this.shipName = newshipName;
	}
	public String getShipName() {
		return shipName;
	}
	
	public void launchMainWindow() {
		MainScreen window = new MainScreen(this);
		window.frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		GameEnvironment environment = new GameEnvironment();
		environment.launchMainWindow();
	}
}
