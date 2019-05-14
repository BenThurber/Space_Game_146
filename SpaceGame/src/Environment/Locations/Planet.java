package Environment.Locations;

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
	
	public final String type = "Planet";
	
	private boolean containsShipPart;
	private boolean containsFood;
	private boolean containsMedicalItem;
	private boolean containsMoney;
	
	
	
	// When a new planet is instantiated, it generates random attributes; name, image, etc.
	public Planet() {
		Random rand = new Random();
		this.name = names[rand.nextInt(names.length)];
		containsShipPart = rand.nextBoolean();
		containsFood = rand.nextBoolean();
		containsMedicalItem = rand.nextBoolean();
		containsMoney = rand.nextBoolean();
	}
	public Planet(String name) {
		super(name);
	}
	
	
	public String getType() {
		return type;
	}
	
	public String getLocationFormatted() {
		return String.format("<html><div style='text-align: left;'>%s<br/>%s</div></html>", this.getType(), this.getName());
	}

}
