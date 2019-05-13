package Environment;

public class Communicator extends CrewMember {
	
	public final String specialization = "communications";
	private final String avatarImage = "/Images/Avatars/communications.png";
	
	public Communicator(String name, int cremMemberID) {
		super(name, cremMemberID);
		// TODO Auto-generated constructor stub
	}

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
