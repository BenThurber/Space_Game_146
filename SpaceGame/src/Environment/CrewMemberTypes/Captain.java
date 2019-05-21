package Environment.CrewMemberTypes;

public class Captain extends CrewMember {
	
	public final String specialization = "captain";
	public final static String avatarImage = "/Images/Avatars/captain.png";
	
	// Captain heals physical stats to full
	private final int HUNGER_LVL_INCREASE_EAT = -100;
	private final int STANIMA_LVL_INCREASE_SLEEP = -100;
	private final int HEALTH_LVL_INCREASE_MED_ITEM = 100;
	
	// Captain takes off this amount from physical stats lost before applying it to them.  AKA damage reduction.
	private final int CAPTAIN_STANIMA_DAMAGE_REDUCTION = 10;
	private final int CAPTAIN_HUNGER_DAMAGE_REDUCTION = 10;
	private final int CAPTAIN_HEALTH_DAMAGE_REDUCTION = 20;
	
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
	
	//High is good
	/**Adds or subtracts health from crew member.  If adding health, auto restores to full.  
	 * If taking damage (removing health) subtracts CAPTAIN_PHYSICAL_STAT_DAMAGE_REDUCTION 
	 * off the damage before applying it. */
	public void addHealth(int addedHealth) {
		if (addedHealth >= 0) {
			super.addHealth(100);
		} else {
			super.addHealth(Math.min(0, addedHealth + CAPTAIN_HEALTH_DAMAGE_REDUCTION));
		}
	}
	//Low is good
	/**Adds or subtracts Stamina from crew member.  If removing Stamina, auto restores to zero.  
	 * If taking adding Stamina, subtracts CAPTAIN_PHYSICAL_STAT_DAMAGE_REDUCTION from the 
	 * increase before applying it.*/
	public void addStamina(int addedStamina) {
		if (addedStamina <= 0) {
			super.addStamina(-100);
		} else {
			super.addStamina(Math.max(0, addedStamina - CAPTAIN_STANIMA_DAMAGE_REDUCTION));
		}
	}
	//Low is good
	/**Adds or subtracts Hunger from crew member.  If removing Hunger, auto restores to zero.  
	 * If taking adding Hunger, subtracts CAPTAIN_PHYSICAL_STAT_DAMAGE_REDUCTION from the 
	 * increase before applying it.*/
	public void addHunger(int addedHunger) {
		if (addedHunger <= 0) {
			super.addHunger(-100);
		} else {
			super.addHunger(Math.max(0, addedHunger - CAPTAIN_HUNGER_DAMAGE_REDUCTION));
		}
	}

}
