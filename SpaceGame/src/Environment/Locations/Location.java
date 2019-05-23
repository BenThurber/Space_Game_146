package Environment.Locations;

/**
 * A super class that defines where the ship is.  Holds an image location of what the 
 * location looks like.  This class is just empty space.
 * @author Benjamin Thurber
 * @author Blake Kayser
 *
 */
/**
 * @author Ben
 *
 */
public class Location {
	
	public final String type = "Unknown";
	protected String name = "Empty Space";
	protected final String imagePath = "/Images/Locations/EmptySpace.png";
	
	public Location() {
	}

	/**
	 * @param name string name of new Lacation object
	 */
	public Location(String name) {
		this.name = name;
	}

	/**
	 * @return string of Location object
	 */
	public String getName() {
		return name;
	}

	/**
	 * set a new name for this Location
	 * @param name String name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return String the type of location like "Planet" or "Outpost"
	 */
	public String getType() {
		return type;
	}
	
	
	/**
	 * @return String the name of the location but formatted using HTML
	 */
	public String getLocationFormatted() {
		return name;
	}

	/**
	 * Gets the image path of the location
	 * @return String of the path of Locations image as given in each Subclass of Location i.e. 
	 * {@literal "/Images/Locations/<name>.png"} or {@literal "/Images/Locations/Planets/<name>.jpg"}
	 */
	public String getImagePath() {
		return imagePath;
	}
	
	
	
	/**
	 * @return boolean true if this Location contains a ship part
	 */
	public boolean isContainsShipPart() {
		return false;
	}
	/**
	 * Removes a ship part from this Location if one exists.  Sets containsShipPart to false in Planet class
	 */
	public void removeShipPart() {
	}
	/**
	 * @return boolean true if this Location contains food
	 */
	public boolean isContainsFood() {
		return false;
	}
	/**
	 * @return boolean true if this Location contains a medical item
	 */
	public boolean isContainsMedicalItem() {
		return false;
	}
	/**
	 * @return boolean true if this Location contains money
	 */
	public boolean isContainsMoney() {
		return false;
	}
	
}
