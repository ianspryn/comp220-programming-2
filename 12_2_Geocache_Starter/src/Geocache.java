/**
 * @author WOLFEBD
 * Contains information about a geocache item
 */
public class Geocache {
	private final String hint;
	private final String id;
	private final Coordinates location;
	
	public Geocache(Coordinates location, String id, String hint){
		this.location = location;
		this.id = id;
		this.hint = hint;
	}
	
	@Override
	public String toString(){
		return id + " @ " + location + "\n" + hint;
	}
	
	// TODO: override equals and hashCode
	@Override // There is already an equals method, but I want to use mine instead
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Geocache)) {
			return false;
		}
		Geocache other = (Geocache) obj;
		
		if (other.location.equals(this.location) && other.id.equals(this.id) && other.hint.equals(this.hint)) {
			return true;
		} else {
			return false;
		}
	}
	
	//FINISH THIS THING
	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + hint.hashCode();
		result = 37 * result + id.hashCode();
		result = 37 * result + location.hashCode();
		return result;
	}
}