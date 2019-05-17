package Environment.Events;

import Environment.Crew;
import Environment.GameEnvironment;
import Environment.MessageBox;
import Environment.Misc;

public class AsteroidBelt extends Event {
	
	private final String MESSAGE_ASTEROID_COLLISION = "Your ship has passed through an Asteroid Belt!\nYour shields have taken %d%% damage.";
	private final int SHIELD_DAMAGE = 50;
	private final int SHIELD_DAMAGE_RANDOM_RANGE = 10;
	
	public AsteroidBelt(GameEnvironment environment, Crew crew) {
		super(environment, crew);
		// TODO Auto-generated constructor stub
	}
	
	public void initiate() {
		int shieldDamageTaken = Misc.numberPlusMinusRandom(SHIELD_DAMAGE, SHIELD_DAMAGE_RANDOM_RANGE);
		this.environment.ship.addToSheildLevel(-shieldDamageTaken);
		MessageBox messageBoxAsteroidCollision = new MessageBox(String.format(MESSAGE_ASTEROID_COLLISION, shieldDamageTaken));
	}
}
