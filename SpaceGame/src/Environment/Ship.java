package Environment;

public class Ship {
	
	private String shipName = "";
	private String location = "";
	private int shipPartsFound = 0;
	private int shipPartsTotalMissing = 0;
	private int sheildLevel = 100;
	//private int maxCrewCapacity;  Should we?
	
	
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
		this.sheildLevel = Math.max(Math.min(sheildLevel, 100), 0);
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
