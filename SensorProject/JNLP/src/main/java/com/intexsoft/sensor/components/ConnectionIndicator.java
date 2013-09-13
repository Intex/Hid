package com.intexsoft.sensor.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import com.intexsoft.sensor.MainPanel;

public class ConnectionIndicator extends Indicator implements IAdd<ConnectionIndicator>{

	private static final long serialVersionUID = 1L;
	public static final int CONNECTION_INDICATOR_GRID_X = 3;
    public static final int CONNECTION_INDICATOR_GRID_Y = 3;
    
    private GridBagConstraints gridBagConstraints=new GridBagConstraints() ;
    
   
	public ConnectionIndicator(){}
    
    public ConnectionIndicator(Dimension dimension, String toolTipText, String trueIconPath, String falseIconPath) {
		super(dimension,toolTipText,trueIconPath,falseIconPath);
		
		this.gridBagConstraints.gridx = CONNECTION_INDICATOR_GRID_X ;
		this.gridBagConstraints.gridy = CONNECTION_INDICATOR_GRID_Y;
    }

	@Override
	public void addComp(MainPanel mainPanel, ConnectionIndicator comp) {
		mainPanel.add(comp,getGridBagConstraints());
		
	}


	 public GridBagConstraints getGridBagConstraints() {
			return gridBagConstraints;
		}

}
