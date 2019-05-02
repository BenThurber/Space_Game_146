package Environment;

public class CrewMember {
	
	// Should attributes representing percentages be ints 0...100 or floats 0.0...1.0
	private int health = 100;
	private int hunger = 0;
	private int stamina = 100;
	private String name;  // Should crew members have individual names?
	
	/**Crew member sleeps and regains some amount of stamina (health?)*/
	public void sleep() {
		
	}
	
	/**Crew member eats and decreases some amount of hunger.*/
	public void eat() {
		
	}
	
	/**Crew member eats and regains some amount of health.*/
	public void useMedicalItem() {
		
	}
	
}