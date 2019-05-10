package Environment;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**Container class for CrewMember objects.*/
public class Crew {
	
	final int MAX_CREW_MEMBERS = 4;
	
	// Fixed length list to store crew members
	//private List<CrewMember> members = Arrays.asList(new CrewMember[MAX_CREW_MEMBERS]);
	private CrewMember[] members = new CrewMember[MAX_CREW_MEMBERS];
	
	/**Adds a crew member to the members array.  Can accept either a CrewMember object or name and specialization*/
	public void addCrewMember(CrewMember newCrewMember) {
		for (int crewListPosition=0; crewListPosition < MAX_CREW_MEMBERS; crewListPosition++) {
			if (members[crewListPosition] == null) {
				members[crewListPosition] = newCrewMember;
				members[crewListPosition].setCrewMemberID(crewListPosition);
				return;
			}
		}
		throw new ArrayIndexOutOfBoundsException("Ship is at capacity.  Max Capacity: " + MAX_CREW_MEMBERS);
	}
	public void addCrewMember(String name, String specialization) {
		for (int crewListPosition=0; crewListPosition < MAX_CREW_MEMBERS; crewListPosition++) {
			if (members[crewListPosition] == null) {
				members[crewListPosition] = new CrewMember(name, specialization, crewListPosition);
				return;
			}
		}
		throw new ArrayIndexOutOfBoundsException("Ship is at capacity.  Max Capacity: " + MAX_CREW_MEMBERS);
	}
	
	public void killCrewMemberCrewMember(int cremMemberID) {
		
	}
}
