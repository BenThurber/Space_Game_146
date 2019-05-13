package Environment;

public class Doctor extends CrewMember {
	
	public final String specialization = "doctor";
	private final String avatarImage = "/Images/Avatars/doctor.png";

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