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

public class Introduction {

	private JFrame frmMeteorMadness;
	private JLabel lblHowManyDays;
	private JButton btnConfirm;
	
	private GameEnvironment environment;
	
	public int daysToPlay;
	
	public String shipName;
	private JLabel lblASpaceCrew;
	private JTextField textField;

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
		lblMeteorMadness.setBounds(333, 33, 131, 15);
		frmMeteorMadness.getContentPane().add(lblMeteorMadness);
		
		lblHowManyDays = new JLabel("<html><div style='text-align: center;'>Howdy Space Cadet!<br/> Your mission, if you choose to accept it, is to find all components to your ship to get back to earth. <br/> How many days will your mission last?</div></html>");
		lblHowManyDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowManyDays.setBounds(87, 75, 614, 68);
		frmMeteorMadness.getContentPane().add(lblHowManyDays);
		
		String days[] = {"3", "4", "5", "6", "7", "8", "9", "10"};
		
		JComboBox comboBox = new JComboBox(days);
		comboBox.setBounds(351, 155, 96, 24);
		frmMeteorMadness.getContentPane().add(comboBox);
		frmMeteorMadness.setBounds(100, 100, 800, 500);
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
		btnConfirm.setBounds(351, 356, 114, 25);
		frmMeteorMadness.getContentPane().add(btnConfirm);
		
		lblASpaceCrew = new JLabel("<html><div style='text-align: center;'>A space crew is nothing without their ship. What will you name yours?</div></html>");
		lblASpaceCrew.setBounds(242, 201, 317, 80);
		frmMeteorMadness.getContentPane().add(lblASpaceCrew);
		
		textField = new JTextField();
		textField.setBounds(340, 293, 124, 19);
		frmMeteorMadness.getContentPane().add(textField);
		textField.setColumns(10);
		
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
