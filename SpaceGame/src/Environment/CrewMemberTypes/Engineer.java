package Environment.CrewMemberTypes;

import Environment.Ship;

/**
 * Engineers are able to repair the ship's shield by 50%.
 * 
 * @author Benjamin Thurber
 * @author Blake Kayser
 */
public class Engineer extends CrewMember {
	public final String specialization = "engineer";
	public final static String avatarImage = "/Images/Avatars/engineer.png";
	private final static String DESCRIPTION = "<html><div style='text-align: center;'>Engineers are able to repair the ship's shield by 50%.</div></html>";
	
	protected final int SHEILD_REPAIR_AMOUNT = 50;
	
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
	public Engineer(String name, int cremMemberID) {
		super(name, cremMemberID);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name String of the CrewMember's name
	 */
	public Engineer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public String getSpecialization() {
		return specialization;
	}
	
	public String getAvatarImage() {
		return avatarImage;
	}
	
	public void repairSheilds(Ship ship) {
		super.repairSheilds(ship, SHEILD_REPAIR_AMOUNT);
	}
}
