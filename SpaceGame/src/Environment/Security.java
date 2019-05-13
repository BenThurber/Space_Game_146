package Environment;

public class Security extends CrewMember {
	
	public final String specialization = "security";
	private final String avatarImage = "/Images/Avatars/security.png";
	
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
