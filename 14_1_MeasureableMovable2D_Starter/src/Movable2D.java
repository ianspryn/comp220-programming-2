/**
 * An object that has x, y coordinates and can be moved in x and y directions.
 * @author WOLFEBD
 */
public interface Movable2D {
	double getX();
	double getY();
	void setX(double x);
	void setY(double y);
	
	/**
	 * Adds @param dx to the object's x location
	 * Adds @param dy to the object's y location
	 */
	// TODO: write a default method
	default void shift(double dx, double dy) {
		setX(getX() + dx);
		setY(getY() + dy);
		//INTERFACES DON'T HAVE MEMBER VARIABLES
	}
}
