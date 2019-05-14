package Environment;

import javax.swing.JComboBox;

import Environment.CrewMemberTypes.Captain;
import Environment.CrewMemberTypes.Communicator;
import Environment.CrewMemberTypes.CrewMember;
import Environment.CrewMemberTypes.Engineer;
import Environment.CrewMemberTypes.Scientist;
import Environment.Locations.Location;
import Environment.Locations.Planet;
import Environment.Locations.SpaceOutpost;

public class GameEnvironment {
	
	private CrewMember[] testMembers = {new Scientist("John"), new Communicator("Cortana"), new Captain("Keys"), new Engineer("Arbiter")};
	
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
		System.out.println("Moving to Next Planet");
		currentLocation = new Planet();
		ship.setLocation(currentLocation);
		// Do asteroid belt
		window.update();
	}
	public void startNextDay() {
		System.out.println("Starting Next Day");
		incrementCurrentDay();
		MessageBox newDayMsg = new MessageBox(String.format("A new day has begun.\n\nDay %d of %d", getCurrentDay(), getTotalDays()));
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
			break;
		}
		window.update();  //Refresh the window?
	}
	public void executeCrewMemberAction(CrewMember member, JComboBox crewMemberComboBox) {
		executeCrewMemberAction(member, crewMemberComboBox.getSelectedItem().toString());
		crewMemberComboBox.setSelectedIndex(0);
	}
	
	
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
