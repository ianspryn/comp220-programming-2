/**
 * @author WOLFEBD
 * Represents a worker in a call center
 * A simple implementation with only a name
 */
public class Worker {
	private final String name;
	
	public Worker(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void handleCall(Call c){
		// A dummy method for debugging
		System.out.println(name + " \t is taking call from " + c.getPhone());
		
		// After handling the call, we would need to
		//  call available on the CallCenter so this
		//  worker could handle the next call
	}
}
