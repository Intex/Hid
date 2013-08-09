package main;

import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class MainApplet extends JApplet {

	private static final long serialVersionUID = 7536899015922113327L;

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					JButton startButton = new JButton();
					startButton.setName("Start/Stop");
					startButton.setText("Start/Stop");
					
					Indicator validDataIndicator = new Indicator(null, "valid data", "correct.jpg", "incorrect.jpg");
					validDataIndicator.setOn(true);

					Indicator connectionIndicator = new Indicator(new Dimension(22, 22), "connection", "true.jpg", "false.jpg");
					connectionIndicator.setOn(true);
					
					JLabel connectionInfoLabel = new JLabel();
					connectionInfoLabel.setText("Connected...Connected...Connected...Connected...");
					
					JPanel main = new MainPanel(startButton, validDataIndicator, connectionIndicator, connectionInfoLabel);
					JPanel settings = new SettingsPanel();

					JTabbedPane jtp = new JTabbedPane();

					jtp.add("Main menu", main);
					jtp.add("Settings", settings);
					getContentPane().add(jtp);
				}
			});
		} catch (Exception e) {
			System.err.println("createGUI didn't complete successfully");
		}
	}
}
