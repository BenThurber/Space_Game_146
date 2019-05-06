package Environment;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Color;

public class MainScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final int WINDOW_X = 320;
		final int WINDOW_Y = 100;
		final int WINDOW_WIDTH = 767;
		final int WINDOW_HEIGHT = 832;
		
		final float BG_IMAGE_SCALE_FACTOR = 0.5326f;
		final int BG_IMAGE_LABEL_X = 0;
		final int BG_IMAGE_LABEL_Y = -85;
		final int BG_IMAGE_LABEL_WIDTH = WINDOW_WIDTH;
		final int BG_IMAGE_LABEL_HEIGHT = 895;
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel backgroundImageLabel = new JLabel("");
		ImageIcon unscaledBackgroundImage = new ImageIcon("/Users/Ben/Desktop/SENG201/Project/Space_Game_146/Graphics/MainWindow/Main_Screen_Background.png");
		ImageIcon backgroundImage = scaledImageIcon(unscaledBackgroundImage, BG_IMAGE_SCALE_FACTOR);
		backgroundImageLabel.setIcon(backgroundImage);
		// Label should be 22 shorter than window to fit perfectly in it
		//lblNewLabel.setBounds(0, -85, 767, 895);
		backgroundImageLabel.setBounds(BG_IMAGE_LABEL_X, BG_IMAGE_LABEL_Y, BG_IMAGE_LABEL_WIDTH, BG_IMAGE_LABEL_HEIGHT);
		frame.getContentPane().add(backgroundImageLabel);
		
		JLabel flashingLightsGIFLabel = new JLabel("");
		ImageIcon unscaledLightsGIF = new ImageIcon("/Users/Ben/Desktop/SENG201/Project/Space_Game_146/Graphics/MainWindow/Lights GIF/Centre-Light-scaled_slightly_larger.gif");
		flashingLightsGIFLabel.setIcon(unscaledLightsGIF);
		//flashingLightsGIFLabel.setBounds(326, 240, 124, 39);
		flashingLightsGIFLabel.setBounds(326, 240, 124, 39);
		frame.getContentPane().add(flashingLightsGIFLabel);
		
		
		

	}
	
	/**
	 * Takes an ImageIcon and width and height or percent scale and scales the image.
	 */
	private ImageIcon scaledImageIcon(ImageIcon unscaledImageIcon, int width, int height) {
		return scale(unscaledImageIcon, width, height);
	}
	private ImageIcon scaledImageIcon(ImageIcon unscaledImageIcon, float percentSize) {
		int width = Math.round(unscaledImageIcon.getIconWidth() * percentSize);
		int height = Math.round(unscaledImageIcon.getIconHeight() * percentSize);
		return scale(unscaledImageIcon, width, height);
	}
	private ImageIcon scale(ImageIcon unscaledImageIcon, int width, int height) {
		Image image = unscaledImageIcon.getImage();
		Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
		unscaledImageIcon = new ImageIcon(newimg);
		return unscaledImageIcon;
	}
}
