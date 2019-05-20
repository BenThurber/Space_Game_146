package Environment.CrewMemberTypes;

public class Captain extends CrewMember {
	
	public final String specialization = "captain";
	private final String avatarImage = "/Images/Avatars/captain.png";
	
	// Captain heals physical stats to full
	private final int HUNGER_LVL_INCREASE_EAT = -100;
	private final int STANIMA_LVL_INCREASE_SLEEP = 100;
	private final int HEALTH_LVL_INCREASE_MED_ITEM = 100;
	
	// Captain takes off this amount from physical stats lost before applying it to them.  AKA damage reduction.
	private final int CAPTAIN_PHYSICAL_STAT_DECREASE_THRESHOLD = 10;
	
	private final static String DESCRIPTION = "<html><div style='text-align: center;'>The Captain restores his respective stats FULLY from sleeping, eating and healing. Damage taken is reduced by 10%.</div></html>";
	
	public static String getDescription() {
		return DESCRIPTION;
	}

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
	
	public void receiveHealingFromDoctor() {
		super.receiveHealingFromDoctor(HEALTH_LVL_INCREASE_MED_ITEM);
	}
	
	public void addHealth(int addedHealth) {
		if (addedHealth >= 0) {
			super.addHealth(addedHealth);
		} else {
			super.addHealth(Math.min(0, addedHealth + CAPTAIN_PHYSICAL_STAT_DECREASE_THRESHOLD));
		}
	}
	
	public void addStamina(int addedStamina) {
		if (addedStamina >= 0) {
			super.addStamina(addedStamina);
		} else {
			super.addStamina(Math.min(0, addedStamina + CAPTAIN_PHYSICAL_STAT_DECREASE_THRESHOLD));
		}
	}
	
	public void addHunger(int addedHunger) {
		if (addedHunger <= 0) {
			super.addHunger(addedHunger);
		} else {
			super.addHunger(Math.max(0, addedHunger - CAPTAIN_PHYSICAL_STAT_DECREASE_THRESHOLD));
		}
	}

}
