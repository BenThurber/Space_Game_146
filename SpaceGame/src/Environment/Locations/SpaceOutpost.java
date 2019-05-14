package Environment.Locations;

import java.util.Random;

public class SpaceOutpost extends Location {
	
	public final String type = "Outpost";
	
	public SpaceOutpost() {
		Random rand = new Random();
		this.name = String.valueOf(rand.nextInt(500));
	}

	public SpaceOutpost(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public String getType() {
		return type;
	}

	public String getLocationFormatted() {
		return String.format("<html><div style='text-align: left;'>%s<br/>%s</div></html>", this.getType(), this.getName());
	}

}
