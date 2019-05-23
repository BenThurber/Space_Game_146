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
	
	public Event(GameEnvironment environment, Crew crew) {
		this.environment = environment;
		this.crew = crew;
		// TODO Auto-generated constructor stub
	}
	
	public void initiate() {
		System.out.println("Event Obj Initiated.  Nothing Happens");
	}
	public void initiate(ArrayList<CrewMember> crewDurringEvent) {
		initiate();
	}
	
}
