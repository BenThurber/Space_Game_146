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

import Environment.CrewMemberTypes.CrewMember;
import Environment.Exceptions.CrewMemberNotFoundException;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;

public class MainScreen {
	
	private final int WINDOW_X = 320;
	private final int WINDOW_Y = 100;
	private final int WINDOW_WIDTH = 767;
	private final int WINDOW_HEIGHT = 832;
	
	private final float BG_IMAGE_SCALE_FACTOR = 0.5326f;
	private final int BG_IMAGE_LABEL_X = 0;
	private final int BG_IMAGE_LABEL_Y = -85;
	private final int BG_IMAGE_LABEL_WIDTH = WINDOW_WIDTH;
	private final int BG_IMAGE_LABEL_HEIGHT = 895;
	
	private final int VIEW_SCREEN_IMAGE_WIDTH = 575;
	
	private final int AVATAR_IMG_SIZE = 53;
	
	private final float GO_BUTTON_SCALE_FACTOR = 0.35f;
	
	private final Color TOP_BAR_BLUE = new Color(17, 152, 234);
	
	
	
	// Variable environment can be used to get attributes to update labels and such
	private GameEnvironment environment;
	protected JFrame frame;
	
	// Ship Related Variables
	private JLabel lblLocation = new JLabel("Unknown");
	private JLabel lblShipParts = new JLabel("0/0");
	private JLabel lblSheildLevel = new JLabel("100%");
	private JProgressBar progressBarSheildLvl = new JProgressBar();
	private JLabel viewScreenImageLabel = new JLabel("");
	
	// CrewMember1 Variables
	private final int CREW_MEMBER_1_ID = 0;
	private CrewMember crewMember1;
	private JPanel panelCrewMember1 = new JPanel();
	private JProgressBar progressBarHealth1 = new JProgressBar();
	private JLabel lblRemainingActions1 = new JLabel("0/0");
	private JLabel lblStanimaLevel1 = new JLabel("0%");
	private JLabel lblHungerLevel1 = new JLabel("0%");
	private JComboBox comboBoxNextAction1 = new JComboBox();
	
	// CrewMember2 Variables
	private final int CREW_MEMBER_2_ID = 1;
	private CrewMember crewMember2;
	private JPanel panelCrewMember2 = new JPanel();
	private JProgressBar progressBarHealth2 = new JProgressBar();
	private JLabel lblRemainingActions2 = new JLabel("0/0");
	private JLabel lblStanimaLevel2 = new JLabel("0%");
	private JLabel lblHungerLevel2 = new JLabel("0%");
	private JComboBox comboBoxNextAction2 = new JComboBox();
	
	// CrewMember3 Variables
	private final int CREW_MEMBER_3_ID = 2;
	private CrewMember crewMember3;
	private JPanel panelCrewMember3 = new JPanel();
	private JProgressBar progressBarHealth3 = new JProgressBar();
	private JLabel lblRemainingActions3 = new JLabel("0/0");
	private JLabel lblStanimaLevel3 = new JLabel("0%");
	private JLabel lblHungerLevel3 = new JLabel("0%");
	private JComboBox comboBoxNextAction3 = new JComboBox();
	
	// CrewMember4 Variables
	private final int CREW_MEMBER_4_ID = 3;
	private CrewMember crewMember4;
	private JPanel panelCrewMember4 = new JPanel();
	private JProgressBar progressBarHealth4 = new JProgressBar();
	private JLabel lblRemainingActions4 = new JLabel("0/0");
	private JLabel lblStanimaLevel4 = new JLabel("0%");
	private JLabel lblHungerLevel4 = new JLabel("0%");
	private JComboBox comboBoxNextAction4 = new JComboBox();
	
	
	
	
	/**
	 * Create the application.
	 * @wbp.parser.constructor
	 */
	public MainScreen(GameEnvironment environment) {
		this.environment = environment;
		initialize();
	}
	
	/**Update the widgets on the MainScreen*/
	public void update() {
		updateShipAtributes();
		updateViewScreen();
		System.out.println("Updated Ship");
		updateCrewMember1();
		System.out.println("Updated CrewMember1");
		updateCrewMember2();
		System.out.println("Updated CrewMember2");
		updateCrewMember3();
		System.out.println("Updated CrewMember3");
		updateCrewMember4();
		System.out.println("Updated CrewMember4\n");
	}
	
	/**Updates the widgets related to the ship*/
	private void updateShipAtributes() {
		lblLocation.setText(environment.ship.getLocation().getLocationFormatted());
		lblShipParts.setText(String.valueOf(environment.getShipPartsFound()) + "/" + String.valueOf(environment.getShipPartsTotalMissing()));
		lblSheildLevel.setText(String.valueOf(environment.ship.getSheildLevel()) + "%");
		progressBarSheildLvl.setValue(environment.ship.getSheildLevel());
	}
	/**Updates the view screen image at the top of the GUI*/
	private void updateViewScreen() {
		ImageIcon unscaledViewScreenImage = new ImageIcon(MainScreen.class.getResource(environment.currentLocation.getImagePath()));
		ImageIcon viewScreenImage = scaledImageIcon(unscaledViewScreenImage, VIEW_SCREEN_IMAGE_WIDTH, true);
		
		viewScreenImageLabel.setIcon(viewScreenImage);
	}
	/**Updates CrewMember1 (top left) to */
	private void updateCrewMember1() {
		crewMember1 = environment.crew.getCrewMember(CREW_MEMBER_1_ID);
		panelCrewMember1.setVisible(crewMember1.isAlive());
		
		progressBarHealth1.setValue(crewMember1.getHealth());
		progressBarHealth1.setForeground(progressBarColor(progressBarHealth1.getValue(), crewMember1));
		lblRemainingActions1.setText(String.valueOf((crewMember1.getNumActions()) + "/" + crewMember1.MAX_ACTIONS));
		lblStanimaLevel1.setText(String.valueOf(crewMember1.getStamina()) + "%");
		lblHungerLevel1.setText(String.valueOf(crewMember1.getHunger()) + "%");
	}
	private void updateCrewMember2() {
		crewMember2 = environment.crew.getCrewMember(CREW_MEMBER_2_ID);
		panelCrewMember2.setVisible(crewMember2.isAlive());
		
		progressBarHealth2.setValue(crewMember2.getHealth());
		progressBarHealth2.setForeground(progressBarColor(progressBarHealth2.getValue(), crewMember2));
		lblRemainingActions2.setText(String.valueOf((crewMember2.getNumActions()) + "/" + crewMember2.MAX_ACTIONS));
		lblStanimaLevel2.setText(String.valueOf(crewMember2.getStamina()) + "%");
		lblHungerLevel2.setText(String.valueOf(crewMember2.getHunger()) + "%");
	}
	private void updateCrewMember3() {
		crewMember3 = environment.crew.getCrewMember(CREW_MEMBER_3_ID);
		panelCrewMember3.setVisible(crewMember3.isAlive());
		
		progressBarHealth3.setValue(crewMember3.getHealth());
		progressBarHealth3.setForeground(progressBarColor(progressBarHealth3.getValue(), crewMember3));
		lblRemainingActions3.setText(String.valueOf((crewMember3.getNumActions()) + "/" + crewMember3.MAX_ACTIONS));
		lblStanimaLevel3.setText(String.valueOf(crewMember3.getStamina()) + "%");
		lblHungerLevel3.setText(String.valueOf(crewMember3.getHunger()) + "%");
	}
	private void updateCrewMember4() {
		crewMember4 = environment.crew.getCrewMember(CREW_MEMBER_4_ID);
		panelCrewMember4.setVisible(crewMember4.isAlive());
		
		progressBarHealth4.setValue(crewMember4.getHealth());
		progressBarHealth4.setForeground(progressBarColor(progressBarHealth4.getValue(), crewMember4));
		lblRemainingActions4.setText(String.valueOf((crewMember4.getNumActions()) + "/" + crewMember4.MAX_ACTIONS));
		lblStanimaLevel4.setText(String.valueOf(crewMember4.getStamina()) + "%");
		lblHungerLevel4.setText(String.valueOf(crewMember4.getHunger()) + "%");
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		
		update();
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel backgroundImageLabel = new JLabel("");
		ImageIcon unscaledBackgroundImage = new ImageIcon(MainScreen.class.getResource("/Images/Main_Screen_Background.png"));
		ImageIcon backgroundImage = scaledImageIcon(unscaledBackgroundImage, BG_IMAGE_SCALE_FACTOR);
		
		ImageIcon unscaledimgExecuteNextAction = new ImageIcon(MainScreen.class.getResource("/Images/Go.png"));
		ImageIcon imgExecuteNextAction = scaledImageIcon(unscaledimgExecuteNextAction, GO_BUTTON_SCALE_FACTOR);
		
		JLabel lblShipName = new JLabel(environment.ship.getName());
		lblShipName.setHorizontalAlignment(SwingConstants.CENTER);
		// Sets text size based on length of ship name
		int shipNameFontSize = Math.min(50 * 13 / (10 + (int)(1.9*lblShipName.getText().length())), 32);
		lblShipName.setFont(new Font("Dialog", Font.BOLD, shipNameFontSize));
		lblShipName.setForeground(TOP_BAR_BLUE);
		lblShipName.setBounds(286, 365, 194, 39);
		frame.getContentPane().add(lblShipName);
		
		
		
		lblLocation.setForeground(Color.BLACK);
		lblLocation.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblLocation.setBounds(103, 446, 124, 47);
		frame.getContentPane().add(lblLocation);
		
		
		lblShipParts.setForeground(Color.BLACK);
		lblShipParts.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblShipParts.setBounds(642, 448, 68, 34);
		frame.getContentPane().add(lblShipParts);
		
		
		lblSheildLevel.setForeground(Color.BLACK);
		lblSheildLevel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblSheildLevel.setBounds(549, 520, 49, 16);
		frame.getContentPane().add(lblSheildLevel);
		
		
		progressBarSheildLvl.setForeground(new Color(0, 191, 255));
		progressBarSheildLvl.setBounds(603, 518, 146, 20);
		frame.getContentPane().add(progressBarSheildLvl);
		
		JButton btnNextPlanet = new JButton("");
		btnNextPlanet.setOpaque(false);
		btnNextPlanet.setContentAreaFilled(false);
		btnNextPlanet.setBorderPainted(false);
		btnNextPlanet.setBounds(385, 562, 186, 29);
		frame.getContentPane().add(btnNextPlanet);
		btnNextPlanet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.moveToNextPlanet();
			}
		});
		
		JButton btnViewInventory = new JButton("");
		btnViewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.viewInventory();
			}
		});
		btnViewInventory.setOpaque(false);
		btnViewInventory.setContentAreaFilled(false);
		btnViewInventory.setBorderPainted(false);
		btnViewInventory.setBounds(294, 492, 175, 29);
		frame.getContentPane().add(btnViewInventory);
		
		
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
		
		
		
		panelCrewMember1.setBackground(new Color(74, 170, 1));
		panelCrewMember1.setBounds(0, 604, 374, 86);
		frame.getContentPane().add(panelCrewMember1);
		panelCrewMember1.setLayout(null);
		
		
		progressBarHealth1.setToolTipText("Health Level");
		progressBarHealth1.setBackground(Color.BLACK);
		progressBarHealth1.setBounds(6, 75, 53, 8);
		panelCrewMember1.add(progressBarHealth1);
		
		JLabel lblNameHeading1 = new JLabel("Name:");
		lblNameHeading1.setForeground(Color.BLACK);
		lblNameHeading1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNameHeading1.setBounds(6, 6, 47, 16);
		panelCrewMember1.add(lblNameHeading1);
		
		JLabel lblName1 = new JLabel(crewMember1.getName());
		lblName1.setForeground(Color.BLACK);
		lblName1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblName1.setBounds(54, 6, 215, 16);
		panelCrewMember1.add(lblName1);
		
		JLabel lblTypeHeading1 = new JLabel("Specialty:");
		lblTypeHeading1.setForeground(Color.BLACK);
		lblTypeHeading1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTypeHeading1.setBounds(71, 27, 70, 16);
		panelCrewMember1.add(lblTypeHeading1);
		
		JLabel lblType1 = new JLabel(crewMember1.getSpecialization());
		lblType1.setForeground(Color.BLACK);
		lblType1.setHorizontalAlignment(SwingConstants.LEFT);
		lblType1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblType1.setBounds(143, 27, 117, 16);
		panelCrewMember1.add(lblType1);
		
		JLabel lblCrewAvatarImage1 = new JLabel("");
		ImageIcon unscaledAvatarImg1 = new ImageIcon(MainScreen.class.getResource(crewMember1.getAvatarImage()));
		ImageIcon avatarImg1 = scaledImageIcon(unscaledAvatarImg1, AVATAR_IMG_SIZE, AVATAR_IMG_SIZE);
		lblCrewAvatarImage1.setIcon(avatarImg1);
		lblCrewAvatarImage1.setForeground(Color.BLACK);
		lblCrewAvatarImage1.setBounds(6, 27, 53, 53);
		panelCrewMember1.add(lblCrewAvatarImage1);
		
		JLabel lblNextActionHeading1 = new JLabel("Next Action:");
		lblNextActionHeading1.setForeground(Color.BLACK);
		lblNextActionHeading1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNextActionHeading1.setBounds(71, 57, 88, 16);
		panelCrewMember1.add(lblNextActionHeading1);
		
		comboBoxNextAction1 = new JComboBox(convertCollectionForComboBox(crewMember1.ACTIONS, true));
		comboBoxNextAction1.setBounds(160, 53, 146, 27);
		panelCrewMember1.add(comboBoxNextAction1);
		
		
		lblRemainingActions1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRemainingActions1.setForeground(Color.BLACK);
		lblRemainingActions1.setBounds(345, 57, 23, 16);
		panelCrewMember1.add(lblRemainingActions1);
		
		
		lblStanimaLevel1.setForeground(Color.BLACK);
		lblStanimaLevel1.setBounds(332, 6, 36, 16);
		panelCrewMember1.add(lblStanimaLevel1);
		
		
		lblHungerLevel1.setForeground(Color.BLACK);
		lblHungerLevel1.setBounds(332, 27, 36, 16);
		panelCrewMember1.add(lblHungerLevel1);
		
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
				environment.executeCrewMemberAction(crewMember1, comboBoxNextAction1.getSelectedItem().toString());
				comboBoxNextAction1.setSelectedIndex(0);
			}
		});
		
		JLabel lblHealthHeading1 = new JLabel("Hunger:");
		lblHealthHeading1.setForeground(Color.BLACK);
		lblHealthHeading1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblHealthHeading1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHealthHeading1.setBounds(262, 27, 61, 16);
		panelCrewMember1.add(lblHealthHeading1);
		btnExecuteNextAction1.setFont(new Font("Dialog", Font.PLAIN, 9));
		btnExecuteNextAction1.setBounds(310, 54, 23, 23);
		panelCrewMember1.add(btnExecuteNextAction1);
		
		
		
		panelCrewMember2.setLayout(null);
		panelCrewMember2.setBackground(new Color(74, 170, 1));
		panelCrewMember2.setBounds(390, 604, 374, 86);
		frame.getContentPane().add(panelCrewMember2);
		
		
		progressBarHealth2.setToolTipText("Health Level");
		progressBarHealth2.setBackground(Color.BLACK);
		
		progressBarHealth2.setBounds(6, 75, 53, 8);
		panelCrewMember2.add(progressBarHealth2);
		
		JLabel lblNameHeading2 = new JLabel("Name:");
		lblNameHeading2.setForeground(Color.BLACK);
		lblNameHeading2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNameHeading2.setBounds(6, 6, 47, 16);
		panelCrewMember2.add(lblNameHeading2);
		
		JLabel lblName2 = new JLabel(crewMember2.getName());
		lblName2.setForeground(Color.BLACK);
		lblName2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblName2.setBounds(54, 6, 215, 16);
		panelCrewMember2.add(lblName2);
		
		JLabel lblTypeHeading2 = new JLabel("Specialty:");
		lblTypeHeading2.setForeground(Color.BLACK);
		lblTypeHeading2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTypeHeading2.setBounds(71, 27, 70, 16);;
		panelCrewMember2.add(lblTypeHeading2);
		
		JLabel lblType2 = new JLabel(crewMember2.getSpecialization());
		lblType2.setForeground(Color.BLACK);
		lblType2.setHorizontalAlignment(SwingConstants.LEFT);
		lblType2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblType2.setBounds(143, 27, 117, 16);
		panelCrewMember2.add(lblType2);
		
		JLabel lblCrewAvatarImage2 = new JLabel("");
		ImageIcon unscaledAvatarImg2 = new ImageIcon(MainScreen.class.getResource(crewMember2.getAvatarImage()));
		ImageIcon avatarImg2 = scaledImageIcon(unscaledAvatarImg2, AVATAR_IMG_SIZE, AVATAR_IMG_SIZE);
		lblCrewAvatarImage2.setIcon(avatarImg2);
		lblCrewAvatarImage2.setForeground(Color.BLACK);
		lblCrewAvatarImage2.setBounds(6, 27, 53, 53);
		panelCrewMember2.add(lblCrewAvatarImage2);
		
		JLabel lblNextActionHeading2 = new JLabel("Next Action:");
		lblNextActionHeading2.setForeground(Color.BLACK);
		lblNextActionHeading2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNextActionHeading2.setBounds(71, 57, 88, 16);
		panelCrewMember2.add(lblNextActionHeading2);
		
		comboBoxNextAction2 = new JComboBox(convertCollectionForComboBox(crewMember2.ACTIONS, true));
		comboBoxNextAction2.setBounds(160, 53, 146, 27);
		panelCrewMember2.add(comboBoxNextAction2);
		
		
		lblRemainingActions2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRemainingActions2.setForeground(Color.BLACK);
		lblRemainingActions2.setBounds(345, 57, 23, 16);
		panelCrewMember2.add(lblRemainingActions2);
		
		
		lblStanimaLevel2.setForeground(Color.BLACK);
		lblStanimaLevel2.setBounds(332, 6, 36, 16);
		panelCrewMember2.add(lblStanimaLevel2);
		
		
		lblHungerLevel2.setForeground(Color.BLACK);
		lblHungerLevel2.setBounds(332, 27, 36, 16);
		panelCrewMember2.add(lblHungerLevel2);
		
		JLabel lblStanimaHeading2 = new JLabel("Stanima:");
		lblStanimaHeading2.setForeground(Color.BLACK);
		lblStanimaHeading2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStanimaHeading2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblStanimaHeading2.setBounds(259, 6, 64, 16);
		panelCrewMember2.add(lblStanimaHeading2);
		
		JLabel lblHealthHeading2 = new JLabel("Hunger:");
		lblHealthHeading2.setForeground(Color.BLACK);
		lblHealthHeading2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHealthHeading2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblHealthHeading2.setBounds(259, 27, 64, 16);
		panelCrewMember2.add(lblHealthHeading2);
		
		JButton btnExecuteNextAction2 = new JButton("");
		btnExecuteNextAction2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.executeCrewMemberAction(crewMember2, comboBoxNextAction2.getSelectedItem().toString());
				comboBoxNextAction2.setSelectedIndex(0);
			}
		});
		btnExecuteNextAction2.setIcon(imgExecuteNextAction);
		btnExecuteNextAction2.setFont(new Font("Dialog", Font.PLAIN, 9));
		btnExecuteNextAction2.setBounds(310, 54, 23, 23);
		panelCrewMember2.add(btnExecuteNextAction2);
		
		
		
		panelCrewMember3.setLayout(null);
		panelCrewMember3.setBackground(new Color(74, 170, 1));
		panelCrewMember3.setBounds(0, 705, 374, 86);
		frame.getContentPane().add(panelCrewMember3);
		
		progressBarHealth3.setToolTipText("Health Level");
		progressBarHealth3.setBackground(Color.BLACK);
		
		progressBarHealth3.setBounds(6, 75, 53, 8);
		panelCrewMember3.add(progressBarHealth3);
		
		JLabel lblNameHeading3 = new JLabel("Name:");
		lblNameHeading3.setForeground(Color.BLACK);
		lblNameHeading3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNameHeading3.setBounds(6, 6, 47, 16);
		panelCrewMember3.add(lblNameHeading3);
		
		JLabel lblName3 = new JLabel(crewMember3.getName());
		lblName3.setForeground(Color.BLACK);
		lblName3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblName3.setBounds(54, 6, 215, 16);
		panelCrewMember3.add(lblName3);
		
		JLabel lblTypeHeading3 = new JLabel("Specialty:");
		lblTypeHeading3.setForeground(Color.BLACK);
		lblTypeHeading3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTypeHeading3.setBounds(71, 27, 70, 16);;
		panelCrewMember3.add(lblTypeHeading3);
		
		JLabel lblType3 = new JLabel(crewMember3.getSpecialization());
		lblType3.setForeground(Color.BLACK);
		lblType3.setHorizontalAlignment(SwingConstants.LEFT);
		lblType3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblType3.setBounds(143, 27, 117, 16);
		panelCrewMember3.add(lblType3);
		
		JLabel lblCrewAvatarImage3 = new JLabel("");
		ImageIcon unscaledAvatarImg3 = new ImageIcon(MainScreen.class.getResource(crewMember3.getAvatarImage()));
		ImageIcon avatarImg3 = scaledImageIcon(unscaledAvatarImg3, AVATAR_IMG_SIZE, AVATAR_IMG_SIZE);
		lblCrewAvatarImage3.setIcon(avatarImg3);
		lblCrewAvatarImage3.setForeground(Color.BLACK);
		lblCrewAvatarImage3.setBounds(6, 27, 53, 53);
		panelCrewMember3.add(lblCrewAvatarImage3);
		
		JLabel lblNextActionHeading3 = new JLabel("Next Action:");
		lblNextActionHeading3.setForeground(Color.BLACK);
		lblNextActionHeading3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNextActionHeading3.setBounds(71, 57, 88, 16);
		panelCrewMember3.add(lblNextActionHeading3);
		
		comboBoxNextAction3 = new JComboBox(convertCollectionForComboBox(crewMember3.ACTIONS, true));
		comboBoxNextAction3.setBounds(160, 53, 146, 27);
		panelCrewMember3.add(comboBoxNextAction3);
		
		
		lblRemainingActions3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRemainingActions3.setForeground(Color.BLACK);
		lblRemainingActions3.setBounds(345, 57, 23, 16);
		panelCrewMember3.add(lblRemainingActions3);
		
		
		lblStanimaLevel3.setForeground(Color.BLACK);
		lblStanimaLevel3.setBounds(332, 6, 36, 16);
		panelCrewMember3.add(lblStanimaLevel3);
		
		
		lblHungerLevel3.setForeground(Color.BLACK);
		lblHungerLevel3.setBounds(332, 27, 36, 16);
		panelCrewMember3.add(lblHungerLevel3);
		
		JLabel lblStanimaHeading3 = new JLabel("Stanima:");
		lblStanimaHeading3.setForeground(Color.BLACK);
		lblStanimaHeading3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStanimaHeading3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblStanimaHeading3.setBounds(259, 6, 64, 16);
		panelCrewMember3.add(lblStanimaHeading3);
		
		JLabel lblHealthHeading3 = new JLabel("Hunger:");
		lblHealthHeading3.setForeground(Color.BLACK);
		lblHealthHeading3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHealthHeading3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblHealthHeading3.setBounds(262, 27, 61, 16);
		panelCrewMember3.add(lblHealthHeading3);
		
		JButton btnExecuteNextAction3 = new JButton("");
		btnExecuteNextAction3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.executeCrewMemberAction(crewMember3, comboBoxNextAction3.getSelectedItem().toString());
				comboBoxNextAction3.setSelectedIndex(0);
			}
		});
		btnExecuteNextAction3.setIcon(imgExecuteNextAction);
		btnExecuteNextAction3.setBounds(310, 54, 23, 23);
		panelCrewMember3.add(btnExecuteNextAction3);
		
		
		
		panelCrewMember4.setLayout(null);
		panelCrewMember4.setBackground(new Color(74, 170, 1));
		panelCrewMember4.setBounds(390, 705, 374, 86);
		frame.getContentPane().add(panelCrewMember4);
		
		
		progressBarHealth4.setToolTipText("Health Level");
		progressBarHealth4.setBackground(Color.BLACK);
		
		
		progressBarHealth4.setBounds(6, 75, 53, 8);
		panelCrewMember4.add(progressBarHealth4);
		
		JLabel lblNameHeading4 = new JLabel("Name:");
		lblNameHeading4.setForeground(Color.BLACK);
		lblNameHeading4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNameHeading4.setBounds(6, 6, 47, 16);
		panelCrewMember4.add(lblNameHeading4);
		
		JLabel lblName4 = new JLabel(crewMember4.getName());
		lblName4.setForeground(Color.BLACK);
		lblName4.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblName4.setBounds(54, 6, 215, 16);
		panelCrewMember4.add(lblName4);
		
		JLabel lblTypeHeading4 = new JLabel("Specialty:");
		lblTypeHeading4.setForeground(Color.BLACK);
		lblTypeHeading4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTypeHeading4.setBounds(71, 27, 70, 16);;
		panelCrewMember4.add(lblTypeHeading4);
		
		JLabel lblType4 = new JLabel(crewMember4.getSpecialization());
		lblType4.setForeground(Color.BLACK);
		lblType4.setHorizontalAlignment(SwingConstants.LEFT);
		lblType4.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblType4.setBounds(143, 27, 117, 16);
		panelCrewMember4.add(lblType4);
		
		JLabel lblCrewAvatarImage4 = new JLabel("");
		ImageIcon unscaledAvatarImg4 = new ImageIcon(MainScreen.class.getResource(crewMember4.getAvatarImage()));
		ImageIcon avatarImg4 = scaledImageIcon(unscaledAvatarImg4, AVATAR_IMG_SIZE, AVATAR_IMG_SIZE);
		lblCrewAvatarImage4.setIcon(avatarImg4);
		lblCrewAvatarImage4.setForeground(Color.BLACK);
		lblCrewAvatarImage4.setBounds(6, 27, 53, 53);
		panelCrewMember4.add(lblCrewAvatarImage4);
		
		JLabel lblNextActionHeading4 = new JLabel("Next Action:");
		lblNextActionHeading4.setForeground(Color.BLACK);
		lblNextActionHeading4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNextActionHeading4.setBounds(71, 57, 88, 16);
		panelCrewMember4.add(lblNextActionHeading4);
		
		comboBoxNextAction4 = new JComboBox(convertCollectionForComboBox(crewMember4.ACTIONS, true));
		comboBoxNextAction4.setBounds(160, 53, 146, 27);
		panelCrewMember4.add(comboBoxNextAction4);
		
		lblRemainingActions4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRemainingActions4.setForeground(Color.BLACK);
		lblRemainingActions4.setBounds(345, 57, 23, 16);
		panelCrewMember4.add(lblRemainingActions4);
		
		
		lblStanimaLevel4.setForeground(Color.BLACK);
		lblStanimaLevel4.setBounds(332, 6, 36, 16);
		panelCrewMember4.add(lblStanimaLevel4);
		
		
		lblHungerLevel4.setForeground(Color.BLACK);
		lblHungerLevel4.setBounds(332, 27, 36, 16);
		panelCrewMember4.add(lblHungerLevel4);
		
		JLabel lblStanimaHeading4 = new JLabel("Stanima:");
		lblStanimaHeading4.setForeground(Color.BLACK);
		lblStanimaHeading4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStanimaHeading4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblStanimaHeading4.setBounds(259, 6, 64, 16);
		panelCrewMember4.add(lblStanimaHeading4);
		
		JLabel lblHealthHeading4 = new JLabel("Hunger:");
		lblHealthHeading4.setForeground(Color.BLACK);
		lblHealthHeading4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHealthHeading4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblHealthHeading4.setBounds(259, 27, 64, 16);
		panelCrewMember4.add(lblHealthHeading4);
		
		JButton btnExecuteNextAction4 = new JButton("");
		btnExecuteNextAction4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.executeCrewMemberAction(crewMember4, comboBoxNextAction4.getSelectedItem().toString());
				comboBoxNextAction4.setSelectedIndex(0);
			}
		});
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
		
		
		viewScreenImageLabel.setBounds(101, -15, VIEW_SCREEN_IMAGE_WIDTH, 283);
		frame.getContentPane().add(viewScreenImageLabel);
		
		
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
	private ImageIcon scaledImageIcon(ImageIcon unscaledImageIcon, int sideLength, boolean scaleByWidth) {
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
	private ImageIcon scale(ImageIcon unscaledImageIcon, int width, int height) {
		Image image = unscaledImageIcon.getImage();
		Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
		unscaledImageIcon = new ImageIcon(newimg);
		return unscaledImageIcon;
	}
	
	private Color progressBarColor(int healthBarLevel, CrewMember member) {
		Color barColor;
		if (member.hasSpacePlague()) {
			barColor = new Color(186, 85, 211);  //Bright purple
		} else if (healthBarLevel >= (100 * 2/3)) {
			barColor = Color.GREEN;
		} else if ((healthBarLevel >= (100 * 1/3) && healthBarLevel < (100 * 2/3))) {
			barColor = Color.YELLOW;
		} else {
			barColor = Color.RED;
		}
		return barColor;
	}

	/** Converts a set into a primitive array that can be used by a comboBox.  Boolean capitalize capitalized the first letter of each word.*/
	private String[] convertCollectionForComboBox(Set<String> set, boolean capitalize) {
		String[] comboBoxArray = new String[set.size() + 1];
		comboBoxArray[0] = "";
		int i = 1;
		for (String str: set) {
			if (capitalize) comboBoxArray[i] = Misc.capitalize(str);
			else comboBoxArray[i] = str;
			i++;
		}
		return comboBoxArray;
	}
	
	public String getSelectedNextAction(int crewMemberID) throws CrewMemberNotFoundException {
		JComboBox comboBox;
		switch (crewMemberID) {
		case 0:
			comboBox = comboBoxNextAction1;
			break;
		case 1:
			comboBox = comboBoxNextAction2;
			break;
		case 2:
			comboBox = comboBoxNextAction3;
			break;
		case 3:
			comboBox = comboBoxNextAction4;
			break;
		default:
			throw new CrewMemberNotFoundException("The CrewMember with ID " + crewMemberID + " is not part of the crew.");
		}
		return comboBox.getSelectedItem().toString().toLowerCase();
	}
	public String getSelectedNextAction(CrewMember member) throws CrewMemberNotFoundException {
		if (member.equals(environment.crew.getCrewMember(member.getCrewMemberID()))) {
			return getSelectedNextAction(member.getCrewMemberID());
		} else {
			throw new CrewMemberNotFoundException("The CrewMember " + member.getName() + " is not part of the crew or has a crewMemberID mismatch");
		}
	}
	public void clearComboBoxes(int crewMemberID) {
		switch (crewMemberID) {
		case 0:
			comboBoxNextAction1.setSelectedIndex(0);
			break;
		case 1:
			comboBoxNextAction2.setSelectedIndex(0);
			break;
		case 2:
			comboBoxNextAction3.setSelectedIndex(0);
			break;
		case 3:
			comboBoxNextAction4.setSelectedIndex(0);
			break;
		default:
			break;
		}
	}
	public void clearComboBoxes(CrewMember member) {
		if (member.equals(environment.crew.getCrewMember(member.getCrewMemberID()))) {
			clearComboBoxes(member.getCrewMemberID());
		}
	}
	public void clearComboBoxes() {
		comboBoxNextAction1.setSelectedIndex(0);
		comboBoxNextAction2.setSelectedIndex(0);
		comboBoxNextAction3.setSelectedIndex(0);
		comboBoxNextAction4.setSelectedIndex(0);
	}
}





///**
// * Launch the application.
// */
//public static void main(String[] args) {
//	MainScreen window = new MainScreen();
//	window.frame.setVisible(true);
//	
//}