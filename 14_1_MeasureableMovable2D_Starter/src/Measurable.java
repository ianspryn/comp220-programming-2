/**
 * An interface for objects that have some default measure
 *   we can use to order them, compare them, etc.
 *   
 * @author WOLFEBD
 *
 */
public interface Measurable {
	double getMeasure();
	
	default boolean isBiggerThan(Measurable other){
		return getMeasure() > other.getMeasure();
	}
}
