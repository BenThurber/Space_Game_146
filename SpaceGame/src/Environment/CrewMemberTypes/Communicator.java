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
