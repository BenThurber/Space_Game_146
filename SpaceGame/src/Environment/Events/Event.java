package Environment.Events;

import Environment.Crew;
import Environment.GameEnvironment;

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
	
}
