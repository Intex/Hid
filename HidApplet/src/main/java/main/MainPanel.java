package main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 5605409120229305701L;

	public static final int START_BUTTON_FILL = GridBagConstraints.HORIZONTAL;
	public static final double START_BUTTON_WEIGHTX = 0.5;
	public static final Insets START_BUTTON_INSETS = new Insets(10, 20, 0, 20);
	public static final int START_BUTTON_GRID_X = 0;
	public static final int START_BUTTON_GRID_Y = 1;

	public static final int VALID_INDICATOR_GRID_X = 3;
	public static final int VALID_INDICATOR_GRID_Y = 1;

	private JButton startButton;
	private Indicator validDataIndicator;
	private Indicator connectionIndicator;
	private JLabel connectionInfoLabel;

	private GridBagConstraints gridBagConstraints = new GridBagConstraints();

	public MainPanel(JButton startButton, Indicator validDataIndicator,
			Indicator connectionIndicator, JLabel connectionInfoLabel) {
		setLayout(new GridBagLayout());

		addStartButton(startButton);
		addValidDataIndicator(validDataIndicator);
		addConnectionInfoLabel(connectionInfoLabel);
		addConnectionIndicator(connectionIndicator);

		gridBagConstraints.ipady = 40;
		gridBagConstraints.weightx = 0.0;
		gridBagConstraints.gridwidth = 5;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		ImageIcon image = new ImageIcon("gr.jpg");
		JLabel jLabel = new JLabel(image);
		jLabel.setPreferredSize(new Dimension(600, 265));
		
		add(jLabel, gridBagConstraints);
		
	}

	private void addStartButton(JButton startButton) {
		gridBagConstraints.fill = START_BUTTON_FILL;
		gridBagConstraints.weightx = START_BUTTON_WEIGHTX;
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
		gridBagConstraints.ipady = 0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.PAGE_END;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridy = 3;
		add(connectionInfoLabel, gridBagConstraints);
		this.connectionInfoLabel = connectionInfoLabel;
	}
	
	private void addConnectionIndicator(Indicator connectionIndicator) {
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 3;
		add(connectionIndicator, gridBagConstraints);
		this.connectionIndicator = connectionIndicator;
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
	
}
