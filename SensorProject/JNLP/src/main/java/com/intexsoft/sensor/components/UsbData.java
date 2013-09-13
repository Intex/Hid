package com.intexsoft.sensor.components;


import com.intexsoft.sensor.usb.UsbAdapter;
import org.jfree.data.time.Millisecond;

import javax.swing.*;


/**
 * User: sergey.berdashkevich
 * Date: 19.08.13
 */
public class UsbData extends Thread {

    JLabel label;
    GraphPanel graphPanel;
    public static volatile int position;
    private static volatile boolean stop = true;

    public static void stopGracefully() {
        stop = true;
    }

    public UsbData(JLabel jLabel, GraphPanel graphPanel) {
        this.label = jLabel;
        this.graphPanel = graphPanel;
    }

    public void run() {
        int position;
        stop = false;
        UsbAdapter adapter = new UsbAdapter();
        while (!stop) {

            String s = adapter.openDevice();
            if (s != null) {
                System.out.println(s);
            }

            position = getData(adapter);
            this.position = position;
            label.setText(String.valueOf(position));
            graphPanel.getSeries().add(new Millisecond(), position - 128);

//                adapter.closeDevice();

            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static int getData(UsbAdapter adapter) {
        int result = -301;
        result = adapter.getPosition();
        return result;
    }

    public static boolean isStop() {
        return stop;
    }
}
