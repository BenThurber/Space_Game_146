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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * The Window at the end of the game to show your final score.
 * 
 * @author Benjamin Thurber
 * @author Blake Kayser
 */
public class ScoreBoard {
	private JFrame frame;
	private GameEnvironment environment;
	private final int SPACE_PART_MULTIPLIER = 1000;
	private final int NUM_DAYS_TAKEN_MULTIPLIER = 800;
	private final int CREW_ALIVE_MULTIPLIER = 600;
	private final int SHIP_SHIELD_LOST_MULTIPLIER = 1;
	private final int WORST_CASE_SHIELD_LOSS = 150;

	/**
	 * Launch the application.
	 * @param args runtime arguments
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
	 * @param environment the current GameEnvironment
	 */
	public ScoreBoard(GameEnvironment environment) {
		this.environment = environment;
		initialize();
	}
	
	/**Closes the ScoreBoard window variable*/
	public void closeWindow() {
		frame.dispose();
	}
	
	/**Closes ScoreBoard and exits.  Method called when window needs to be closed, and the game quits*/
	public void finishedWindow() {
		environment.closeScoreBoard(this);
	}
	
	/**Closes ScoreBoard and restarts the game.  Method called when window needs to be closed, and game restarted*/
	public void finishedWindowAndRestartGame() {
		environment.closeScoreBoard(this);
		GameEnvironment newEnvironment = new GameEnvironment();
		newEnvironment.launchIntroduction();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(GameEnvironment.WINDOW_INIT_X, GameEnvironment.WINDOW_INIT_Y, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblScoreBoard = new JLabel("Score Board");
		lblScoreBoard.setBounds(111, 0, 222, 41);
		lblScoreBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoreBoard.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		frame.getContentPane().add(lblScoreBoard);
		
		JLabel lblDaysTaken = new JLabel("Days Taken:");
		lblDaysTaken.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDaysTaken.setBounds(47, 63, 100, 16);
		frame.getContentPane().add(lblDaysTaken);
		
		JLabel lblDaysTakenFraction = new JLabel(String.valueOf(Math.min(environment.getCurrentDay(), environment.getTotalDays()) + "/" + environment.getTotalDays()));
		lblDaysTakenFraction.setBounds(159, 63, 77, 16);
		frame.getContentPane().add(lblDaysTakenFraction);
		
		JLabel lblPartsFound = new JLabel("Parts Found:");
		lblPartsFound.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPartsFound.setBounds(238, 63, 100, 16);
		frame.getContentPane().add(lblPartsFound);
		
		JLabel lblPartsFoundFraction = new JLabel(String.valueOf(environment.getShipPartsFound()) + "/" + environment.getShipPartsTotalMissing());
		lblPartsFoundFraction.setBounds(350, 63, 77, 16);
		frame.getContentPane().add(lblPartsFoundFraction);
		
		JLabel lblCrewKilled = new JLabel("Crew Killed:");
		lblCrewKilled.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrewKilled.setBounds(47, 103, 100, 16);
		frame.getContentPane().add(lblCrewKilled);
		
		System.out.println("Live Crew After Game: " + environment.crew.getNumLiveCrew());
		int numKilledCrew = environment.crew.getNumCrewMembers() - environment.crew.getNumLiveCrew();
		JLabel lblCrewKilledFraction = new JLabel(String.valueOf(numKilledCrew) + "/" + environment.crew.getNumCrewMembers());
		lblCrewKilledFraction.setBounds(159, 103, 77, 16);
		frame.getContentPane().add(lblCrewKilledFraction);
		
		JLabel lblFinalScoreHeading = new JLabel("Final Score");
		lblFinalScoreHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinalScoreHeading.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFinalScoreHeading.setBounds(166, 142, 118, 41);
		frame.getContentPane().add(lblFinalScoreHeading);
		
		JLabel finalScore = new JLabel(String.valueOf(getFinalScore()));
		finalScore.setHorizontalAlignment(SwingConstants.CENTER);
		finalScore.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		finalScore.setBounds(176, 184, 93, 26);
		frame.getContentPane().add(finalScore);
		
		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindowAndRestartGame();
			}
		});
		btnPlayAgain.setBounds(281, 230, 117, 29);
		frame.getContentPane().add(btnPlayAgain);
		
		JButton btnQuit = new JButton("Exit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnQuit.setBounds(59, 230, 117, 29);
		frame.getContentPane().add(btnQuit);
		
		JLabel lblSheildLevelHeading = new JLabel("Total Shield Lost:");
		lblSheildLevelHeading.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSheildLevelHeading.setBounds(206, 103, 132, 16);
		frame.getContentPane().add(lblSheildLevelHeading);
		
		JLabel lblSheildLevel = new JLabel(String.valueOf(Math.abs(environment.ship.getTotalLostEnergy())) + "%");
		lblSheildLevel.setBounds(350, 103, 77, 16);
		frame.getContentPane().add(lblSheildLevel);
		
		frame.setVisible(true);
	}
	
	/**
	 * Returns the final score from playing the game.  To calculate the score, uses the percent number of crew alive of total, 
	 * the total amount of shield lost for the while game, the percent number of parts found of total, 
	 * the percent number of days left of total.
	 * @return an integer the final score (a somewhat arbitrary number representing the score)
	 */
	public int getFinalScore() {
		double percCrewAlive = environment.crew.getNumLiveCrew() / environment.crew.getNumCrewMembers();
		double percShipShieldLost = Math.abs(environment.ship.getTotalLostEnergy());
		double percPartsFound = environment.getShipPartsFound() / environment.getShipPartsTotalMissing();
		double percDaysLeft = 1 - (environment.getCurrentDay() / environment.getTotalDays());
		double finalScore = Math.max(0, (SPACE_PART_MULTIPLIER * percPartsFound) + (NUM_DAYS_TAKEN_MULTIPLIER * percDaysLeft) + (CREW_ALIVE_MULTIPLIER * percCrewAlive) - (SHIP_SHIELD_LOST_MULTIPLIER * percShipShieldLost) + WORST_CASE_SHIELD_LOSS);
		return Math.round((float)finalScore);
	}
}
