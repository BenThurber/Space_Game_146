package Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Environment.CrewMemberTypes.CrewMember;

/**Container class for CrewMember objects.
 * @author Benjamin Thurber
 * @author Blake Kayser
 * */
public class Crew {
	
	final int MAX_CREW_MEMBERS = 4;
	final int HUNGER_INCREASE_PER_DAY = 20;
	final int EXHAUSTION_INCREASE_PER_DAY = 20;
	final int PLAGUE_HEALTH_INCREASE_PER_DAY = -50;
	final int RANDOM_RANGE = 5;
	
	
	// ArrayList to store crew members
	private ArrayList<CrewMember> members = new ArrayList<CrewMember>(MAX_CREW_MEMBERS);
	
	/**Initializes a Crew with blank (dead) crew members*/
	public Crew() {
	}
	/**Construct new Crew from List (ArrayList)
	 * @param members List object of crew members to initialize with
	 */
	public Crew(List<CrewMember> members) {
		addNewCrewMembers(members);
	}
	/**Construct new Crew from primitive array
	 * @param members primitive array to initialize with
	 */
	public Crew(CrewMember[] members) {
		addNewCrewMembers(members);
	}
	
	/**Adds a primitive array of CrewMember to the members array.  Sets the CrewMember crewMemberID to the index in 
	 * the array that its in.
	 * @param newMembers primitive array to initialize with
	 */
	public void addNewCrewMembers(CrewMember[] newMembers) {
		List<CrewMember> membersList = new ArrayList<CrewMember>(newMembers.length);
		for (CrewMember member: newMembers) {
			if (member != null) {
				membersList.add(member);
			}
			
		}
		addNewCrewMembers(membersList);
	}
	/**Adds a List of CrewMember to the members array.  Sets the CrewMember crewMemberID to the index in 
	 * the array that its in.
	 * @param members List object of crew members to initialize with
	 */
	public void addNewCrewMembers(List<CrewMember> members) {
		this.members.clear();
		CrewMember nextMember;
		for (int i=0; i < members.size() && i < MAX_CREW_MEMBERS; i++) {
			try {
				nextMember = members.get(i);
				this.addCrewMember(nextMember);
				//this.members.get(i).setCrewMemberID(i);
			} catch(java.lang.IndexOutOfBoundsException e1) {
				continue;
			}
		}
	}

	/**Adds a CrewMember to the members array.  Sets the CrewMember crewMemberID to the index in 
	 * the array that its in.
	 * @param newCrewMember single CrewMember object to add
	 */
	public void addCrewMember(CrewMember newCrewMember) {
		if (members.size() < MAX_CREW_MEMBERS) {
			members.add(newCrewMember);
			newCrewMember.setCrewMemberID(members.indexOf(newCrewMember));
		}
	}
	
	public int getNumCrewMembers() {
		return members.size();
	}
	
	/**Helper method that finds the next empty array slot that is either null or contains a dead CrewMember.
	 * @param members the crew member array or another array
	 * @return an index of the next place to put a crew member in the array
	 */
	private int nextCrewMemberArrayIndex(CrewMember[] members) {
		for (int crewListPosition=0; crewListPosition < MAX_CREW_MEMBERS; crewListPosition++) {
			if (members[crewListPosition] == null || !members[crewListPosition].isAlive()) {
				return crewListPosition;
			}
		}
		throw new IndexOutOfBoundsException("Ship is at capacity.  Max Capacity: " + MAX_CREW_MEMBERS);
	}
	
	
	
	/**Gets a crew member by crewMemberID.  If array is null or array out of bounds, returns a dead crew member
	 * @param crewMemberID an index (typically 0 to 3) of the position of the desired crew member in the array
	 * @return the Desired CrewMember object
	 */
	public CrewMember getCrewMember(int crewMemberID) {
		try {
			if (members.get(crewMemberID) == null) {
				CrewMember deadCrewMember = new CrewMember("Dead Crew Member", crewMemberID);
				deadCrewMember.kill();
				return deadCrewMember;
			}
			return members.get(crewMemberID);
		}
		catch(IndexOutOfBoundsException e) {
			CrewMember deadCrewMember = new CrewMember("Dead Crew Member", crewMemberID);
			deadCrewMember.kill();
			return deadCrewMember;
		}
	}
	
	/**Return an ArrayList of CrewMembers with a given name (don't need to be alive)
	 * @param name string of the name of the CrewMember you'd like the method to return
	 * @return desired CrewMember object
	 */
	public ArrayList<CrewMember> getCrewMembersByName(String name) {
		ArrayList<CrewMember> matchingCrew = new ArrayList<CrewMember>(MAX_CREW_MEMBERS);
		for (CrewMember member: members) {
			if (member.getName().toLowerCase().matches(name.toLowerCase())) {
				matchingCrew.add(member);
			}
		}
		return matchingCrew;
	}
	/**Return an ArrayList of CrewMembers with a given specialization with boolean deadOrAlive which includes dead crew if true
	 * @param specialization a string of the desired specialization you want the CrewMember to have. 
	 * @param deadOrAlive if true includes dead crew members in the search.
	 * @return desired CrewMember object
	 */
	public ArrayList<CrewMember> getCrewMembersBySpecialization(String specialization, boolean deadOrAlive) {
		ArrayList<CrewMember> matchingCrew = new ArrayList<CrewMember>(MAX_CREW_MEMBERS);
		for (CrewMember member: members) {
			if (member.getSpecialization().toLowerCase().matches(specialization.toLowerCase()) && (member.isAlive() || deadOrAlive)) {
				matchingCrew.add(member);
			}
		}
		return matchingCrew;
	}
	/**Return an ArrayList of CrewMembers with a given specialization and are alive
	 * @param specialization a string of the desired specialization you want the CrewMember to have.  
	 * @return desired CrewMember object
	 */
	public ArrayList<CrewMember> getCrewMembersBySpecialization(String specialization) {
		return getCrewMembersBySpecialization(specialization, false);
	}
	
	/**Returns the array of CrewMembers held in Crew
	 * @return the array of CrewMembers held in Crew
	 */
	public ArrayList<CrewMember> getCrewMemberArray() {
		return members;
	}
	
	/**Returns number of live CrewMembers in Crew
	 * @return integer of number of crew members
	 */
	public int getNumLiveCrew() {
		int numLive = 0;
		for (int i=0; i < members.size(); i++) {
			if (members.get(i) != null && members.get(i).isAlive()) {
				numLive++;
			}
		}
		return numLive;
	}
	/**Returns an array of all CrewMembers that are alive
	 * @return primitive array holding all crew members that are alive
	 */
	public CrewMember[] getLiveCrewMemberArray() {
		CrewMember[] liveMembers = new CrewMember[this.getNumLiveCrew()];
		int i = 0;
		for (CrewMember member: members) {
			if (member.isAlive()) {
				liveMembers[i] = member;
				i++;
			}
		}
		return liveMembers;
	}
	
	/**Sets the number of actions of each CrewMember to max.  Increases hunger, decreases exhaustion and decreases health if CrewMember has space plague.*/
	public void resetCrewForNewDay() {
		for (CrewMember member: members) {
			// Reset Actions
			member.setNumActionsReset();
			// Add Hunger
			member.addHunger(Misc.numberPlusMinusRandom(HUNGER_INCREASE_PER_DAY, RANDOM_RANGE));
			// Decrease Exhaustion
			member.addExhaustion(Misc.numberPlusMinusRandom(EXHAUSTION_INCREASE_PER_DAY, RANDOM_RANGE));
			//Add space plague affects
			if (member.hasSpacePlague()) {
				member.addHealth(Misc.numberPlusMinusRandom(PLAGUE_HEALTH_INCREASE_PER_DAY, RANDOM_RANGE));
			}
		}
	}
	
	/**Returns true if any of the crew are alive
	 * @return true if all CrewMembers are alive
	 */
	public boolean isAlive() {
		for (CrewMember member: members) {
			if (member.isAlive()) {
				return true;
			}
		}
		return false;
	}
}
