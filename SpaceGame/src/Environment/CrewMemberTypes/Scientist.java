package Environment.CrewMemberTypes;

import java.util.Random;

import Environment.GameEnvironment;
import Environment.MessageBox;
import Environment.Locations.Planet;

/**
 * 
 * Scientists have a higher chance at finding spare parts on foreign planets.
 * @author Benjamin Thurber
 * @author Blake Kayser
 */
public class Scientist extends CrewMember {
	
	public final String specialization = "scientist";
	public final static String avatarImage = "/Images/Avatars/scientist.png";
	
	private final String FOUND_PART_MESSAGE = "Your Scientist has scanned the planet and sucsessfully found a ship part on the surface!";
	private final String COULDNT_FIND_PART_MESSAGE = "Your Scientist was not able to find any ship parts, it is unlikley that any exist.";
	
	private final int FIND_SHIP_PART_SUCSESS_RATE = 80;
	
	private final static String DESCRIPTION = "<html><div style='text-align: center;'>Scientists have a higher chance at finding spare parts on foreign planets.</div></html>";
	
	/**
	 * @return a String of the description of what the type of CrewMember does.  Formatted with HTML.
	 */
	public static String getDescription() {
		return DESCRIPTION;
	}
	
	/**
	 * @param name String of the CrewMember's name
	 * @param cremMemberID where the crew member belongs in the GUI (typically 0 to 3)
	 */
	public Scientist(String name, int cremMemberID) {
		super(name, cremMemberID);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name String of the CrewMember's name
	 */
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
