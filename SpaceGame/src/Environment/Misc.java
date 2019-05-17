package Environment;

import java.util.Random;

public class Misc {
	
	public static String capitalize(String s) {
		if (s.length() > 0) {
			return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
		} else {
			return "";
		}
	}
	
	public static String formatWithHTML(String message, String align) {
		return String.format("<html><div align=\"%s\">%s</div></html>", align.toLowerCase(), message.replace("\n", "<br>"));
	}
	
	public static int numberPlusMinusRandom(int num, int range) {
		Random rand = new Random();
		return num + rand.nextInt(range + 1 + range) - range;
	}
	public static int numberRandomMinMax(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max + 1 - min) + min;
	}

}