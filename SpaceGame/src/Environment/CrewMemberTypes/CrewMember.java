package Environment.CrewMemberTypes;

import java.util.Set;

import Environment.GameEnvironment;
import Environment.MessageBox;
import Environment.Ship;
import Environment.Locations.Planet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * Super Class of crew members.  Performs the general actions of the crew members like sleep eat etc.
 * @author Benjamin Thurber
 * @author Blake Kayser
 *
 */
public class CrewMember {
	//	public final Set<String> SPECIALIZATIONS = new HashSet<String>(Arrays.asList(
	//	new String[] {"engineer", "scientist", "doctor", "navigator", "captain", "communications", "security"}));
	
	public final Set<String> ACTIONS = new HashSet<String>(Arrays.asList(
			new String[] {"eat", "pilot ship", "repair sheilds", "search planet", "sleep", "use medical item"}));
	
	public final int MAX_ACTIONS = 2;
	 
	//Amounts by which stats increase with their respective actions
	protected final int HUNGER_LVL_INCREASE_EAT = -50;
	protected final int EXHAUSTION_LVL_INCREASE_SLEEP = -50;
	protected final int HEALTH_LVL_INCREASE_MED_ITEM = 50;
	protected final int SHEILD_REPAIR_AMOUNT = 20;
	
	// Percent chance of finding an item on a planet
	protected final int FIND_SHIP_PART_SUCSESS_RATE = 75;
	protected final String FOUND_PART_MESSAGE = "Your crew member has sucsessfully found a ship part on the planet's surface!";
	protected final String COULDNT_FIND_PART_MESSAGE = "Your crew member was not able to find any ship parts (parts may or may not exist on this planet)";
	protected final String NO_ACTIONS_LEFT_MESSAGE = "%s has no actions left!  Start next day to rest your members.";
	
	public final String specialization = "none";
	public final static String avatarImage = "/Images/Avatars/captain.png";  //Just use captain image...
	
	private String name;
	private int health = 100;
	private int hunger = 0;
	private int exhaustion = 0;
	private boolean isAlive = true;
	private boolean hasSpacePlague = false;
	private int numActions = MAX_ACTIONS;
	
	// Integer to identify where CrewMember belongs in the array in Crew and where it goes in the GUI
	private int crewMemberID;
	
	/**
	 * @param name String of the CrewMember's name
	 * @param cremMemberID where the crew member belongs in the GUI (typically 0 to 3)
	 */
	public CrewMember(String name, int cremMemberID) {
		this.setName(name);
		this.setCrewMemberID(cremMemberID);
	}
	
	/**
	 * @param name String of the CrewMember's name
	 */
	public CrewMember(String name) {
		this.setName(name);
		this.setCrewMemberID(0);
	}
	
	/**Crew member sleeps and decreases some amount of exhaustion
	 * @param exhaustionIncrease integer amount of exhaustion to add (positive or negative)
	 */
	protected void sleep(int exhaustionIncrease) {
		if (this.decrementNumActions()) {
			this.addExhaustion(exhaustionIncrease);
		}
	}
	
	/**Crew member sleeps and decreases default amount of exhaustion*/
	public void sleep() {
		sleep(EXHAUSTION_LVL_INCREASE_SLEEP);
	}
	
	/**Crew member eats and increases some amount of exhaustion and health.
	 * @param hungerIncrease integer amount of hunger to add (positive or negative)
	 */
	protected void eat(int hungerIncrease) {
		if (this.decrementNumActions()) {
			this.addHunger(hungerIncrease);
		}
	}
	
	/**Crew member eats and decreases default amount of hunger.*/
	public void eat() {
		eat(HUNGER_LVL_INCREASE_EAT);
	}
	
	/**Crew member uses medical item and regains some amount of health.  If they have space plague then cures that.
	 * @param healthIncrease integer amount of health to increase (positinve or negative)
	 */
	protected void useMedicalItem(int healthIncrease) {
		if (this.decrementNumActions()) {
			if (this.hasSpacePlague()) {
				this.setHasSpacePlague(false);
			} else {
				this.addHealth(healthIncrease);
			}
		}
	}
	
	/**
	 * Crew member uses medical item and regains some amount of health.  If they have space plague then cures that.
	 */
	public void useMedicalItem() {
		useMedicalItem(HEALTH_LVL_INCREASE_MED_ITEM);
	}
	
	/**
	 * Called when a CrewMember is healed from a doctor and not by himself using a medical item
	 * @param healthIncrease integer amount to increase health by
	 */
	protected void receiveHealingFromDoctor(int healthIncrease) {
		if (this.hasSpacePlague()) {
			this.setHasSpacePlague(false);
		} else {
			this.addHealth(healthIncrease);
		}
	}
	
	/**
	 * Called when a CrewMember is healed from a doctor and not by himself using a medical item
	 */
	public void receiveHealingFromDoctor() {
		//Implement remove space plague?
		this.receiveHealingFromDoctor(HEALTH_LVL_INCREASE_MED_ITEM);
	}
	
	/**
	 * @param ship the ship to repair the shields of
	 * @param amount integer about from 0 to 100
	 */
	protected void repairSheilds(Ship ship, int amount) {
		if (this.decrementNumActions()) {
			ship.addToSheildLevel(amount);
			System.out.println(ship.getSheildLevel());
		}
	}
	
	/**
	 * @param ship the ship to repair the shields of
	 */
	public void repairSheilds(Ship ship) {
		repairSheilds(ship, SHEILD_REPAIR_AMOUNT);
	}
	
	/**Called when a crew member pilots the ship.  Decrements an action*/
	public void pilotShip() {
		decrementNumActions();
	}
	
	/**
	 * Called when a CrewMember searches a planet
	 * @param planet the Planet object to be searched
	 * @param environment the current GameEnvironment object
	 * @param findShipPartSucsessRate integer 0 to 100 representing the percent chance of crew member finding a space ship part if its there
	 * @param foundPartMessage String the message displayed when a CrewMember finds a part
	 * @param couldntFindPartMessage String the message displayed when a CrewMember DOESEN'T finds a part
	 */
	public void searchPlanet(Planet planet, GameEnvironment environment, int findShipPartSucsessRate, String foundPartMessage, String couldntFindPartMessage) {
		if (this.decrementNumActions()) {
			Random rand = new Random();
			System.out.println("Searching Planet: " + planet.getName() + "Has Part: " + planet.isContainsShipPart());
			if (planet.isContainsShipPart() && findShipPartSucsessRate > rand.nextInt(100)) {
				System.out.println("Found a ship part");
				environment.incrementShipPartsFound();
				MessageBox foundPartMessageBox = new MessageBox(foundPartMessage);
			} else {
				System.out.println("Could not find a ship part");
				MessageBox couldntFindPartMessageBox = new MessageBox(couldntFindPartMessage);
			}
			environment.checkForGameOver();
		}
	}
	public void searchPlanet(Planet planet, GameEnvironment environment) {
		searchPlanet(planet, environment, FIND_SHIP_PART_SUCSESS_RATE, FOUND_PART_MESSAGE, COULDNT_FIND_PART_MESSAGE);
	}
	
	/**
	 * @return current health int
	 */
	public int getHealth() {
		return health;
	}
	
	/**Adds/subtracts health.  If dropped to 0 CrewMember dies.
	 * @param addedHealth int health increase (positive or negative)
	 */
	public void addHealth(int addedHealth) {
		this.health = Math.max(Math.min(this.health + addedHealth, 100), 0);
		if (this.health <= 0) {
			this.kill();
		}
	}
	
	/**
	 * @return current hunger int
	 */
	public int getHunger() {
		return hunger;
	}
	
	/**Adds/subtracts hunger.  If raised to 100 CrewMember dies.
	 * @param addedHunger int hunger increase (positive or negative)
	 */
	public void addHunger(int addedHunger) {
		this.hunger = Math.max(Math.min(this.hunger + addedHunger, 100), 0);
		if (this.hunger >= 100) {
			this.kill();
		}
	}
	
	/**
	 * @return exhaustion level int
	 */
	public int getExhaustion() {
		return exhaustion;
	}
	
	/**Adds/subtracts exhaustion.  If raised to 100 CrewMember dies.
	 * @param addedExhaustion int exhaustion increase (positive or negative)
	 */
	public void addExhaustion(int addedExhaustion) {
		this.exhaustion = Math.max(Math.min(this.exhaustion + addedExhaustion, 100), 0);
		if (this.exhaustion >= 100) {
			this.kill();
		}
	}

	/**
	 * @return string CrewMember's assigned name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name CrewMember's new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return boolean, true is CrewMember is alive
	 */
	public boolean isAlive() {
		return isAlive;
	}
	
	public void kill() {
		this.isAlive = false;
	}

	/**
	 * @return boolean, true if the crew member has space plague
	 */
	public boolean hasSpacePlague() {
		return hasSpacePlague;
	}
	
	/**
	 * @param hasSpacePlague true if the crew member has just contracted space plague
	 */
	public void setHasSpacePlague(boolean hasSpacePlague) {
		this.hasSpacePlague = hasSpacePlague;
	}
	
	/**
	 * @return String of the CrewMembers's specialization as given in each Subclass of CrewMember
	 */
	public String getSpecialization() {
		return specialization;
	}
	
	/**
	 * @return String of the path of CrewMembers's avatar image as given in each Subclass of CrewMember i.e. {@literal "/Images/Avatars/<specialization>.png"}
	 */
	public String getAvatarImage() {
		return avatarImage;
	}
	
	/**
	 * @return int number of actions the CrewMember has remaining
	 */
	public int getNumActions() {
		return numActions;
	}
	
	/**Resets number of actions to MAX_ACTIONS*/
	public void setNumActionsReset() {
		this.numActions = MAX_ACTIONS;
	}
	
	/**Remove one Action (min 0)  Returns true if there was an action remaining when the method was called.
	 * @return boolean which is true if the crew member had any actions remaining when the method was called.
	 */
	public boolean decrementNumActions() {
		boolean actionsRemaining;
		if (this.numActions > 0) {
			actionsRemaining = true;
			this.numActions = Math.max(this.numActions-1, 0);
		} else {
			actionsRemaining = false;
			MessageBox noActionsLeft = new MessageBox(String.format(NO_ACTIONS_LEFT_MESSAGE, this.getName()));
		}
		return actionsRemaining;
	}
	
	/**
	 * @return the ID number (typically 0 - 3) if where the CrewMember belongs in the GUI
	 */
	public int getCrewMemberID() {
		return crewMemberID;
	}
	
	/**
	 * @param crewMemberID the ID number (typically 0 - 3) if where the CrewMember belongs in the GUI
	 */
	public void setCrewMemberID(int crewMemberID) {
		this.crewMemberID = crewMemberID;
	}	
}