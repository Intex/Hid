package com.intexsoft.sensor;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingsPanel extends JPanel {

	private static final long serialVersionUID = 640029470434166332L;

	private JLabel selectLocation() {
		JLabel labelDevices = new JLabel("Select your loacation: ");
		return labelDevices;
	}

	private JLabel selectDevice() {
		JLabel labelDevices = new JLabel("Select your device: ");
		return labelDevices;
	}

	private JLabel help() {
		JLabel jLabel = new JLabel();
		String help = "Help...";
		jLabel.setText(help);
		return jLabel;
	}

	private JButton getButtonOk() {
		JButton button = new JButton();
		button.setName("Ok");
		button.setText("Ok");
		return button;
	}

	private JComboBox<String> changeCity() {
		JComboBox<String>  boxCity = new JComboBox<String>();
		String[] array = { "Сity0", "Сity1" };
		boxCity = new JComboBox<String>(array);
		return boxCity;
	}

	private JComboBox<String>  changeCountry() {
		JComboBox<String>  boxCountry = new JComboBox<String>();
		String[] array = { "Country0", "Country1" };
		boxCountry = new JComboBox<String> (array);
		return boxCountry;
	}
	
	private JComboBox<String> arrayDevice(int n) {
		String[] data = new String[n];
		for (int i = 0; i < data.length; i++) {
			data[i] = new String("devices_" + i);
		}
		JComboBox<String> box = new JComboBox<String>(data);
		return box;
	}
	
	public void setCell(GridBagConstraints gridBagConstaints,int x,int y,Component comp){
		
		gridBagConstaints.gridx = x;
		gridBagConstaints.gridy = y;
		add(comp, gridBagConstaints);
	}

	public SettingsPanel() {
		setLayout(new GridBagLayout());
		GridBagConstraints gridBagConstaints = new GridBagConstraints();
		int n = 4 + new Random().nextInt(8);

		gridBagConstaints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstaints.weightx = 0.2;
		gridBagConstaints.insets = new Insets(10, 20, 0, 20);

		setCell(gridBagConstaints,1,1,selectLocation());
		setCell(gridBagConstaints,1,2,changeCountry());
		
		gridBagConstaints.weightx = 0.5;
		setCell(gridBagConstaints,1,3,changeCity());
		setCell(gridBagConstaints,2,3,getButtonOk());
		setCell(gridBagConstaints,1,5,selectDevice());
		setCell(gridBagConstaints,1,6,arrayDevice(n));
		
		gridBagConstaints.ipady = 0;
		gridBagConstaints.weighty = 1.0;
		gridBagConstaints.anchor = GridBagConstraints.PAGE_END;
		gridBagConstaints.gridwidth = 2;
		setCell(gridBagConstaints,1,7,help());
		
	}
}
