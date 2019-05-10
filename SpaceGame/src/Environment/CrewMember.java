package Environment;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class CrewMember {
	
	private final Set<String> SPECIALIZATIONS = new HashSet<String>(Arrays.asList(
		     new String[] {"engineer", "scientist", "doctor", "navigator", "captain", "communications", "security"}
		));
	
	private String name;
	private String specialization;
	private int health = 100;
	private int stamina = 100;
	private boolean isAlive = true;
	// Integer to identify where CrewMember belongs in the array in Crew and where it goes in the GUI
	private int crewMemberID;
	
	
	public CrewMember(String name, String specialization, int cremMemberID) {
		this.setName(name);
		this.setSpecialization(specialization);
		this.setCrewMemberID(cremMemberID);
	}
	public CrewMember(String name, String specialization) {
		this.setName(name);
		this.setSpecialization(specialization);
		this.setCrewMemberID(0);
	}
	
	/**Crew member sleeps and regains some amount of stamina (health?)*/
	public void sleep() {
		
	}
	
	/**Crew member eats and increases some amount of stamina and health.*/
	public void eat() {
		
	}
	
	/**Crew member eats and regains some amount of health.*/
	public void useMedicalItem() {
		
	}

	public int getHealth() {
		return health;
	}
	/**Sets health.  If dropped to 0 CrewMember dies.*/
	public void setHealth(int health) {
		this.health = Math.max(Math.min(health, 100), 0);
		if (this.health == 0) {
			this.kill();
		}
	}
	public int getStamina() {
		return stamina;
	}
	/**Sets stamina.  If dropped to 0 CrewMember dies.*/
	public void setStamina(int stamina) {
		this.stamina = Math.max(Math.min(stamina, 100), 0);
		if (this.stamina == 0) {
			this.kill();
		}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isAlive() {
		return isAlive;
	}
	public void kill() {
		this.isAlive = false;
	}

	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		if (SPECIALIZATIONS.contains(specialization.toLowerCase())) {
			this.specialization = specialization;
		} else {
			throw new IllegalArgumentException("CrewMember has an invalid specialization.");
		}
	}

	public int getCrewMemberID() {
		return crewMemberID;
	}
	public void setCrewMemberID(int crewMemberID) {
		this.crewMemberID = crewMemberID;
	}
	
	
	
}