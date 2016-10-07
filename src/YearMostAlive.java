import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class YearMostAlive extends JFrame{
	
	public final static int MIN_YEAR = 1900;
	
	// Gather data from file into an array
	public static int[] getData() throws FileNotFoundException{
		
		Scanner input = new Scanner(new File("Data.txt")); 
		
		// Slots 0 - 100 represent the years 1900 - 2000
		// Every slot will hold how many people were alive in that year
		int[] aliveYears = new int[101];
		
		while(input.hasNext()){
			
			// Strip out the values for the birth and death year from this line of text
			String line = input.nextLine();
			String yearsStr = line.substring(line.indexOf(",") + 2);
			int birthYear = Integer.parseInt(yearsStr.substring(0, 4)) - MIN_YEAR;
			int deathYear = Integer.parseInt(yearsStr.substring(5, 9)) - MIN_YEAR;
			
			// Add 1 to every year this person was alive in the array
			for(int i = birthYear; i <= deathYear; i++){
				aliveYears[i]++;
			}	
		}
		return aliveYears;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		int[] yearsAlive = getData();
		
		BarGraph barGraph = new BarGraph(yearsAlive, MIN_YEAR);
	    barGraph.pack();
	    barGraph.setVisible(true);
	    
	    System.out.println("Year most people were alive: " + barGraph.yearMostAlive());
	}
	
}
