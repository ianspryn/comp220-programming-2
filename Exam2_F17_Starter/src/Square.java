
public class Square extends Shape {
	// TODO: define any member variables you need
	// Use only private access variables
	
	private int sideLength;
	
	// x and y are the coordinates of the center of the square,
	// and sideLength is the length of one side
	public Square(int x, int y, int sideLength){
		super(x, y);
		this.sideLength = sideLength;
	}
	
	// should return the length of one side
	public int getSideLength(){
		return this.sideLength;
	}
	
	// should set the sideLength to be len
	public void setSideLength(int len){
		this.sideLength = len;
	}

	// should return the x coordinate of the center
	/*
	public int getX(){
		return super.getX();
	}

	// should return the y coordinate of the center
	public int getY(){
		return super.getY();
	}
	*/
	// should return the area of the shape
	public double getArea(){
		return getSideLength() * getSideLength();
	}
	
	// should return the perimeter of the shape
	public double getPerimeter(){
		return 4 * getSideLength();
	}
	
	// should return the yield of the shape,
	// which is the area divided by the perimeter
	public double getYield(){
		return super.getYield();
	}

	// should update the x and y coordinates of the shape,
	// adding dx to the previous x position
	// and dy to the previous y position
	public void move(int dx, int dy){
		super.move(dx, dy);
	}
	
	@Override public boolean equals(Object obj) {
		if (super.equals(obj)) {
			if(!(obj instanceof Square)){
				return false;
			}

			Square other = (Square) obj;
			if(this.sideLength == other.sideLength) {
				return true;
			}
			else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	@Override public int hashCode(){
		Double newSideLength = new Double(sideLength);
		
		int result = super.hashCode();
		result = 37 * result + newSideLength.hashCode();
		
		return result;
	}

}
