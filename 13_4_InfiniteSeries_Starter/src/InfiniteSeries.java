/**
 * A base class for various infinite series	
 * @author WOLFEBD
 */
public abstract class InfiniteSeries {
	
	/*
	
	 * @return Always 0.0, since this is a placeholder
	 
	public double get(int index){
		return 0.0;
	}
	*/
	
	/*
	 *@return the index item of the series
	*/	 
	public abstract double get(int index);
	//anything that extends InfiniteSeries must have a get method
	    
	/**
	 * @return the sum of the first @param numTerms items of the series
	 */
	public double sum(int numTerms){
		double res = 0.0;
		for(int i=0; i<numTerms; i++){
			res += get(i);
		}
		return res;
	}
}
