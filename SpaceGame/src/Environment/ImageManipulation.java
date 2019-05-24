package Environment;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 
 * Static methods to manipulate the the size of ImageIcons
 * @author Benjamin Thurber
 * @author Blake Kayser
 */
public class ImageManipulation {

	/**Takes an ImageIcon and desired width and height and returns a scaled ImageIcon.
	 * @param unscaledImageIcon swing ImageIcon to be scaled
	 * @param width int desired width
	 * @param height int desired height
	 * @return a new swing ImageIcon scaled to the desired size
	 */
	public static ImageIcon scaledImageIcon(ImageIcon unscaledImageIcon, int width, int height) {
		return scale(unscaledImageIcon, width, height);
	}
	
	/**Takes an ImageIcon and desired percent scale factor and returns a scaled ImageIcon.
	 * @param unscaledImageIcon swing ImageIcon to be scaled
	 * @param percentSize float of the amount to scale by
	 * @return a new swing ImageIcon scaled to the desired size
	 */
	public static ImageIcon scaledImageIcon(ImageIcon unscaledImageIcon, float percentSize) {
		int width = Math.round(unscaledImageIcon.getIconWidth() * percentSize);
		int height = Math.round(unscaledImageIcon.getIconHeight() * percentSize);
		return scale(unscaledImageIcon, width, height);
	}
	
	/**Takes an ImageIcon, desired side length and a boolean scaleByWidth.  If true it fixes the sideLength to 
	 * the width and scales the height proportionally.  If false, fixes the sideLength to the height.  
	 * Returns a scaled ImageIcon.
	 * @param unscaledImageIcon swing ImageIcon to be scaled
	 * @param sideLength the length either width or height to scale to
	 * @param scaleByWidth boolean.  If true it fixes the sideLength to 
	 * the width and scales the height proportionally.  If false, fixes the sideLength to the height.
	 * @return a new swing ImageIcon scaled to the desired size
	 */
	public static ImageIcon scaledImageIcon(ImageIcon unscaledImageIcon, int sideLength, boolean scaleByWidth) {
		int width, height;
		if (scaleByWidth) {
			height = Math.round(((float) unscaledImageIcon.getIconHeight() / unscaledImageIcon.getIconWidth()) * sideLength);
			width = sideLength;
		} else {
			width = Math.round(((float) unscaledImageIcon.getIconWidth() / unscaledImageIcon.getIconHeight()) * sideLength);
			height = sideLength;
		}
		return scale(unscaledImageIcon, width, height);
	}
	
	/**Helper method for scaledImageIcon to do the scaling.
	 * @param unscaledImageIcon swing ImageIcon to be scaled
	 * @param width int desired width
	 * @param height int desired height
	 * @return a new swing ImageIcon scaled to the desired size
	 */
	private static ImageIcon scale(ImageIcon unscaledImageIcon, int width, int height) {
		Image image = unscaledImageIcon.getImage();
		Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
		unscaledImageIcon = new ImageIcon(newimg);
		return unscaledImageIcon;
	}

}
