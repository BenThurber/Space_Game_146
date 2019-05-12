package Environment;

public class GameEnvironment {
	
	private static CrewMember[] testMembers = {new CrewMember("John", "Security"), new CrewMember("Cortana", "Scientist"), new CrewMember("Arbiter", "Navigator"), new CrewMember("Keys", "Captain")};
	
	public static Ship ship = new Ship();
	public static Crew crew = new Crew(testMembers);
	
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
	
	
	
	public void launchMainWindow() {
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
		
		testMembers[0].addHunger(+22);
		testMembers[3].addHealth(-69);
		testMembers[0].addHealth(-37);
		testMembers[2].addStamina(-14);
		testMembers[1].decrementNumActions();
		testMembers[1].decrementNumActions();
		testMembers[1].decrementNumActions();
		testMembers[0].decrementNumActions();
	}
}
