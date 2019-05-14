package Environment;

import java.util.Random;

public class Planet extends Location {
	
	// Credit for names: https://www.fantasynamegenerators.com/planet_names.php
	private final String[] names = {"Bucater", "Hubraorilia", "Kizinda", "Hotrolla", 
	                                 "Xehiri", "Umia", "Struropra", "Thoaliv", 
	                                 "Charth 66E", "Thomia 9TE", "Gocawei", "Ethaeria", 
	                                 "Viseron", "Ethadus", "Leibos", "Ialara", 
	                                 "Gnolecarro", "Trazuliv", "Diea FWWP", "Cradus GF4", 
	                                 "Salnaruta", "Zonreozuno", "Zustrade", "Cenion", 
	                                 "Luitune", "Chocury", "Chiepra", "Phixonides", 
	                                 "Vorth MHP", "Doria G", "Dodruapra", "Vuchuliv", 
	                                 "Abbuna", "Yoborth", "Novis", "Zoitera", 
	                                 "Ziaruta", "Gnoduthea", "Zeron 0Y0", "Coria GB"};
	
	private String name;
	
	// When a new planet is instantiated, it generates random attributes; name, image, etc.
	public Planet() {
		Random rand = new Random();
		this.name = names[rand.nextInt(names.length)];
	}
	
	public Planet(String name) {
		this.name = name;
	}
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
