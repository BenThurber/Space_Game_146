package Environment.CrewMemberTypes;

/**
 * 
 * Doctors can heal up to two other crew members with one action, either including or not including themselves.
 * @author Benjamin Thurber
 * @author Blake Kayser
 */
public class Doctor extends CrewMember {
	public final String specialization = "doctor";
	public final static String avatarImage = "/Images/Avatars/doctor.png";
	private final static String DESCRIPTION = "<html><div style='text-align: center;'>Doctors can heal up to two other crew members with one action, either including or not including themselves.</div></html>";
	
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
	public Doctor(String name, int cremMemberID) {
		super(name, cremMemberID);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name String of the CrewMember's name
	 */
	public Doctor(String name) {
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