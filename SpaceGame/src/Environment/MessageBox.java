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
	
	private final int WINDOW_PADDING_X = 100;
	private final int WINDOW_PADDING_Y = 80;
	private final int WINDOW_MAX_WIDTH = 400;
	private final String WHITESPACE = "            ";
	
	private final JPanel contentPanel = new JPanel();
	JPanel panel = new JPanel();
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

	/**
	 * Create the dialog.
	 */
	public MessageBox(String messageText) {
		message = messageText;
		setBounds(500, 200, 300, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JLabel label = new JLabel(Misc.formatWithHTML(message, "center"));
				panel.add(label);
				label.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		{
			JLabel label = new JLabel(WHITESPACE);
			contentPanel.add(label, BorderLayout.WEST);
		}
		{
			JLabel label = new JLabel(WHITESPACE);
			contentPanel.add(label, BorderLayout.EAST);
		}
		{
			JLabel lblNewLabel = new JLabel(WHITESPACE);
			contentPanel.add(lblNewLabel, BorderLayout.SOUTH);
		}
		{
			JLabel lblNewLabel_1 = new JLabel(WHITESPACE);
			contentPanel.add(lblNewLabel_1, BorderLayout.NORTH);
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
		System.out.println(windowWidth +" "+ windowHeight);
		this.setBounds(500, 200, windowWidth + WINDOW_PADDING_X, windowHeight + WINDOW_PADDING_Y);
		this.setVisible(true);
		
	}

}
