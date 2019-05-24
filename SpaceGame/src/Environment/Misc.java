package Environment;

import java.util.Random;

/**
 * 
 * Miscellaneous static methods
 * @author Benjamin Thurber
 * @author Blake Kayser
 */
public class Misc {
	/**
	 * @param s any string
	 * @return the input string s with the first character capitalized, and the rest lower case
	 */
	public static String capitalize(String s) {
		if (s.length() > 0) {
			return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
		} else {
			return "";
		}
	}
	
	/**
	 * @param message any string
	 * @param align a string "left", "right", or "center" that determines the alignment of the HTML text
	 * @return text formatted with HTML which can be used in a Swing application
	 */
	public static String formatWithHTML(String message, String align) {
		return String.format("<html><div align=\"%s\">%s</div></html>", align.toLowerCase(), message.replace("\n", "<br>"));
	}
	
	/**
	 * Returns a number plus a random range
	 * @param num any number
	 * @param range a range which the number is allowed to fluctuate above and below.
	 * @return the number num added to a number which is randomly selected and is in the range  {@literal (-range <= x <= range)}
	 */
	public static int numberPlusMinusRandom(int num, int range) {
		Random rand = new Random();
		return num + rand.nextInt(range + 1 + range) - range;
	}
	
	/**
	 * Returns a random number in a range
	 * @param min minimum that the number can be
	 * @param max maximum that the number can be
	 * @return a random number in the range {@literal (min <= x <= max)}
	 */
	public static int numberRandomMinMax(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max + 1 - min) + min;
	}
}