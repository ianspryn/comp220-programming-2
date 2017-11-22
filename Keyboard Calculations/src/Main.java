
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
   
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
        float[] targetWeightLeft = {11f,13f,15f,16f,19.0f};
        float[] targetWeightRight = {11f,12.5f,14.5f,16f};
        Character[] best1 = new Character[25]; int conflicts1 = 100000; float[] weight1 = new float[9]; double score1 = 0;
        Character[] best2 = new Character[25]; int conflicts2 = 100000; float[] weight2 = new float[9]; double score2 = 0;
        Character[] best3 = new Character[25]; int conflicts3 = 100000; float[] weight3 = new float[9]; double score3 = 0;
 
        Character[] swaps = { 'b', 'c', 'd', 'f', 'g', 'j', 'k', 'l', 'm', 'p', 'q', 'u', 'v', 'w', 'x', 'y'}; 
        Character[] statics = {'h', 't', 'n', 'r', 's', 'e', 'i', 'a', 'o'};
        ArrayList<Character> allletters = new ArrayList<Character>();
        Character[] newletters = new Character[25];

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
       
        int k = 8; //15
        int l = 9; //16
        System.out.println("Instance" + k + "-" + l);

        newletters[9] =(allletters.get(l));allletters.remove(l);
        newletters[10] =(allletters.get(k));allletters.remove(k);
       
            for(int m = 0; m < 14; m++){
                newletters[11] =(allletters.get(m));allletters.remove(m);
                System.out.println(m + " out of 14");
                for(int n = 0; n < 13; n++){
                    newletters[12] =(allletters.get(n));allletters.remove(n);
                    for(int o = 0; o < 12; o++){
                        newletters[13] =(allletters.get(o));allletters.remove(o);
                        for(int p = 0; p < 11; p++){
                            newletters[14] =(allletters.get(p));allletters.remove(p);
                            for(int q = 0; q < 10; q++){
                                newletters[15] =(allletters.get(q));allletters.remove(q);
                                for(int r = 0; r < 9; r++){
                                    newletters[16] =(allletters.get(r));allletters.remove(r);
                                    for(int s = 0; s < 8; s++){
                                        newletters[17] =(allletters.get(s));allletters.remove(s);
                                        for(int t = 0; t < 7; t++){
                                            newletters[18] =(allletters.get(t));allletters.remove(t);
                                            for(int u = 0; u < 6; u++){
                                                newletters[19] =(allletters.get(u));allletters.remove(u);
                                                for(int v = 0; v < 5; v++){
                                                    newletters[20] =(allletters.get(v));allletters.remove(v);
                                                    for(int w = 0; w < 4; w++){
                                                        newletters[21] =(allletters.get(w));allletters.remove(w);
                                                        for(int x = 0; x < 3; x++){
                                                            newletters[22] =(allletters.get(x));allletters.remove(x);
                                                            for(int y = 0; y < 2; y++){

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
                                                                   
                                                                    if(conflicts > 705){
                                                                        fail = true;
                                                                        break;
                                                                    }
                                                                    
                                                                }
                                                               
                                                                counter++;
 
                                                               
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
                                                                   
                                                                    for(int i = 0; i < 5; i++){
                                                                        offtotal += Math.pow(left[i] - targetWeightLeft[i], 2);
                                                                    }
                                                                    for(int i = 0; i < 4; i++){
                                                                        offtotal += Math.pow(right[i] - targetWeightRight[i], 2);
                                                                    }
                                                                    
                                                                    double score = (96.0d/(double)conflicts) + (4.0d/offtotal);
                                                                    if(score > score1){
                                                                        weight1 = weight;
                                                                        conflicts1 = conflicts;
                                                                        best1 = newletters.clone();
                                                                        score1 = score;
                                                                    } else if(score > score2){
                                                                        weight2 = weight;
                                                                        conflicts2 = conflicts;
                                                                        best2 = newletters.clone();
                                                                        score2 = score;
                                                                    } else if (score > score3){
                                                                        weight3 = weight;
                                                                        conflicts3 = conflicts;
                                                                        best3 = newletters.clone();
                                                                        score3 = score;
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
               
        PrintWriter fw = new PrintWriter("Instance" + k + "-" + l + ".txt");
                   
        fw.println(counter);
        for(Character a : best1){
        	fw.print(a + " ");
        }
        fw.println("\nScore: " + score1 + " Conflicts: " + conflicts1);
        for(int i = 0; i < 9; i++){
            fw.print(weight1[i] + " ");
        } fw.println("");
        for(Character a : best2){
        	fw.print(a + " ");
        }
        fw.println("\nScore: " + score2 + " Conflicts: " + conflicts2);
        for(int i = 0; i < 9; i++){
            fw.print(weight2[i] + " ");
        } fw.println("");
        for(Character a : best3){
        	fw.print(a + " ");
        }
        fw.println("\nScore: " + score3 + " Conflicts: " + conflicts3);
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