package Environment;

import java.util.ArrayList;
import java.util.Arrays;

import Environment.CrewMemberTypes.Captain;
import Environment.CrewMemberTypes.Communicator;
import Environment.CrewMemberTypes.CrewMember;
import Environment.CrewMemberTypes.Doctor;
import Environment.CrewMemberTypes.Engineer;
import Environment.CrewMemberTypes.Navigator;
import Environment.CrewMemberTypes.Scientist;
import Environment.Events.AlienPirates;
import Environment.Events.AsteroidBelt;
import Environment.Events.Event;
import Environment.Events.RandomEventGenerator;
import Environment.Events.SpacePlague;
import Environment.Exceptions.CrewMemberNotFoundException;
import Environment.Locations.Location;
import Environment.Locations.Planet;
import Environment.Locations.SpaceOutpost;

public class GameEnvironment {
	
	
	//----------------
	// VARIABLES:
	//----------------
	
	private final String NOT_ENOUGH_CREW_MEMBERS_MSG = "You don't have enough Crew Members to pilot the ship\n"
			+ "(or they have no more actions).\n\nSelect \"Pilot Ship\" as an action for atleast %d crew members and try again.";
	private final String FIRST_DAY_MESSAGE = "First Day message";
	private final String NEXT_DAY_MESSAGE = "Day %d of %d\n\nA new day has begun.  Your Crew have new actions that they can perfom.";
	private final String SHIP_DEAD_MESSAGE = "You've been hit by an Asteroid, and your sheilds did not have enough energy to deflect it.  Your ship has been destroyed.";
	private final String CREW_DEAD_MESSAGE = "All of your crew have perished from either from lack of food, sleep or from plague.";
	private final String GAME_OVER_MESSAGE = "GAME OVER";
	private final String NOT_AT_A_PLANET_MESSAGE = "Your ship is not currently at a planet.  Pilot to a planet to search for parts.";
	private final String YOU_WIN_MESSAGE = "All parts of your ship have been recovered!\n\nYou Win!";
	private final int MIN_CREW_TO_PILOT_SHIP = 2;
	private final int MAX_NUM_PATIENTS_HEALED = 2;
	
	private CrewMember[] testMembers = {new Scientist("John"), new Navigator("Cortana"), new Doctor("Keys"), new Engineer("Arbiter")};
	
	private int totalDays = 0;
	private int currentDay = 0;
	private int shipPartsFound = 0;
	private int shipPartsTotalMissing = 0;
	
	public Ship ship = new Ship();
	public Crew crew = new Crew();
	public Location currentLocation = new Location();
	
	
	private RandomEventGenerator nextDayRandomEvents = new RandomEventGenerator(
			new ArrayList<Event>(Arrays.asList(
					new SpacePlague(this, crew), 
//					new AlienPirates(this, crew),
					new AsteroidBelt(this, crew)))
			);
	private RandomEventGenerator nextPlanetRandomEvents = new RandomEventGenerator(
			new ArrayList<Event>(Arrays.asList(
					new AsteroidBelt(this, crew)))
			);
	
	private MainScreen mainWindow;
	
	
	//----------------
	// METHODS:
	//----------------
	
	public void closeMainScreen(MainScreen mainWindow) {
		mainWindow.closeWindow();
	}
	
	public void closeIntroduction(Introduction introWindow) {
		introWindow.closeWindow();	
		setDays(introWindow.getDaysToPlay());
		launchTeamSelection();
	}
	
	public void closeTeamSelection(TeamSelection teamSelectionWindow ) {
		teamSelectionWindow.closeWindow();
		launchMainScreen();
	}
	
	public void launchTeamSelection() {
		TeamSelection teamSelectionWindow = new TeamSelection(this);
		
	}
	
	public void launchIntroduction() {
		Introduction introWindow = new Introduction(this);
	}
	
	public void launchMainScreen() {
		mainWindow = new MainScreen(this);
		runTestCode();  // Just for testing
		startFirstDay();
	}
	
	
	
	public void visitSpaceOutpost() {
		System.out.println("Visiting Space Outpost");
		currentLocation = new SpaceOutpost();
		ship.setLocation(currentLocation);
		mainWindow.update();
	}
	public void moveToNextPlanet() {
		ArrayList<CrewMember> membersWithAction = crewMembersWithAction(crew, mainWindow, "pilot ship", MIN_CREW_TO_PILOT_SHIP, new Navigator("blank"));
		if (membersWithAction.size() < MIN_CREW_TO_PILOT_SHIP) {
			MessageBox newDayMsg = new MessageBox(String.format(NOT_ENOUGH_CREW_MEMBERS_MSG, MIN_CREW_TO_PILOT_SHIP), mainWindow);
			return;
		}
		System.out.println(membersWithAction);
		System.out.println("Moving to Next Planet");
		for (CrewMember member: membersWithAction) {
			member.pilotShip();
			mainWindow.clearComboBoxes(member);
		}
		currentLocation = new Planet();
		ship.setLocation(currentLocation);
		AsteroidBelt nextPlanetAsteroids = new AsteroidBelt(this, crew);  // Asteroid Belt
		nextPlanetAsteroids.initiate(membersWithAction);
		mainWindow.update();
		checkForGameOver();
	}
	public void startNextDay() {
		System.out.println("Starting Next Day");
		incrementCurrentDay();
		crew.resetCrewForNewDay();
		nextDayRandomEvents.initiateRandomEvent();  // Random Event
		MessageBox messageBoxNewDay = new MessageBox(String.format(NEXT_DAY_MESSAGE, getCurrentDay(), getTotalDays()), mainWindow);
		mainWindow.clearComboBoxes();
		mainWindow.update();
		checkForGameOver();
	}
	public void viewInventory() {
		System.out.println("Viewing Inventory");
	}
	
	
	public void startFirstDay() {
		System.out.println("Starting First Day");
		MessageBox messageBoxNewDay = new MessageBox(String.format(FIRST_DAY_MESSAGE), mainWindow);
		nextDayRandomEvents.initiateRandomEvent();  // Random Event
		mainWindow.update();
		messageBoxNewDay.setAlwaysOnTop(true);
	}
	
	
	public void executeCrewMemberAction(CrewMember member, String task) {
		switch (task.toLowerCase()) {
		case "sleep":
			member.sleep();
			break;
		case "eat":
			member.eat();
			break;
		case "use medical item":
			if (member.getSpecialization().equals("doctor")) {
				if(member.getNumActions() > 0) {
					ArrayList<CrewMember> membersToBeHealed = crewMembersWithAction(crew, mainWindow, "use medical item", MAX_NUM_PATIENTS_HEALED, new Doctor("blank"), false, false);
					for (CrewMember healedMember: membersToBeHealed) {
						healedMember.receiveHealingFromDoctor();
						mainWindow.clearComboBoxes(healedMember);
					}
					member.decrementNumActions();
				}
			} else {
				member.useMedicalItem();
			}
			break;
		case "repair sheilds":
			member.repairSheilds(ship);
			break;
		case "search planet":
			if (currentLocation instanceof Planet) {
				member.searchPlanet((Planet) currentLocation, this);
			} else {
				MessageBox notAtPlanetMessage = new MessageBox(NOT_AT_A_PLANET_MESSAGE, mainWindow);
			}
			//window.update();
			break;
		case "pilot ship":
			moveToNextPlanet();
			break;
		}
		mainWindow.update();  //Refresh the window?
	}
	/**Takes a Crew, MainScreen, Action string, numMembersRequired, and Subclass of CrewMember (to determine special type).  
	 * Returns an ArrayList of CrewMembers (Captain, Scientist, Navigator, etc.) with a remaining action and who's action JComboBox 
	 * has the desired action selected. The ArrayList will be less than or equal in size to numMembersRequired.  
	 * If needRemainingAction then the CrewMembers in the list will all have an action remaining.
	 * If there are more CrewMembers than fit, it chooses the special type of crew member first.*/
	private ArrayList<CrewMember> crewMembersWithAction(Crew crew, MainScreen window, String action, int numMembersRequired, CrewMember specialMemberType, boolean favorSpecialType, boolean needRemainingAction) {
		//Build an ArrayList of all crew members that have action selected on their JComboBox
		action = action.toLowerCase();
		ArrayList<CrewMember> matchingCrewMembers = new ArrayList<CrewMember>(crew.MAX_CREW_MEMBERS);
		for (CrewMember member: crew.getCrewMemberArray()) {
			// If CrewMember is alive, has an action, and has the correct JComboBox item selected
			try {
				System.out.println(window);
				if (member.isAlive() && (member.getNumActions() > 0 || !needRemainingAction) && window.getSelectedNextAction(member).equals(action)) {
					matchingCrewMembers.add(member);
				}
			}
			catch (CrewMemberNotFoundException e) {
				System.out.println("CrewMemberNotFoundException while filtering crew");
				continue;
			}
		}
		// If ArrayList not larger than numMembersRequired return.  Otherwise filter out until right size
		if (matchingCrewMembers.size() <= numMembersRequired) return matchingCrewMembers;

		//Build a new ArrayList by adding just crew members that are (or NOT) of special type
		ArrayList<CrewMember> filteredCrewMembers = new ArrayList<CrewMember>(numMembersRequired);
		for (CrewMember member: matchingCrewMembers) {
			// First Expression is NOT (favorSpecialType XOR isSpecialType). If member is special type (negate if !favorSpecialType) and don't over-fill the ArrayList
			if (!(favorSpecialType ^ member.getSpecialization().equals(specialMemberType.getSpecialization())) && filteredCrewMembers.size() < numMembersRequired) {
				filteredCrewMembers.add(member);
			}
		}
		// If array list is full of special crew members return.  Otherwise start adding ones that are not special to fill the list.
		if (filteredCrewMembers.size() >= numMembersRequired) return filteredCrewMembers;

		//Add crew members that are not special to fill the list then return
		for (CrewMember member: matchingCrewMembers) {
			// If member is NOT special type (or IS special type if NOT favorSpecialType)
			if (!(favorSpecialType ^ !member.getSpecialization().equals(specialMemberType.getSpecialization())) && filteredCrewMembers.size() < numMembersRequired) {
				filteredCrewMembers.add(member);
			}
		}
		return filteredCrewMembers;
	}
	private ArrayList<CrewMember> crewMembersWithAction(Crew crew, MainScreen window, String action, int numMembersRequired, CrewMember specialMemberType) {
		return crewMembersWithAction(crew, window, action, numMembersRequired, specialMemberType, true, true);
	}
	
	
	
	
	
	public static void main(String[] args) {
		GameEnvironment environment = new GameEnvironment();
		environment.runTestCode();
		environment.launchIntroduction();
		
	}
	
	private void runTestCode() {
		// Test code
		ship.setName("UNSC Dawn");
		crew.addNewCrewMembers(testMembers);
	}
	
	
	public int getTotalDays() {
		return totalDays;
	}
	/**Sets total and remaining days and the number of ship parts to be found (2/3 * Days)*/
	public void setDays(int days) {
		totalDays = days;
		currentDay = 1;
		setShipParts(2*days/3);
	}
	public int getCurrentDay() {
		return currentDay;
	}
	public void setCurrentDay(int numDays) {
		this.currentDay = Math.max(numDays, 0);
	}
	public void incrementCurrentDay() {
		currentDay = Math.min(currentDay+1, totalDays);
	}
	
	public int getShipPartsFound() {
		return shipPartsFound;
	}
	public void incrementShipPartsFound() {
		this.shipPartsFound++;
	}
	
	public int getShipPartsTotalMissing() {
		return shipPartsTotalMissing;
	}
	public void setShipParts(int shipPartsTotal) {
		shipPartsTotalMissing = shipPartsTotal;
		shipPartsFound = 0;
	}
	
	public void checkForGameOver() {
		if (!ship.isAlive()) {
			initiateGameOver(SHIP_DEAD_MESSAGE);
		}
		if (!crew.isAlive()) {
			initiateGameOver(CREW_DEAD_MESSAGE);
		}
		if (shipPartsFound >= shipPartsTotalMissing) {
			initiateGameOver(YOU_WIN_MESSAGE);
			// Open Scoreboard window
		}
	}
	public void initiateGameOver(String message) {
		MessageBox messageBoxGameOver = new MessageBox(message + "\n\n" + GAME_OVER_MESSAGE, mainWindow);
		mainWindow.frame.dispose();  // Make better
	}
	public void initiateGameOver() {
		MessageBox messageBoxGameOver = new MessageBox(GAME_OVER_MESSAGE, mainWindow);
		mainWindow.frame.dispose();  // Make better
	}
}
