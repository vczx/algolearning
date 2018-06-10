package geekforgeek.SortingAlgo;

//https://www.geeksforgeeks.org/find-the-missing-number/
public class FindTheMissingNumber {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,5};
        int missingNum = getMissingNumber(a,5);
        int missingNum2 = getMissingNumXOR(a,5);
        System.out.println("Missing Num is: " + missingNum);
    }

    //Method 1 : sum 1 to n then substract all the current numbers
    public static int getMissingNumber(int[] a, int n){
        int sum = n*(n+1)/2;
        for(int i=0;i< a.length;i++){
            sum -= a[i];
        }
        return sum;
    }

    public static int getMissingNumXOR(int[] a, int n){
        int i;
        int x1 = a[0]; /* For xor of all the elements in array */
        int x2 = 1; /* For xor of all the elements from 1 to n+1 */

        for (i = 1; i< n; i++)
            x1 = x1^a[i];

        for ( i = 2; i <= n+1; i++)
            x2 = x2^i;

        return (x1^x2);
    }
}
