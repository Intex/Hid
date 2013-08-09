package com.intexsoft.sensor;

import com.intexsoft.sensor.graphics.GraphPanel;
import com.intexsoft.sensor.graphics.WheelPanel;
import com.intexsoft.sensor.usb.UsbAdapter;
import org.jfree.data.time.Millisecond;
import org.jfree.ui.RefineryUtilities;

import javax.jnlp.BasicService;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * Hanna Eismant
 * 26.07.13
 */


public class Runner {

    static BasicService basicService = null;
    static final JLabel label = new JLabel();
    static final WheelPanel WHEEL_PANEL = new WheelPanel();
    static final GraphPanel GRAPH_PANEL = new GraphPanel();
    static final JPanel CONTAINER = new JPanel();

    private static HessianClient hessianClient = new HessianClient();

    public static void main(String args[]) {

        try {
            Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
            fieldSysPath.setAccessible(true);
            fieldSysPath.set(null, null);

            ClassPathLibraryLoader.loadNativeHIDLibrary();
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Lib isn't found: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Lib isn't found: " + System.getProperty("java.io.tmpdir"), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println("Something is wrong: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Something is wrong: ", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {
            basicService = (BasicService)
                    ServiceManager.lookup("javax.jnlp.BasicService");
        } catch (UnavailableServiceException e) {
            System.err.println("Lookup failed: " + e);
        }

        label.setText("Data");
        label.setPreferredSize(new Dimension(30, 30));

        JFrame frame = new JFrame("Wheeeeeeeeeeel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container content = frame.getContentPane();

        content.add(label, BorderLayout.LINE_START);
        content.add(getContent(), BorderLayout.CENTER);


        JButton startButton = new JButton("Start!");

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                HelloRunnable helloRunnable = new HelloRunnable(label, WHEEL_PANEL, GRAPH_PANEL);
                helloRunnable.start();
            }
        };

        startButton.addActionListener(listener);

        JButton stopButton = new JButton("Stop!");

        ActionListener stopListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    HelloRunnable.stopGracefully();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        stopButton.addActionListener(stopListener);

        JButton getDataButton = new JButton("Get Data!");

        ActionListener dataListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    System.out.println(hessianClient.getData());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        getDataButton.addActionListener(dataListener);

        JButton sendDataButton = new JButton("Send Data!");

        ActionListener sendDataListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    hessianClient.sendData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        sendDataButton.addActionListener(sendDataListener);
        JPanel bottomContainer = new JPanel();
        bottomContainer.setBorder(BorderFactory.createEtchedBorder());

        GroupLayout bottomLayot = new GroupLayout(bottomContainer);
        bottomContainer.setLayout(bottomLayot);
        bottomLayot.setAutoCreateGaps(true);
        bottomLayot.setAutoCreateContainerGaps(true);
        bottomLayot.setVerticalGroup(bottomLayot.createParallelGroup()
                .addComponent(startButton)
                .addComponent(stopButton)
                .addComponent(getDataButton)
                .addComponent(sendDataButton)
                .addGroup(bottomLayot.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(startButton)
                        .addComponent(stopButton)
                        .addComponent(getDataButton)
                        .addComponent(sendDataButton)));
        bottomLayot.setHorizontalGroup(bottomLayot.createSequentialGroup()
                .addComponent(startButton)
                .addComponent(stopButton)
                .addComponent(getDataButton)
                .addComponent(sendDataButton));


        content.add(bottomContainer, BorderLayout.SOUTH);

        frame.pack();
        frame.setSize(1300, 600);
        frame.setVisible(true);
        RefineryUtilities.centerFrameOnScreen(frame);
    }

    public static JPanel getContent() {
        GroupLayout groupLayout = new GroupLayout(CONTAINER);
        CONTAINER.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);


        WHEEL_PANEL.setSize(200, 200);

        Border wheelPanelBorder = BorderFactory.createTitledBorder("Wheel");
        WHEEL_PANEL.setBorder(wheelPanelBorder);

        final JPanel graphPanelContainer = new JPanel();
        Border graphPanelBorder = BorderFactory.createTitledBorder("Graph");
        graphPanelContainer.setBorder(graphPanelBorder);
        graphPanelContainer.setSize(200, 200);

        graphPanelContainer.add(GRAPH_PANEL.getPanel());

        groupLayout.setVerticalGroup(groupLayout.createParallelGroup()
                .addComponent(WHEEL_PANEL)
                .addComponent(graphPanelContainer)
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(WHEEL_PANEL)
                        .addComponent(graphPanelContainer)));

        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addComponent(WHEEL_PANEL)
                .addComponent(graphPanelContainer)
        );

        return CONTAINER;

    }

    public static class HelloRunnable extends Thread {

        JLabel label;
        WheelPanel wheelPanel;
        GraphPanel graphPanel;
        public static volatile int position;
        private static volatile boolean stop = false;

        public static void stopGracefully() {
            stop = true;
        }

        public HelloRunnable(JLabel jLabel, WheelPanel wheelPanel, GraphPanel graphPanel) {
            this.label = jLabel;
            this.wheelPanel = wheelPanel;
            this.graphPanel = graphPanel;
        }

        public void run() {
            int position;
            stop = false;
            while (!stop) {
                position = getData();
                HelloRunnable.position = position;
                label.setText(String.valueOf(position));

                wheelPanel.setAngle(position);
                wheelPanel.repaint();

                graphPanel.getSeries().add(new Millisecond(), position - 128);

                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static int getData() {
            int result = -301;
            UsbAdapter adapter = new UsbAdapter();
            String s = adapter.openDevice();

            if (s != null) {
                System.out.println(s);
            } else {
                result = adapter.getPosition();
            }

            adapter.closeDevice();
            return result;
        }
    }

} 