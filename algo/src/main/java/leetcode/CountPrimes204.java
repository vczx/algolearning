package leetcode;

//https://leetcode.com/problems/count-primes/description/
public class CountPrimes204 {
    public static void main(String[] args) {
        System.out.println(countPrimesBF(2));
    }

    /*
    *The Sieve of Eratosthenes is one of the most efficient ways to find all prime numbers up to n.
I promise that the concept is surprisingly simple.
    * */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    public static int countPrimesBF(int n) {
        int count = 0;
        for(int i=2;i<n;i++){
            boolean isPrime =true;
            for(int j=2;j<i;j++){
                if(i%j == 0){
                    isPrime = false;
                }
            }
            if(isPrime){
                count ++;
            }
        }
        return count;
    }

}
