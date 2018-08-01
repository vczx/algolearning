package leetcode;

//https://leetcode.com/problems/rotate-string/description/
public class RotateString {
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
    }

    public static boolean rotateString(String A, String B) {
        if(A.equals(B)){
            return true;
        }
        for(int i=0;i<A.length();i++){
            A = rotate(A.toCharArray());
            if(A.equals(B)){
                return  true;
            }

        }
        return false;
    }

    public static String rotate(char[] str){
        char first = str[0];
        int length = str.length;
        for(int i=0;i<length-1;i++){
            str[i] = str[i+1];
        }
        str[length-1] = first;
        return String.valueOf(str);
    }

    public boolean rotateString2(String A, String B) {
        if(B.length() != A.length()) return false;
        StringBuilder sb = new StringBuilder();
        sb.append(B);
        sb.append(B);
        if(sb.toString().contains(A)) {
            return true;
        }
        return false;
    }

    public boolean rotateString3(String A, String B) {
        if(A.length()!=B.length())
            return false;
        return (A+A).contains(B);
    }
}
