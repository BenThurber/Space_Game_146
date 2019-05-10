package Environment;

import java.awt.EventQueue;

public class GameEnvironment {

	private String shipName = "";
	private String location = "";
	private int shipPartsFound = 0;
	private int shipPartsTotalMissing = 0;
	private int sheildLevel = 100;
	
	
	public void visitSpaceOutpost() {
		System.out.println("Visiting Space Outpost");
	}
	public void moveToNextPlanet() {
		System.out.println("Moving to Next Planet");
	}
	public void startNextDay() {
		System.out.println("Starting Next Day");
	}


	
	public void launchMainWindow() {
		MainScreen window = new MainScreen(this);
		window.frame.setVisible(true);
	}
	
	
	
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String newshipName) {
		this.shipName = newshipName;
	}
	
	public int getShipPartsFound() {
		return shipPartsFound;
	}
	public void setShipPartsFound(int shipPartsFound) {
		this.shipPartsFound = shipPartsFound;
	}
	
	public int getShipPartsTotalMissing() {
		return shipPartsTotalMissing;
	}
	public void setShipPartsTotalMissing(int shipPartsTotalMissing) {
		this.shipPartsTotalMissing = shipPartsTotalMissing;
	}
	
	public int getSheildLevel() {
		return sheildLevel;
	}
	public void setSheildLevel(int sheildLevel) {
		this.sheildLevel = sheildLevel;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	
	
	public static void main(String[] args) {
		GameEnvironment environment = new GameEnvironment();
		environment.launchMainWindow();
	}
}
