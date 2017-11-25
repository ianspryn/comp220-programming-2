import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WOLFEBD
 *
 */
public class CallCenterFAIL {
	// TODO: Declare the member variables you need,
	//       using collections that are well-suited to this application
	HashMap<Worker, Call> callCenter = new HashMap<>();
	
	Queue<Call> calls = new LinkedList<Call>();
	int numAvailableWorkers;
	int pendingCalls;
	/**
	 * Creates a call center with no available workers and no calls
	 */
	public CallCenterFAIL(){
		// TODO: initialize your member variables
		
		this.numAvailableWorkers = 0;
		this.pendingCalls = 0; 
	}
	
	/**
	 * @return The number of calls waiting in line
	 */
	public int pendingCalls(){
		return pendingCalls;
	}
	
	/**
	 * @return The number of workers currently idle
	 *   and available for taking a call.
	 */
	public int availableWorkers(){
		return numAvailableWorkers;
	}
	
	/**
	 * If there is a worker available, assign the call
	 *   to him or her. You can pick any available worker
	 *   (i.e., you do not have to balance the load among workers).
	 *   
	 * If there is no worker available, add the call at the end
	 *   of a waiting list.
	 */
	public void receive(Call c){
		
		if (numAvailableWorkers == 0) {
			calls.add(c);
		} else {
			
		}
		
	}
	
	/**
	 * If there is a call in the waiting list, assign the
	 *   first call in line to this worker w.
	 * 
	 * Otherwise, add w to a group of available workers.
	 */
	public void available(Worker w){
		if (calls.peek() != null) {
			put (w, c);
		}
		
	}
}

