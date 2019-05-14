package Environment;

import Environment.Locations.Location;

public class Ship {
	
	private String name = "";
	private Location location = new Location();
	private int sheildLevel = 100;
	
	
	public Ship() {
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String newshipName) {
		this.name = newshipName;
	}
	
	public int getSheildLevel() {
		return sheildLevel;
	}
	public void addToSheildLevel(int addedSheildEnergy) {
		this.sheildLevel = Math.max(Math.min(this.sheildLevel + addedSheildEnergy, 100), 0);
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public void setLocation(String location) {
		this.location = new Location(location);
	}
}
