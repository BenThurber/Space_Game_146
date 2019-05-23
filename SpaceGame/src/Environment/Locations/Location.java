package Environment.Locations;

/**
 * A super class that defines where the ship is.  Holds an image location of what the 
 * location looks like.  This class is just empty space.
 * @author Benjamin Thurber
 * @author Blake Kayser
 *
 */
public class Location {
	
	public final String type = "Unknown";
	protected String name = "Empty Space";
	protected final String imagePath = "/Images/Locations/EmptySpace.png";
	
	public Location() {
	}

	public Location(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	
	public String getLocationFormatted() {
		return name;
	}

	public String getImagePath() {
		return imagePath;
	}
	
	
	
	public boolean isContainsShipPart() {
		return false;
	}
	public void removeShipPart() {
	}
	public boolean isContainsFood() {
		return false;
	}
	public boolean isContainsMedicalItem() {
		return false;
	}
	public boolean isContainsMoney() {
		return false;
	}
	
}
