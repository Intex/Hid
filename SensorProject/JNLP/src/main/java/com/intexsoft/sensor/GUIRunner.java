package com.intexsoft.sensor;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class GUIRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("jFrame");

		JButton startButton = new JButton();
		startButton.setName("Start/Stop");
		startButton.setText("Start/Stop");
		Indicator validDataIndicator = new Indicator(null, "valid data",
				"correct.jpg", "incorrect.jpg");
		validDataIndicator.setOn(true);

		Indicator connectionIndicator = new Indicator(new Dimension(22, 22),
				"connection", "true.jpg", "false.jpg");
		connectionIndicator.setOn(true);

		JLabel connectionInfoLabel = new JLabel();
		connectionInfoLabel
				.setText("Connected...Connected...Connected...Connected...");

		JPanel main = new MainPanel(startButton, validDataIndicator,
				connectionIndicator, connectionInfoLabel);
		JPanel settings = new SettingsPanel();

		JTabbedPane jtp = new JTabbedPane();

		jtp.add("Main menu", main);
		jtp.add("Settings", settings);
		frame.getContentPane().add(jtp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(640, 480);
	}

}
