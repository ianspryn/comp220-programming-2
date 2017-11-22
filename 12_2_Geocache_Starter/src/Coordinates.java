
/**
 * @author WOLFEBD
 * Holds latitude and longitude coordinates
 */
public class Coordinates {
    private static final double earthRadius = 6372.8; // In kilometers
	
	private double lat;
	private double lon;
	
	public Coordinates(double lat, double lon){
		// TODO: complete this method
		this.lat = lat;
		this.lon = lon;
	}
	
	public double getLatitude(){
		return lat;
	}
	
	public double getLongitude(){
		return lon;
	}
	
	@Override
	public String toString(){
		return "(" + lat + ", " + lon + ")";
	}
	
	/**
	 * @return "great circle" distance from this
	 *  to other in kilometers
	 */
	public double distance(Coordinates other){
	    double lat1 = lat;
	    double lat2 = other.lat;
	    double lon1 = lon;
	    double lon2 = other.lon;

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
	 
        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return earthRadius * c;
	}
	
	// TODO: override equals and hashCode
	@Override // There is already an equals method, but I want to use mine instead
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Coordinates)) {
			//takes a variable on the left and a class on the right,
			//and it will be true if you have an Credentials object
			return false;
		}
		
		//Time to check the actual member variables
		
		//get a Credentials reference to obj
		//We're saying, "give me a Credentials reference to obj!"
		//So you always want to use instanceof before you do a cast
		Coordinates other = (Coordinates) obj;
		
		if (other.lat == this.lat && other.lon == this.lon) {
			return true;
		} else {
			return false;
		}
	}
	
	
	@Override
	public int hashCode() {
		Double stuffLat = new Double(lat);
		Double stuffLon = new Double(lon);
		int result = 17;
		result = 37 * result + stuffLat.hashCode();
		result = 37 * result + stuffLon.hashCode();
		return result;
	}
	
}
