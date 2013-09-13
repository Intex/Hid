package com.intexsoft.sensor.components;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import com.intexsoft.sensor.MainPanel;

public class ConnectionInfoLabel extends JLabel implements IAdd<ConnectionInfoLabel> {
	
	
	private static final long serialVersionUID = 1L;
	
	public static final int CONNECTION_INFO_LABEL_IPAD_Y = 0;
	public static final double CONNECTION_INFO_LABEL_WEIGHT_Y = 1D;
    public static final int CONNECTION_INFO_LABEL_ANCHOR = GridBagConstraints.PAGE_END;
    public static final int CONNECTION_INFO_LABEL_GRID_X = 1;
    public static final int CONNECTION_INFO_LABEL_GRID_Y = 3;
	public static final int CONNECTION_INFO_LABEL_GRID_WIDTH = 2;
	
	private GridBagConstraints gridBagConstraints=new GridBagConstraints() ;
	
	public ConnectionInfoLabel(){
		this.gridBagConstraints.ipady = CONNECTION_INFO_LABEL_IPAD_Y;
		this.gridBagConstraints.weighty = CONNECTION_INFO_LABEL_WEIGHT_Y;
		this.gridBagConstraints.anchor = CONNECTION_INFO_LABEL_ANCHOR;
		this.gridBagConstraints.gridx = CONNECTION_INFO_LABEL_GRID_X;
		this.gridBagConstraints.gridy = CONNECTION_INFO_LABEL_GRID_Y;
		this.gridBagConstraints.gridwidth = CONNECTION_INFO_LABEL_GRID_WIDTH;
	}

	@Override
	public void addComp(MainPanel mainPanel, ConnectionInfoLabel comp) {
		mainPanel.add(comp, getGridBagConstraints());
		
	}
	
	public GridBagConstraints getGridBagConstraints() {
		return gridBagConstraints;
	}

}
