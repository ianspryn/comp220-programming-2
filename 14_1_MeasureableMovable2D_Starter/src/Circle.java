
public class Circle implements Measurable, Movable2D {
	//eyyyyyy you can implement multiple classes!
	private final double radius;
	
	//coordinates of the circle's center
	private double x;
	private double y;
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public double getMeasure(){
		return radius * radius * Math.PI;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
}
