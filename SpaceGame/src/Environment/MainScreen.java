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
		frame = new JFrame();
		frame.setForeground(Color.BLACK);
		frame.setBounds(320, 100, 767, 832);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon("/Users/Ben/Desktop/SENG201/Project/Space_Game_146/Graphics/MainWindow/Main_Screen_Background half size.png"));
		// Label should be 22 shorter than window to fit perfectly in it
		//lblNewLabel.setBounds(0, -85, 767, 895);
		// Set width to 767 and export as PNG
		lblNewLabel.setBounds(0, -85, 767, 895);
		frame.getContentPane().add(lblNewLabel);
		
		//ImageIcon backgroundImage = new ImageIcon("/Users/Ben/Desktop/SENG201/Project/Space_Game_146/Graphics/MainWindow/Cropped half size.png");
		//backgroundImage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		
		//Image newImage = backgroundImage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

	}
}
