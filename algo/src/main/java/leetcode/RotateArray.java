package leetcode;

public class RotateArray {
    //https://leetcode.com/problems/rotate-array/description/
    public static void main(String[] args) throws Exception {
        int[] list = new int[]{1,2,3,4,5,6,7,8};
        //leftRotate(list, 3);
//        leftRotateRversal(list,2);

        list = new int[]{1,2,3,4,5,6,7,8};
        leftRotateRversal(list,2);

        for (int i = 0; i <list.length ; i++) {
            System.out.print(list[i] + " ");
        }

        //

        rightRotateReversal(list,2);
        for (int i = 0; i <list.length ; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();

    }

    public static void rightRotate(int[] nums, int k) throws Exception {

    }

    public static void leftRotate(int[] nums, int k) throws Exception{
        int length = nums.length;
        if(length == 0){
            throw new Exception();
        }
        for (int i = 0; i <k ; i++) {
            int first = nums[0];
            for(int j=0;j<length-1;j++){
                nums[j] = nums[j+1];
            }
            nums[length -1] = first;
        }
    }
    public static void rightRotateReversal(int[] nums, int k) throws Exception{
            int length = nums.length;
            reverseArray(nums,0, length-1);
            reverseArray(nums,k,length-1);
            reverseArray(nums,0,k-1);
    }

    public static void leftRotateRversal(int[] nums, int k) throws Exception{
        int length = nums.length;
        reverseArray(nums,0,length-1);
        reverseArray(nums,0,length-k-1);
        reverseArray(nums,length-k,length-1);
    }

    public static void reverseArray(int[] nums,int start, int end){
        int temp = 0;
        while(start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
