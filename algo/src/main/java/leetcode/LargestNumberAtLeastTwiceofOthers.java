package leetcode;

public class LargestNumberAtLeastTwiceofOthers {
    public static void main(String[] args) {
        int[] input = new int[]{1,0};
        System.out.println(dominantIndex(input));
    }

    public static int dominantIndex(int[] nums) {

        if(nums.length < 2){
            return 0;
        }

        int maxIndex=0, max = nums[0], secondMax = -100;

        for(int i=0;i<nums.length;i++){
            if(nums[i] > max){
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            }else if(nums[i] > secondMax){
                secondMax = nums[i];
            }
        }
        System.out.println(max);
        System.out.println(secondMax);
        return secondMax * 2 <= max ? maxIndex : -1;
    }


}
