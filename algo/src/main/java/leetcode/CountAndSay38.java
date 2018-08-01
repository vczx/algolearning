package leetcode;

//https://leetcode.com/problems/count-and-say/description/
public class CountAndSay38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String str = countAndSay(n-1) + "*"; //concatenate to make sure chars count do not exit when n =2
        char[] chars = str.toCharArray();
        int counter = 1;
        String s = "";
        for(int i=0;i<chars.length-1;i++){
            if(chars[i] == chars[i+1]){
                counter++;
            }else {
                s = s+ counter+chars[i];
                counter = 1;
            }
        }

        return s;
    }
}
