package com.intexsoft.sensor;

import com.intexsoft.sensor.components.StartButton;
import com.intexsoft.sensor.components.GraphPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

    private static final long serialVersionUID = 5605409120229305701L;

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

    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private Indicator validDataIndicator;
    private JLabel connectionInfoLabel;
    private Indicator connectionIndicator;
    private GraphPanel graphPanel;

    public MainPanel(StartButton startButton, Indicator validDataIndicator,
                     Indicator connectionIndicator, JLabel connectionInfoLabel, GraphPanel graphPanel) {
        setLayout(new GridBagLayout());
        this.graphPanel = graphPanel;
        this.connectionIndicator = connectionIndicator;
        this.connectionInfoLabel = connectionInfoLabel;
        this.validDataIndicator = validDataIndicator;

        addStartButton(startButton);
        addValidDataIndicator(validDataIndicator);
        addConnectionInfoLabel(connectionInfoLabel);
        addConnectionIndicator(connectionIndicator);
        addGraphic(graphPanel);
    }

    private void addStartButton(StartButton startButton) {
        startButton.init(gridBagConstraints, connectionInfoLabel, graphPanel);
        add(startButton, startButton.getGridBagConstraints());
    }

    private void addValidDataIndicator(Indicator validDataIndicator) {
        gridBagConstraints.gridx = VALID_INDICATOR_GRID_X;
        gridBagConstraints.gridy = VALID_INDICATOR_GRID_Y;
        add(validDataIndicator, gridBagConstraints);
    }

    private void addConnectionInfoLabel(JLabel connectionInfoLabel) {
        gridBagConstraints.ipady = CONNECTION_INFO_LABEL_IPAD_Y;
        gridBagConstraints.weighty = CONNECTION_INFO_LABEL_WEIGHT_Y;
        gridBagConstraints.anchor = CONNECTION_INFO_LABEL_ANCHOR;
        gridBagConstraints.gridx = CONNECTION_INFO_LABEL_GRID_X;
        gridBagConstraints.gridy = CONNECTION_INFO_LABEL_GRID_Y;
        gridBagConstraints.gridwidth = CONNECTION_INFO_LABEL_GRID_WIDTH;
        add(connectionInfoLabel, gridBagConstraints);
    }

    private void addConnectionIndicator(Indicator connectionIndicator) {
        gridBagConstraints.gridx = CONNECTION_INDICATOR_GRID_X;
        gridBagConstraints.gridy = CONNECTION_INDICATOR_GRID_Y;
        add(connectionIndicator, gridBagConstraints);
    }

    private void addGraphic(GraphPanel graphPanel) {
        graphPanel.init(gridBagConstraints);
        add(graphPanel.getPanel(), graphPanel.getGridBagConstraints());
    }
}
