package Environment.Events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import Environment.Crew;
import Environment.GameEnvironment;
import Environment.MessageBox;
import Environment.Misc;
import Environment.CrewMemberTypes.CrewMember;

/**
 * An Event that causes alien pirates to attack the ship.  
 * A certain amount of shield is lost and some crew members 
 * may lose health from attacks.  Can be reduced or 
 * negated with a security CrewMember.
 * @author Benjamin Thurber
 * @author Blake Kayser
 *
 */
public class AlienPirates extends Event {
	private final String MESSAGE_FULL_ALIEN_INVASION = "Your ship has been attacked by aliens! Your shields have taken %d%% and %d crew member(s) have taken serious damage. Fix them up before the aliens attack again!";
	private final String MESSAGE_PARTIAL_ALIEN_INVASION = "Your ship has been attacked by aliens! Thankfully your Security fended the cretins off, shields taking %d%% and %d crew member(s) mildly hurt.";
	private final String MESSAGE_AVOIDED_ALIEN_INVASION = "Aliens tried to attack your ship! Skillfully, your security fought them off, protecting the vessel.";
	private final int SHIELD_FULL_DAMAGE = -30;
	private final int SHIELD_PARTIAL_DAMAGE = -15;
	private final int SHIELD_DAMAGE_RANDOM_RANGE = 10;
	private final int MAX_SECUTIRY = 2;
	private final int HIGHEST_DIE_THAT_AVOIDS = 25;
	private final int MEMBER_FULL_DAMAGE = -33;
	private final int MEMBER_PARTIAL_DAMAGE = -16;
	private final int MEMBER_DAMAGE_RANDOM_RANGE = 10;
	private final int MIN_CREW_AFFECTED = 1;
	private final int NUM_LESS_THAN_MAX_CREW = 1;
	
	/**
	 * Instantiate an Event, but don't initiate
	 * @param environment the current GameEnvironment
	 * @param crew the current Crew
	 */
	public AlienPirates(GameEnvironment environment, Crew crew) {
		super(environment, crew);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Apply the affects caused by the Event
	 * @param numSecurity the number of Security crew members that are part of the crew
	 */
	private void initiate(int numSecurity) {
		Random rand = new Random();
		if (numSecurity == 0) {
			didNotAvoidAliens();
			return;
		}
		
		// Low die roll is good
		int navigatorAvoidenceDieRoll = rand.nextInt(100) / Math.min(numSecurity, MAX_SECUTIRY);
		if (navigatorAvoidenceDieRoll > HIGHEST_DIE_THAT_AVOIDS) {
			didNotAvoidAliens();
		} else if (navigatorAvoidenceDieRoll <= HIGHEST_DIE_THAT_AVOIDS && navigatorAvoidenceDieRoll > HIGHEST_DIE_THAT_AVOIDS/2) {
			avoidedSomeAliens();
		} else if (navigatorAvoidenceDieRoll <= HIGHEST_DIE_THAT_AVOIDS/2) {
			avoidedAllAliens();
		}
	}

	/**If no arguments are given, uses the number of Navigators in the Crew (piloting or not)*/
	public void initiate() {		
		initiate(crew.getCrewMembersBySpecialization("security").size());
	}
	
	/**Case when all alien damage is avoided*/
	private void avoidedAllAliens() {
		System.out.println("Avoided all collisions");
		MessageBox messageBoxAvoidedAlienInvasion = new MessageBox(MESSAGE_AVOIDED_ALIEN_INVASION);
	}
	
	/**Case when some alien damage is taken*/
	private void avoidedSomeAliens() {
		int shieldDamageTaken = Misc.numberPlusMinusRandom(SHIELD_PARTIAL_DAMAGE, SHIELD_DAMAGE_RANDOM_RANGE);
		this.environment.ship.addToSheildLevel(shieldDamageTaken);
		int numHurtMembers = hurtMembersAttacked(MEMBER_PARTIAL_DAMAGE);
		MessageBox messageBoxFullAlienInvasion = new MessageBox(String.format(MESSAGE_PARTIAL_ALIEN_INVASION, Math.abs(shieldDamageTaken), numHurtMembers));
	}
	
	/**Case when full alien damage is taken*/
	private void didNotAvoidAliens() {
		int shieldDamageTaken = Misc.numberPlusMinusRandom(SHIELD_FULL_DAMAGE, SHIELD_DAMAGE_RANDOM_RANGE);
		this.environment.ship.addToSheildLevel(shieldDamageTaken);
		int numHurtMembers = hurtMembersAttacked(MEMBER_FULL_DAMAGE);
		MessageBox messageBoxFullAlienInvasion = new MessageBox(String.format(MESSAGE_FULL_ALIEN_INVASION, Math.abs(shieldDamageTaken), numHurtMembers));
	}
	
	/**
	 * Applies attacks to CrewMembers.  Gets the crew members from randomCrewList()
	 * @param hurtMembersDamage the amount of damage to take per crew member
	 * @return The number of CrewMembers attacked
	 */
	private int hurtMembersAttacked(int hurtMembersDamage) {
		ArrayList<CrewMember> liveCrew = randomCrewList();
		int minNumCrewAffected = Math.min(liveCrew.size(), MIN_CREW_AFFECTED);
		int maxNumCrewAffected = Math.max(1, liveCrew.size()-NUM_LESS_THAN_MAX_CREW);
		int numCrewAffected = Misc.numberRandomMinMax(minNumCrewAffected, maxNumCrewAffected);
		for (int i=0; i < numCrewAffected; i++) {
			liveCrew.get(i).addHealth(Misc.numberPlusMinusRandom(hurtMembersDamage, MEMBER_DAMAGE_RANDOM_RANGE));
		}
		return(numCrewAffected);
	}
	
	/**Returns a random ArrayList of Crew Members with Security at the begginging of the ArrayList*
	 * @return ArrayList of CrewMembers
	 */
	private ArrayList<CrewMember> randomCrewList() {
		ArrayList<CrewMember> liveCrew = new ArrayList<CrewMember>(Arrays.asList(crew.getLiveCrewMemberArray()));
		ArrayList<CrewMember> securityPriority = crew.getCrewMembersBySpecialization("security");
		Collections.shuffle(securityPriority);
		Collections.shuffle(liveCrew);
		for(CrewMember member: liveCrew) {
			if(!(member.getSpecialization().equals("security"))) {
				securityPriority.add(member);
			}
		}
		System.out.println("Size of live crew: " + liveCrew.size());
		return securityPriority;
	}
}
