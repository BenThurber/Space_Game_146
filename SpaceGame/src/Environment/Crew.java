package Environment;

import java.util.ArrayList;
import java.util.List;

/**Container class for CrewMember objects.*/
public class Crew {
	
	final int MAX_CREW_MEMBERS = 4;
	
	// Fixed length list to store crew members
	private CrewMember[] members = new CrewMember[MAX_CREW_MEMBERS];
	//private List<CrewMember> members = Arrays.asList(new CrewMember[MAX_CREW_MEMBERS]);
	
	/**Construct new Crew from List (ArrayList)*/
	public Crew(List<CrewMember> members) {
		addNewCrewMembersList(members);
	}
	/**Construct new Crew from primitive array*/
	public Crew(CrewMember[] members) {
		List<CrewMember> membersList = new ArrayList<CrewMember>(MAX_CREW_MEMBERS);
		for (CrewMember member: members) {
			membersList.add(member);
		}
		addNewCrewMembersList(membersList);
	}
	private void addNewCrewMembersList(List<CrewMember> members) {
		CrewMember nextMember;
		for (int i=0; i < MAX_CREW_MEMBERS; i++) {
			try {
				nextMember = members.get(i);
			} catch(java.lang.IndexOutOfBoundsException e1) {
				nextMember = null;
			}
			this.members[i] = nextMember;
		}
	}
	

		
	/**Adds a CrewMember to the members array.  Sets the CrewMember crewMemberID to the index in 
	 * the array that its in.*/
	public void addCrewMember(CrewMember newCrewMember) {
		int crewListPosition = nextCrewMemberArrayIndex(members);
		members[crewListPosition] = newCrewMember;
		members[crewListPosition].setCrewMemberID(crewListPosition);
	}
	/**Adds a new CrewMember to the members array from name, specialization.  Sets the CrewMember 
	 * crewMemberID to the index in the array that its in.*/
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
//	private ArrayList<CrewMember> filterCrewByString(String)
//	
//	public void killCrewMember(int cremMemberID) {
//		
//	}
}
