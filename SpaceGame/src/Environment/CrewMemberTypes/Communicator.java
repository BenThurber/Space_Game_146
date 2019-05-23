package Environment.CrewMemberTypes;

/**
 * 
 * A subclass of CrewMember but isn't presently used in the game.  Has an avatar image but no special benefits.
 * @author Benjamin Thurber
 * @author Blake Kayser
 */
public class Communicator extends CrewMember {
	
	public final String specialization = "communications";
	public final static String avatarImage = "/Images/Avatars/communications.png";
	
	private final static String DESCRIPTION = "<html><div style='text-align: center;'>Nothing yet.  Communicator is not yet implemented in the game.</div></html>";
	
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
	public Communicator(String name, int cremMemberID) {
		super(name, cremMemberID);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param name String of the CrewMember's name
	 */
	public Communicator(String name) {
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
