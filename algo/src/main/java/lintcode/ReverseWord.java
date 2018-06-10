package lintcode;

public class ReverseWord {

    public static void main(String[] args) {
        System.out.println(reverseWords("Sky is Blue"));
    }
    /*
     * @param s: A string
     * @return: A string
     */
    public static String reverseWords(String s) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        String[] ar = s.trim().split(" ");
        for(int i=0 ; i<ar.length/2; i++){
            int tailPos = ar.length - i -1;
            String word = ar[tailPos].trim();
            ar[tailPos] = ar[i].trim();
            ar[i] = word;
        }
        for(int i=0 ; i<ar.length; i++){
            sb.append(ar[i] + " ");
        }
        return sb.toString().trim();
    }
}
