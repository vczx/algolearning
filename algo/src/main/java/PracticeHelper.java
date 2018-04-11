public class PracticeHelper {
    public static int[] getTestArray(){
        return new int[]{4,2,7,1,3};
    }

    public static void printArray(int[] array){
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] getReverseArray(){
        return new int[]{10,9,8,7,6,5,4,3,2,1,0};
    }
}
