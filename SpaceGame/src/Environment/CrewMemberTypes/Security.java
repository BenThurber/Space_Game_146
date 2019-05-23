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

	public static String getDescription() {
		return DESCRIPTION;
	}
	
	public Security(String name, int cremMemberID) {
		super(name, cremMemberID);
		// TODO Auto-generated constructor stub
	}

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
