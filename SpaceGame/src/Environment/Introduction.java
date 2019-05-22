package Environment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ComboBoxModel;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class Introduction {

	private JFrame frmMeteorMadness;
	private JLabel lblHowManyDays;
	private JButton btnConfirm;
	
	private GameEnvironment environment;
	
	public int daysToPlay;
	
	public String shipName;
	private JLabel lblASpaceCrew;
	private JTextField textField;
	private JLabel lblNewLabel;

	/*public void closeWindow() {
		frmMeteorMadness.dispose();
	}
	
	public void finishedWindow() {
		GameEnvironment.closeIntroduction(this);
	}*/
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GameEnvironment environment = new GameEnvironment();
		Introduction window = new Introduction(environment);
		window.frmMeteorMadness.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public Introduction(GameEnvironment environment) {
		this.environment = environment;
		initialize();
	}
	
	public void closeWindow() {
		frmMeteorMadness.dispose();
	}
	
	public void finishedWindow() {
		environment.closeIntroduction(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMeteorMadness = new JFrame();
		frmMeteorMadness.setTitle("Meteor Madness");
		frmMeteorMadness.getContentPane().setEnabled(true);
		frmMeteorMadness.getContentPane().setLayout(null);
		
		JLabel lblMeteorMadness = new JLabel("Meteor Madness");
		lblMeteorMadness.setFont(new Font("L M Mono Caps10", Font.BOLD, 26));
		lblMeteorMadness.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeteorMadness.setForeground(Color.YELLOW);
		lblMeteorMadness.setBounds(264, 22, 252, 41);
		frmMeteorMadness.getContentPane().add(lblMeteorMadness);
		
		lblHowManyDays = new JLabel("<html><div style='text-align: center;'>Howdy Space Cadet!<br/> Your mission, if you choose to accept it, is to find all components to your ship to get back to earth. <br/> How many days will your mission last?</div></html>");
		lblHowManyDays.setForeground(Color.LIGHT_GRAY);
		lblHowManyDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowManyDays.setBounds(87, 75, 614, 68);
		frmMeteorMadness.getContentPane().add(lblHowManyDays);
		
		String days[] = {"3", "4", "5", "6", "7", "8", "9", "10"};
		
		JComboBox comboBox = new JComboBox(days);
		comboBox.setBounds(351, 155, 96, 24);
		frmMeteorMadness.getContentPane().add(comboBox);
		frmMeteorMadness.setBounds(GameEnvironment.WINDOW_INIT_X, GameEnvironment.WINDOW_INIT_Y, 800, 493);
		frmMeteorMadness.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnConfirm = new JButton("CONFIRM");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String daysToPlay = comboBox.getSelectedItem().toString();
				shipName = textField.getText();
				System.out.println("Confirm " + daysToPlay + " days to play.");
				System.out.println("Ship named " + shipName);
				System.out.println("Change to TeamSelection window");
				setDaysToPlay(Integer.valueOf(daysToPlay));    // Ben added this.  Sets object attribute daysToPlay to local String daysToPlay and converts to int
				environment.ship.setName(getShipName());
				finishedWindow();
			}
		});
		btnConfirm.setBounds(347, 356, 114, 25);
		frmMeteorMadness.getContentPane().add(btnConfirm);
		
		lblASpaceCrew = new JLabel("<html><div style='text-align: center;'>A space crew is nothing without their ship. What will you name yours?</div></html>");
		lblASpaceCrew.setForeground(Color.LIGHT_GRAY);
		lblASpaceCrew.setBounds(242, 201, 317, 80);
		frmMeteorMadness.getContentPane().add(lblASpaceCrew);
		
		textField = new JTextField();
		textField.setBounds(340, 293, 124, 19);
		frmMeteorMadness.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Introduction.class.getResource("/Images/Locations/EmptySpace.png")));
		lblNewLabel.setBounds(0, 0, 800, 472);
		frmMeteorMadness.getContentPane().add(lblNewLabel);
		
		frmMeteorMadness.setVisible(true);
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public int getDaysToPlay() {
		return daysToPlay;
	}

	public void setDaysToPlay(int daysToPlay) {
		this.daysToPlay = daysToPlay;
	}
	
	
}
