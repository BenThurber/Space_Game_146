package Environment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ScoreBoard {

	private JFrame frame;
	private GameEnvironment environment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEnvironment environment = new GameEnvironment();
					ScoreBoard window = new ScoreBoard(environment);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScoreBoard(GameEnvironment environment) {
		this.environment = environment;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblScoreBoard = new JLabel("Score Board");
		lblScoreBoard.setBounds(111, 0, 222, 41);
		lblScoreBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoreBoard.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		frame.getContentPane().add(lblScoreBoard);
		
		JLabel lblDaysTaken = new JLabel("Days Taken:");
		lblDaysTaken.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDaysTaken.setBounds(144, 53, 100, 16);
		frame.getContentPane().add(lblDaysTaken);
		
		JLabel lblNewLabel = new JLabel("0/0");
		lblNewLabel.setBounds(256, 53, 77, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPartsFound = new JLabel("Parts Found:");
		lblPartsFound.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPartsFound.setBounds(144, 81, 100, 16);
		frame.getContentPane().add(lblPartsFound);
		
		JLabel label_1 = new JLabel("0/0");
		label_1.setBounds(256, 81, 77, 16);
		frame.getContentPane().add(label_1);
		
		JLabel lblCrewKilled = new JLabel("Crew Killed:");
		lblCrewKilled.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrewKilled.setBounds(144, 109, 100, 16);
		frame.getContentPane().add(lblCrewKilled);
		
		JLabel label_2 = new JLabel("0/0");
		label_2.setBounds(256, 109, 77, 16);
		frame.getContentPane().add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("Final Score");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(166, 142, 118, 41);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("<Score>");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label.setBounds(176, 184, 93, 26);
		frame.getContentPane().add(label);
		
		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setBounds(281, 230, 117, 29);
		frame.getContentPane().add(btnPlayAgain);
		
		JButton btnQuit = new JButton("Exit");
		btnQuit.setBounds(59, 230, 117, 29);
		frame.getContentPane().add(btnQuit);
		
		frame.setVisible(true);
	}
}
