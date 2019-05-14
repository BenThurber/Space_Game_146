package Environment.Locations;

public class Location {
	
	public final String type = "Empty Space";
	protected String name = "Unknown";
	
	public Location() {
	}

	public Location(String location) {
		name = location;
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
	
}
