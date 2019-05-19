package Environment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.Color;

public class TeamSelection {

	private JFrame frmMeteorMadness;

	private GameEnvironment environment;
	
	/**
	 * Launch the application.
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
	 */
	public TeamSelection(GameEnvironment environment) {
		this.environment = environment;
		initialize();
	}
	
	public void closeWindow() {
		frmMeteorMadness.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMeteorMadness = new JFrame();
		frmMeteorMadness.setTitle("Meteor Madness");
		frmMeteorMadness.setBounds(100, 100, 800, 500);
		frmMeteorMadness.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMeteorMadness.getContentPane().setLayout(null);
		
		
		JLabel lblGreatChoicetext = new JLabel("<html><div style='text-align: center;'>Select Heroes to view their traits!<br/><br/>Press 'Add' to add them to your team.<br/><br/>Press 'Remove' to remove a Hero.<br/><br/> Your crew can have up to four members!<br/><br/> Press confirm when you are happy with your team :)</div></html>");
		lblGreatChoicetext.setForeground(new Color(211, 211, 211));
		lblGreatChoicetext.setBounds(414, 217, 144, 225);
		frmMeteorMadness.getContentPane().add(lblGreatChoicetext);
		
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.setBounds(624, 417, 114, 25);
		frmMeteorMadness.getContentPane().add(btnConfirm);
		
		JLabel lblNewLabel = new JLabel("<html><div style='text-align: center;'>Stats</div></html>");
		lblNewLabel.setForeground(new Color(211, 211, 211));
		lblNewLabel.setBounds(624, 12, 57, 25);
		frmMeteorMadness.getContentPane().add(lblNewLabel);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Engineer");
		tglbtnNewToggleButton.setBounds(30, 77, 144, 35);
		frmMeteorMadness.getContentPane().add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Scientist");
		tglbtnNewToggleButton_1.setBounds(201, 24, 144, 35);
		frmMeteorMadness.getContentPane().add(tglbtnNewToggleButton_1);
		
		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("Doctor");
		tglbtnNewToggleButton_2.setBounds(370, 24, 144, 35);
		frmMeteorMadness.getContentPane().add(tglbtnNewToggleButton_2);
		
		JToggleButton tglbtnNewToggleButton_3 = new JToggleButton("Navigator");
		tglbtnNewToggleButton_3.setBounds(201, 77, 144, 35);
		frmMeteorMadness.getContentPane().add(tglbtnNewToggleButton_3);
		
		JToggleButton tglbtnNewToggleButton_4 = new JToggleButton("Security Guard");
		tglbtnNewToggleButton_4.setBounds(370, 77, 144, 35);
		frmMeteorMadness.getContentPane().add(tglbtnNewToggleButton_4);
		
		JToggleButton tglbtnNewToggleButton_5 = new JToggleButton("Communicator");
		tglbtnNewToggleButton_5.setBounds(30, 24, 144, 35);
		frmMeteorMadness.getContentPane().add(tglbtnNewToggleButton_5);
		
		JLabel lblShowCurrentTeam = new JLabel("Show current team array");
		lblShowCurrentTeam.setForeground(Color.BLACK);
		lblShowCurrentTeam.setBackground(Color.WHITE);
		lblShowCurrentTeam.setBounds(45, 235, 358, 189);
		frmMeteorMadness.getContentPane().add(lblShowCurrentTeam);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(532, 49, 232, 153);
		frmMeteorMadness.getContentPane().add(lblNewLabel_1);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(45, 160, 114, 25);
		frmMeteorMadness.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setBounds(219, 160, 114, 25);
		frmMeteorMadness.getContentPane().add(btnRemove);
		
		JLabel lblSpaceCrew = new JLabel("Space Crew");
		lblSpaceCrew.setForeground(new Color(211, 211, 211));
		lblSpaceCrew.setBounds(55, 208, 91, 15);
		frmMeteorMadness.getContentPane().add(lblSpaceCrew);
		
		frmMeteorMadness.setVisible(true);
		
		/*JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 472);
		frmMeteorMadness.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(TeamSelection.class.getResource("/Images/space background_updated.gif")));
		backgroundLabel.setBounds(0, 0, 800, 472);
		panel.add(backgroundLabel);*/

	}
}
