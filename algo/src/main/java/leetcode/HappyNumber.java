package leetcode;

//https://leetcode.com/problems/happy-number/description/
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        if(n < 1){
            return false;
        }
        int sum =0;
        while(n/10 != 0 && n%10  != 0){
            int digit = n %10;
            sum += digit * digit;
            n = n/10;
        }

        if(sum == 1){
            return true;
        }
        if(sum == n){
            return false;
        }
        return isHappy(sum);

    }
}
