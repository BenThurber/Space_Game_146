package Environment.CrewMemberTypes;

public class Scientist extends CrewMember {
	
	public final String specialization = "scientist";
	private final String avatarImage = "/Images/Avatars/scientist.png";
	
	public Scientist(String name, int cremMemberID) {
		super(name, cremMemberID);
		// TODO Auto-generated constructor stub
	}

	public Scientist(String name) {
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
