package Environment.Events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Set;

import Environment.Crew;
import Environment.GameEnvironment;
import Environment.MessageBox;
import Environment.Misc;
import Environment.CrewMemberTypes.CrewMember;

/**
 * An Event that causes some amount of crew members to come down with space plague.
 * @author Benjamin Thurber
 * @author Blake Kayser
 *
 */
public class SpacePlague extends Event {
	
	private final String MESSAGE_GOT_PLAGUE = "%d of your crew members have come down with Space Plague.\n\nThose affected have a purple health bar and will loose health with each day.\n\nHeal the plague on affected crew members by using a medical item.";
	
	private final int MIN_CREW_AFFECTED = 1;
	private final int NUM_LESS_THAN_MAX_CREW = 1;
	
	/**
	 * Instantiate an Event, but don't initiate
	 * @param environment
	 * @param crew
	 */
	public SpacePlague(GameEnvironment environment, Crew crew) {
		super(environment, crew);
		// TODO Auto-generated constructor stub
	}
	
	public void initiate() {
		ArrayList<CrewMember> liveCrew = new ArrayList<CrewMember>(Arrays.asList(crew.getLiveCrewMemberArray()));
		Collections.shuffle(liveCrew);
		System.out.println("Size of live crew: " + liveCrew.size());
		int minNumCrewAffected = Math.min(liveCrew.size(), MIN_CREW_AFFECTED);
		int maxNumCrewAffected = Math.max(1, liveCrew.size()-NUM_LESS_THAN_MAX_CREW);
		int numCrewAffected = Misc.numberRandomMinMax(minNumCrewAffected, Math.max(1, liveCrew.size()-NUM_LESS_THAN_MAX_CREW));
		for (int i=0; i < numCrewAffected; i++) {
			liveCrew.get(i).setHasSpacePlague(true);
		}
		
		MessageBox messageBoxAsteroidCollision = new MessageBox(String.format(MESSAGE_GOT_PLAGUE, numCrewAffected));
	}
	
}
