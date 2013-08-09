package main;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Indicator extends JLabel {

	private static final long serialVersionUID = -3329260821694909800L;
	
	private String falseIconPath;
	public String trueIconPath;
	
	private boolean on;

	public Indicator(Dimension dimension, String toolTipText, String trueIconPath, String falseIconPath) {
		super();
		setPreferredSize(dimension);
		setToolTipText(toolTipText);
		setTrueIconPath(trueIconPath);
		setFalseIconPath(falseIconPath);
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		ImageIcon icon = on ? new ImageIcon(getTrueIconPath()) : new ImageIcon(getFalseIconPath());
		setIcon(icon);
		this.on = on;
	}

	public String getFalseIconPath() {
		return falseIconPath;
	}

	public void setFalseIconPath(String falseIconPath) {
		this.falseIconPath = falseIconPath;
	}

	public String getTrueIconPath() {
		return trueIconPath;
	}

	public void setTrueIconPath(String trueIconPath) {
		this.trueIconPath = trueIconPath;
	}	
	

}
