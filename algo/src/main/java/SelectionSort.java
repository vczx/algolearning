public class SelectionSort {
    public static void main(String[] args) {
        int[] a = PracticeHelper.getTestArray();
        PracticeHelper.printArray(selectionSort(a));
        System.out.println("--Testing Reverse Array --");
        PracticeHelper.printArray(selectionSort(PracticeHelper.getReverseArray()));
    }

    public static int[] selectionSort(int[] array){
        //comparison
        //changing position- swap
        //starting from the first index
        //each pass will loop till the end, find the lowest index and swap with the head pointer
        // 4 2 7 1 3
        // 1 2 7 4 3
        // 1 2 7 4 3
        // 1 2 3 7 4
        // 1 2 3 4 7
        if(array == null || array.length ==0){
            System.out.println("Nothing to sort here");   
        }else{
            for(int i=0;i<array.length;i++){
                int lowestValueIndex = i;
                //j should start from i+1 as we dont we need to compare with itself first
                for(int j=i+1;j<array.length;j++){
                    //find the lowest value's index
                    if(array[j]<array[lowestValueIndex]){
                        lowestValueIndex = j;
                    }
                }
                //swap
                if(lowestValueIndex != i){
                    int temp = array[i];
                    array[i] = array[lowestValueIndex];
                    array[lowestValueIndex] = temp;
                }
            }    
        }
        return array;
    }


}
