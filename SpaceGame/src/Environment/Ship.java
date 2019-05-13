package Environment;

public class Ship {
	
	private String name = "";
	private String location = "";
	private int shipPartsFound = 0;
	private int shipPartsTotalMissing = 0;
	private int sheildLevel = 100;
	
	
	public String getName() {
		return name;
	}
	public void setName(String newshipName) {
		this.name = newshipName;
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
	public void addToSheildLevel(int addedSheildEnergy) {
		this.sheildLevel = Math.max(Math.min(this.sheildLevel + addedSheildEnergy, 100), 0);
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
