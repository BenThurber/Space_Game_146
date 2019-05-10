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
	
	// Variable environment can be used to get attributes to update labels and such
	GameEnvironment environment;
	JFrame frame;
	
	/**
	 * Create the application.
	 * @wbp.parser.constructor
	 */
	public MainScreen(GameEnvironment environment) {
		this.environment = environment;
		initialize();
	}
	// Just for testing?
	public MainScreen() {
		initialize();
	}



//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		MainScreen window = new MainScreen();
//		window.frame.setVisible(true);
//		
//	}



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
		
		final float GO_BUTTON_SCALE_FACTOR = 0.35f;
		
		final Color BG_BLUE = new Color(17, 152, 234);
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel backgroundImageLabel = new JLabel("");
		ImageIcon unscaledBackgroundImage = new ImageIcon(MainScreen.class.getResource("/Images/Main_Screen_Background.png"));
		ImageIcon backgroundImage = scaledImageIcon(unscaledBackgroundImage, BG_IMAGE_SCALE_FACTOR);
		
		ImageIcon unscaledimgExecuteNextAction = new ImageIcon(MainScreen.class.getResource("/Images/Go.png"));
		ImageIcon imgExecuteNextAction = scaledImageIcon(unscaledimgExecuteNextAction, GO_BUTTON_SCALE_FACTOR);
		
		JLabel lblShipName = new JLabel(environment.getShipName());
		lblShipName.setHorizontalAlignment(SwingConstants.CENTER);
		// Sets text size based on length of ship name
		int shipNameFontSize = Math.min(50 * 13 / (10 + (int)(1.9*lblShipName.getText().length())), 32);
		lblShipName.setFont(new Font("Dialog", Font.BOLD, shipNameFontSize));
		lblShipName.setForeground(BG_BLUE);
		lblShipName.setBounds(286, 365, 194, 39);
		frame.getContentPane().add(lblShipName);
		
		
		JLabel lblLocation = new JLabel(environment.getLocation());
		lblLocation.setForeground(Color.BLACK);
		lblLocation.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblLocation.setBounds(86, 448, 129, 16);
		frame.getContentPane().add(lblLocation);
		
		JLabel lblShipParts = new JLabel(String.valueOf(environment.getShipPartsFound()) + '/' + String.valueOf(environment.getShipPartsTotalMissing()));
		lblShipParts.setForeground(Color.BLACK);
		lblShipParts.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblShipParts.setBounds(642, 448, 68, 34);
		frame.getContentPane().add(lblShipParts);
		
		JLabel lblSheildLevel = new JLabel(String.valueOf(environment.getSheildLevel()) + '%');
		lblSheildLevel.setForeground(Color.BLACK);
		lblSheildLevel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblSheildLevel.setBounds(549, 520, 49, 16);
		frame.getContentPane().add(lblSheildLevel);
		
		JProgressBar progressBarSheildLvl = new JProgressBar();
		progressBarSheildLvl.setForeground(new Color(0, 191, 255));
		progressBarSheildLvl.setValue(environment.getSheildLevel());
		progressBarSheildLvl.setBounds(603, 518, 146, 20);
		frame.getContentPane().add(progressBarSheildLvl);
		
		JButton btnNextPlanet = new JButton("");
		btnNextPlanet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.moveToNextPlanet();
			}
		});
		btnNextPlanet.setOpaque(false);
		btnNextPlanet.setContentAreaFilled(false);
		btnNextPlanet.setBorderPainted(false);
		btnNextPlanet.setBounds(385, 562, 186, 29);
		frame.getContentPane().add(btnNextPlanet);
		
		JButton btnVisitOutpost = new JButton("");
		btnVisitOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.visitSpaceOutpost();
			}
		});
		btnVisitOutpost.setOpaque(false);
		btnVisitOutpost.setContentAreaFilled(false);
		btnVisitOutpost.setBorderPainted(false);
		btnVisitOutpost.setBounds(210, 562, 175, 29);
		frame.getContentPane().add(btnVisitOutpost);
		
		JButton btnNextDay = new JButton("");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.startNextDay();
			}
		});
		btnNextDay.setOpaque(false);
		btnNextDay.setContentAreaFilled(false);
		btnNextDay.setBorderPainted(false);
		btnNextDay.setBounds(570, 562, 140, 29);
		frame.getContentPane().add(btnNextDay);
		
		JPanel panelCrewMember1 = new JPanel();
		panelCrewMember1.setBackground(new Color(0, 0, 0, 0));
		panelCrewMember1.setBounds(0, 604, 374, 86);
		frame.getContentPane().add(panelCrewMember1);
		panelCrewMember1.setLayout(null);
		
		JLabel lblNameHeading1 = new JLabel("Name:");
		lblNameHeading1.setForeground(Color.BLACK);
		lblNameHeading1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNameHeading1.setBounds(6, 6, 47, 16);
		panelCrewMember1.add(lblNameHeading1);
		
		JLabel lblName1 = new JLabel("<Name>");
		lblName1.setForeground(Color.BLACK);
		lblName1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblName1.setBounds(54, 6, 215, 16);
		panelCrewMember1.add(lblName1);
		
		JLabel lblTypeHeading1 = new JLabel("Type:");
		lblTypeHeading1.setForeground(Color.BLACK);
		lblTypeHeading1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTypeHeading1.setBounds(71, 27, 47, 16);
		panelCrewMember1.add(lblTypeHeading1);
		
		JLabel lblType1 = new JLabel("<Type>");
		lblType1.setForeground(Color.BLACK);
		lblType1.setHorizontalAlignment(SwingConstants.LEFT);
		lblType1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblType1.setBounds(118, 27, 117, 16);
		panelCrewMember1.add(lblType1);
		
		JLabel lblCrewAvatarImage1 = new JLabel("<Image>");
		lblCrewAvatarImage1.setForeground(Color.BLACK);
		lblCrewAvatarImage1.setBounds(6, 27, 53, 53);
		panelCrewMember1.add(lblCrewAvatarImage1);
		
		JLabel lblNextActionHeading1 = new JLabel("Next Action:");
		lblNextActionHeading1.setForeground(Color.BLACK);
		lblNextActionHeading1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNextActionHeading1.setBounds(71, 57, 88, 16);
		panelCrewMember1.add(lblNextActionHeading1);
		
		JComboBox comboBoxNextAction1 = new JComboBox();
		comboBoxNextAction1.setForeground(new Color(74, 170, 1));
		comboBoxNextAction1.setBackground(new Color(74, 170, 1));
		comboBoxNextAction1.setBounds(160, 53, 146, 27);
		panelCrewMember1.add(comboBoxNextAction1);
		
		JLabel lblRemainingActions1 = new JLabel("2/2");
		lblRemainingActions1.setForeground(Color.BLACK);
		lblRemainingActions1.setBounds(345, 57, 23, 16);
		panelCrewMember1.add(lblRemainingActions1);
		
		JLabel lblStanimaLevel1 = new JLabel("100%");
		lblStanimaLevel1.setForeground(Color.BLACK);
		lblStanimaLevel1.setBounds(332, 6, 36, 16);
		panelCrewMember1.add(lblStanimaLevel1);
		
		JLabel lblHealthLevel1 = new JLabel("100%");
		lblHealthLevel1.setForeground(Color.BLACK);
		lblHealthLevel1.setBounds(332, 27, 36, 16);
		panelCrewMember1.add(lblHealthLevel1);
		
		JLabel lblStanimaHeading1 = new JLabel("Stanima:");
		lblStanimaHeading1.setForeground(Color.BLACK);
		lblStanimaHeading1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblStanimaHeading1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStanimaHeading1.setBounds(259, 6, 64, 16);
		panelCrewMember1.add(lblStanimaHeading1);
		
		JButton btnExecuteNextAction1 = new JButton("");
		btnExecuteNextAction1.setIcon(imgExecuteNextAction);
		btnExecuteNextAction1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblHealthHeading1 = new JLabel("Health:");
		lblHealthHeading1.setForeground(Color.BLACK);
		lblHealthHeading1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblHealthHeading1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHealthHeading1.setBounds(262, 27, 61, 16);
		panelCrewMember1.add(lblHealthHeading1);
		btnExecuteNextAction1.setFont(new Font("Dialog", Font.PLAIN, 9));
		btnExecuteNextAction1.setBounds(310, 54, 23, 23);
		panelCrewMember1.add(btnExecuteNextAction1);
		
		JPanel panelCrewMember2 = new JPanel();
		panelCrewMember2.setLayout(null);
		panelCrewMember2.setBackground(new Color(0, 0, 0, 0));
		panelCrewMember2.setBounds(390, 604, 374, 86);
		frame.getContentPane().add(panelCrewMember2);
		
		JLabel lblNameHeading2 = new JLabel("Name:");
		lblNameHeading2.setForeground(Color.BLACK);
		lblNameHeading2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNameHeading2.setBounds(6, 6, 47, 16);
		panelCrewMember2.add(lblNameHeading2);
		
		JLabel lblName2 = new JLabel("<Name>");
		lblName2.setForeground(Color.BLACK);
		lblName2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblName2.setBounds(54, 6, 215, 16);
		panelCrewMember2.add(lblName2);
		
		JLabel lblTypeHeading2 = new JLabel("Type:");
		lblTypeHeading2.setForeground(Color.BLACK);
		lblTypeHeading2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTypeHeading2.setBounds(71, 27, 47, 16);
		panelCrewMember2.add(lblTypeHeading2);
		
		JLabel lblType2 = new JLabel("<Type>");
		lblType2.setForeground(Color.BLACK);
		lblType2.setHorizontalAlignment(SwingConstants.LEFT);
		lblType2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblType2.setBounds(118, 27, 117, 16);
		panelCrewMember2.add(lblType2);
		
		JLabel lblCrewAvatarImage2 = new JLabel("<Image>");
		lblCrewAvatarImage2.setForeground(Color.BLACK);
		lblCrewAvatarImage2.setBounds(6, 27, 53, 53);
		panelCrewMember2.add(lblCrewAvatarImage2);
		
		JLabel lblNextActionHeading2 = new JLabel("Next Action:");
		lblNextActionHeading2.setForeground(Color.BLACK);
		lblNextActionHeading2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNextActionHeading2.setBounds(71, 57, 88, 16);
		panelCrewMember2.add(lblNextActionHeading2);
		
		JComboBox comboBoxNextAction2 = new JComboBox();
		comboBoxNextAction2.setForeground(new Color(74, 170, 1));
		comboBoxNextAction2.setBackground(new Color(74, 170, 1));
		comboBoxNextAction2.setBounds(160, 53, 146, 27);
		panelCrewMember2.add(comboBoxNextAction2);
		
		JLabel lblRemainingActions2 = new JLabel("2/2");
		lblRemainingActions2.setForeground(Color.BLACK);
		lblRemainingActions2.setBounds(345, 57, 23, 16);
		panelCrewMember2.add(lblRemainingActions2);
		
		JLabel lblStanimaLevel2 = new JLabel("100%");
		lblStanimaLevel2.setForeground(Color.BLACK);
		lblStanimaLevel2.setBounds(332, 6, 36, 16);
		panelCrewMember2.add(lblStanimaLevel2);
		
		JLabel lblHealthLevel2 = new JLabel("100%");
		lblHealthLevel2.setForeground(Color.BLACK);
		lblHealthLevel2.setBounds(332, 27, 36, 16);
		panelCrewMember2.add(lblHealthLevel2);
		
		JLabel lblStanimaHeading2 = new JLabel("Stanima:");
		lblStanimaHeading2.setForeground(Color.BLACK);
		lblStanimaHeading2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStanimaHeading2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblStanimaHeading2.setBounds(259, 6, 64, 16);
		panelCrewMember2.add(lblStanimaHeading2);
		
		JLabel lblHealthHeading2 = new JLabel("Health:");
		lblHealthHeading2.setForeground(Color.BLACK);
		lblHealthHeading2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHealthHeading2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblHealthHeading2.setBounds(259, 27, 64, 16);
		panelCrewMember2.add(lblHealthHeading2);
		
		JButton btnExecuteNextAction2 = new JButton("");
		btnExecuteNextAction2.setIcon(imgExecuteNextAction);
		btnExecuteNextAction2.setFont(new Font("Dialog", Font.PLAIN, 9));
		btnExecuteNextAction2.setBounds(310, 54, 23, 23);
		panelCrewMember2.add(btnExecuteNextAction2);
		
		JPanel panelCrewMember3 = new JPanel();
		panelCrewMember3.setLayout(null);
		panelCrewMember3.setBackground(new Color(0, 0, 0, 0));
		panelCrewMember3.setBounds(0, 705, 374, 86);
		frame.getContentPane().add(panelCrewMember3);
		
		JLabel lblNameHeading3 = new JLabel("Name:");
		lblNameHeading3.setForeground(Color.BLACK);
		lblNameHeading3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNameHeading3.setBounds(6, 6, 47, 16);
		panelCrewMember3.add(lblNameHeading3);
		
		JLabel lblName3 = new JLabel("<Name>");
		lblName3.setForeground(Color.BLACK);
		lblName3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblName3.setBounds(54, 6, 215, 16);
		panelCrewMember3.add(lblName3);
		
		JLabel lblTypeHeading3 = new JLabel("Type:");
		lblTypeHeading3.setForeground(Color.BLACK);
		lblTypeHeading3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTypeHeading3.setBounds(71, 27, 47, 16);
		panelCrewMember3.add(lblTypeHeading3);
		
		JLabel lblType3 = new JLabel("<Type>");
		lblType3.setForeground(Color.BLACK);
		lblType3.setHorizontalAlignment(SwingConstants.LEFT);
		lblType3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblType3.setBounds(118, 27, 117, 16);
		panelCrewMember3.add(lblType3);
		
		JLabel lblCrewAvatarImage3 = new JLabel("<Image>");
		lblCrewAvatarImage3.setForeground(Color.BLACK);
		lblCrewAvatarImage3.setBounds(6, 27, 53, 53);
		panelCrewMember3.add(lblCrewAvatarImage3);
		
		JLabel lblNextActionHeading3 = new JLabel("Next Action:");
		lblNextActionHeading3.setForeground(Color.BLACK);
		lblNextActionHeading3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNextActionHeading3.setBounds(71, 57, 88, 16);
		panelCrewMember3.add(lblNextActionHeading3);
		
		JComboBox comboBoxNextAction3 = new JComboBox();
		comboBoxNextAction3.setForeground(new Color(74, 170, 1));
		comboBoxNextAction3.setBackground(new Color(74, 170, 1));
		comboBoxNextAction3.setBounds(160, 53, 146, 27);
		panelCrewMember3.add(comboBoxNextAction3);
		
		JLabel lblRemainingActions3 = new JLabel("2/2");
		lblRemainingActions3.setForeground(Color.BLACK);
		lblRemainingActions3.setBounds(345, 57, 23, 16);
		panelCrewMember3.add(lblRemainingActions3);
		
		JLabel lblStanimaLevel3 = new JLabel("100%");
		lblStanimaLevel3.setForeground(Color.BLACK);
		lblStanimaLevel3.setBounds(332, 6, 36, 16);
		panelCrewMember3.add(lblStanimaLevel3);
		
		JLabel lblHealthLevel3 = new JLabel("100%");
		lblHealthLevel3.setForeground(Color.BLACK);
		lblHealthLevel3.setBounds(332, 27, 36, 16);
		panelCrewMember3.add(lblHealthLevel3);
		
		JLabel lblStanimaHeading3 = new JLabel("Stanima:");
		lblStanimaHeading3.setForeground(Color.BLACK);
		lblStanimaHeading3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStanimaHeading3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblStanimaHeading3.setBounds(259, 6, 64, 16);
		panelCrewMember3.add(lblStanimaHeading3);
		
		JLabel lblHealthHeading3 = new JLabel("Health:");
		lblHealthHeading3.setForeground(Color.BLACK);
		lblHealthHeading3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHealthHeading3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblHealthHeading3.setBounds(262, 27, 61, 16);
		panelCrewMember3.add(lblHealthHeading3);
		
		JButton btnExecuteNextAction3 = new JButton("");
		btnExecuteNextAction3.setIcon(imgExecuteNextAction);
		btnExecuteNextAction3.setBounds(310, 54, 23, 23);
		panelCrewMember3.add(btnExecuteNextAction3);
		
		JPanel panelCrewMember4 = new JPanel();
		panelCrewMember4.setLayout(null);
		panelCrewMember4.setBackground(new Color(0, 0, 0, 0));
		panelCrewMember4.setBounds(390, 705, 374, 86);
		frame.getContentPane().add(panelCrewMember4);
		
		JLabel lblNameHeading4 = new JLabel("Name:");
		lblNameHeading4.setForeground(Color.BLACK);
		lblNameHeading4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNameHeading4.setBounds(6, 6, 47, 16);
		panelCrewMember4.add(lblNameHeading4);
		
		JLabel lblName4 = new JLabel("<Name>");
		lblName4.setForeground(Color.BLACK);
		lblName4.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblName4.setBounds(54, 6, 215, 16);
		panelCrewMember4.add(lblName4);
		
		JLabel lblTypeHeading4 = new JLabel("Type:");
		lblTypeHeading4.setForeground(Color.BLACK);
		lblTypeHeading4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTypeHeading4.setBounds(71, 27, 47, 16);
		panelCrewMember4.add(lblTypeHeading4);
		
		JLabel lblType4 = new JLabel("<Type>");
		lblType4.setForeground(Color.BLACK);
		lblType4.setHorizontalAlignment(SwingConstants.LEFT);
		lblType4.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblType4.setBounds(118, 27, 117, 16);
		panelCrewMember4.add(lblType4);
		
		JLabel lblCrewAvatarImage4 = new JLabel("<Image>");
		lblCrewAvatarImage4.setForeground(Color.BLACK);
		lblCrewAvatarImage4.setBounds(6, 27, 53, 53);
		panelCrewMember4.add(lblCrewAvatarImage4);
		
		JLabel lblNextActionHeading4 = new JLabel("Next Action:");
		lblNextActionHeading4.setForeground(Color.BLACK);
		lblNextActionHeading4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNextActionHeading4.setBounds(71, 57, 88, 16);
		panelCrewMember4.add(lblNextActionHeading4);
		
		JComboBox comboBoxNextAction4 = new JComboBox();
		comboBoxNextAction4.setForeground(new Color(74, 170, 1));
		comboBoxNextAction4.setBackground(new Color(74, 170, 1));
		comboBoxNextAction4.setBounds(160, 53, 146, 27);
		panelCrewMember4.add(comboBoxNextAction4);
		
		JLabel lblRemainingActions4 = new JLabel("2/2");
		lblRemainingActions4.setForeground(Color.BLACK);
		lblRemainingActions4.setBounds(345, 57, 23, 16);
		panelCrewMember4.add(lblRemainingActions4);
		
		JLabel lblStanimaLevel4 = new JLabel("100%");
		lblStanimaLevel4.setForeground(Color.BLACK);
		lblStanimaLevel4.setBounds(332, 6, 36, 16);
		panelCrewMember4.add(lblStanimaLevel4);
		
		JLabel lblHealthLevel4 = new JLabel("100%");
		lblHealthLevel4.setForeground(Color.BLACK);
		lblHealthLevel4.setBounds(332, 27, 36, 16);
		panelCrewMember4.add(lblHealthLevel4);
		
		JLabel lblStanimaHeading4 = new JLabel("Stanima:");
		lblStanimaHeading4.setForeground(Color.BLACK);
		lblStanimaHeading4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStanimaHeading4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblStanimaHeading4.setBounds(259, 6, 64, 16);
		panelCrewMember4.add(lblStanimaHeading4);
		
		JLabel lblHealthHeading4 = new JLabel("Health:");
		lblHealthHeading4.setForeground(Color.BLACK);
		lblHealthHeading4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHealthHeading4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblHealthHeading4.setBounds(259, 27, 64, 16);
		panelCrewMember4.add(lblHealthHeading4);
		
		JButton btnExecuteNextAction4 = new JButton("");
		btnExecuteNextAction4.setIcon(imgExecuteNextAction);
		btnExecuteNextAction4.setFont(new Font("Dialog", Font.PLAIN, 9));
		btnExecuteNextAction4.setBounds(310, 54, 23, 23);
		panelCrewMember4.add(btnExecuteNextAction4);
		
		
		backgroundImageLabel.setIcon(backgroundImage);
		// Label should be 22 shorter than window to fit perfectly in it
		//lblNewLabel.setBounds(0, -85, 767, 895);
		backgroundImageLabel.setBounds(BG_IMAGE_LABEL_X, BG_IMAGE_LABEL_Y, BG_IMAGE_LABEL_WIDTH, BG_IMAGE_LABEL_HEIGHT);
		frame.getContentPane().add(backgroundImageLabel);
		
		JLabel flashingLightsGIFLabel = new JLabel("");
		ImageIcon unscaledLightsGIF = new ImageIcon(MainScreen.class.getResource("/Images/Centre-Light-scaled_slightly_larger.gif"));
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
	
	
//	public void setShipName(String name) {
//		lblShipName.setText(name);
//	}
//	
//	public String getShipName() {
//		return lblShipName.getText();
//	}
//	
//	public void setLocation(String location) {
//		lblLocation.setText(location);
//	}
//	
//	public String getLocation() {
//		return lblLocation.getText();
//	}
//	
////	public void setShipParts() {
////		try:
////			String[] numeratorDenominator = lblShipParts.getText().split("/");
////			if (numeratorDenominator[0] < numeratorDenominator[1]) {
////				
////			}
////	}
//	public void setShipParts(String fractionOfParts) {
//		lblShipParts.setText(fractionOfParts);
//	}

}
