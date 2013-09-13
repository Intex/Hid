package com.intexsoft.sensor.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import com.intexsoft.sensor.MainPanel;

public class ValidDataIndicator extends Indicator implements IAdd<ValidDataIndicator> {

	
	private static final long serialVersionUID = 1L;
	

    public static final int VALID_INDICATOR_GRID_X = 3;
    public static final int VALID_INDICATOR_GRID_Y = 1;
    
    private GridBagConstraints gridBagConstraints =new GridBagConstraints();
 
    public ValidDataIndicator(){}
    
    public ValidDataIndicator(Dimension dimension, String toolTipText, String trueIconPath, String falseIconPath) {
		super(dimension,toolTipText,trueIconPath,falseIconPath);

		this.gridBagConstraints.gridx = VALID_INDICATOR_GRID_X;
		this.gridBagConstraints.gridy = VALID_INDICATOR_GRID_Y;
    }

	@Override
	public void addComp(MainPanel mainPanel, ValidDataIndicator comp) {
		mainPanel.add(comp, getGridBagConstraints());
		
	}

	 public GridBagConstraints getGridBagConstraints() {
			return gridBagConstraints;
		}
}
