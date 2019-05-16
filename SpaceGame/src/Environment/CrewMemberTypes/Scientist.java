package Environment.CrewMemberTypes;

import java.util.Random;

import Environment.Locations.Planet;

public class Scientist extends CrewMember {
	
	public final String specialization = "scientist";
	private final String avatarImage = "/Images/Avatars/scientist.png";
	
	private final int FIND_ITEM_SUCSESS_RATE = 85;
	
	public Scientist(String name, int cremMemberID) {
		super(name, cremMemberID);
		// TODO Auto-generated constructor stub
	}

	public Scientist(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public String getSpecialization() {
		return specialization;
	}
	
	public String getAvatarImage() {
		return avatarImage;
	}
	
	public void searchPlanet(Planet planet) {
		if (this.decrementNumActions()) {
			// Re-implement using items
			Random rand = new Random();
			System.out.println("Scientist Searching Planet: " + planet.getName());
			if (planet.isContainsFood() && FIND_ITEM_SUCSESS_RATE > rand.nextInt(100)) {
				System.out.println("Found Something");
			}
		}
	}
}
