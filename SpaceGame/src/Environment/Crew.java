package Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Environment.CrewMemberTypes.CrewMember;

/**Container class for CrewMember objects.*/
public class Crew {
	
	final int MAX_CREW_MEMBERS = 4;
	final int HUNGER_INCREASE_PER_DAY = 20;
	final int STAMINA_INCREASE_PER_DAY = -20;
	final int RANDOM_RANGE = 3;
	
	// Fixed length list to store crew members
	private CrewMember[] members = new CrewMember[MAX_CREW_MEMBERS];
	//private List<CrewMember> members = Arrays.asList(new CrewMember[MAX_CREW_MEMBERS]);
	
	public Crew() {
	}
	/**Construct new Crew from List (ArrayList)*/
	public Crew(List<CrewMember> members) {
		addNewCrewMembers(members);
	}
	/**Construct new Crew from primitive array*/
	public Crew(CrewMember[] members) {
		addNewCrewMembers(members);
	}
	
	/**Adds a List of CrewMember to the members array.  Sets the CrewMember crewMemberID to the index in 
	 * the array that its in.*/
	public void addNewCrewMembers(CrewMember[] members) {
		List<CrewMember> membersList = new ArrayList<CrewMember>(members.length);
		for (CrewMember member: members) {
			membersList.add(member);
		}
		addNewCrewMembers(membersList);
	}
	/**Adds a primitive array of CrewMember to the members array.  Sets the CrewMember crewMemberID to the index in 
	 * the array that its in.*/
	public void addNewCrewMembers(List<CrewMember> members) {
		CrewMember nextMember;
		for (int i=0; i < members.size(); i++) {
			try {
				nextMember = members.get(i);
			} catch(java.lang.IndexOutOfBoundsException e1) {
				nextMember = null;
			}
			this.members[i] = nextMember;
			this.members[i].setCrewMemberID(i);
		}
	}
		
	/**Adds a CrewMember to the members array.  Sets the CrewMember crewMemberID to the index in 
	 * the array that its in.*/
	public void addCrewMember(CrewMember newCrewMember) {
		int crewListPosition = nextCrewMemberArrayIndex(members);
		members[crewListPosition] = newCrewMember;
		members[crewListPosition].setCrewMemberID(crewListPosition);
	}
	
	public int getNumCrewMembers() {
		int num = 0;
		for (CrewMember member: members) {
			if (member != null || member.isAlive()) {
				num++;
			}
		}
		return num;
	}
	
	/**Helper method that finds the next empty array slot that is either null or contains a dead CrewMwmber.*/
	private int nextCrewMemberArrayIndex(CrewMember[] members) {
		for (int crewListPosition=0; crewListPosition < MAX_CREW_MEMBERS; crewListPosition++) {
			if (members[crewListPosition] == null || !members[crewListPosition].isAlive()) {
				return crewListPosition;
			}
		}
		throw new ArrayIndexOutOfBoundsException("Ship is at capacity.  Max Capacity: " + MAX_CREW_MEMBERS);
	}
	
	
	
	/**Gets a crew member by crewMemberID.  If array is null or array out of bounds, returns a dead crew member*/
	public CrewMember getCrewMember(int crewMemberID) {
		if (members[crewMemberID] == null) {
			CrewMember deadCrewMember = new CrewMember("Dead Crew Member", crewMemberID);
			deadCrewMember.kill();
			return deadCrewMember;
		}
		try {
			return members[crewMemberID];
		}
		catch(ArrayIndexOutOfBoundsException e) {
			CrewMember deadCrewMember = new CrewMember("Dead Crew Member", crewMemberID);
			deadCrewMember.kill();
			return deadCrewMember;
		}
	}
	
	/**Return an ArrayList of CrewMembers with a given name*/
	public ArrayList<CrewMember> getCrewMembersByName(String name) {
		ArrayList<CrewMember> matchingCrew = new ArrayList<CrewMember>(MAX_CREW_MEMBERS);
		for (CrewMember member: members) {
			if (member.getName().toLowerCase().matches(name.toLowerCase())) {
				matchingCrew.add(member);
			}
		}
		return matchingCrew;
	}
	/**Return an ArrayList of CrewMembers with a given specialization*/
	public ArrayList<CrewMember> getCrewMembersBySpecialization(String specialization) {
		ArrayList<CrewMember> matchingCrew = new ArrayList<CrewMember>(MAX_CREW_MEMBERS);
		for (CrewMember member: members) {
			if (member.getSpecialization().toLowerCase().matches(specialization.toLowerCase())) {
				matchingCrew.add(member);
			}
		}
		return matchingCrew;
	}
	
	
	public void resetCrewForNewDay() {
		for (CrewMember member: members) {
			System.out.println(Misc.numberPlusMinusRandom(STAMINA_INCREASE_PER_DAY, RANDOM_RANGE));
			// Reset Actions
			member.setNumActionsReset();
			// Add Hunger
			member.addHunger(Misc.numberPlusMinusRandom(HUNGER_INCREASE_PER_DAY, RANDOM_RANGE));
			// Decrease Stamina
			member.addStamina(Misc.numberPlusMinusRandom(STAMINA_INCREASE_PER_DAY, RANDOM_RANGE));
			//Add space plague affects
		}
	}
//	private ArrayList<CrewMember> filterCrewByString(String)
//	
//	public void killCrewMember(int cremMemberID) {
//		
//	}
}
