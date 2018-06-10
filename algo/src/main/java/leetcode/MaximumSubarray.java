package leetcode;

public class MaximumSubarray {
    //https://leetcode.com/problems/maximum-subarray/description/
    public static void main(String[] args) {
        int[] testList = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] testList2 = new int[]{-2,1};
        int[] testList3 = new int[]{-1,0,-2};
//        System.out.println(maxSubarrayBruteForce(testList3));
        System.out.println(maxSubArrayKadane(testList));
    }

    public static int maxSubArrayKadane(int[] nums) {
        int maxCurrent = nums[0], maxGlobal = nums[0];
        int length = nums.length;
        for (int i = 1; i <length ; i++) {
            maxCurrent = Math.max(nums[i],maxCurrent + nums[i]);
            if(maxCurrent > maxGlobal){
                maxGlobal = maxCurrent;
            }
        }
        return maxGlobal;
    }

    public static int maxSubarrayBruteForce(int[] nums){

        //brute force
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        if(length == 1){
            return nums[0];
        }
        int maxSum = nums[0];
        int localSum =0;
        for(int i=0;i<length;i++){
            localSum = nums[i];
            for(int j=i+1;j<length;j++){
                localSum += nums[j];
                if(localSum > maxSum){
                    maxSum = localSum;
                }
            }
            if(localSum > maxSum){
                maxSum = localSum;
            }
            localSum = 0;
        }
        return maxSum;
    }
}
