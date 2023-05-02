package gui.instrument;

import java.util.ArrayList;
import java.util.HashMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * This class manages all instrument charts of the graphical tree, including : 1) pie chart for node type count 2) bar chart for node type count 3) curve
 * chart for tree height evolution during the visit.
 * 
 * This class works with {@link InstrumentVisitor} which feeds the necessary information asked by the charts.
 * 
 * @see InstrumentVisitor
 * @author rouas,malek
 */
public class ChartManager {
	private HashMap<Character, Integer> nodeTypeCount = new HashMap<Character, Integer>();
	private ArrayList<Integer> heights = new ArrayList<Integer>();

	/**
	 * Initializes the manager, by creating null value for each node type.
	 */
	public ChartManager() {
		nodeTypeCount.put('A', 0);
		nodeTypeCount.put('B', 0);
		nodeTypeCount.put('C', 0);
		nodeTypeCount.put('D', 0);
	}

	/**
	 * Counts update for node types.
	 * 
	 * @param type the node type to count
	 */
	public void countType(char type) {
		int count = nodeTypeCount.get(type);
		nodeTypeCount.put(type, count + 1);
	}
	public void removeCountType(char type) {
		int count = nodeTypeCount.get(type);
		nodeTypeCount.put(type, count - 1);
	}

	/**
	 * Adds step by step the evolution of the tree height.
	 * 
	 * @param height current tree height
	 */
	public void registerHeightByStep(int height) {
		heights.add(height);
	}

	/**
	 * Generates the node type pie chart.
	 * 
	 * @return the pie chart
	 */
	
	/**
	 * Generates the node type bar chart.
	 * 
	 * @return the bar chart.
	 */
	public JFreeChart getTypeCountBar() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(nodeTypeCount.get('A'), "nombres de souris en vie", "Egoiste(BLANC)");
		dataset.setValue(nodeTypeCount.get('B'), "nombres de souris en vie", "Mutuelle(ROUGE)");
		dataset.setValue(nodeTypeCount.get('C'), "nombres de souris en vie", "Récéptive(GRIS)");
		dataset.setValue(nodeTypeCount.get('D'), "nombres de souris en vie", "Nihiliste(JAUNE)");

		return ChartFactory.createBarChart("Souris vivantes en fonction de leur nature", "Node type", "Count", dataset, PlotOrientation.VERTICAL, true, true, false);
	}

	@Override
	public String toString() {
		return "ChartManager [nodeTypeCount=" + nodeTypeCount + "]";
	}

	

}
