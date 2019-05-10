package Environment;

public class GameEnvironment {
	
	private CrewMember[] testMembers = {new CrewMember("John", "Security"), new CrewMember("Cortana", "Scientist"), new CrewMember("Arbiter", "Security"), new CrewMember("Johnson", "Security")};
	
	public Ship ship = new Ship();
	private Crew crew = new Crew(testMembers);
	
	
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
		MainScreen window = new MainScreen(this);
		window.frame.setVisible(true);
	}
	

	
	
	public static void main(String[] args) {
		GameEnvironment environment = new GameEnvironment();
		environment.launchMainWindow();
	}
}
