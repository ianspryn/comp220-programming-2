import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileTraversal {

	/**
	 * @return all of the files that are in @param startingDir or
	 *    any of its subdirectories (or their subdirectories, ...).
	 * Should not include directories in the returned list.
	 */
	public static List<File> findAllFiles(File startingDir){
		// Just in case the user passes us something other than a directory...
		if(!startingDir.isDirectory()){
			// For non-directories (e.g., files), return the thing itself
			ArrayList<File> listOfOne = new ArrayList<>();
			listOfOne.add(startingDir);
			return listOfOne;
		}
		
		// Use the .listFiles method of File to get
		//   the contents of startingDir.
		List<File> filesAndSubdirs = Arrays.asList(startingDir.listFiles());

		// filesAndSubdirs includes the files and subdirectories in startingDir
		//  (but not the things inside those subdirectories)
		
		// allFiles starts empty
		List<File> allFiles = new ArrayList<>();
		
		// TODO: Add Files to allFiles, using recursion,
		//   so allFiles contains all of the files in startingDir or in its
		//   subdirectories or in their subdirectories ...
		// HINT: Use the .isFile() and .isDirectory() methods of File object
		//   to check if each File in filesAndSubdirs is a file or directory
		
    		for (File file : startingDir.listFiles()) {
    			if (file.isFile()) {
    				allFiles.add(file);
    				//
    			} else if (file.isDirectory()) {
    				allFiles.addAll(findAllFiles(file));
    	          }
        	}
    		
    		
    		for (File f : filesAndSubdirs) {
    			if (f.isFile()) {
    				allFiles.add(f);
    			} else if (f.isDirectory()) {
    				findAllFiles(f);
    				allFiles.add(f);
//    				List<File> subdirFiles = findAllFiles(f);
//    				allFiles.addAll(subdirFiles);
    				//ALT METHOD
    			}
    		}
		
		
		// Return the result
		return allFiles;
	}
	
	public static void main(String[] args) {
		List<File> results = findAllFiles(new File("."));
		Collections.sort(results);
		
		for(File f : results){
			System.out.println(f);
		}
	}

}
