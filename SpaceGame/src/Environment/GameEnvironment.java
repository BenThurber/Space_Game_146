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

/**The Class with the main method, that runs the game and calls the shots.*/
public class GameEnvironment {
	
	
	//----------------
	// VARIABLES:
	//----------------
	
	private final String NOT_ENOUGH_CREW_MEMBERS_MSG = "You don't have enough Crew Members to pilot the ship\n"
			+ "(or they have no more actions).\n\nSelect \"Pilot Ship\" as an action for atleast %d crew members and try again.";
	private final String FIRST_DAY_MESSAGE = "Welcome aboard %s.  Your objective is to find %d parts to your space ship.\n\n"
			+ "Maintain the sheilds of your ship as well as the health of your crew by having them eat, sleep and get healed when they're sick.\n\nGood Luck.";
	private final String NEXT_DAY_MESSAGE = "Day %d of %d\n\nA new day has begun.  Your Crew have new actions that they can perfom.";
	private final String SHIP_DEAD_MESSAGE = "You've been hit by an Asteroid, and your sheilds did not have enough energy to deflect it.  Your ship has been destroyed.";
	private final String CREW_DEAD_MESSAGE = "All of your crew have perished from either from lack of food, sleep or from plague.";
	private final String NOT_ENOUGH_CREW_PILOT_SHIP_MESSAGE = "You no longer have enough Crew Members to pilot your ship.  "
			+ "They have perished from either from lack of food, sleep or from plague.  You cannot find enough parts on the "
			+ "current planet to win the game, and you can't move to a new one.  Your situation is bleak.";
	private final String GAME_OVER_MESSAGE = "GAME OVER";
	private final String OUT_OF_DAYS_MESSAGE = "You have ran out of days to find the parts to your ship.";
	private final String YOU_WIN_MESSAGE = "All parts of your ship have been recovered!\n\nYou Win!";
	private final String NOT_AT_A_PLANET_MESSAGE = "Your ship is not currently at a planet.  Pilot to a planet to search for parts.";
	private final int MIN_CREW_TO_PILOT_SHIP = 2;
	private final int MAX_NUM_PATIENTS_HEALED = 2;
	
	public final static int WINDOW_INIT_X = 320;
	public final static int WINDOW_INIT_Y = 100;
	
	private CrewMember[] testMembers = {new Scientist("John"), new Navigator("Cortana"), new Doctor("Keys"), new Engineer("Arbiter")};
	//private CrewMember[] crewMembers = {};
	
	/**The total days of the mission*/
	private int totalDays = 0;
	/**The current day of the mission*/
	private int currentDay = 0;
	/**Number of ship parts currently found*/
	private int shipPartsFound = 0;
	/**Number of ship parts that need to be found*/
	private int shipPartsTotalMissing = 0;
	
	/**The ship*/
	public Ship ship = new Ship();
	/**The crew*/
	public Crew crew = new Crew();
	/**The current location.  Starts as a super class Location object which is empty space.  
	 * currentLocation changes as you move to new Planets and SpaceOutposts.*/
	public Location currentLocation = new Location();
	
	/**Object that generates a random event at the start of each day.*/
	private RandomEventGenerator nextDayRandomEvents = new RandomEventGenerator(
			new ArrayList<Event>(Arrays.asList(
					new AsteroidBelt(this, crew),
					new SpacePlague(this, crew),
					new AlienPirates(this, crew)
					))
			);
	/**Object that generates a random event when moving to a new planet.*/
	private RandomEventGenerator nextPlanetRandomEvents = new RandomEventGenerator(
			new ArrayList<Event>(Arrays.asList(
					new AsteroidBelt(this, crew)))
			);
	
	/**The MainScreen object*/
	private MainScreen mainWindow;
	
	
	
	//----------------
	// METHODS:
	//----------------
	
	/**Closes MainScreen window*/
	public void closeMainScreen(MainScreen mainWindow) {
		mainWindow.closeWindow();
		launchScoreBoard();
	}
	/**Closes Introduction window and calls launchTeamSelection()*/
	public void closeIntroduction(Introduction introWindow) {
		introWindow.closeWindow();	
		setDays(introWindow.getDaysToPlay());
		launchTeamSelection();
	}
	/**Closes TeamSelection window and calls launchMainScreen()*/
	public void closeTeamSelection(TeamSelection teamSelectionWindow ) {
		teamSelectionWindow.closeWindow();
		launchMainScreen();
	}
	/**Closes ScoreBoard window*/
	public void closeScoreBoard(ScoreBoard scoreBoard) {
		scoreBoard.closeWindow();
	}
	/**Opens TeamSelection window*/
	public void launchTeamSelection() {
		TeamSelection teamSelectionWindow = new TeamSelection(this);
	}
	/**Opens Introduction window and starts first day*/
	public void launchIntroduction() {
		Introduction introWindow = new Introduction(this);
	}
	/**Opens MainScreen window and starts first day*/
	public void launchMainScreen() {
		mainWindow = new MainScreen(this);
		startFirstDay();
	}
	/**Opens ScoreBoard window and starts first day*/
	public void launchScoreBoard() {
		ScoreBoard scoreBoard = new ScoreBoard(this);
	}
	
	
	/**Called when "Visit space outpost" is clicked.  Changes location to a new SpaceOutpost*/
	public void visitSpaceOutpost() {
		System.out.println("Visiting Space Outpost");
		currentLocation = new SpaceOutpost();
		ship.setLocation(currentLocation);
		mainWindow.update();
	}
	/**Called when "Warp to next planet" is clicked.  Changes location to a new Planet*/
	public void moveToNextPlanet() {
		// If there is only one crew member left alive, and there are no parts on the current planet that will finish the game, 
		// GameOver because player will not be able to pilot and find remaining parts.
		if (crew.getNumLiveCrew() < 2 && ((getShipPartsFound() < getShipPartsTotalMissing() - 1) || !currentLocation.isContainsShipPart())) {
			initiateGameOver(NOT_ENOUGH_CREW_PILOT_SHIP_MESSAGE);
		}
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
	/**Called when "Start Next Day" is clicked.  Begins a new day*/
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
	/**View item inventory (Currently not working)*/
	public void viewInventory() {
		System.out.println("Viewing Inventory");
	}
	
	/**Starts the first day of the game.*/
	public void startFirstDay() {
		System.out.println("Starting First Day");
		MessageBox messageBoxNewDay = new MessageBox(String.format(FIRST_DAY_MESSAGE, ship.getName(), this.getShipPartsTotalMissing()), mainWindow);
/*		nextDayRandomEvents.initiateRandomEvent();  // Random Event
*/		mainWindow.update();
		messageBoxNewDay.setAlwaysOnTop(true);
	}
	
	/**Takes a CrewMember and a task (a String) and makes the crew member perform that task.  Called when go button is pressed.*/
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
	 * Returns an ArrayList of CrewMembers (Captain, Scientist, Navigator, etc.) with a remaining action 
	 * (if needRemainingAction is true) and who's action JComboBox has the desired action selected. The ArrayList will be 
	 * less than or equal in size to numMembersRequired. If favorSpecialType is true and there are more CrewMembers than fit, 
	 * it chooses the special type of crew member first, otherwise it it chooses CrewMembers NOT of the special type first.
	 * 
	 * This method is used to choose CrewMembers to pilot the ship and to choose CrewMembers to be healed by a doctor.*/
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
	/**Calls crewMembersWithAction with boolean favorSpecialType and boolean needRemainingAction set to true.*/
	private ArrayList<CrewMember> crewMembersWithAction(Crew crew, MainScreen window, String action, int numMembersRequired, CrewMember specialMemberType) {
		return crewMembersWithAction(crew, window, action, numMembersRequired, specialMemberType, true, true);
	}
	
	
	
	
	/**Main Function that runs the game.  Creates an object of GameEnvironment and launches the Introduction window.*/
	public static void main(String[] args) {
		GameEnvironment environment = new GameEnvironment();
		environment.launchIntroduction();
		
	}
	/**Tests features before the initial screens are implemented*/
	private void runTestCode() {
		// Test code
		ship.setName("UNSC Dawn");
		//crew.addNewCrewMembers(testMembers);
	}
	
	/**Gets the total number of days remaining*/
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
	/**Sets the current day*/
	public void setCurrentDay(int numDays) {
		this.currentDay = Math.max(numDays, 0);
	}
	/**Increments currentDay variable*/
	public void incrementCurrentDay() {
		currentDay++;  // DON'T use min/max.  Needs to be greater than total days to trigger game over
	}
	
	public int getShipPartsFound() {
		return shipPartsFound;
	}
	/**Increments shipPartsFound variable (when a new part is found)*/
	public void incrementShipPartsFound() {
		this.shipPartsFound = Math.min(shipPartsFound+1, shipPartsTotalMissing);;
	}
	
	public int getShipPartsTotalMissing() {
		return shipPartsTotalMissing;
	}
	/**Sets the total number of ship parts to be found and resets shipPartsFound to zero*/
	public void setShipParts(int shipPartsTotal) {
		shipPartsTotalMissing = shipPartsTotal;
		shipPartsFound = 0;
	}
	/**Checks if a condition is met to finish the game, either: All the crew are dead, the ship has been destroyed, 
	 * the player has run out of days, or all the ship parts have been found.  A game over could constitute a win 
	 * as well as a lose.*/
	public void checkForGameOver() {
		if (!ship.isAlive()) {
			initiateGameOver(SHIP_DEAD_MESSAGE);
		}
		if (!crew.isAlive()) {
			initiateGameOver(CREW_DEAD_MESSAGE);
		}
		if (currentDay > totalDays) {
			initiateGameOver(OUT_OF_DAYS_MESSAGE);
		}
		if (shipPartsFound >= shipPartsTotalMissing) {
			initiateGameOver(YOU_WIN_MESSAGE);
		}
		
	}
	/**Opens a new MessageBox with a message string (argument) followed by a blank line and the words "GAME OVER" (from variable GAME_OVER_MESSAGE)*/
	public void initiateGameOver(String message) {
		MessageBox messageBoxGameOver = new MessageBox(message + "\n\n" + GAME_OVER_MESSAGE, mainWindow);
		closeMainScreen(mainWindow);
	}
	/**Calls initiateGameOver with no message*/
	public void initiateGameOver() {
		initiateGameOver("");
	}
}
