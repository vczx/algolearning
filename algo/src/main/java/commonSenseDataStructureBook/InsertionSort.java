package commonSenseDataStructureBook;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println("--Textbook Implementation--");
//        PracticeHelper.printArray(textBookSelectionSort(PracticeHelper.getTestArray()));
        PracticeHelper.printArray(mySelectionSort(PracticeHelper.getTestArray()));
        PracticeHelper.printArray(mySelectionSort(PracticeHelper.getReverseArray()));

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

    private static int[] mySelectionSort(int[] a){
        for(int i=1;i<a.length;i++){
            int insertIndex = i;
            int insertValue = a[i];

            for(int j=i;j>0;j--){
                if(a[j-1] > insertValue){
                    a[j] = a[j-1];
                    insertIndex = j-1;
                }
            }

            a[insertIndex] = insertValue;
        }
        return a;
    }
}
