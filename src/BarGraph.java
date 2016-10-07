import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarGraph extends JFrame{
	
	private int yearMostAlive;
	
	public BarGraph(int[] data, int minYear) {
		
		// Data set used to visually show data in bar graph
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		dataset.addValue(data[0], "", Integer.toString(minYear));
		int mostAliveYear = 0;  // The year most people were alive so far. 0 represents the year 1900.
		int mostNumAlive = data[0];  // Holds the amount of people alive for the year most people were alive so far
		// Add file data to bar graph image and find the the year most people were alive from that data
		for(int i = 1; i < data.length; i++){
			
			dataset.addValue(data[i], "", Integer.toString(i + minYear));
			
			if(data[i] > mostNumAlive){
				mostAliveYear = i;
				mostNumAlive = data[i];
			}
		}
		yearMostAlive = mostAliveYear + minYear;
		
		// Create bar Graph Image
		JFreeChart barGraph = ChartFactory.createBarChart("Number of People Alive Per Year", "Year", "Number of people alive", dataset);
        ChartPanel chartPanel = new ChartPanel(barGraph);
        chartPanel.setPreferredSize(new java.awt.Dimension(1600, 900)); // Set bar graph image size
        setContentPane(chartPanel);
		
	}

	public int yearMostAlive(){
		return yearMostAlive;
	}
	
};
