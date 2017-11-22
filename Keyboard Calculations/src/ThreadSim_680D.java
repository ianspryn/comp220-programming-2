import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ThreadSim_680D implements Runnable{
   
	/**
     * Setup here.
     */
	
    public static void main(String[] args) throws IOException{
    	
    	l =  15;
    	k = 14;
    	threads = 2; //MAX: 14
    	
    	
    	// Don't worry about anything else beyond here.
    	// Version: 680 D
    	maxConflicts = 680;
    	System.out.println("Instance " + k + " " + l);
    	
    	File file = new File("matrix");
        Scanner scnr = new Scanner(file);
       
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
               
                numbers[i][j] = scnr.nextInt();
               
            }
        }
       
        for(int i = 0; i < 26; i++){
            for(int j = i; j < 26; j++){
               
                numbers[i][j] += numbers[j][i];
                numbers[j][i] = numbers[i][j];
               
            }
        }
       
        scnr.close();
    	
    	for(int num = 0; num < threads; num++){
    	Thread thread = new Thread(new ThreadSim_680D(l, k, num));
    	thread.start();
    	}
	}
    
    
	static int maxConflicts;
	public static int[][] numbers = new int[26][26];
    static float[] targetWeightLeft = {10.5f,12.5f,15f,16.5f,19.5f};
    static float[] targetWeightRight = {10.5f,12.5f,14.5f,16.5f};
    static ArrayList<letterSet> bestSets;
    Queue<letterSet> bestQueue = new LinkedList<letterSet>();
    
    static final Character[] swaps = { 'b', 'c', 'd', 'f', 'g', 'j', 'k', 'l', 'm', 'p', 'q', 'u', 'v', 'w', 'x', 'y'}; 
    static final Character[] statics = {'h', 't', 'n', 'r', 's', 'e', 'i', 'a', 'o'};
    ArrayList<Character> allletters = new ArrayList<Character>();
    Character[] newletters = new Character[25];
    int thread;
    static Long count = new Long(0);
    static int threads, threadsDone = 0, l, k;
    
    public ThreadSim_680D(int l, int k, int thread){
    	if(bestSets == null){
    		bestSets = new ArrayList<letterSet>();
    		for(int i = 0; i < 5; i++){
    			bestSets.add(new letterSet());
    		}
    	}
    	
        newletters[0] = statics[0];
        newletters[1] = statics[1];
        newletters[2] = statics[2];
        newletters[3] = statics[3];
        newletters[4] = statics[4];
        newletters[5] = statics[5];
        newletters[6] = statics[6];
        newletters[7] = statics[7];
        newletters[8] = statics[8];
        
        allletters.add(swaps[0]);
        allletters.add(swaps[1]);
        allletters.add(swaps[2]);
        allletters.add(swaps[3]);
        allletters.add(swaps[4]);
        allletters.add(swaps[5]);
        allletters.add(swaps[6]);
        allletters.add(swaps[7]);
        allletters.add(swaps[8]);
        allletters.add(swaps[9]);
        allletters.add(swaps[10]);
        allletters.add(swaps[11]);
        allletters.add(swaps[12]);
        allletters.add(swaps[13]);
        allletters.add(swaps[14]);
        allletters.add(swaps[15]);

        newletters[9] =(allletters.get(l));allletters.remove(l);
        newletters[10] =(allletters.get(k));allletters.remove(k);
        
        this.thread = thread;
    }

	@Override
	public void run() {
		 for(int m = (threads == 14) ? thread : 0; (threads == 14 && thread == m)||(threads != 14 && m < 14); m++){
             newletters[11] =(allletters.get(m));allletters.remove(m);
             for(int n = (threads == 13) ? thread : 0; (threads == 13 && thread == n)||(threads != 13 && n < 13); n++){
                 System.out.println(count/435891456 + " out of 200");
                 newletters[12] =(allletters.get(n));allletters.remove(n);
                 for(int o = (threads == 12) ? thread : 0; (threads == 12 && thread == o)||(threads != 12 && o < 12); o++){
                     newletters[13] =(allletters.get(o));allletters.remove(o);
                     for(int p = (threads == 11) ? thread : 0; (threads == 11 && thread == p)||(threads != 11 && p < 11); p++){
                         newletters[14] =(allletters.get(p));allletters.remove(p);
                         for(int q = (threads == 10) ? thread : 0; (threads == 10 && thread == q)||(threads != 10 && q < 10); q++){
                             newletters[15] =(allletters.get(q));allletters.remove(q);
                             for(int r = (threads == 9) ? thread : 0; (threads == 9 && thread == r)||(threads != 9 && r < 9); r++){
                                 newletters[16] =(allletters.get(r));allletters.remove(r);
                                 for(int s = (threads == 8) ? thread : 0; (threads == 8 && thread == s)||(threads != 8 && s < 8); s++){
                                     newletters[17] =(allletters.get(s));allletters.remove(s);
                                     for(int t = (threads == 7) ? thread : 0; (threads == 7 && thread == t)||(threads != 7 && t < 7); t++){
                                         newletters[18] =(allletters.get(t));allletters.remove(t);
                                         for(int u = (threads == 6) ? thread : 0; (threads == 6 && thread == u)||(threads != 6 && u < 6); u++){
                                             newletters[19] =(allletters.get(u));allletters.remove(u);
                                             for(int v = (threads == 5) ? thread : 0; (threads == 5 && thread == v)||(threads != 5 && v < 5); v++){
                                                 newletters[20] =(allletters.get(v));allletters.remove(v);
                                                 for(int w = (threads == 4) ? thread : 0; (threads == 4 && thread == w)||(threads != 4 && w < 4); w++){
                                                     newletters[21] =(allletters.get(w));allletters.remove(w);
                                                     for(int x = (threads == 3) ? thread : 0; (threads == 3 && thread == x)||(threads != 3 && x < 3); x++){
                                                         newletters[22] =(allletters.get(x));allletters.remove(x);
                                                         for(int y = (threads == 2) ? thread : 0; (threads == 2 && thread == y)||(threads != 2 && y < 2); y++){

                                                             newletters[23] =(allletters.get(y));allletters.remove(y);
                                                             newletters[24] =(allletters.get(0));
                                                            
                                                             int conflicts = 0;
                                                             float[] weight = {0,0,0,0,0,0,0,0,0};
                                                             boolean fail = false;
                                                            
                                                             for(int letter = 0; letter < 25; letter++){
                                                                
                                                                 char current = newletters[letter];
                                                                 int place = getPlace(current);
                                                                
                                                                 switch(letter){
                                                                
                                                                 case 0: conflicts += numbers[place][getPlace(newletters[9])] + numbers[place][getPlace(newletters[16])]
                                                                         + numbers[place][getPlace(newletters[21])] + numbers[place][getPlace(newletters[24])];
                                                                         weight[0] += getWeight(current);
                                                                         break;
                                                                 case 1: conflicts += numbers[place][getPlace(newletters[10])] + numbers[place][getPlace(newletters[9])]
                                                                         + numbers[place][getPlace(newletters[17])] + numbers[place][getPlace(newletters[22])];
                                                                         weight[1] += getWeight(current);
                                                                         break;
                                                                 case 2: conflicts += numbers[place][getPlace(newletters[10])] + numbers[place][getPlace(newletters[11])]
                                                                         + numbers[place][getPlace(newletters[16])] + numbers[place][getPlace(newletters[18])];
                                                                         weight[2] += getWeight(current);
                                                                         break;
                                                                 case 3: conflicts += numbers[place][getPlace(newletters[12])] + numbers[place][getPlace(newletters[11])]
                                                                         + numbers[place][getPlace(newletters[17])] + numbers[place][getPlace(newletters[21])];
                                                                         weight[3] += getWeight(current);
                                                                         break;
                                                                 case 4: conflicts += numbers[place][getPlace(newletters[12])] + numbers[place][getPlace(newletters[18])]
                                                                         + numbers[place][getPlace(newletters[22])] + numbers[place][getPlace(newletters[24])];
                                                                         weight[4] += getWeight(current);
                                                                         break;
                                                                 case 5: conflicts += numbers[place][getPlace(newletters[13])] + numbers[place][getPlace(newletters[19])]
                                                                         + numbers[place][getPlace(newletters[23])];
                                                                         weight[5] += getWeight(current);
                                                                         break;
                                                                 case 6: conflicts += numbers[place][getPlace(newletters[13])] + numbers[place][getPlace(newletters[14])]
                                                                         + numbers[place][getPlace(newletters[20])];
                                                                         weight[6] += getWeight(current);
                                                                         break;
                                                                 case 7: conflicts += numbers[place][getPlace(newletters[14])] + numbers[place][getPlace(newletters[15])]
                                                                         + numbers[place][getPlace(newletters[19])];
                                                                         weight[7] += getWeight(current);
                                                                         break;
                                                                 case 8: conflicts += numbers[place][getPlace(newletters[15])] + numbers[place][getPlace(newletters[20])]
                                                                         + numbers[place][getPlace(newletters[23])];
                                                                         weight[8] += getWeight(current);
                                                                         break;
                                                                 case 9: conflicts += numbers[place][getPlace(newletters[16])] + numbers[place][getPlace(newletters[17])] +
                                                                         numbers[place][getPlace(newletters[21])] + numbers[place][getPlace(newletters[22])]
                                                                         + numbers[place][getPlace(newletters[24])]; weight[0] += getWeight(current); weight[1] += getWeight(current);
                                                                         break;
                                                                 case 10: conflicts += numbers[place][getPlace(newletters[16])] + numbers[place][getPlace(newletters[17])] +
                                                                         numbers[place][getPlace(newletters[18])] + numbers[place][getPlace(newletters[22])]
                                                                         ; weight[2] += getWeight(current); weight[1] += getWeight(current);
                                                                         break;
                                                                 case 11: conflicts += numbers[place][getPlace(newletters[16])] + numbers[place][getPlace(newletters[17])] +
                                                                         numbers[place][getPlace(newletters[18])] + numbers[place][getPlace(newletters[21])];
                                                                         weight[2] += getWeight(current); weight[3] += getWeight(current);
                                                                         break;
                                                                 case 12: conflicts += numbers[place][getPlace(newletters[18])] + numbers[place][getPlace(newletters[17])] +
                                                                         numbers[place][getPlace(newletters[22])] + numbers[place][getPlace(newletters[21])]
                                                                         + numbers[place][getPlace(newletters[24])]; weight[4] += getWeight(current); weight[3] += getWeight(current);
                                                                         break;
                                                                 case 13: conflicts += numbers[place][getPlace(newletters[19])] + numbers[place][getPlace(newletters[20])] +
                                                                         numbers[place][getPlace(newletters[23])];
                                                                         weight[5] += getWeight(current); weight[6] += getWeight(current);
                                                                         break;
                                                                 case 14: conflicts += numbers[place][getPlace(newletters[19])] + numbers[place][getPlace(newletters[20])]
                                                                         ; weight[7] += getWeight(current); weight[6] += getWeight(current);
                                                                         break;
                                                                 case 15: conflicts += numbers[place][getPlace(newletters[19])] + numbers[place][getPlace(newletters[20])] +
                                                                         numbers[place][getPlace(newletters[23])]; weight[7] += getWeight(current); weight[8] += getWeight(current);
                                                                         break;
                                                                 case 16: conflicts +=numbers[place][getPlace(newletters[21])] + numbers[place][getPlace(newletters[18])]
                                                                         + numbers[place][getPlace(newletters[24])]; weight[0] += getWeight(current); weight[2] += getWeight(current);
                                                                         break;
                                                                 case 17: conflicts += numbers[place][getPlace(newletters[21])] + numbers[place][getPlace(newletters[22])]
                                                                         ; weight[1] += getWeight(current); weight[3] += getWeight(current);
                                                                         break;
                                                                 case 18: conflicts += numbers[place][getPlace(newletters[22])] + numbers[place][getPlace(newletters[24])]
                                                                         ; weight[2] += getWeight(current); weight[4] += getWeight(current);
                                                                         break;
                                                                 case 19: conflicts += numbers[place][getPlace(newletters[23])]; weight[5] += getWeight(current); weight[7] += getWeight(current);
                                                                         break;
                                                                 case 20: conflicts += numbers[place][getPlace(newletters[23])]; weight[6] += getWeight(current); weight[8] += getWeight(current);
                                                                         break;
                                                                 case 21: conflicts += numbers[place][getPlace(newletters[24])];
                                                                         weight[0] += getWeight(current); weight[3] += getWeight(current);
                                                                         break;
                                                                 case 22: conflicts += numbers[place][getPlace(newletters[24])]; weight[1] += getWeight(current); weight[4] += getWeight(current);
                                                                         break;
                                                                 case 23:  weight[8] += getWeight(current); weight[5] += getWeight(current);
                                                                         break;
                                                                 case 24:  weight[0] += getWeight(current); weight[4] += getWeight(current);
                                                                         break;
                                                                
                                                                 default: ;
                                                                 
                                                                 }
                                                                
                                                                 if(conflicts > maxConflicts){
                                                                     fail = true;
                                                                     break;
                                                                 }
                                                                 
                                                             }
                                                             
                                                             count++;
                                                             
                                                            
                                                             if(!fail) {
                                                                
                                                                 // Reorganize Weight
                                                                
                                                                 double[] left = new double[5];
                                                                 for(int i = 0; i < 5; i++){
                                                                     left[i] = weight[i];
                                                                 }
                                                                 double[] right = new double[4];
                                                                 for(int i = 0; i < 4; i++){
                                                                     right[i] = weight[i+5];
                                                                 }
                                                                 Arrays.sort(left);
                                                                 Arrays.sort(right);
                                                                
                                                                 // Calculate closeness
                                                                
                                                                 double offtotal = 0;
                                                                
                                                                 for(int i = 1; i < 5; i++){
                                                                     offtotal += Math.pow(Math.abs(left[i] - targetWeightLeft[i]) + 1, 2);
                                                                 }
                                                                 offtotal += (left[0] - targetWeightLeft[0]) > 0 ? Math.pow(Math.abs(left[0] - targetWeightLeft[0]) + 1, 4) : Math.pow(Math.abs(left[0] - targetWeightLeft[0]) + 1, 2);
                                                                 for(int i = 1; i < 4; i++){
                                                                     offtotal += Math.pow(Math.abs(right[i] - targetWeightRight[i]) + 1, 2);
                                                                 }
                                                                 offtotal += (right[0] - targetWeightRight[0]) > 0 ? Math.pow(Math.abs(right[0] - targetWeightRight[0]) + 1, 4) : Math.pow(Math.abs(right[0] - targetWeightRight[0]) + 1, 2);
                                                                 
                                                                 double score = (1000d/(double)conflicts) + (32d/offtotal);
                                                                 if (score > bestSets.get(4).getScore()){
                                                                     bestQueue.add(new letterSet(newletters.clone(), conflicts, weight.clone(), score));
                                                                 }
                                                             }
                                                             
                                                             allletters.add(y,newletters[23]);
                                                         }
                                                         allletters.add(x,newletters[22]);
                                                     }
                                                     allletters.add(w,newletters[21]);
                                                 }
                                                 allletters.add(v,newletters[20]);
                                             }
                                             doQueue();
                                             allletters.add(u,newletters[19]);
                                         }
                                         allletters.add(t,newletters[18]);
                                     }
                                     allletters.add(s,newletters[17]);
                                 }
                                 allletters.add(r,newletters[16]);
                             }
                             allletters.add(q,newletters[15]);
                         }
                         allletters.add(p,newletters[14]);
                     }
                     allletters.add(o,newletters[13]);
                 }
                 allletters.add(n,newletters[12]);
             }
             allletters.add(m,newletters[11]);
         }

		 doQueue();
		 try {

			checkPrint();
		} catch (IOException e) {
			System.err.println("COULD NOT PRINT RESULTS?!??!");
			e.printStackTrace();
		}
		
	}
    
	public static char getChar(int i){
	    switch(i){
	    case 0: return 'a';
	    case 1: return 'b';
	    case 2: return 'c';
	    case 3: return 'd';
	    case 4: return 'e';
	    case 5: return 'f';
	    case 6: return 'g';
	    case 7: return 'h';
	    case 8: return 'i';
	    case 9: return 'j';
	    case 10: return 'k';
	    case 11: return 'l';
	    case 12: return 'm';
	    case 13: return 'n';
	    case 14: return 'o';
	    case 15: return 'p';
	    case 16: return 'q';
	    case 17: return 'r';
	    case 18: return 's';
	    case 19: return 't';
	    case 20: return 'u';
	    case 21: return 'v';
	    case 22: return 'w';
	    case 23: return 'x';
	    case 24: return 'y';
	    case 25: return 'z';
	    default: return '~';
	    }
	}
	 
	public static float getWeight(char chars){
	    switch(chars){
	        case 'a': return 8.167f;
	        case 'b': return 1.492f;
	        case 'c': return 2.782f;
	        case 'd': return 4.253f;
	        case 'e': return 12.702f;
	        case 'f': return 2.228f;
	        case 'g': return 2.015f;
	        case 'h': return 6.094f;
	        case 'i': return 6.966f;
	        case 'j': return 0.153f;
	        case 'k': return 0.772f;
	        case 'l': return 4.025f;
	        case 'm': return 2.406f;
	        case 'n': return 6.749f;
	        case 'o': return 7.507f;
	        case 'p': return 1.929f;
	        case 'q': return 0.095f;
	        case 'r': return 5.987f;
	        case 's': return 6.327f;
	        case 't': return 9.056f;
	        case 'u': return 2.758f;
	        case 'v': return 0.978f;
	        case 'w': return 2.360f;
	        case 'x': return 0.150f;
	        case 'y': return 1.974f;
	        case 'z': return 0.074f;
	        default: System.out.println("ERROR 2"); return 100000;
	    }
	}
	   
	    public static int getPlace(char chars){
	        switch(chars){
	    case 'a': return 0;
	    case 'b': return 1;
	    case 'c': return 2;
	    case 'd': return 3;
	    case 'e': return 4;
	    case 'f': return 5;
	    case 'g': return 6;
	    case 'h': return 7;
	    case 'i': return 8;
	    case 'j': return 9;
	    case 'k': return 10;
	    case 'l': return 11;
	    case 'm': return 12;
	    case 'n': return 13;
	    case 'o': return 14;
	    case 'p': return 15;
	    case 'q': return 16;
	    case 'r': return 17;
	    case 's': return 18;
	    case 't': return 19;
	    case 'u': return 20;
	    case 'v': return 21;
	    case 'w': return 22;
	    case 'x': return 23;
	    case 'y': return 24;
	    case 'z': return 25;
	    default: return 100000;
	        }
	    }
	    
	    public void doQueue(){
	    	while(bestQueue.size() > 0){


	    		letterSet set = bestQueue.poll();
    			synchronized(bestSets){
	    		for(int i = 0; i < 5; i++){
	    			if(bestSets.get(i).getScore() <
	    					set.getScore()){
	    				bestSets.add(i, new letterSet(set));
	    				bestSets.remove(5);
	    				break;
	    			}
	    			}
	    		}
	    	}
	    }
	    
	    public static void checkPrint() throws IOException{
	    	threadsDone++;
			System.out.println(threadsDone + " out of " + threads + " threads complete.");
	    	if(threads == threadsDone){
	    		
	    		 PrintWriter fw = new PrintWriter("Instance" + k + "-" + l + ".txt");
	    	        
	    		 	for(letterSet set : bestSets){
	    		 		fw.print(set);
	    		 	}
	    	       
	    	        fw.flush();
	    	        fw.close();
	    	        
	    	    	System.out.println("Run complete.");
	    	}
	    }
	    
	    
	    private class letterSet {
	    	private Character[] best = new Character[25];
	        private int conflicts = maxConflicts;
	        private float[] weight = new float[9];
	        private double score = 0;

	        public letterSet(){
	        	score = 0;
	        }
	        
	    	public letterSet(Character[] best, int conflicts, float[] weight, double score){
	    		this.best = best;
	    		this.conflicts = conflicts;
	    		this.weight = weight;
	    		this.score = score;
	    	}
	    	
	    	public letterSet(letterSet other){
	    		this.best = other.best.clone();
	    		this.conflicts = other.conflicts;
	    		this.weight = other.weight.clone();
	    		this.score = other.score;
	    	}
	    	
	    	public double getScore(){
	    		return score;
	    	}
	    	
	    	@Override
	    	public String toString(){
	    		StringBuilder fw = new StringBuilder();
	    		for(Character a : best){
    	        	fw.append(a + " ");
    	        }
    	        fw.append("\nScore: " + score + " Conflicts: " + conflicts + "\n");
    	        for(int i = 0; i < 9; i++){
    	            fw.append(weight[i] + " ");
    	        } fw.append("\n");
    	        return fw.toString();
	    	}
	    }

}