package Environment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Environment.CrewMemberTypes.Captain;
import Environment.CrewMemberTypes.Captain;
import Environment.CrewMemberTypes.CrewMember;
import Environment.CrewMemberTypes.Doctor;
import Environment.CrewMemberTypes.Engineer;
import Environment.CrewMemberTypes.Navigator;
import Environment.CrewMemberTypes.Scientist;
import Environment.CrewMemberTypes.Security;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import java.awt.SystemColor;
import java.awt.Font;

/**
 * The window to choose the types of your crew members and size of crew.
 * @author Benjamin Thurber
 * @author Blake Kayser
 */
public class TeamSelection {
	private JFrame frmMeteorMadness;

	private GameEnvironment environment;
	private JTextField textFieldEnterName;
	private JLabel lblAvatar;
	
	private final int AVATAR_IMAGE_HEIGHT = 188;

	private ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();

	/**
	 * Launch the application.
	 * @param args runtime arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEnvironment environment = new GameEnvironment();
					TeamSelection window = new TeamSelection(environment);
					window.frmMeteorMadness.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param environment the current GameEnvironment
	 */
	public TeamSelection(GameEnvironment environment) {
		this.environment = environment;
		initialize();
	}
	
	/**
	 * Closes the window.  Called by GameEnvironment
	 */
	public void closeWindow() {
		frmMeteorMadness.dispose();
	}
	
	/**Method called when window needs to be closed, and the next window needs to open.*/
	public void finishedWindow() {
		environment.closeTeamSelection(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMeteorMadness = new JFrame();
		frmMeteorMadness.setTitle("Meteor Madness");
		frmMeteorMadness.setBounds(GameEnvironment.WINDOW_INIT_X, GameEnvironment.WINDOW_INIT_Y, 800, 493);
		frmMeteorMadness.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMeteorMadness.getContentPane().setLayout(null);
		frmMeteorMadness.setResizable(false);

		JLabel lblAdvice = new JLabel("<html><div style='text-align: center;'>Select Heroes to view their traits!<br/><br/>Name your crew member and press 'Add' to add them to your team.<br/><br/>Press 'Remove' to remove a Hero.<br/><br/> Your crew can have up to four members!<br/><br/> Press confirm when you are happy with your team :)</div></html>");
		lblAdvice.setForeground(new Color(211, 211, 211));
		lblAdvice.setBounds(414, 187, 144, 255);
		frmMeteorMadness.getContentPane().add(lblAdvice);

		JLabel lblSpecial = new JLabel("");
		lblSpecial.setForeground(new Color(230, 230, 230));
		lblSpecial.setBounds(532, 49, 232, 110);
		frmMeteorMadness.getContentPane().add(lblSpecial);

		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (crewList.size() >= 2) {
					environment.crew.addNewCrewMembers(crewList);
					finishedWindow();
					System.out.println("crew members added to the ship");
				} else {
					lblAdvice.setText(Misc.formatWithHTML("You need to select at least 2 crew members", "center"));
				}
			}
		});
		btnConfirm.setBounds(624, 417, 114, 25);
		frmMeteorMadness.getContentPane().add(btnConfirm);

		JLabel lblNewLabel = new JLabel("<html><div style='text-align: center;'>Specialization</div></html>");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(211, 211, 211));
		lblNewLabel.setBounds(579, 12, 124, 25);
		frmMeteorMadness.getContentPane().add(lblNewLabel);

		JToggleButton tglbtnEngineer = new JToggleButton("Engineer");
		tglbtnEngineer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					lblSpecial.setText(Engineer.getDescription());
					ImageIcon imgAvatar = ImageManipulation.scaledImageIcon(new ImageIcon(TeamSelection.class.getResource(Engineer.avatarImage)), AVATAR_IMAGE_HEIGHT, false);
					lblAvatar.setIcon(imgAvatar);
					System.out.println("Engineer is selected");
				} else if(e.getStateChange()==ItemEvent.DESELECTED){
					System.out.println("Engineer is not selected");
				}
			}
		});		
		tglbtnEngineer.setBounds(30, 77, 144, 35);
		frmMeteorMadness.getContentPane().add(tglbtnEngineer);

		JToggleButton tglbtnScientist = new JToggleButton("Scientist");
		tglbtnScientist.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					lblSpecial.setText(Scientist.getDescription());
					ImageIcon imgAvatar = ImageManipulation.scaledImageIcon(new ImageIcon(TeamSelection.class.getResource(Scientist.avatarImage)), AVATAR_IMAGE_HEIGHT, false);
					lblAvatar.setIcon(imgAvatar);
					System.out.println("Scientist is selected");
				} else if(e.getStateChange()==ItemEvent.DESELECTED){
					System.out.println("Scientist is not selected");
				}
			}
		});
		tglbtnScientist.setBounds(201, 24, 144, 35);
		frmMeteorMadness.getContentPane().add(tglbtnScientist);

		JToggleButton tglbtnDoctor = new JToggleButton("Doctor");
		tglbtnDoctor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					lblSpecial.setText(Doctor.getDescription());
					ImageIcon imgAvatar = ImageManipulation.scaledImageIcon(new ImageIcon(TeamSelection.class.getResource(Doctor.avatarImage)), AVATAR_IMAGE_HEIGHT, false);
					lblAvatar.setIcon(imgAvatar);
					System.out.println("Doctor is selected");
				} else if(e.getStateChange()==ItemEvent.DESELECTED){
					System.out.println("Doctor is not selected");
				}
			}
		});
		tglbtnDoctor.setBounds(370, 24, 144, 35);
		frmMeteorMadness.getContentPane().add(tglbtnDoctor);

		JToggleButton tglbtnNavigator = new JToggleButton("Navigator");
		tglbtnNavigator.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					lblSpecial.setText(Navigator.getDescription());
					ImageIcon imgAvatar = ImageManipulation.scaledImageIcon(new ImageIcon(TeamSelection.class.getResource(Navigator.avatarImage)), AVATAR_IMAGE_HEIGHT, false);
					lblAvatar.setIcon(imgAvatar);
					System.out.println("Navigator is selected");
				} else if(e.getStateChange()==ItemEvent.DESELECTED){
					System.out.println("Navigator is not selected");
				}
			}
		});
		tglbtnNavigator.setBounds(201, 77, 144, 35);
		frmMeteorMadness.getContentPane().add(tglbtnNavigator);

		JToggleButton tglbtnSecurity = new JToggleButton("Security Guard");
		tglbtnSecurity.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					lblSpecial.setText(Security.getDescription());
					ImageIcon imgAvatar = ImageManipulation.scaledImageIcon(new ImageIcon(TeamSelection.class.getResource(Security.avatarImage)), AVATAR_IMAGE_HEIGHT, false);
					lblAvatar.setIcon(imgAvatar);
					System.out.println("Security is selected");
				} else if(e.getStateChange()==ItemEvent.DESELECTED){
					System.out.println("Security is not selected");
				}
			}
		});
		tglbtnSecurity.setBounds(370, 77, 144, 35);
		frmMeteorMadness.getContentPane().add(tglbtnSecurity);

		JToggleButton tglbtnCaptain = new JToggleButton("Captain");
		tglbtnCaptain.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					lblSpecial.setText(Captain.getDescription());
					ImageIcon imgAvatar = ImageManipulation.scaledImageIcon(new ImageIcon(TeamSelection.class.getResource(Captain.avatarImage)), AVATAR_IMAGE_HEIGHT, false);
					lblAvatar.setIcon(imgAvatar);
					System.out.println("Captain is selected");
				} else if(e.getStateChange()==ItemEvent.DESELECTED){
					System.out.println("Captain is not selected");
				}
			}
		});
		tglbtnCaptain.setBounds(30, 24, 144, 35);
		frmMeteorMadness.getContentPane().add(tglbtnCaptain);

		ButtonGroup classes = new ButtonGroup();
		classes.add(tglbtnEngineer);
		classes.add(tglbtnScientist);
		classes.add(tglbtnDoctor);
		classes.add(tglbtnNavigator);
		classes.add(tglbtnSecurity);
		classes.add(tglbtnCaptain);

		JLabel lblShowCurrentTeam = new JLabel("");
		lblShowCurrentTeam.setForeground(Color.WHITE);
		lblShowCurrentTeam.setBackground(Color.WHITE);
		lblShowCurrentTeam.setBounds(45, 289, 358, 153);
		frmMeteorMadness.getContentPane().add(lblShowCurrentTeam);

		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (crewList.size() < 4) {
					if(tglbtnEngineer.isSelected()) {
						String name = textFieldEnterName.getText();
						crewList.add(new Engineer(name));
						System.out.println("Engineer added to array");
						System.out.println(crewList);
						System.out.println(crewList.size());
					}	

					if(tglbtnScientist.isSelected()) {
						String name = textFieldEnterName.getText();
						crewList.add(new Scientist(name));
						System.out.println("Scientist added to array");
						System.out.println(crewList);
						System.out.println(crewList.size());
					}

					if(tglbtnDoctor.isSelected()) {
						String name = textFieldEnterName.getText();
						crewList.add(new Doctor(name));
						System.out.println("Doctor added to array");
						System.out.println(crewList);
						System.out.println(crewList.size());
					}

					if(tglbtnNavigator.isSelected()) {
						String name = textFieldEnterName.getText();
						crewList.add(new Navigator(name));
						System.out.println("Navigator added to array");
						System.out.println(crewList);
						System.out.println(crewList.size());
					}

					if(tglbtnSecurity.isSelected()) {
						String name = textFieldEnterName.getText();
						crewList.add(new Security(name));
						System.out.println("Security added to array");
						System.out.println(crewList);
						System.out.println(crewList.size());
					}

					if(tglbtnCaptain.isSelected()) {
						String name = textFieldEnterName.getText();
						crewList.add(new Captain(name));
						System.out.println("Captain added to array");
						System.out.println(crewList);
						System.out.println(crewList.size());
					}

					lblShowCurrentTeam.setText(ArrayToString(crewList));
				}else {
					lblAdvice.setText("<html><div style='text-align: center;'>Your crew is at capacity!<br/><br/>Remove a crew member<br/>by clicking the \"REMOVE\" button.<br/><br/>Press confirm when you are happy with your team :)</div></html>");
				}
			}
		});
		btnAdd.setBounds(48, 212, 114, 25);
		frmMeteorMadness.getContentPane().add(btnAdd);

		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (crewList.size() < 5) {
					lblAdvice.setText("<html><div style='text-align: center;'>Select Heroes to view their traits!<br/><br/>Name your crew member and press 'Add' to add them to your team.<br/><br/>Press 'Remove' to remove a Hero.<br/><br/> Your crew can have up to four members!<br/><br/> Press confirm when you are happy with your team :)</div></html>");
					System.out.println(crewList.size());
				}
				if (crewList.size() > 0) {
					crewList.remove(crewList.size() -1);
					System.out.println(crewList);
				}else {
					lblAdvice.setText("<html><div style='text-align: center;'>Your crew doesn't have any members!<br/><br/>Select Heroes to view their traits!<br/><br/>Press 'Add' to add them to your team.<br/><br/> Your crew can have up to four members!<br/><br/>Press confirm when you are happy with your team :)</div></html>");
					System.out.println("Crew at size 0, cannot remove");
				}
				lblShowCurrentTeam.setText(ArrayToString(crewList));
			}
		});
		btnRemove.setBounds(220, 212, 114, 25);
		frmMeteorMadness.getContentPane().add(btnRemove);

		JLabel lblSpaceCrew = new JLabel("Space Crew");
		lblSpaceCrew.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSpaceCrew.setForeground(new Color(211, 211, 211));
		lblSpaceCrew.setBounds(45, 262, 129, 15);
		frmMeteorMadness.getContentPane().add(lblSpaceCrew);

		textFieldEnterName = new JTextField();
		textFieldEnterName.setBounds(30, 174, 315, 25);
		frmMeteorMadness.getContentPane().add(textFieldEnterName);
		textFieldEnterName.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.LIGHT_GRAY);
		lblName.setBounds(40, 134, 66, 15);
		frmMeteorMadness.getContentPane().add(lblName);

		lblAvatar = new JLabel("");
		lblAvatar.setIcon(new ImageIcon(TeamSelection.class.getResource("/Images/Avatars/captain.png")));
		lblAvatar.setBounds(598, 187, 166, 196);
		frmMeteorMadness.getContentPane().add(lblAvatar);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(TeamSelection.class.getResource("/Images/Locations/EmptySpace.png")));
		lblBackground.setBounds(0, -3, 800, 475);
		frmMeteorMadness.getContentPane().add(lblBackground);

		frmMeteorMadness.setVisible(true);
	}

	/**
	 * Creates a string representing an ArrayList of CrewMembers for use in the GUI
	 * @param crewList An ArrayList of crew members
	 * @return a string with each crew member in crewList as "Specialization, Name" and then 2 new lines
	 */
	private String ArrayToString(ArrayList<CrewMember> crewList) {
		String teamArray = "";
		for(int i=0; i < crewList.size(); i++) {
			teamArray += crewList.get(i).getSpecialization() + ", " + crewList.get(i).getName() + "\n\n";	
			System.out.println(teamArray);
		}
		return(Misc.formatWithHTML(teamArray, "left"));
	}	
}
