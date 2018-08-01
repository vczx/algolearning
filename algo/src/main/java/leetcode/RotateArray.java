package leetcode;

import java.util.ArrayList;

public class RotateArray {
    //https://leetcode.com/problems/rotate-array/description/
    public static void main(String[] args) throws Exception {
        int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        //leftRotate(list, 3);
//        leftRotateRversal(list,2);

        list = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        leftRotateRversal(list, 2);
        printList(list);
        //
        System.out.println();
        list = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        rightRotateReversal(list, 2);
        printList(list);
        System.out.println();
        //
        list = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < 2; i++) {
            leftRotate(list);
        }
        printList(list);
        System.out.println();
        //
        list = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < 2; i++) {
            rightRotate(list);
        }
        printList(list);

    }

    private static void printList(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    public static void rightRotate(int[] nums) throws Exception {
        //same as shift all elements in the array to the right
        int length = nums.length;
        int last = nums[length-1];
        for (int i = length - 1; i > 0; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = last;

    }

    public static void leftRotate(int[] nums) throws Exception {
        //same as shifting all elements in the array to the left
        int length = nums.length;
        if (length == 0) {
            throw new Exception();
        }
        int first = nums[0];
        for (int i = 0; i < length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[length - 1] = first;
    }

    public static void rightRotateReversal(int[] nums, int k) throws Exception {
        int length = nums.length;
        k %= length; // this is important is number of numbers is larger than the array size
        reverseArray(nums, 0, length - 1);
        reverseArray(nums, k, length - 1);
        reverseArray(nums, 0, k - 1);
    }

    public static void leftRotateRversal(int[] nums, int k) throws Exception {
        int length = nums.length;
        k %= length; // this is important is number of numbers is larger than the array size
        if (length == 1) {
            return;
        }
        if (k > length) {
            return;
        }

        reverseArray(nums, 0, length - 1);
        reverseArray(nums, 0, length - k - 1);
        reverseArray(nums, length - k, length - 1);
    }

    public static void reverseArray(int[] nums, int start, int end) {
        int temp = 0;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    //
    // TODO: New Method, to research and study - Block replace method
    // https://www.geeksforgeeks.org/block-swap-algorithm-for-array-rotation/
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        int[] extra = new int[k];
        for (int i = 0; i < k; i++)
            extra[i] = nums[nums.length-k+i];

        for (int i = nums.length - 1; i >= k; i--)
            nums[i] = nums[i-k];

        for (int i = 0; i < k; i++)
            nums[i] = extra[i];
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] extra = new int[k];
        System.arraycopy(nums, nums.length-k, extra, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length-k);
        System.arraycopy(extra, 0, nums, 0, k);
    }

    public void rotate4(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = list.get(i);
        }
    }
    //
}
