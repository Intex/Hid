package com.intexsoft.sensor;

import com.intexsoft.sensor.components.ConnectionIndicator;
import com.intexsoft.sensor.components.ConnectionInfoLabel;
import com.intexsoft.sensor.components.StartButton;
import com.intexsoft.sensor.components.GraphPanel;
import com.intexsoft.sensor.components.ValidDataIndicator;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

    private static final long serialVersionUID = 5605409120229305701L;

   
    public MainPanel(){
    	
    	setLayout(new GridBagLayout());
    	
    	ValidDataIndicator validDataIndicator = new ValidDataIndicator(null, "valid data",
				 "correct.png",  "incorrect.jpg");
		
		validDataIndicator.setOn(true);

		ConnectionIndicator connectionIndicator = new ConnectionIndicator(new Dimension(22, 22),
				"connection", "true.jpg", "false.jpg");
		connectionIndicator.setOn(true);

		ConnectionInfoLabel connectionInfoLabel = new ConnectionInfoLabel();
		connectionInfoLabel
				.setText("Connected...Connected...Connected...Connected...");
		
		GraphPanel graphPanel=new GraphPanel();
		
		StartButton startButton = new StartButton(connectionInfoLabel,graphPanel);

		startButton.setName("Start/Stop");
		startButton.setText("Start/Stop");
		
		startButton.addComp(this, startButton);
		validDataIndicator.addComp(this, validDataIndicator);
		connectionIndicator.addComp(this, connectionIndicator);
		connectionInfoLabel.addComp(this, connectionInfoLabel);
		graphPanel.addComp(this, graphPanel.getPanel());
    	
    	
    }

   
}
