import java.util.ArrayList;

public class Layer {
	private String name;
	private ArrayList<Shape> shapes;
	// TODO: declare any member variables you need
	// Use only private access variables

	
	// construct an empty layer with the given name
	public Layer(String name){
		this.name = name;
		shapes = new ArrayList<>(); //AHHHH I FORGOT THIS	
	}
	
	// returns the layer name
	public String getName(){
		return name;
	}
	
	// adds s to this layer
	public void addShape(Shape s){
		shapes.add(s);
	}
	
	// returns an ArrayList of the Shape
	//   objects in this layer, in any order
	public ArrayList<Shape> getShapes(){
		return shapes;
	}
	
	// removes all shapes from this layer
	public void clear(){
		shapes.clear();
	}

}
