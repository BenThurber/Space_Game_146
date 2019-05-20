package Environment.CrewMemberTypes;

import Environment.Ship;

public class Engineer extends CrewMember {
	
	public final String specialization = "engineer";
	public final static String avatarImage = "/Images/Avatars/engineer.png";
	
	private final int SHEILD_REPAIR_AMOUNT = 50;
	
	private final static String DESCRIPTION = "<html><div style='text-align: center;'>Engineers are able to repair the ship's shield 30% more.</div></html>";
	
	public static String getDescription() {
		return DESCRIPTION;
	}
	
	public Engineer(String name, int cremMemberID) {
		super(name, cremMemberID);
		// TODO Auto-generated constructor stub
	}

	public Engineer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public String getSpecialization() {
		return specialization;
	}
	
	public String getAvatarImage() {
		return avatarImage;
	}
	
	public void repairSheilds(Ship ship) {
		super.repairSheilds(ship, SHEILD_REPAIR_AMOUNT);
	}

}
