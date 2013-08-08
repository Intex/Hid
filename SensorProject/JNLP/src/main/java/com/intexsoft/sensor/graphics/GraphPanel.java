package com.intexsoft.sensor.graphics;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;

/**
 * User: sergey.berdashkevich
 * Date: 31.07.13
 */
public class GraphPanel extends JPanel {

    private ChartPanel panel;
    private TimeSeries series;

    public GraphPanel() {

        series = new TimeSeries("data");
        TimeSeriesCollection dataset = new TimeSeriesCollection(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                null, null, null, dataset, false, false, false);

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

    public ChartPanel getPanel() {
        return panel;
    }

    public TimeSeries getSeries() {
        return series;
    }
}
