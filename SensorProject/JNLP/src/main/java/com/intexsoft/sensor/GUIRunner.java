package com.intexsoft.sensor;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GUIRunner {
	
	public static final String URL_TO_IMAGES = GUIRunner.class.getResource("/").getPath();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("jFrame");
		
		JButton startButton = new JButton();

		startButton.setName("Start/Stop");
		startButton.setText("Start/Stop");
		
		Indicator validDataIndicator = new Indicator(null, "valid data",
				URL_TO_IMAGES + "correct.jpg", URL_TO_IMAGES + "incorrect.jpg");
		
		validDataIndicator.setOn(true);

		Indicator connectionIndicator = new Indicator(new Dimension(22, 22),
				"connection", URL_TO_IMAGES + "true.jpg", URL_TO_IMAGES + "false.jpg");
		connectionIndicator.setOn(true);

		JLabel connectionInfoLabel = new JLabel();
		connectionInfoLabel
				.setText("Connected...Connected...Connected...Connected...");
		
		ImageIcon image = new ImageIcon(URL_TO_IMAGES + "gr.jpg");
		JLabel graphic = new JLabel(image);
		graphic.setPreferredSize(new Dimension(600, 265));

		JPanel main = new MainPanel(startButton, validDataIndicator,
				connectionIndicator, connectionInfoLabel, graphic);
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
