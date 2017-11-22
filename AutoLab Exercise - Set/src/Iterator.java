import java.util.*;

public class Iterator {
    public static void main(String args[]) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();  
        map.put(100,"One hundred");  
        map.put(101,"One hundred one");  
        map.put(102,"One hundred two");
        
        printKeys(map);
        printValues(map);
    }
    
    public static void printKeys(HashMap<Integer, String> things) {
    //   for(Integer key : things.keySet()) {
    //       System.out.println(key);
    //   }
       
    java.util.Iterator<Integer> stuff = things.keySet().iterator();
       while(stuff.hasNext()) {
           int whatevz = stuff.next();
           System.out.println(whatevz);
       }
    }
    
    public static void printValues(HashMap<Integer, String> things) {
        for (String values : things.values()) {
            System.out.println(values);
        }
        
        java.util.Iterator<String> stuff = things.values().iterator();
       while(stuff.hasNext()) {
           String whatevz = stuff.next();
           System.out.println(whatevz);
       }
    }
}