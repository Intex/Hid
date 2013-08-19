package com.intexsoft.sensor.components;

import com.intexsoft.sensor.Runner;
import com.intexsoft.sensor.usb.UsbAdapter;
import org.jfree.data.time.Millisecond;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: sergey.berdashkevich
 * Date: 12.08.13
 */
public class StartButton extends JButton {

    public static final int START_BUTTON_FILL = GridBagConstraints.HORIZONTAL;
    public static final double START_BUTTON_WEIGHT_X = 0.5;
    public static final Insets START_BUTTON_INSETS = new Insets(10, 20, 0, 20);
    public static final int START_BUTTON_GRID_X = 0;
    public static final int START_BUTTON_GRID_Y = 1;

    private GridBagConstraints gridBagConstraints;

    public StartButton() {
    }

    public void init(GridBagConstraints gridBagConstraints, final JLabel label, final GraphPanel graphPanel) {
        this.gridBagConstraints = gridBagConstraints;
        this.gridBagConstraints.fill = StartButton.START_BUTTON_FILL;
        this.gridBagConstraints.weightx = StartButton.START_BUTTON_WEIGHT_X;
        this.gridBagConstraints.insets = StartButton.START_BUTTON_INSETS;
        this.gridBagConstraints.gridx = StartButton.START_BUTTON_GRID_X;
        this.gridBagConstraints.gridy = StartButton.START_BUTTON_GRID_Y;


        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (UsbData.isStop()) {
                    final UsbData usbData = new UsbData(label, graphPanel);
                    usbData.start();
                } else {
                    UsbData.stopGracefully();
                }
            }
        };

        this.addActionListener(listener);
    }

    public GridBagConstraints getGridBagConstraints() {
        return gridBagConstraints;
    }
}
