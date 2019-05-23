package Environment.Events;

import java.util.ArrayList;
import java.util.Random;

import Environment.Crew;
import Environment.GameEnvironment;
import Environment.MessageBox;
import Environment.Misc;
import Environment.CrewMemberTypes.CrewMember;


/**
 * An Event that causes the ship to pass through an asteroid belt and lose shield energy.  
 * Can be reduced or negated with one or two Navigators (effect stacks)
 * @author Benjamin Thurber
 * @author Blake Kayser
 *
 */
public class AsteroidBelt extends Event {
	
	private final String MESSAGE_ASTEROID_FULL_COLLISION = "Your ship has passed through an Asteroid Belt!\n\nYour shields have taken %d%% damage.";
	private final String MESSAGE_ASTEROID_PARTIAL_COLLISION = "Your ship has passed through an Asteroid Belt, but your Navigator(s) were able to avoid most of the damage.\n\nYour shields have taken %d%% damage.";
	private final String MESSAGE_ASTEROID_AVOIDED_COLLISION = "Your ship has passed through an Asteroid Belt, but your Navigator(s) skillfuly piloted your ship through it, and avoided damage";
	private final int SHIELD_FULL_DAMAGE = 50;
	private final int SHIELD_PARTIAL_DAMAGE = 15;
	private final int SHIELD_DAMAGE_RANDOM_RANGE = 10;
	private final int MAX_NAVIGATORS = 2;
	private final int HIGHEST_DIE_THAT_AVIODs = 25;
	
	public AsteroidBelt(GameEnvironment environment, Crew crew) {
		super(environment, crew);
		// TODO Auto-generated constructor stub
	}
	
	private void initiate(int numNavigators) {
		Random rand = new Random();
		if (numNavigators == 0) {
			didNotAvoidAsteroids();
			return;
		}
		
		// Low die roll is good
		int navigatorAvoidenceDieRoll = rand.nextInt(100) / Math.min(numNavigators, MAX_NAVIGATORS);
		if (navigatorAvoidenceDieRoll > HIGHEST_DIE_THAT_AVIODs) {
			didNotAvoidAsteroids();
		} else if (navigatorAvoidenceDieRoll <= HIGHEST_DIE_THAT_AVIODs && navigatorAvoidenceDieRoll > HIGHEST_DIE_THAT_AVIODs/2) {
			avoidedSomeAsteroids();
		} else if (navigatorAvoidenceDieRoll <= HIGHEST_DIE_THAT_AVIODs/2) {
			avoidedAllAsteroids();
		}
	}
	/**Takes a list of crew members piloting the ship and determines how many are navigators*/
	public void initiate(ArrayList<CrewMember> crewPiloting) {
		int numNavigators = 0;
		for (CrewMember member: crewPiloting) {
			if (member.getSpecialization().equals("navigator")) {
				numNavigators++;
			}
		}
		initiate(numNavigators);
	}
	/**If no arguments are given, uses the number of Navigators in the Crew (piloting or not)*/
	public void initiate() {
		ArrayList<CrewMember> allNavigators = crew.getCrewMembersBySpecialization("navigator");
		initiate(allNavigators.size());
	}
	
	
	private void avoidedAllAsteroids() {
		System.out.println("Avoided all collisions");
		MessageBox messageBoxAvoidedAsteroidCollision = new MessageBox(MESSAGE_ASTEROID_AVOIDED_COLLISION);
	}
	private void avoidedSomeAsteroids() {
		int shieldDamageTaken = Misc.numberPlusMinusRandom(SHIELD_PARTIAL_DAMAGE, SHIELD_DAMAGE_RANDOM_RANGE);
		this.environment.ship.addToSheildLevel(-shieldDamageTaken);
		MessageBox messageBoxPartialAsteroidCollision = new MessageBox(String.format(MESSAGE_ASTEROID_PARTIAL_COLLISION, shieldDamageTaken));
	}
	private void didNotAvoidAsteroids() {
		int shieldDamageTaken = Misc.numberPlusMinusRandom(SHIELD_FULL_DAMAGE, SHIELD_DAMAGE_RANDOM_RANGE);
		this.environment.ship.addToSheildLevel(-shieldDamageTaken);
		MessageBox messageBoxFullAsteroidCollision = new MessageBox(String.format(MESSAGE_ASTEROID_FULL_COLLISION, shieldDamageTaken));
	}
}
