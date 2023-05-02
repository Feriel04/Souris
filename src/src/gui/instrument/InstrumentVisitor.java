package gui.instrument;



/**
 * This class works with {@link ChartManager}. It registers necessary information for creating different charts.
 * 
 * @see ChartManager
 * @author rouas,malek
 */
public class InstrumentVisitor {
	private ChartManager chartManager;
	private int currentHeight = 0;

	public InstrumentVisitor(ChartManager chartManager) {
		this.chartManager = chartManager;
	}

}

