package Environment;

public class Misc {
	public static String capitalize(String s) {
		if (s.length() > 0) {
			return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
		} else {
			return "";
		}
	}
	
}