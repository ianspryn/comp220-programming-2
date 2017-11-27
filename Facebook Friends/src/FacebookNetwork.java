import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FacebookNetwork {
    private ArrayList< Set<Integer> > friendLists;
    
    /**
     * Creates connections based on id pairs,
     * one pair per line of @param filename
     * @throws FileNotFoundException
     */
    public FacebookNetwork(String filename) throws FileNotFoundException{
	Scanner in = new Scanner(new File(filename));

	friendLists = new ArrayList<>();

	// Loop over the friendship connections (lines) in the file
	while(in.hasNextInt()){
	    // Read the two ids
	    int idOne = in.nextInt();
	    if(!in.hasNextInt()){
		in.close();
		throw new IllegalArgumentException("Friendship connection file has an odd number of ids");
	    }
	    int idTwo = in.nextInt();
	    
	    // ensure that our friendLists is large enough
	    // to handle the larger of the two ids
	    int biggerId = Math.max(idOne, idTwo);
	    while(friendLists.size() <= biggerId){
		friendLists.add(new TreeSet<Integer>());
	    }
	    
	    // Add the friendship in both directions
	    friendLists.get(idOne).add(idTwo);
	    friendLists.get(idTwo).add(idOne);
	}
	
	in.close();
    }
    
    public Set<Integer> friends(int id){
		if(id < 0 || id >= friendLists.size()){
		    throw new IllegalArgumentException("id " + id + " is not valid");
		}
		return friendLists.get(id);
    }
    
    /**
     * @return The set of ids for people within @param numSteps or fewer
     *   friendship "hops" from person startId
     */
    public Set<Integer> friendsOfFriends(int startId, int numSteps){
    	Set<Integer> FoF = new HashSet<Integer>();
    	
    	//for each friend of startID
    	if (numSteps > 0) {
    		for (Integer friends : friends(startId)) {
        		FoF.addAll(friendsOfFriends(friends, numSteps - 1));
        	}
    	}
    	
    	FoF.add(startId);
    	
    	return FoF;
    }
}

