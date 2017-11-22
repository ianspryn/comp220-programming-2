
public abstract class Shape {
	// TODO: define any member variables you need
	// Use only private access variables
	public int x;
	public int y;
	
	// x and y are the coordinates of the center of the shape
	public Shape(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	// should return the x coordinate of the center
	public int getX(){
		return this.x;
	}
	
	// should return the y coordinate of the center
	public int getY(){
		return this.y;
	}
	
	// should return the area of the shape
	public abstract double getArea();
	
	// should return the perimeter of the shape
	public abstract double getPerimeter();
	
	// should return the yield of the shape,
	// which is the area divided by the perimeter
	public double getYield(){
		return getArea() / getPerimeter();
	}

	// should update the x and y coordinates of the shape,
	// adding dx to the previous x position
	// and dy to the previous y position
	public void move(int dx, int dy){
		this.x = (getX() + dx);
		this.y = (getY() + dy);
	}
	
	
	
	
	@Override public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(!(obj instanceof Shape)){
			return false;
		}
		
		Shape other = (Shape) obj;
		if(this.x == other.x && this.y == other.y){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override public int hashCode(){
		Double newX = new Double(x);
		Double newY = new Double(y);
		
		
		int result = 17;
		result = 37 * result + newX.hashCode();
		result = 37 * result + newY.hashCode();
		
		return result;
	}

}
