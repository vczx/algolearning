package commonSenseDataStructureBook;

public class InsertionSort {
    public static void main(String[] args) {
//        commonSenseDataStructureBook.PracticeHelper.printArray(myInsertionSort(commonSenseDataStructureBook.PracticeHelper.getTestArray()));
//        System.out.println("--Testing Reverse Array --");
//        commonSenseDataStructureBook.PracticeHelper.printArray(myInsertionSort(commonSenseDataStructureBook.PracticeHelper.getReverseArray()));
        System.out.println("--Textbook Implementation--");
        PracticeHelper.printArray(textBookSelectionSort(PracticeHelper.getTestArray()));
//        commonSenseDataStructureBook.PracticeHelper.printArray(textBookSelectionSort(commonSenseDataStructureBook.PracticeHelper.getReverseArray()));


    }

    private static int[] textBookSelectionSort(int[] a){
       for(int i=1;i<a.length;i++){
           int position = i;
           int tempValue = a[i];
           System.out.println("Loop : " + i + " , TempValue is  " + a[i]);
           //the last position will always be 1
           //since the first passthrough we always know that the left is already sorted, prior to the index
           //thus why we can stop at the first smaller element to the left
           while (position > 0 && a[position-1] > tempValue){
               a[position] = a[position-1];
               position --;
           }

           a[position] = tempValue;
       }
       return a;
    }

   /* private static int[] myInsertionSort(int[] a) {
        //starting from index 1, take it out and shift the left element if larger than the chosen value
        // 1. chosen value
        // 2. shift the left element if any
        // 3. place the chosen value(index) to its place (comparison here)
        // ----
        // 4 2 7 1 3
        // 2 4 7 1 3
        // 2 4 7 1 3
        // 1 2 4 7 3
        // 1 2 3 4 7

        for(int i=1;i<a.length;i++){
            int chosenValue = a[i];
            int hold= i;
            for(int j =0;j<i;j++){
                if(a[j]>chosenValue){
                    //shift to right
                    a[j+1] = a[j];
                    hold = j;
                }
            }
            if(hold != i){
                a[hold] = chosenValue;
            }
        }

        return a;
    }*/
}
