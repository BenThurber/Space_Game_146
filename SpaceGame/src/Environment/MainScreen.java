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
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		final Color BG_BLUE = new Color(17, 152, 234);
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel backgroundImageLabel = new JLabel("");
		ImageIcon unscaledBackgroundImage = new ImageIcon("/Users/Ben/Desktop/SENG201/Project/Space_Game_146/Graphics/MainWindow/Main_Screen_Background.png");
		ImageIcon backgroundImage = scaledImageIcon(unscaledBackgroundImage, BG_IMAGE_SCALE_FACTOR);
		
		JLabel lblShipName = new JLabel("USS Enterprise".toUpperCase());
		lblShipName.setHorizontalAlignment(SwingConstants.CENTER);
		// Sets text size based on length of ship name
		int shipNameFontSize = Math.min(50 * 11 / (10 + lblShipName.getText().length()), 32);
		lblShipName.setFont(new Font("Trebuchet MS", Font.BOLD, shipNameFontSize));
		lblShipName.setForeground(BG_BLUE);
		lblShipName.setBounds(286, 365, 194, 39);
		frame.getContentPane().add(lblShipName);
		
		
		JLabel lblLocation = new JLabel("Unknown");
		lblLocation.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblLocation.setBounds(86, 448, 129, 16);
		frame.getContentPane().add(lblLocation);
		
		JLabel lblActiveCrew = new JLabel("0");
		lblActiveCrew.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblActiveCrew.setBounds(657, 456, 34, 26);
		frame.getContentPane().add(lblActiveCrew);
		
		JLabel lblSheildLevel = new JLabel("100%");
		lblSheildLevel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 16));
		lblSheildLevel.setBounds(553, 518, 43, 16);
		frame.getContentPane().add(lblSheildLevel);
		
		JProgressBar progressBarSheildLvl = new JProgressBar();
		progressBarSheildLvl.setValue(100);
		progressBarSheildLvl.setBounds(603, 518, 146, 20);
		frame.getContentPane().add(progressBarSheildLvl);
		
		JPanel panelCrewMemberOne = new JPanel();
		panelCrewMemberOne.setBackground(new Color(0, 0, 0, 0));
		panelCrewMemberOne.setBounds(0, 604, 374, 86);
		frame.getContentPane().add(panelCrewMemberOne);
		panelCrewMemberOne.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblName.setBounds(6, 6, 47, 16);
		panelCrewMemberOne.add(lblName);
		
		JLabel label = new JLabel("<Name>");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		label.setBounds(54, 6, 215, 16);
		panelCrewMemberOne.add(label);
		
		JLabel lblSpecialization = new JLabel("Type:");
		lblSpecialization.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblSpecialization.setBounds(71, 27, 47, 16);
		panelCrewMemberOne.add(lblSpecialization);
		
		JLabel lblCommunications = new JLabel("Communicatons");
		lblCommunications.setHorizontalAlignment(SwingConstants.LEFT);
		lblCommunications.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblCommunications.setBounds(118, 27, 117, 16);
		panelCrewMemberOne.add(lblCommunications);
		
		JLabel lblNewLabel = new JLabel("Image");
		lblNewLabel.setBounds(6, 27, 53, 53);
		panelCrewMemberOne.add(lblNewLabel);
		
		JLabel lblNextAction = new JLabel("Next Action:");
		lblNextAction.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNextAction.setBounds(71, 57, 88, 16);
		panelCrewMemberOne.add(lblNextAction);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(74, 170, 1));
		comboBox.setBackground(new Color(74, 170, 1));
		comboBox.setBounds(160, 53, 146, 27);
		panelCrewMemberOne.add(comboBox);
		
		JLabel label_3 = new JLabel("2/2");
		label_3.setBounds(345, 57, 23, 16);
		panelCrewMemberOne.add(label_3);
		
		JLabel lblStanimaLevel = new JLabel("100%");
		lblStanimaLevel.setBounds(335, 6, 33, 16);
		panelCrewMemberOne.add(lblStanimaLevel);
		
		JLabel lblHealthLevel = new JLabel("100%");
		lblHealthLevel.setBounds(335, 27, 33, 16);
		panelCrewMemberOne.add(lblHealthLevel);
		
		JLabel lblStanima = new JLabel("Stanima:");
		lblStanima.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblStanima.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStanima.setBounds(265, 6, 61, 16);
		panelCrewMemberOne.add(lblStanima);
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblHealth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHealth.setBounds(265, 27, 61, 16);
		panelCrewMemberOne.add(lblHealth);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGo.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		btnGo.setBounds(310, 54, 23, 23);
		panelCrewMemberOne.add(btnGo);
		
		
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
		
		JButton btnVisitOutpost = new JButton("Visit Space Outpost");
		btnVisitOutpost.setBounds(210, 562, 175, 29);
		frame.getContentPane().add(btnVisitOutpost);
		
		JButton btnNextPlanet = new JButton("Warp to Next Planet");
		btnNextPlanet.setBounds(385, 562, 186, 29);
		frame.getContentPane().add(btnNextPlanet);
		
		JButton btnNewButton = new JButton("Start Next Day");
		btnNewButton.setBounds(567, 562, 146, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label_1 = new JLabel("2");
		label_1.setBounds(366, 615, 23, 16);
		frame.getContentPane().add(label_1);
		
		
		

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
