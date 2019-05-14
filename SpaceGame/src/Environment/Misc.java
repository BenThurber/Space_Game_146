package Environment;

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
}