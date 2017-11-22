/**
 * A base class for various infinite series	
 * @author WOLFEBD
 */
public interface InfSeriesIF {
	

	
	/*
	 *@return the index item of the series
	*/	 
	double get(int index);
	
	    
	/**
	 * @return the sum of the first @param numTerms items of the series
	 */
	default double sum(int numTerms){
		double res = 0.0;
		for(int i=0; i<numTerms; i++){
			res += get(i);
		}
		return res;
	}
}
