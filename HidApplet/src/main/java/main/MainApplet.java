package main;

import java.awt.*;
import java.util.Random;
import javax.swing.*;



public class MainApplet extends JApplet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// delete||change
	int n=4+new Random().nextInt(8);
	boolean ind= new Random().nextBoolean();

	private JLabel selectDevice() {
		JLabel labelDevices=new JLabel("Select your device: "); 
		return labelDevices;
	}

	private JComboBox arrayDevice(int n){
		String [] data= new String[n];
		for(int i=0; i<data.length;i++){
			data[i]=new String("devices_"+i);
		}
		JComboBox box=new JComboBox(data);
		return box;
	}

	private JLabel indicator(){	
		JLabel labelIndicator= new JLabel();

		ImageIcon iconIndicatorTrue = new ImageIcon("true.jpg");
		ImageIcon iconIndicatorFalse = new ImageIcon("false.jpg");

		if(ind==false) labelIndicator.setIcon(iconIndicatorFalse);
		else labelIndicator.setIcon(iconIndicatorTrue);	
		labelIndicator.setPreferredSize(new Dimension(22, 22));
		return labelIndicator;
	}
	
	private JLabel validDate(){	
		JLabel labelIndicator= new JLabel();

		ImageIcon iconIndicatorTrue = new ImageIcon("correct.jpg");
		ImageIcon iconIndicatorFalse = new ImageIcon("incorrect.jpg");

		if(ind==false) labelIndicator.setIcon(iconIndicatorFalse);
		else labelIndicator.setIcon(iconIndicatorTrue);	
		return labelIndicator;
	}

	private JLabel selectLocation() {
		JLabel labelDevices=new JLabel("Select your loacation: "); 
		return labelDevices;
	}

	private JButton getButtonStart() {
		JButton buttonStart=new JButton();
		buttonStart.setName("Start/Stop");
		buttonStart.setText("Start/Stop");
		return buttonStart;
	}

	private JButton getButtonOk() {
		JButton button=new JButton();
		button.setName("Ok");
		button.setText("Ok");
		return button;
	}

	private JComboBox changeCity(){
		JComboBox boxCity= new JComboBox();
		String[] array={"Сity0","Сity1"};
		boxCity = new JComboBox(array);				
		return boxCity;
	}

	private JComboBox changeCountry(){
		JComboBox boxCountry= new JComboBox();
		String[] array={"Country0","Country1"};
		boxCountry = new JComboBox(array);				
		return boxCountry;
	}

	private JLabel grapphics(){
		ImageIcon image= new ImageIcon("gr.jpg");
		JLabel jLabel= new JLabel(image);
		jLabel.setPreferredSize(new Dimension(600, 265));
		return jLabel;
	}

	private JLabel infConnect(){
		JLabel jLabel= new JLabel();
		String inf="Connected...Connected...Connected...Connected...";
		jLabel.setText(inf);
		return jLabel;
	}

	private JLabel help() {
		// TODO Auto-generated method stub
		JLabel jLabel= new JLabel();
		String help = "Help...";
		jLabel.setText(help);
		return jLabel;
	}

	public void	addComponentsToMainPanel(JPanel pane) {

		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.insets = new Insets(10,20,0,20);

		c.gridx = 0;
		c.gridy = 1;
		pane.add(getButtonStart(), c);
		
		c.gridx = 3;
		c.gridy = 1;
		pane.add(validDate(), c);

		c.ipady = 40;     
		c.weightx = 0.0;
		c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(grapphics(), c);

		c.ipady = 0;      
		c.weighty = 1.0;  
		c.anchor = GridBagConstraints.PAGE_END;
		c.gridx = 1;       
		c.gridwidth = 2;   
		c.gridy = 3;       
		pane.add(infConnect(), c);
		
		c.gridx = 3;
		c.gridy = 3;
		pane.add(indicator(), c);
	}


	public void	addComponentsToSettings(JPanel pane) {

		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.2;
		c.insets = new Insets(10,20,0,20);

		c.gridx = 1;
		c.gridy = 1;
		pane.add(selectLocation(), c);

		c.gridx = 1;
		c.gridy = 2;
		pane.add(changeCountry(), c);

		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 3;
		pane.add(changeCity(), c);

		c.gridx = 2;
		c.gridy = 3;
		pane.add(getButtonOk(), c);

		c.gridx = 1;
		c.gridy = 5;
		pane.add(selectDevice(), c);		

		c.gridx = 1;
		c.gridy = 6;
		pane.add(arrayDevice(n), c);

		c.ipady = 0;      
		c.weighty = 1.0;  
		c.anchor = GridBagConstraints.PAGE_END;
		c.gridx = 1;       
		c.gridwidth = 2;   
		c.gridy = 7;       
		pane.add(help(), c);
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					JPanel main = new JPanel();
					JPanel settings = new JPanel();

					addComponentsToMainPanel(main);
					addComponentsToSettings(settings);

					JTabbedPane jtp = new JTabbedPane();

					jtp.add("Main menu", main);
					jtp.add("Settings", settings);
					getContentPane().add(jtp);
				}
			});
		} catch (Exception e) {
			System.err.println("createGUI didn't complete successfully");
		}	
	}
}
