package Environment.CrewMemberTypes;

public class Doctor extends CrewMember {
	
	public final String specialization = "doctor";
	public final static String avatarImage = "/Images/Avatars/doctor.png";
	
	private final static String DESCRIPTION = "<html><div style='text-align: center;'>Doctors can heal up to two other crew members with one action, either including or not inclucing themselves.</div></html>";
	
	public static String getDescription() {
		return DESCRIPTION;
	}
	
	public Doctor(String name, int cremMemberID) {
		super(name, cremMemberID);
		// TODO Auto-generated constructor stub
	}

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