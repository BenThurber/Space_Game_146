package Environment.Locations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Planet extends Location {
	
	// Credit for names: https://www.fantasynamegenerators.com/planet_names.php
	private static final String[] names = {"Bucater", "Hubraorilia", "Kizinda", "Hotrolla", 
	                                 "Xehiri", "Umia", "Struropra", "Thoaliv", 
	                                 "Charth 66E", "Thomia 9TE", "Gocawei", "Ethaeria", 
	                                 "Viseron", "Ethadus", "Leibos", "Ialara", 
	                                 "Gnolecarro", "Trazuliv", "Diea FWWP", "Cradus GF4", 
	                                 "Salnaruta", "Zonreozuno", "Zustrade", "Cenion", 
	                                 "Luitune", "Chocury", "Chiepra", "Phixonides", 
	                                 "Vorth MHP", "Doria G", "Dodruapra", "Vuchuliv", 
	                                 "Abbuna", "Yoborth", "Novis", "Zoitera", 
	                                 "Ziaruta", "Gnoduthea", "Zeron 0Y0", "Coria GB"};
	
	// These 3 variables are static so that planetFileNames is shuffled once, then keeps its value.  
	// Each time a planet is instantiated, the next planet image in the array is used, so duplicate images aren't displayed.
	private static ArrayList<String> planetFileNames = new ArrayList<String>(Arrays.asList(
			"mercury.jpg", "venus.jpg", "earth.jpg", "mars.jpg", "jupiter.jpg", 
				"saturn.jpg", "neptune.jpg", "uranus.jpg", "pluto.jpg"
	));
	private static int planetIndex = 0;
	private static boolean imagesShuffled = false;
	
	private final String directoryPrefix = "/Images/Locations/Planets/";
	
	public final String type = "Planet";
	
	protected final int SHIP_PART_EXISTS_CHANCE = 75;
	
	private boolean containsShipPart = false;
	private boolean containsFood = false;
	private boolean containsMedicalItem = false;
	private boolean containsMoney = false;
	
	
	
	// When a new planet is instantiated, it generates random attributes; name, image, etc.
	public Planet() {
		Random rand = new Random();
		this.name = names[rand.nextInt(names.length)];
		containsShipPart = SHIP_PART_EXISTS_CHANCE > rand.nextInt(100);
		containsFood = rand.nextBoolean();
		containsMedicalItem = rand.nextBoolean();
		containsMoney = rand.nextBoolean();
		
		if (!imagesShuffled) {
			Collections.shuffle(planetFileNames);
			imagesShuffled = true;
		}
		System.out.println(planetIndex);
		planetIndex = (planetIndex + 1) % planetFileNames.size();  // Increment Index and wrap
	}
	public Planet(String name) {
		this();
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public String getLocationFormatted() {
		return String.format("<html><div style='text-align: left;'>%s<br/>%s</div></html>", this.getType(), this.getName());
	}
	
	
	public boolean isContainsShipPart() {
		return containsShipPart;
	}
	public void removeShipPart() {
		containsShipPart = false;
	}
	public boolean isContainsFood() {
		return containsFood;
	}
	public boolean isContainsMedicalItem() {
		return containsMedicalItem;
	}
	public boolean isContainsMoney() {
		return containsMoney;
	}
	
	public String getImagePath() {
		Random rand = new Random();
		return directoryPrefix + planetFileNames.get(planetIndex);
	}

}
