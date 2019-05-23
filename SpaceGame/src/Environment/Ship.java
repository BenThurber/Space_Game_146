package Environment;

import Environment.Locations.Location;

/**
 * Ship Class hold information like shield level and ship name and location
 * @author Benjamin Thurber
 * @author Blake Kayser
 */
public class Ship {
	
	private String name = "";
	private Location location = new Location();
	private int sheildLevel = 100;
	private int totalLostEnergy = 0;
	
	
	/**
	 * Creates new empty ship object
	 */
	public Ship() {
		
	}
	
	
	/**
	 * @return the ships name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param newshipName a new ship name
	 */
	public void setName(String newshipName) {
		this.name = newshipName;
	}
	
	/**
	 * @return int 0 to 100 of ship's current shield level
	 */
	public int getSheildLevel() {
		return sheildLevel;
	}
	/**
	 * @param addedSheildEnergy amount of energy (positive or negative) to add the the ships shields
	 */
	public void addToSheildLevel(int addedSheildEnergy) {
		if(addedSheildEnergy < 0) {
			totalLostEnergy += addedSheildEnergy;
		}
		this.sheildLevel = Math.max(Math.min(this.sheildLevel + addedSheildEnergy, 100), 0);
	}
	
	/**
	 * The ships current location
	 * @return a Location object (Planet or SpaceOutpost)
	 */
	public Location getLocation() {
		return location;
	}
	/**
	 * Move the ship to new location
	 * @param location a new location the ship is now at
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	/**
	 * Moves the shiop to a new Location object of the given name
	 * @param location a String of the name of the new Location
	 */
	public void setLocation(String location) {
		this.location = new Location(location);
	}
	
	/**
	 * @return boolean that is true if the ship is alive (has more than 0% shield level)
	 */
	public boolean isAlive() {
		return sheildLevel > 0;
	}
	
	/**
	 * @return int a variable (can be greater than 100) that is a running sum of the amount of shield damage the ship has taken
	 */
	public int getTotalLostEnergy() {
		return totalLostEnergy;
	}
}
