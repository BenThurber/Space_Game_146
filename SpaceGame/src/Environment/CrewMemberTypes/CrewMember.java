package Environment.CrewMemberTypes;

import java.util.Set;

import Environment.Ship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CrewMember {
	
//	public final Set<String> SPECIALIZATIONS = new HashSet<String>(Arrays.asList(
//		     new String[] {"engineer", "scientist", "doctor", "navigator", "captain", "communications", "security"}));
	
	public final Set<String> ACTIONS = new HashSet<String>(Arrays.asList(
			new String[] {"eat", "pilot ship", "repair sheilds", "search planet", "sleep", "use medical item"}));
	
	public final int MAX_ACTIONS = 2;
	
	public final String specialization = "none";
	private final String avatarImage = "/Images/Avatars/captain.png";  //Just use captain image...
	
	private String name;
	private int health = 100;
	private int hunger = 0;
	private int stamina = 100;
	private boolean isAlive = true;
	private int numActions = MAX_ACTIONS;
	// Integer to identify where CrewMember belongs in the array in Crew and where it goes in the GUI
	private int crewMemberID;
	
	
	public CrewMember(String name, int cremMemberID) {
		this.setName(name);
		this.setCrewMemberID(cremMemberID);
	}
	public CrewMember(String name) {
		this.setName(name);
		this.setCrewMemberID(0);
	}
	
	
	
	
	
	/**Crew member sleeps and regains some amount of stamina (health?)*/
	public void sleep() {
		this.addStamina(50);
	}
	
	/**Crew member eats and increases some amount of stamina and health.*/
	public void eat() {
		this.addHunger(-50);
		System.out.println(this.name + " ate food.  Hunger: " + this.getHunger());
	}
	
	/**Crew member eats and regains some amount of health.*/
	public void useMedicalItem() {
		this.addHealth(50);
	}
	
	public void repairSheilds(Ship ship) {
		ship.addToSheildLevel(50);
	}
	
	
	

	public int getHealth() {
		return health;
	}
	/**Adds/subtracts health.  If dropped to 0 CrewMember dies.*/
	public void addHealth(int addedHealth) {
		this.health = Math.max(Math.min(this.health + addedHealth, 100), 0);
		if (this.health <= 0) {
			this.kill();
		}
	}
	
	public int getHunger() {
		return hunger;
	}
	/**Adds/subtracts hunger.  If raised to 100 CrewMember dies.*/
	public void addHunger(int addedHunger) {
		this.hunger = Math.max(Math.min(this.hunger + addedHunger, 100), 0);
		if (this.hunger >= 100) {
			this.kill();
		}
	}
	
	public int getStamina() {
		return stamina;
	}
	/**Adds/subtracts stamina.  If dropped to 0 CrewMember dies.*/
	public void addStamina(int addedStamina) {
		this.stamina = Math.max(Math.min(this.stamina + addedStamina, 100), 0);
		if (this.stamina <= 0) {
			this.kill();
		}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isAlive() {
		return isAlive;
	}
	public void kill() {
		this.isAlive = false;
	}

	public String getSpecialization() {
		return specialization;
	}
//	public void setSpecialization(String specialization) {
//		if (SPECIALIZATIONS.contains(specialization.toLowerCase())) {
//			this.specialization = Misc.capitalize(specialization);
//			setAvatarImage(this.specialization);
//		} else {
//			throw new IllegalArgumentException("CrewMember has an invalid specialization.");
//		}
//	}
	
	public String getAvatarImage() {
		return avatarImage;
	}
	
	public int getNumActions() {
		return numActions;
	}
	/**Resets number of actions to MAX_ACTIONS*/
	public void setNumActionsReset() {
		this.numActions = MAX_ACTIONS;
	}
	/**Remove one Action (min 0)*/
	public void decrementNumActions() {
		this.numActions = Math.max(this.numActions-1, 0);
	}
	
	public int getCrewMemberID() {
		return crewMemberID;
	}
	public void setCrewMemberID(int crewMemberID) {
		this.crewMemberID = crewMemberID;
	}
	
	
	
	
	
//	public String[] getActions() {
//		
//		String[] actions = new String[ACTIONS.length + 1];
//		actions[0] = "";
//		for (int i=0; i < ACTIONS.length; i++) {
//			actions[i+1] = Misc.capitalize(ACTIONS[i]);
//		}
//		return actions;
//	}
	
	
	
}