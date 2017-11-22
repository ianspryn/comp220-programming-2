import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class DeleteUsers {
	/**
	 * @param userIds - IDs of users in the system. Must be sorted.
	 * @param toDelete - IDs of users to delete. Must be sorted.
	 * Removes the ids from toDelete from the userIds collection
	 */
	public static void deleteUsers(Collection<Integer> userIds,
		Collection<Integer> toDelete){
		
		for(Integer userNoMore : toDelete){
			userIds.remove(userNoMore);
		}
	}
	
	public static void deleteUsersIterators(Collection<Integer> userIds, Collection<Integer> toDelete) {
		//blue cursor in slides: goes through userIds, looking for next one to delete
		Iterator<Integer> idIter = userIds.iterator();
		
		//loop through users to delete
		for (Integer userNoMore : toDelete ) {
			
			int nextUserId;
			//look for userNoMore in userIds, using an iterator
			do {
				//Always have a hasNext before calling next
				if (!idIter.hasNext()) {
					//we ran out of users before our delete list was done, and that's a problem
					throw new IllegalArgumentException("user to delete was not in the list");
				}
				
				// .next returns next value  and advances the iterator
				nextUserId = idIter.next();
			} while (nextUserId != userNoMore);
			
			//nextUserId == userNoMore
			//which means we want to remove the most recent item returning by .next()
			
		
			
			/*
			 * .remove will remove the most recent item returned by .next()
			 * RULES
			 * 		1. collection cannot be otherwise modified
			 * 		2. only one call to remove per call to next
			 * (and they do not stack; only one step back before going forward again
			 */
			idIter.remove();
			//notice we're calling .remove on the iterator, not the collection
		}
	}
	

	
	public static void main(String[] args) {
		final int n = 100000;
		final boolean useArrayList = false; //if false, (and you use LinkedList, it's about 3 times slower
		
		Collection<Integer> userIds;
		Collection<Integer> toDel;
		
		if(useArrayList){
			userIds = new ArrayList<Integer>();
			toDel = new ArrayList<Integer>();
		}
		else{
			userIds = new LinkedList<Integer>();
			toDel = new LinkedList<Integer>();
		}

		
		// Make the lists
		for(int i=0; i<n; i++){
			userIds.add(i);
			if(i % 10 == 0){
				toDel.add(i);
			}
		}
		
		// Run the delete operation
		long startTime, endTime;
		startTime = System.currentTimeMillis();
		deleteUsersIterators(userIds, toDel);
		endTime = System.currentTimeMillis();
		
		double seconds = (endTime - startTime) / 1000.0;
		
		System.out.println("Took " + seconds);
	}

}
