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
		
		JPanel panelCrewMember1 = new JPanel();
		panelCrewMember1.setBackground(new Color(0, 0, 0, 0));
		panelCrewMember1.setBounds(0, 604, 374, 86);
		frame.getContentPane().add(panelCrewMember1);
		panelCrewMember1.setLayout(null);
		
		JLabel lblNameHeading1 = new JLabel("Name:");
		lblNameHeading1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNameHeading1.setBounds(6, 6, 47, 16);
		panelCrewMember1.add(lblNameHeading1);
		
		JLabel lblName1 = new JLabel("<Name>");
		lblName1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblName1.setBounds(54, 6, 215, 16);
		panelCrewMember1.add(lblName1);
		
		JLabel lblTypeHeading1 = new JLabel("Type:");
		lblTypeHeading1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblTypeHeading1.setBounds(71, 27, 47, 16);
		panelCrewMember1.add(lblTypeHeading1);
		
		JLabel lblType1 = new JLabel("<Type>");
		lblType1.setHorizontalAlignment(SwingConstants.LEFT);
		lblType1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblType1.setBounds(118, 27, 117, 16);
		panelCrewMember1.add(lblType1);
		
		JLabel lblCrewAvatarImage1 = new JLabel("<Image>");
		lblCrewAvatarImage1.setBounds(6, 27, 53, 53);
		panelCrewMember1.add(lblCrewAvatarImage1);
		
		JLabel lblNextActionHeading1 = new JLabel("Next Action:");
		lblNextActionHeading1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNextActionHeading1.setBounds(71, 57, 88, 16);
		panelCrewMember1.add(lblNextActionHeading1);
		
		JComboBox comboBoxNextAction1 = new JComboBox();
		comboBoxNextAction1.setForeground(new Color(74, 170, 1));
		comboBoxNextAction1.setBackground(new Color(74, 170, 1));
		comboBoxNextAction1.setBounds(160, 53, 146, 27);
		panelCrewMember1.add(comboBoxNextAction1);
		
		JLabel lblRemainingActions1 = new JLabel("2/2");
		lblRemainingActions1.setBounds(345, 57, 23, 16);
		panelCrewMember1.add(lblRemainingActions1);
		
		JLabel lblStanimaLevel1 = new JLabel("100%");
		lblStanimaLevel1.setBounds(335, 6, 33, 16);
		panelCrewMember1.add(lblStanimaLevel1);
		
		JLabel lblHealthLevel1 = new JLabel("100%");
		lblHealthLevel1.setBounds(335, 27, 33, 16);
		panelCrewMember1.add(lblHealthLevel1);
		
		JLabel lblStanimaHeading1 = new JLabel("Stanima:");
		lblStanimaHeading1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblStanimaHeading1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStanimaHeading1.setBounds(265, 6, 61, 16);
		panelCrewMember1.add(lblStanimaHeading1);
		
		JLabel lblHealthHeading1 = new JLabel("Health:");
		lblHealthHeading1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblHealthHeading1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHealthHeading1.setBounds(265, 27, 61, 16);
		panelCrewMember1.add(lblHealthHeading1);
		
		JButton btnExecuteNextAction1 = new JButton("Go");
		btnExecuteNextAction1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExecuteNextAction1.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		btnExecuteNextAction1.setBounds(310, 54, 23, 23);
		panelCrewMember1.add(btnExecuteNextAction1);
		
		JPanel panelCrewMember2 = new JPanel();
		panelCrewMember2.setLayout(null);
		panelCrewMember2.setBackground(new Color(0, 0, 0, 0));
		panelCrewMember2.setBounds(390, 604, 374, 86);
		frame.getContentPane().add(panelCrewMember2);
		
		JLabel lblNameHeading2 = new JLabel("Name:");
		lblNameHeading2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNameHeading2.setBounds(6, 6, 47, 16);
		panelCrewMember2.add(lblNameHeading2);
		
		JLabel lblName2 = new JLabel("<Name>");
		lblName2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblName2.setBounds(54, 6, 215, 16);
		panelCrewMember2.add(lblName2);
		
		JLabel lblTypeHeading2 = new JLabel("Type:");
		lblTypeHeading2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblTypeHeading2.setBounds(71, 27, 47, 16);
		panelCrewMember2.add(lblTypeHeading2);
		
		JLabel lblType2 = new JLabel("<Type>");
		lblType2.setHorizontalAlignment(SwingConstants.LEFT);
		lblType2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblType2.setBounds(118, 27, 117, 16);
		panelCrewMember2.add(lblType2);
		
		JLabel lblCrewAvatarImage2 = new JLabel("<Image>");
		lblCrewAvatarImage2.setBounds(6, 27, 53, 53);
		panelCrewMember2.add(lblCrewAvatarImage2);
		
		JLabel lblNextActionHeading2 = new JLabel("Next Action:");
		lblNextActionHeading2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNextActionHeading2.setBounds(71, 57, 88, 16);
		panelCrewMember2.add(lblNextActionHeading2);
		
		JComboBox comboBoxNextAction2 = new JComboBox();
		comboBoxNextAction2.setForeground(new Color(74, 170, 1));
		comboBoxNextAction2.setBackground(new Color(74, 170, 1));
		comboBoxNextAction2.setBounds(160, 53, 146, 27);
		panelCrewMember2.add(comboBoxNextAction2);
		
		JLabel lblRemainingActions2 = new JLabel("2/2");
		lblRemainingActions2.setBounds(345, 57, 23, 16);
		panelCrewMember2.add(lblRemainingActions2);
		
		JLabel lblStanimaLevel2 = new JLabel("100%");
		lblStanimaLevel2.setBounds(335, 6, 33, 16);
		panelCrewMember2.add(lblStanimaLevel2);
		
		JLabel lblHealthLevel2 = new JLabel("100%");
		lblHealthLevel2.setBounds(335, 27, 33, 16);
		panelCrewMember2.add(lblHealthLevel2);
		
		JLabel lblStanimaHeading2 = new JLabel("Stanima:");
		lblStanimaHeading2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStanimaHeading2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblStanimaHeading2.setBounds(265, 6, 61, 16);
		panelCrewMember2.add(lblStanimaHeading2);
		
		JLabel lblHealthHeading2 = new JLabel("Health:");
		lblHealthHeading2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHealthHeading2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblHealthHeading2.setBounds(265, 27, 61, 16);
		panelCrewMember2.add(lblHealthHeading2);
		
		JButton btnExecuteNextAction2 = new JButton("Go");
		btnExecuteNextAction2.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		btnExecuteNextAction2.setBounds(310, 54, 23, 23);
		panelCrewMember2.add(btnExecuteNextAction2);
		
		JPanel panelCrewMember3 = new JPanel();
		panelCrewMember3.setLayout(null);
		panelCrewMember3.setBackground(new Color(0, 0, 0, 0));
		panelCrewMember3.setBounds(0, 705, 374, 86);
		frame.getContentPane().add(panelCrewMember3);
		
		JLabel lblNameHeading3 = new JLabel("Name:");
		lblNameHeading3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNameHeading3.setBounds(6, 6, 47, 16);
		panelCrewMember3.add(lblNameHeading3);
		
		JLabel lblName3 = new JLabel("<Name>");
		lblName3.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblName3.setBounds(54, 6, 215, 16);
		panelCrewMember3.add(lblName3);
		
		JLabel lblTypeHeading3 = new JLabel("Type:");
		lblTypeHeading3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblTypeHeading3.setBounds(71, 27, 47, 16);
		panelCrewMember3.add(lblTypeHeading3);
		
		JLabel lblType3 = new JLabel("<Type>");
		lblType3.setHorizontalAlignment(SwingConstants.LEFT);
		lblType3.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblType3.setBounds(118, 27, 117, 16);
		panelCrewMember3.add(lblType3);
		
		JLabel lblCrewAvatarImage3 = new JLabel("<Image>");
		lblCrewAvatarImage3.setBounds(6, 27, 53, 53);
		panelCrewMember3.add(lblCrewAvatarImage3);
		
		JLabel lblNextActionHeading3 = new JLabel("Next Action:");
		lblNextActionHeading3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNextActionHeading3.setBounds(71, 57, 88, 16);
		panelCrewMember3.add(lblNextActionHeading3);
		
		JComboBox comboBoxNextAction3 = new JComboBox();
		comboBoxNextAction3.setForeground(new Color(74, 170, 1));
		comboBoxNextAction3.setBackground(new Color(74, 170, 1));
		comboBoxNextAction3.setBounds(160, 53, 146, 27);
		panelCrewMember3.add(comboBoxNextAction3);
		
		JLabel lblRemainingActions3 = new JLabel("2/2");
		lblRemainingActions3.setBounds(345, 57, 23, 16);
		panelCrewMember3.add(lblRemainingActions3);
		
		JLabel lblStanimaLevel3 = new JLabel("100%");
		lblStanimaLevel3.setBounds(335, 6, 33, 16);
		panelCrewMember3.add(lblStanimaLevel3);
		
		JLabel lblHealthLevel3 = new JLabel("100%");
		lblHealthLevel3.setBounds(335, 27, 33, 16);
		panelCrewMember3.add(lblHealthLevel3);
		
		JLabel lblStanimaHeading3 = new JLabel("Stanima:");
		lblStanimaHeading3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStanimaHeading3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblStanimaHeading3.setBounds(265, 6, 61, 16);
		panelCrewMember3.add(lblStanimaHeading3);
		
		JLabel lblHealthHeading3 = new JLabel("Health:");
		lblHealthHeading3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHealthHeading3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblHealthHeading3.setBounds(265, 27, 61, 16);
		panelCrewMember3.add(lblHealthHeading3);
		
		JButton btnExecuteNextAction3 = new JButton("Go");
		btnExecuteNextAction3.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		btnExecuteNextAction3.setBounds(310, 54, 23, 23);
		panelCrewMember3.add(btnExecuteNextAction3);
		
		JPanel panelCrewMember4 = new JPanel();
		panelCrewMember4.setLayout(null);
		panelCrewMember4.setBackground(new Color(0, 0, 0, 0));
		panelCrewMember4.setBounds(390, 705, 374, 86);
		frame.getContentPane().add(panelCrewMember4);
		
		JLabel lblNameHeading4 = new JLabel("Name:");
		lblNameHeading4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNameHeading4.setBounds(6, 6, 47, 16);
		panelCrewMember4.add(lblNameHeading4);
		
		JLabel lblName4 = new JLabel("<Name>");
		lblName4.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblName4.setBounds(54, 6, 215, 16);
		panelCrewMember4.add(lblName4);
		
		JLabel lblTypeHeading4 = new JLabel("Type:");
		lblTypeHeading4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblTypeHeading4.setBounds(71, 27, 47, 16);
		panelCrewMember4.add(lblTypeHeading4);
		
		JLabel lblType4 = new JLabel("<Type>");
		lblType4.setHorizontalAlignment(SwingConstants.LEFT);
		lblType4.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblType4.setBounds(118, 27, 117, 16);
		panelCrewMember4.add(lblType4);
		
		JLabel lblCrewAvatarImage4 = new JLabel("<Image>");
		lblCrewAvatarImage4.setBounds(6, 27, 53, 53);
		panelCrewMember4.add(lblCrewAvatarImage4);
		
		JLabel lblNextActionHeading4 = new JLabel("Next Action:");
		lblNextActionHeading4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNextActionHeading4.setBounds(71, 57, 88, 16);
		panelCrewMember4.add(lblNextActionHeading4);
		
		JComboBox comboBoxNextAction4 = new JComboBox();
		comboBoxNextAction4.setForeground(new Color(74, 170, 1));
		comboBoxNextAction4.setBackground(new Color(74, 170, 1));
		comboBoxNextAction4.setBounds(160, 53, 146, 27);
		panelCrewMember4.add(comboBoxNextAction4);
		
		JLabel lblRemainingActions4 = new JLabel("2/2");
		lblRemainingActions4.setBounds(345, 57, 23, 16);
		panelCrewMember4.add(lblRemainingActions4);
		
		JLabel lblStanimaLevel4 = new JLabel("100%");
		lblStanimaLevel4.setBounds(335, 6, 33, 16);
		panelCrewMember4.add(lblStanimaLevel4);
		
		JLabel lblHealthLevel4 = new JLabel("100%");
		lblHealthLevel4.setBounds(335, 27, 33, 16);
		panelCrewMember4.add(lblHealthLevel4);
		
		JLabel lblStanimaHeading4 = new JLabel("Stanima:");
		lblStanimaHeading4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStanimaHeading4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblStanimaHeading4.setBounds(265, 6, 61, 16);
		panelCrewMember4.add(lblStanimaHeading4);
		
		JLabel lblHealthHeading4 = new JLabel("Health:");
		lblHealthHeading4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHealthHeading4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblHealthHeading4.setBounds(265, 27, 61, 16);
		panelCrewMember4.add(lblHealthHeading4);
		
		JButton btnExecuteNextAction4 = new JButton("Go");
		btnExecuteNextAction4.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		btnExecuteNextAction4.setBounds(310, 54, 23, 23);
		panelCrewMember4.add(btnExecuteNextAction4);
		
		
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
