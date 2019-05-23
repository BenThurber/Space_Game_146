package Environment.Events;

import Environment.Crew;
import Environment.GameEnvironment;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class to handle which random event is executed randomly.  Takes an ArrayList of Events and spits one out when wanted.
 * @author Benjamin Thurber
 * @author Blake Kayser
 *
 */
public class RandomEventGenerator {
	
	private static Random rand = new Random();
	private int chanceOfEventOccurance;
	private ArrayList<Event> possibleEvents;
	

	public RandomEventGenerator(ArrayList<Event> possibleEvents) {
		this.possibleEvents = possibleEvents;
	}
	
	public void initiateRandomEvent() {
		this.getRandomEvent().initiate();
	}
	
	public Event getRandomEvent() {
		int eventIndex = rand.nextInt(possibleEvents.size());
		return possibleEvents.get(eventIndex);
	}

}
