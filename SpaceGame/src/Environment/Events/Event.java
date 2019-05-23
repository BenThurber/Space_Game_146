package Environment.Events;

import java.util.ArrayList;

import Environment.Crew;
import Environment.GameEnvironment;
import Environment.CrewMemberTypes.CrewMember;

/**
 * Super Class event object which has method initiate.  Inherited by SpacePlague, AsteroidBelt, AlienPirates.
 * @author Benjamin Thurber
 * @author Blake Kayser
 *
 */
public class Event {
	
	protected GameEnvironment environment;
	protected Crew crew;
	private boolean active;
	
	/**
	 * Instantiate an Event, but don't initiate
	 * @param environment the current GameEnvironemnt
	 * @param crew the current Crew
	 */
	public Event(GameEnvironment environment, Crew crew) {
		this.environment = environment;
		this.crew = crew;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Apply the affects caused by the Event
	 */
	public void initiate() {
		System.out.println("Event Obj Initiated.  Nothing Happens");
	}
	/**
	 * Calls initiate() with no arguments. Doesen't do anything for this Class
	 * @param crewDurringEvent an ArrayList of CrewMembers
	 */
	public void initiate(ArrayList<CrewMember> crewDurringEvent) {
		initiate();
	}
	
}
