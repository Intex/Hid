package com.intexsoft.sensor.components;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;
import java.awt.*;

/**
 * User: sergey.berdashkevich
 * Date: 31.07.13
 */
public class GraphPanel extends JPanel {

    private final int GRAPHIC_IPAD_Y = 40;
    private final double GRAPHIC_WEIGHT_X = 0D;
    private final int GRAPHIC_GRID_WIDTH = 5;
    private final int GRAPHIC_GRID_X = 0;
    private final int GRAPHIC_GRID_Y = 2;

    private ChartPanel panel;
    private TimeSeries series;
    private GridBagConstraints gridBagConstraints;


    public GraphPanel() {

        series = new TimeSeries("data");
        TimeSeriesCollection dataSet = new TimeSeriesCollection(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                null, null, null, dataSet, false, false, false);

        final XYPlot plot = chart.getXYPlot();
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(20000.0);
        axis = plot.getRangeAxis();
        axis.setRange(-150.0, 150.0);

        panel = new ChartPanel(chart);

        XYSplineRenderer xySplineRenderer = new XYSplineRenderer();
        xySplineRenderer.setBaseShapesVisible(false);
        chart.getXYPlot().setRenderer(xySplineRenderer);
    }

    public void init(GridBagConstraints gridBagConstraints)  {
        this.gridBagConstraints = gridBagConstraints;
        this.gridBagConstraints.ipady = GRAPHIC_IPAD_Y;
        this.gridBagConstraints.weightx = GRAPHIC_WEIGHT_X;
        this.gridBagConstraints.gridwidth = GRAPHIC_GRID_WIDTH;
        this.gridBagConstraints.gridx = GRAPHIC_GRID_X;
        this.gridBagConstraints.gridy = GRAPHIC_GRID_Y;
        this.gridBagConstraints.fill = GridBagConstraints.BOTH;
    }

    public ChartPanel getPanel() {
        return panel;
    }

    public TimeSeries getSeries() {
        return series;
    }

    public GridBagConstraints getGridBagConstraints() {
        return gridBagConstraints;
    }
}
