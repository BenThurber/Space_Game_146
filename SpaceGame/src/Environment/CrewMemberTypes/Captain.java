package Environment.CrewMemberTypes;

public class Captain extends CrewMember {
	
	public final String specialization = "captain";
	private final String avatarImage = "/Images/Avatars/captain.png";
	
	// Captain heals physical stats to full
	private final int HUNGER_LVL_INCREASE_EAT = -100;
	private final int STANIMA_LVL_INCREASE_SLEEP = 100;
	private final int HEALTH_LVL_INCREASE_MED_ITEM = 100;
	
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
	
	// Override physical stats
	public void sleep() {
		super.sleep(STANIMA_LVL_INCREASE_SLEEP);
	}
	
	public void eat() {
		super.eat(HUNGER_LVL_INCREASE_EAT);
	}
	
	public void useMedicalItem() {
		super.useMedicalItem(HEALTH_LVL_INCREASE_MED_ITEM);
	}
	

}
