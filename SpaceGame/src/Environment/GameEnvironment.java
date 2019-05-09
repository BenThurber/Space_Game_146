package Environment;

import java.awt.EventQueue;

public class GameEnvironment {
	
	
	public void launchMainWindow() {
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
	
	public static void main(String[] args) {
		GameEnvironment environment = new GameEnvironment();
		environment.launchMainWindow();
	}
}
