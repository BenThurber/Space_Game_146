package Environment;

import Environment.CrewMemberTypes.Captain;
import Environment.CrewMemberTypes.Communicator;
import Environment.CrewMemberTypes.CrewMember;
import Environment.CrewMemberTypes.Engineer;
import Environment.CrewMemberTypes.Scientist;

public class GameEnvironment {
	
	private static CrewMember[] testMembers = {new Scientist("John"), new Communicator("Cortana"), new Captain("Keys"), new Engineer("Arbiter")};
	
	public Ship ship = new Ship();
	public Crew crew = new Crew(testMembers);
	
	private MainScreen window;
	
	
	public void visitSpaceOutpost() {
		System.out.println("Visiting Space Outpost");
	}
	public void moveToNextPlanet() {
		System.out.println("Moving to Next Planet");
	}
	public void startNextDay() {
		System.out.println("Starting Next Day");
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
		ship.setLocation("Installation 04");
		ship.setShipPartsTotalMissing(5);
		ship.setShipPartsFound(1);
		
		for (int i=0; i < 4; i++) {
			System.out.println(i);
			testMembers[i].addHunger(+65);
			testMembers[i].addHealth(-69);
			testMembers[i].addStamina(-14);
		}
	}
}
