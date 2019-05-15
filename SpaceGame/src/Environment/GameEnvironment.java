package Environment;

import java.util.ArrayList;

import Environment.CrewMemberTypes.Captain;
import Environment.CrewMemberTypes.Communicator;
import Environment.CrewMemberTypes.CrewMember;
import Environment.CrewMemberTypes.Engineer;
import Environment.CrewMemberTypes.Navigator;
import Environment.CrewMemberTypes.Scientist;
import Environment.Locations.Location;
import Environment.Locations.Planet;
import Environment.Locations.SpaceOutpost;

public class GameEnvironment {
	
	private final String NOT_ENOUGH_CREW_MEMBERS_MSG = "You don't have enough Crew Members to pilot the ship\n"
			+ "(or they have no more actions).\n\nSelect \"Pilot Ship\" as an action for atleast %d crew members and try again.";
	private final String NEXT_DAY_NESSAGE = "Day %d of %d\n\nA new day has begun.  Your Crew have new actions that they can perfom.";
	private final int MIN_CREW_TO_PILOT_SHIP = 2;
	
	private CrewMember[] testMembers = {new Scientist("John"), new Communicator("Cortana"), new Captain("Keys"), new Navigator("Arbiter")};
	
	private int totalDays = 0;
	private int currentDay = 0;
	private int shipPartsFound = 0;
	private int shipPartsTotalMissing = 0;
	
	public Ship ship = new Ship();
	public Crew crew = new Crew(testMembers);
	public Location currentLocation = new Location();
	
	private MainScreen window;
	
	
	public void visitSpaceOutpost() {
		System.out.println("Visiting Space Outpost");
		currentLocation = new SpaceOutpost();
		ship.setLocation(currentLocation);
		window.update();
	}
	public void moveToNextPlanet() {
		ArrayList<CrewMember> membersWithAction = crewMembersWithAction(crew, window, "pilot ship", MIN_CREW_TO_PILOT_SHIP, new Navigator("blank"));
		if (membersWithAction.size() < MIN_CREW_TO_PILOT_SHIP) {
			MessageBox newDayMsg = new MessageBox(String.format(NOT_ENOUGH_CREW_MEMBERS_MSG, MIN_CREW_TO_PILOT_SHIP));
			return;
		}
		System.out.println(membersWithAction);
		System.out.println("Moving to Next Planet");
		for (CrewMember member: membersWithAction) {
			executeCrewMemberAction(member, "pilot ship");
		}
		currentLocation = new Planet();
		ship.setLocation(currentLocation);
		// Do asteroid belt
		window.update();
	}
	public void startNextDay() {
		System.out.println("Starting Next Day");
		incrementCurrentDay();
		MessageBox newDayMsg = new MessageBox(String.format(NEXT_DAY_NESSAGE, getCurrentDay(), getTotalDays()));
		crew.resetCrewForNewDay();
		// Implement random event here
		window.update();
	}
	public void viewInventory() {
		System.out.println("Viewing Inventory");
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
			member.useMedicalItem();
			break;
		case "repair sheilds":
			member.repairSheilds(ship);
			break;
		case "search planet":
			break;
		case "pilot ship":
			member.pilotShip();
			break;
		}
		window.update();  //Refresh the window?
	}
	/**Takes a Crew, MainScreen, Action string, numMembersRequired, and Subclass of CrewMember (to determine preferred type).  
	 * Returns an ArrayList of CrewMembers (Captain, Scientist, Navigator, etc.) with a remaining action and who's action JComboBox 
	 * has the desired action selected. The ArrayList will be less than or equal in size to numMembersRequired.
	 * If there are more CrewMembers than fit, it chooses the preferred type of crew member first.*/
	private ArrayList<CrewMember> crewMembersWithAction(Crew crew, MainScreen window, String action, int numMembersRequired, CrewMember preferredMemberType) {
		//Build an ArrayList of all crew members that have action selected on their JComboBox
		action = action.toLowerCase();
		ArrayList<CrewMember> matchingCrewMembers = new ArrayList<CrewMember>(crew.MAX_CREW_MEMBERS);
		for (int iD=0; iD < crew.MAX_CREW_MEMBERS; iD++) {
			// If CrewMember is alive, has an action, and has the correct JComboBox item selected
			if (crew.getCrewMember(iD).isAlive() && crew.getCrewMember(iD).getNumActions() > 0 && window.getSelectedNextAction(iD).equals(action)) {
				matchingCrewMembers.add(crew.getCrewMember(iD));
			}
		}
		// If ArrayList not larger than numMembersRequired return.  Otherwise filter out until right size
		if (matchingCrewMembers.size() <= numMembersRequired) return matchingCrewMembers;
		
		//Build a new ArrayList by adding just crew members that are of preferred type
		ArrayList<CrewMember> preferredCrewMembers = new ArrayList<CrewMember>(numMembersRequired);
		for (CrewMember member: matchingCrewMembers) {
			// If member is preferred type and don't over-fill the ArrayList
			if (member.getSpecialization().equals(preferredMemberType.getSpecialization()) && preferredCrewMembers.size() < numMembersRequired) {
				preferredCrewMembers.add(member);
			}
		}
		// If array list is full of preferred crew members return.  Otherwise start adding ones that are not preferred to fill the list.
		if (preferredCrewMembers.size() <= numMembersRequired) return preferredCrewMembers;
		
		//Add crew members that are not preferred to fill the list then return
		for (CrewMember member: matchingCrewMembers) {
			// If member is NOT preferred type
			if (!member.getSpecialization().equals(preferredMemberType.getSpecialization())) {
				preferredCrewMembers.add(member);
			}
		}
		return preferredCrewMembers;
	}
	//private boolean haveRequiredCrewMembersForAction(Crew crew, MainScreen window, String action, int numCrewMembersRequired)
//	public void executeCrewMemberAction(CrewMember member, JComboBox crewMemberComboBox) {
//		executeCrewMemberAction(member, crewMemberComboBox.getSelectedItem().toString());
//		crewMemberComboBox.setSelectedIndex(0);
//	}
	
	
	public void launchMainWindow() {
		//Introduction introduction = new Introduction(this);
		
		window = new MainScreen(this);
		window.frame.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		GameEnvironment environment = new GameEnvironment();
		environment.runTestCode();
		environment.launchMainWindow();
		
	}
	
	private void runTestCode() {
		// Test code
		ship.setName("UNSC Dawn");
		ship.addToSheildLevel(-32);
		//ship.setLocation("Installation 04");
		setDays(5);
		
		for (int i=0; i < 4; i++) {
			testMembers[i].addHunger(+65);
			testMembers[i].addHealth(-69);
			testMembers[i].addStamina(-14);
		}
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
}
