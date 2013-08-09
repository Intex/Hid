package main;

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
		// TODO Auto-generated method stub
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

	public SettingsPanel() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		int n = 4 + new Random().nextInt(8);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.2;
		c.insets = new Insets(10, 20, 0, 20);

		c.gridx = 1;
		c.gridy = 1;
		add(selectLocation(), c);

		c.gridx = 1;
		c.gridy = 2;
		add(changeCountry(), c);

		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 3;
		add(changeCity(), c);

		c.gridx = 2;
		c.gridy = 3;
		add(getButtonOk(), c);

		c.gridx = 1;
		c.gridy = 5;
		add(selectDevice(), c);

		c.gridx = 1;
		c.gridy = 6;
		add(arrayDevice(n), c);

		c.ipady = 0;
		c.weighty = 1.0;
		c.anchor = GridBagConstraints.PAGE_END;
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 7;
		add(help(), c);
	}
}
