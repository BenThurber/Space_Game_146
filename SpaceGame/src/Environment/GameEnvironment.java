package Environment;

public class GameEnvironment {
	
	private static CrewMember[] testMembers = {new CrewMember("John", "Security"), new CrewMember("Cortana", "Scientist"), new CrewMember("Arbiter", "Security"), new CrewMember("Keys", "Captain")};
	
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
	
	
	
	public void launchMainWindow() {
		window = new MainScreen(this);
		window.frame.setVisible(true);
	}
	

	
	
	public static void main(String[] args) {
		GameEnvironment environment = new GameEnvironment();
		// Test code
		testMembers[0].addHealth(-1);
		testMembers[3].addHealth(-50);
		testMembers[2].addStamina(-10);
		testMembers[1].decrementNumActions();
		testMembers[1].decrementNumActions();
		testMembers[1].decrementNumActions();
		testMembers[0].decrementNumActions();
		environment.launchMainWindow();
		
	}
}
