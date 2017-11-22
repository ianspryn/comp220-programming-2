import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Old {
    
    public static int[][] numbers = new int[26][26];
    
    //14.5 avg
    
public static void main(String[] args) throws IOException, InterruptedException{

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
    
        long counter = 0;
        float[] targetWeight = {11f,13f,15f,16f,19.0f,   16f,14.5f,12.5f,11f};
        ArrayList<Character> best1 = new ArrayList<Character>(); int conflicts1 = 100000; float[] weight1 = new float[9]; double score1 = 0;
        ArrayList<Character> best2 = new ArrayList<Character>(); int conflicts2 = 100000; float[] weight2 = new float[9]; double score2 = 0;
        ArrayList<Character> best3 = new ArrayList<Character>(); int conflicts3 = 100000; float[] weight3 = new float[9]; double score3 = 0;
    
        //FIXME 6-11

        int n = 0;

        System.out.println("Instance" + n);
        for(int m = 0; m < 1; m++)
                    for(int o = 0; o < 1; o++){
                        for(int p = 0; p < 1; p++){
                            for(int q = 0; q < 1; q++){
                                for(int r = 0; r < 9; r++){
                                    for(int s = 0; s < 8; s++){
                                        for(int t = 0; t < 7; t++){
                                            for(int u = 0; u < 6; u++){
                                                for(int v = 0; v < 5; v++){
                                                    for(int w = 0; w < 4; w++){
                                                        for(int x = 0; x < 3; x++){
                                                            for(int y = 0; y < 2; y++){
                                                                
                                                                ArrayList<Character> allletters = new ArrayList<Character>();
                                                                allletters.add('b');
                                                                allletters.add('f');
                                                                allletters.add('c');
                                                                allletters.add('u');
                                                                allletters.add('k');
                                                                allletters.add('d');
                                                                allletters.add('p');
                                                                allletters.add('t');
                                                                allletters.add('e');
                                                                allletters.add('w');
                                                                allletters.add('i');
                                                                allletters.add('y');
                                                                allletters.add('l');
                                                                allletters.add('s');
                                                                
                                                                ArrayList<Character> newletters = new ArrayList<Character>();
                                                                
                                                                newletters.add('o');
                                                                newletters.add('a');
                                                                newletters.add(allletters.get(m));allletters.remove(m);
                                                                newletters.add(allletters.get(n));allletters.remove(n);
                                                                newletters.add('r');
                                                                newletters.add(allletters.get(o));allletters.remove(o);
                                                                newletters.add(allletters.get(p));allletters.remove(p);
                                                                newletters.add(allletters.get(q));allletters.remove(q);
                                                                newletters.add('h');
                                                                newletters.add('n');
                                                                newletters.add('q');
                                                                newletters.add(allletters.get(r));allletters.remove(r);
                                                                newletters.add(allletters.get(s));allletters.remove(s);
                                                                newletters.add(allletters.get(t));allletters.remove(t);
                                                                newletters.add('x');
                                                                newletters.add(allletters.get(u));allletters.remove(u);
                                                                newletters.add('m');
                                                                newletters.add('j');
                                                                newletters.add(allletters.get(v));allletters.remove(v);
                                                                newletters.add(allletters.get(w));allletters.remove(w);
                                                                newletters.add('v');
                                                                newletters.add(allletters.get(x));allletters.remove(x);
                                                                newletters.add(allletters.get(y));allletters.remove(y);
                                                                newletters.add(allletters.get(0));
                                                                newletters.add('g');
                                                                newletters.add('z');
                                                                
                                                                int conflicts = 0;
                                                                float[] weight = {0,0,0,0,0,0,0,0,0};
                                                                boolean fail = false;
                                                                
                                                                for(int letter = 0; letter < 26; letter++){
                                                                    
                                                                    char current = newletters.get(letter);
                                                                    int place = getPlace(current);
                                                                    
                                                                    switch(letter){
                                                                    
                                                                    case 0: conflicts += numbers[place][getPlace(newletters.get(9))] + numbers[place][getPlace(newletters.get(16))] 
                                                                            + numbers[place][getPlace(newletters.get(21))] + numbers[place][getPlace(newletters.get(24))];
                                                                            weight[0] += getWeight(current);
                                                                            break;
                                                                    case 1: conflicts += numbers[place][getPlace(newletters.get(10))] + numbers[place][getPlace(newletters.get(9))] 
                                                                            + numbers[place][getPlace(newletters.get(17))] + numbers[place][getPlace(newletters.get(22))];
                                                                            weight[1] += getWeight(current);
                                                                            break;
                                                                    case 2: conflicts += numbers[place][getPlace(newletters.get(10))] + numbers[place][getPlace(newletters.get(11))] 
                                                                            + numbers[place][getPlace(newletters.get(16))] + numbers[place][getPlace(newletters.get(18))];
                                                                            weight[2] += getWeight(current);
                                                                            break;
                                                                    case 3: conflicts += numbers[place][getPlace(newletters.get(12))] + numbers[place][getPlace(newletters.get(11))] 
                                                                            + numbers[place][getPlace(newletters.get(17))] + numbers[place][getPlace(newletters.get(21))]
                                                                            + numbers[place][getPlace(newletters.get(25))];
                                                                            weight[3] += getWeight(current);
                                                                            break;
                                                                    case 4: conflicts += numbers[place][getPlace(newletters.get(12))] + numbers[place][getPlace(newletters.get(18))] 
                                                                            + numbers[place][getPlace(newletters.get(22))] + numbers[place][getPlace(newletters.get(24))];
                                                                            weight[4] += getWeight(current);
                                                                            break;
                                                                    case 5: conflicts += numbers[place][getPlace(newletters.get(13))] + numbers[place][getPlace(newletters.get(19))] 
                                                                            + numbers[place][getPlace(newletters.get(23))] + numbers[place][getPlace(newletters.get(25))];
                                                                            weight[5] += getWeight(current);
                                                                            break;
                                                                    case 6: conflicts += numbers[place][getPlace(newletters.get(13))] + numbers[place][getPlace(newletters.get(14))] 
                                                                            + numbers[place][getPlace(newletters.get(20))];
                                                                            weight[6] += getWeight(current);
                                                                            break;
                                                                    case 7: conflicts += numbers[place][getPlace(newletters.get(14))] + numbers[place][getPlace(newletters.get(15))] 
                                                                            + numbers[place][getPlace(newletters.get(19))];
                                                                            weight[7] += getWeight(current);
                                                                            break;
                                                                    case 8: conflicts += numbers[place][getPlace(newletters.get(15))] + numbers[place][getPlace(newletters.get(20))] 
                                                                            + numbers[place][getPlace(newletters.get(23))];
                                                                            weight[8] += getWeight(current);
                                                                            break;
                                                                    case 9: conflicts += numbers[place][getPlace(newletters.get(16))] + numbers[place][getPlace(newletters.get(17))] + 
                                                                            numbers[place][getPlace(newletters.get(21))] + numbers[place][getPlace(newletters.get(22))]
                                                                            + numbers[place][getPlace(newletters.get(24))]; weight[0] += getWeight(current); weight[1] += getWeight(current);
                                                                            break;
                                                                    case 10: conflicts += numbers[place][getPlace(newletters.get(16))] + numbers[place][getPlace(newletters.get(17))] + 
                                                                            numbers[place][getPlace(newletters.get(18))] + numbers[place][getPlace(newletters.get(22))]
                                                                            ; weight[2] += getWeight(current); weight[1] += getWeight(current);
                                                                            break;
                                                                    case 11: conflicts += numbers[place][getPlace(newletters.get(16))] + numbers[place][getPlace(newletters.get(17))] + 
                                                                            numbers[place][getPlace(newletters.get(18))] + numbers[place][getPlace(newletters.get(21))]
                                                                            + numbers[place][getPlace(newletters.get(25))]; weight[2] += getWeight(current); weight[3] += getWeight(current);
                                                                            break;
                                                                    case 12: conflicts += numbers[place][getPlace(newletters.get(18))] + numbers[place][getPlace(newletters.get(17))] + 
                                                                            numbers[place][getPlace(newletters.get(22))] + numbers[place][getPlace(newletters.get(21))]
                                                                            + numbers[place][getPlace(newletters.get(25))] + numbers[place][getPlace(newletters.get(24))]; weight[4] += getWeight(current); weight[3] += getWeight(current);
                                                                            break;
                                                                    case 13: conflicts += numbers[place][getPlace(newletters.get(19))] + numbers[place][getPlace(newletters.get(20))] + 
                                                                            numbers[place][getPlace(newletters.get(23))] + numbers[place][getPlace(newletters.get(25))];
                                                                            weight[5] += getWeight(current); weight[6] += getWeight(current);
                                                                            break;
                                                                    case 14: conflicts += numbers[place][getPlace(newletters.get(19))] + numbers[place][getPlace(newletters.get(20))]
                                                                            ; weight[7] += getWeight(current); weight[6] += getWeight(current);
                                                                            break;
                                                                    case 15: conflicts += numbers[place][getPlace(newletters.get(19))] + numbers[place][getPlace(newletters.get(20))] + 
                                                                            numbers[place][getPlace(newletters.get(23))]; weight[7] += getWeight(current); weight[8] += getWeight(current);
                                                                            break;
                                                                    case 16: conflicts +=numbers[place][getPlace(newletters.get(21))] + numbers[place][getPlace(newletters.get(18))]
                                                                            + numbers[place][getPlace(newletters.get(24))]; weight[0] += getWeight(current); weight[2] += getWeight(current);
                                                                            break;
                                                                    case 17: conflicts += numbers[place][getPlace(newletters.get(21))] + numbers[place][getPlace(newletters.get(22))]
                                                                            + numbers[place][getPlace(newletters.get(25))]; weight[1] += getWeight(current); weight[3] += getWeight(current);
                                                                            break;
                                                                    case 18: conflicts += numbers[place][getPlace(newletters.get(22))] + numbers[place][getPlace(newletters.get(24))]
                                                                            ; weight[2] += getWeight(current); weight[4] += getWeight(current);
                                                                            break;
                                                                    case 19: conflicts += numbers[place][getPlace(newletters.get(23))]; weight[5] += getWeight(current); weight[7] += getWeight(current);
                                                                            break;
                                                                    case 20: conflicts += numbers[place][getPlace(newletters.get(23))]; weight[6] += getWeight(current); weight[8] += getWeight(current);
                                                                            break;
                                                                    case 21: conflicts += numbers[place][getPlace(newletters.get(24))]+ numbers[place][getPlace(newletters.get(25))];
                                                                            weight[0] += getWeight(current); weight[3] += getWeight(current);
                                                                            break;
                                                                    case 22: conflicts += numbers[place][getPlace(newletters.get(24))]; weight[1] += getWeight(current); weight[4] += getWeight(current);
                                                                            break;
                                                                    case 23:  weight[8] += getWeight(current); weight[5] += getWeight(current);
                                                                            break;
                                                                    case 24:  weight[0] += getWeight(current); weight[4] += getWeight(current);
                                                                            break;
                                                                    case 25:  weight[5] += getWeight(current); weight[3] += getWeight(current);
                                                                            break;
                                                                    
                                                                    default: ;
                                                                    
                                                                    }
                                                                    
                                                                    if(conflicts > 13000){
                                                                        fail = true;
                                                                        break;
                                                                    }
                                                                    
                                                                }
                                                                
                                                                counter++;

                                                                
                                                                if(!fail) {
                                                                
	                                                                //Calculate closeness
	                                                                
	                                                                float offtotal = 0;
	                                                                
	                                                                for(int i = 0; i < 9; i++){
	                                                                    offtotal += Math.pow(weight[i] - targetWeight[i], 2.2);
	                                                                }
	                                                                
	                                                                double score = (95.0d/(double)conflicts) + (5.0d/offtotal);
	                                                                
	                                                                if(score > score1){
	                                                                    weight1 = weight;
	                                                                    conflicts1 = conflicts;
	                                                                    best1 = newletters;
	                                                                    score1 = score;
	                                                                } else if(score > score2){
	                                                                    weight2 = weight;
	                                                                    conflicts2 = conflicts;
	                                                                    best2 = newletters;
	                                                                    score2 = score;
	                                                                } else if (score > score3){
	                                                                    weight3 = weight;
	                                                                    conflicts3 = conflicts;
	                                                                    best3 = newletters;
	                                                                    score3 = score;
	                                                                }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                
        PrintWriter fw = new PrintWriter("Instance" + (n) + ".txt");
                    
        fw.println(counter);
        fw.println(best1);
        fw.println("Score: " + score1 + " Conflicts: " + conflicts1);
        for(int i = 0; i < 9; i++){
            fw.print(weight1[i] + " ");
        } fw.println("");
        fw.println(best2);
        fw.println("Score: " + score2 + " Conflicts: " + conflicts2);
        for(int i = 0; i < 9; i++){
            fw.print(weight2[i] + " ");
        } fw.println("");
        fw.println(best3);
        fw.println("Score: " + score3 + " Conflicts: " + conflicts3);
        for(int i = 0; i < 9; i++){
            fw.print(weight3[i] + " ");
        } fw.println("");
        
        fw.flush();
        fw.close();
            
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

}
