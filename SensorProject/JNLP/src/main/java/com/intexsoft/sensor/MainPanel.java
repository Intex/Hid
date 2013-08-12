package com.intexsoft.sensor;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 5605409120229305701L;

	public static final int START_BUTTON_FILL = GridBagConstraints.HORIZONTAL;
	public static final double START_BUTTON_WEIGHT_X = 0.5;
	public static final Insets START_BUTTON_INSETS = new Insets(10, 20, 0, 20);
	public static final int START_BUTTON_GRID_X = 0;
	public static final int START_BUTTON_GRID_Y = 1;

	public static final int VALID_INDICATOR_GRID_X = 3;
	public static final int VALID_INDICATOR_GRID_Y = 1;
	
	public static final int CONNECTION_INFO_LABEL_IPAD_Y = 0;
	public static final double CONNECTION_INFO_LABEL_WEIGHT_Y = 1D;
	public static final int CONNECTION_INFO_LABEL_ANCHOR = GridBagConstraints.PAGE_END;
	public static final int CONNECTION_INFO_LABEL_GRID_X = 1;
	public static final int CONNECTION_INFO_LABEL_GRID_Y = 3;
	public static final int CONNECTION_INFO_LABEL_GRID_WIDTH = 2;
	
	public static final int CONNECTION_INDICATOR_GRID_X = 3;
	public static final int CONNECTION_INDICATOR_GRID_Y = 3;
	
	public static final int GRAPHIC_IPAD_Y = 40;
	public static final double GRAPHIC_WEIGHT_X = 0D;
	public static final int GRAHIC_GRID_WIDTH = 5;
	public static final int GRAPHIC_GRID_X = 0;
	public static final int GRAPHIC_GRID_Y = 2;	

	private JButton startButton;
	private Indicator validDataIndicator;
	private Indicator connectionIndicator;
	private JLabel connectionInfoLabel;
	private JLabel graphic;

	private GridBagConstraints gridBagConstraints = new GridBagConstraints();

	public MainPanel(JButton startButton, Indicator validDataIndicator,
			Indicator connectionIndicator, JLabel connectionInfoLabel, JLabel graphic) {
		setLayout(new GridBagLayout());

		addStartButton(startButton);
		addValidDataIndicator(validDataIndicator);
		addConnectionInfoLabel(connectionInfoLabel);
		addConnectionIndicator(connectionIndicator);
		addGraphic(graphic);		
	}

	private void addStartButton(JButton startButton) {
		gridBagConstraints.fill = START_BUTTON_FILL;
		gridBagConstraints.weightx = START_BUTTON_WEIGHT_X;
		gridBagConstraints.insets = START_BUTTON_INSETS;

		gridBagConstraints.gridx = START_BUTTON_GRID_X;
		gridBagConstraints.gridy = START_BUTTON_GRID_Y;
		add(startButton, gridBagConstraints);
		this.startButton = startButton;
	}

	private void addValidDataIndicator(Indicator validDataIndicator) {
		gridBagConstraints.gridx = VALID_INDICATOR_GRID_X;
		gridBagConstraints.gridy = VALID_INDICATOR_GRID_Y;
		add(validDataIndicator, gridBagConstraints);
		this.validDataIndicator = validDataIndicator;

	}

	private void addConnectionInfoLabel(JLabel connectionInfoLabel) {
		gridBagConstraints.ipady = CONNECTION_INFO_LABEL_IPAD_Y;
		gridBagConstraints.weighty = CONNECTION_INFO_LABEL_WEIGHT_Y;
		gridBagConstraints.anchor = CONNECTION_INFO_LABEL_ANCHOR;
		gridBagConstraints.gridx = CONNECTION_INFO_LABEL_GRID_X;
		gridBagConstraints.gridy = CONNECTION_INFO_LABEL_GRID_Y;
		gridBagConstraints.gridwidth = CONNECTION_INFO_LABEL_GRID_WIDTH;		
		add(connectionInfoLabel, gridBagConstraints);
		this.connectionInfoLabel = connectionInfoLabel;
	}
	
	private void addConnectionIndicator(Indicator connectionIndicator) {
		gridBagConstraints.gridx = CONNECTION_INDICATOR_GRID_X;
		gridBagConstraints.gridy = CONNECTION_INDICATOR_GRID_Y;
		add(connectionIndicator, gridBagConstraints);
		this.connectionIndicator = connectionIndicator;
	}
	
	private void addGraphic(JLabel graphic) {
		gridBagConstraints.ipady = GRAPHIC_IPAD_Y;
		gridBagConstraints.weightx = GRAPHIC_WEIGHT_X;
		gridBagConstraints.gridwidth = GRAHIC_GRID_WIDTH;
		gridBagConstraints.gridx = GRAPHIC_GRID_X;
		gridBagConstraints.gridy = GRAPHIC_GRID_Y;
		add(graphic, gridBagConstraints);
		this.setGraphic(graphic);
	}

	public JButton getStartButton() {
		return startButton;
	}

	public void setStartButton(JButton startButton) {
		this.startButton = startButton;
	}

	public Indicator getValidDataIndicator() {
		return validDataIndicator;
	}

	public void setValidDataIndicator(Indicator validDataIndicator) {
		this.validDataIndicator = validDataIndicator;
	}

	public Indicator getConnectionIndicator() {
		return connectionIndicator;
	}

	public void setConnectionIndicator(Indicator connectionIndicator) {
		this.connectionIndicator = connectionIndicator;
	}

	public JLabel getConnectionInfoLabel() {
		return connectionInfoLabel;
	}

	public void setConnectionInfoLabel(JLabel connectionInfoLabel) {
		this.connectionInfoLabel = connectionInfoLabel;
	}

	public GridBagConstraints getGridBagConstraints() {
		return gridBagConstraints;
	}

	public void setGridBagConstraints(GridBagConstraints gridBagConstraints) {
		this.gridBagConstraints = gridBagConstraints;
	}

	public JLabel getGraphic() {
		return graphic;
	}

	public void setGraphic(JLabel graphic) {
		this.graphic = graphic;
	}	
	
}
