package Environment;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**Container class for CrewMember objects.*/
public class Crew {
	
	final int MAX_CREW_MEMBERS = 4;
	
	// Fixed length list to store crew members
	private CrewMember[] members = new CrewMember[MAX_CREW_MEMBERS];
	//private List<CrewMember> members = Arrays.asList(new CrewMember[MAX_CREW_MEMBERS]);
	
	/**Adds a crew member to the members array.  Can accept either a CrewMember object, 
	 * or name and specialization.  Sets the CrewMember crewMemberID to the index in 
	 * the array that its in.*/
	public void addCrewMember(CrewMember newCrewMember) {
		int crewListPosition = nextCrewMemberArrayIndex(members);
		members[crewListPosition] = newCrewMember;
		members[crewListPosition].setCrewMemberID(crewListPosition);
	}
	public void addCrewMember(String name, String specialization) {
		int crewListPosition = nextCrewMemberArrayIndex(members);
		members[crewListPosition] = new CrewMember(name, specialization, crewListPosition);
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
	
	public CrewMember getCrewMember(int crewMemberID) {
		return members[crewMemberID];
	}
//	
//	public void killCrewMember(int cremMemberID) {
//		
//	}
}
