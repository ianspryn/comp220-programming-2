import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WOLFEBD
 *
 */
public class CallCenter {
	private Queue<Call> incomingCalls;
	private Queue<Worker> availableWorkers;
	
	/**
	 * Creates a call center with no available workers and no calls
	 */
	public CallCenter(){
		incomingCalls = new LinkedList<Call>();
		availableWorkers = new LinkedList<Worker>();
	}
	
	/**
	 * @return The number of calls waiting in line
	 */
	public int pendingCalls(){
		return incomingCalls.size();
	}
	
	/**
	 * @return The number of workers currently idle
	 *   and available for taking a call.
	 */
	public int availableWorkers(){
		return availableWorkers.size();
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
		if(availableWorkers.size() > 0){
			availableWorkers.poll().handleCall(c);
		} else {
			incomingCalls.add(c);
		}
	}
	
	/**
	 * If there is a call in the waiting list, assign the
	 *   first call in line to this worker w.
	 * 
	 * Otherwise, add w to a group of available workers.
	 */
	public void available(Worker w){
		if(incomingCalls.size() > 0){
			w.handleCall(incomingCalls.poll());
		}
		else {
			availableWorkers.add(w);
		}
	}
}

