package Environment.Events;

import Environment.Crew;
import Environment.GameEnvironment;

import java.util.ArrayList;
import java.util.Random;

public class RandomEventGenerator {
	
	private static Random rand = new Random();
	private int chanceOfEventOccurance;
	private ArrayList<Event> possibleEvents;
	
	public RandomEventGenerator(int chanceOfEventOccurance, ArrayList<Event> possibleEvents) {
		this.chanceOfEventOccurance = chanceOfEventOccurance;
		this.possibleEvents = possibleEvents;
		
	}
	public RandomEventGenerator(ArrayList<Event> possibleEvents) {
		this(100, possibleEvents);
	}
	
	public void initiateRandomEvent() {
		this.getRandomEvent().initiate();
	}
	
	public Event getRandomEvent() {
		int eventIndex = rand.nextInt(possibleEvents.size());
		return possibleEvents.get(eventIndex);
	}

}
