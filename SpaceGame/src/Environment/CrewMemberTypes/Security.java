package Environment.CrewMemberTypes;

/**
 * 
 * Reduces damage of an alien attack to both crew members and the ship.
 * @author Benjamin Thurber
 * @author Blake Kayser
 */
public class Security extends CrewMember {
	public final String specialization = "security";
	public final static String avatarImage = "/Images/Avatars/security.png";
	private final static String DESCRIPTION = "<html><div style='text-align: center;'>Reduces damage of an alien attack to both crew members and the ship.</div></html>";

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
	public Security(String name, int cremMemberID) {
		super(name, cremMemberID);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name String of the CrewMember's name
	 */
	public Security(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public String getSpecialization() {
		return specialization;
	}
	
	public String getAvatarImage() {
		return avatarImage;
	}
}
