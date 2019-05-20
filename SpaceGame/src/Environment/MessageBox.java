package Environment;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MessageBox extends JDialog {
	
	private static int lastWindowX = 500;
	private static int lastWindowY = 200;
	private static int lastWindowWidth = 500;
	private static int lastWindowHeight = 200;
	private final int WINDOW_PADDING_WIDTH = 100;
	private final int WINDOW_PADDING_HEIGHT = 80;
	private final int WINDOW_MAX_WIDTH = 400;
	private final String WHITESPACE = "            ";
	
	private final JPanel contentPanel = new JPanel();
	
	public JPanel messagepanel = new JPanel();
	private String message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MessageBox dialog = new MessageBox("Test Message");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**Create the dialog.  Takes X, Y, Width and Height parameteres.*/
	public MessageBox(String messageText, int parentX, int parentY, int parentWidth, int parentHeight) {
		message = messageText;
		setBounds(500, 200, 300, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			contentPanel.add(messagepanel);
			messagepanel.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JLabel lblMessage = new JLabel(Misc.formatWithHTML(message, "center"));
				messagepanel.add(lblMessage);
				lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		{
			JLabel lblPaddingWest = new JLabel(WHITESPACE);
			contentPanel.add(lblPaddingWest, BorderLayout.WEST);
		}
		{
			JLabel lblPaddingEast = new JLabel(WHITESPACE);
			contentPanel.add(lblPaddingEast, BorderLayout.EAST);
		}
		{
			JLabel lblPaddingSouth = new JLabel(WHITESPACE);
			contentPanel.add(lblPaddingSouth, BorderLayout.SOUTH);
		}
		{
			JLabel lblPaddingNorth = new JLabel(WHITESPACE);
			contentPanel.add(lblPaddingNorth, BorderLayout.NORTH);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.pack();
		int windowWidth = Math.min((int) this.getSize().getSize().getWidth(), WINDOW_MAX_WIDTH);
		int windowHeight = (int) this.getSize().getSize().getHeight();
		int windowWidthPadded = windowWidth + WINDOW_PADDING_WIDTH;
		int windowHeightPadded = windowHeight + WINDOW_PADDING_HEIGHT;
		int windowX = parentX + parentWidth/2 - windowWidthPadded/2;
		int windowY = parentY + parentHeight/2 - windowHeightPadded/2;
		System.out.println(windowWidthPadded +" "+ windowWidthPadded);
		this.setBounds(windowX, windowY, windowWidthPadded, windowHeightPadded);
		this.setVisible(true);
		lastWindowX = parentX;
		lastWindowY = parentY;
		lastWindowWidth = parentWidth;
		lastWindowHeight = parentHeight;
	}
	public MessageBox(String messageText) {
		this(messageText, lastWindowX, lastWindowY, lastWindowWidth, lastWindowHeight);
	}
	public MessageBox(String messageText, MainScreen parent) {
		this(messageText, parent.frame.getX(), parent.frame.getY(), parent.frame.getWidth(), parent.frame.getHeight());
	}
	
}
