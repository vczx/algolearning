package leetcode;

import org.junit.Assert;

public class ReverseString {
    public static void main(String[] args) {
        Assert.assertEquals("olleh",reverseString("hello"));
        Assert.assertEquals( "amanaP :lanac a ,nalp a ,nam A",reverseString("A man, a plan, a canal: Panama"));

    }

    public static String reverseString(String s) {
        if(s == null || s.equals("")){
            return s;
        }
        char[] chars = s.toCharArray();
        for(int i=0;i<s.length()/2;i++){
            char temp = chars[i];
            int endPos = chars.length - 1 - i;
            chars[i] = chars[endPos];
            chars[endPos] = temp;
        }

        return String.valueOf(chars);
    }
}
