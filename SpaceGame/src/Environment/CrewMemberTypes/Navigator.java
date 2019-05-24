package Environment.CrewMemberTypes;

/**
 * 
 * Navigators have a chance at avoiding asteroid damage, 
 * navigating the ship between planets. Having a Navigator 
 * in your crew reduces chance of over-night meteor damage. 
 * Navigators stack, up to two.
 * @author Benjamin Thurber
 * @author Blake Kayser
 */
public class Navigator extends CrewMember {
	public final String specialization = "navigator";
	public final static String avatarImage = "/Images/Avatars/navigator.png";
	
	private final static String DESCRIPTION = "<html><div style='text-align: center;'>Navigators have a chance at avoiding asteroid damage, navigating the ship between planets. Having a Navigator in your crew reduces chance of over-night meteor damage. Navigators stack, up to two.</div></html>";
	
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
	public Navigator(String name, int cremMemberID) {
		super(name, cremMemberID);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name String of the CrewMember's name
	 */
	public Navigator(String name) {
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
