package Environment.CrewMemberTypes;

public class Captain extends CrewMember {
	
	public final String specialization = "captain";
	private final String avatarImage = "/Images/Avatars/captain.png";
	
	public Captain(String name, int cremMemberID) {
		super(name, cremMemberID);
		// TODO Auto-generated constructor stub
	}

	public Captain(String name) {
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
