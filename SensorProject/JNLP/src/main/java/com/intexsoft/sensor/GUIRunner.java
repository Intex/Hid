package com.intexsoft.sensor;

import com.intexsoft.sensor.components.StartButton;
import com.intexsoft.sensor.components.GraphPanel;
import org.jfree.ui.RefineryUtilities;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.UIManager.*;

public class GUIRunner {
	
	public static final String URL_TO_IMAGES = GUIRunner.class.getResource("/").getPath();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Nimbus L&F doesn't found.");
        }

		JFrame frame = new JFrame("jFrame");
		
		StartButton startButton = new StartButton();

		startButton.setName("Start/Stop");
		startButton.setText("Start/Stop");
		
		Indicator validDataIndicator = new Indicator(null, "valid data",
				URL_TO_IMAGES + "correct.png", URL_TO_IMAGES + "incorrect.jpg");
		
		validDataIndicator.setOn(true);

		Indicator connectionIndicator = new Indicator(new Dimension(22, 22),
				"connection", URL_TO_IMAGES + "true.jpg", URL_TO_IMAGES + "false.jpg");
		connectionIndicator.setOn(true);

		JLabel connectionInfoLabel = new JLabel();
		connectionInfoLabel
				.setText("Connected...Connected...Connected...Connected...");
		
		/*ImageIcon image = new ImageIcon(URL_TO_IMAGES + "gr.jpg");
		JLabel graphic = new JLabel(image);
		graphic.setPreferredSize(new Dimension(300, 50));*/

		JPanel main = new MainPanel(startButton, validDataIndicator,
				connectionIndicator, connectionInfoLabel, new GraphPanel());
		JPanel settings = new SettingsPanel();

		JTabbedPane jtp = new JTabbedPane();

		jtp.add("Main menu", main);
		jtp.add("Settings", settings);
		frame.getContentPane().add(jtp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(740, 620);
        frame.setMinimumSize(new Dimension(740, 620));
        RefineryUtilities.centerFrameOnScreen(frame);
	}

}
