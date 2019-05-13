package Environment;

public class Navigator extends CrewMember {
	
	public final String specialization = "navigator";
	private final String avatarImage = "/Images/Avatars/navigator.png";

	public Navigator(String name, int cremMemberID) {
		super(name, cremMemberID);
		// TODO Auto-generated constructor stub
	}

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
