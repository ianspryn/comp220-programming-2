/**
 * @author WOLFEBD
 *
 */
public class GeometricSeries extends InfiniteSeries {
	private final double startVal;
	private final double ratio;
	
	public GeometricSeries(double startVal, double ratio){
		this.startVal = startVal;
		this.ratio = ratio;
	}
	
	/**
	 * @return the element of the series at the given @param index
	 */
	@Override
	public double get(int index){
		return startVal * Math.pow(ratio, index);
		//get the startVal, multiple it with ratio by index times
	}
}
