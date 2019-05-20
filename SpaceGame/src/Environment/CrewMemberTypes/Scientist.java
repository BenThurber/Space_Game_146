package Environment.CrewMemberTypes;

import java.util.Random;

import Environment.GameEnvironment;
import Environment.MessageBox;
import Environment.Locations.Planet;

public class Scientist extends CrewMember {
	
	public final String specialization = "scientist";
	private final String avatarImage = "/Images/Avatars/scientist.png";
	
	private final String FOUND_PART_MESSAGE = "Your Scientist has scanned the planet and sucsessfully found a ship part on the surface!";
	private final String COULDNT_FIND_PART_MESSAGE = "Your Scientist was not able to find any ship parts, it is unlikley that any exist.";
	
	private final int FIND_SHIP_PART_SUCSESS_RATE = 80;
	
	private final static String DESCRIPTION = "<html><div style='text-align: center;'>Scientists have a higher chance at finding spare parts on foreign planets.</div></html>";
	
	public static String getDescription() {
		return DESCRIPTION;
	}
	
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
	
	public void searchPlanet(Planet planet, GameEnvironment environment) {
		super.searchPlanet(planet, environment, FIND_SHIP_PART_SUCSESS_RATE, FOUND_PART_MESSAGE, COULDNT_FIND_PART_MESSAGE);
	}
}
