package leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {
    private static String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public static void main(String[] args) {
        String[] inputs = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(inputs));
    }
    public static int uniqueMorseRepresentations(String[] words) {
        int length = words.length;
        StringBuilder sb = null;
        String currStr = "";
        Set set = new HashSet();
        for(int i = 0; i <length ; i++){
            sb = new StringBuilder();
            currStr = words[i];
            for (int j = 0; j <currStr.length() ; j++) {
                sb.append(morse[currStr.charAt(j) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    //https://www.geeksforgeeks.org/count-frequencies-elements-array-o1-extra-space-time/
    // count frequencies
}
