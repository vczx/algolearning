// For bubble sort, each passthrough the highest unsorted value bubble to the right most
// Each passthrough will sort one number to the right most, hence the index keep reducing
//
public class BubbleSort {
    public static void main(String[] args) {
        int[] unsortedArray = PracticeHelper.getTestArray();
//        printArray(bubbleSort(unsortedArray));
        PracticeHelper.printArray(textbookBubbleSort(unsortedArray));
    }

    //my implementation
    public static int[] bubbleSort(int[] array){
        for(int i=array.length -1; i>0;i--){
            for(int j=0;j<i;j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j]=array[j+1];
                    array[j+1] =temp;
                }
            }
        }
        return array;
    }

    //textbook implementation
    public static int[] textbookBubbleSort(int[] array){
        boolean isSorted = false;
        int endingIndex = array.length -1;
        while(!isSorted){
            isSorted = true;

            for(int i =0;i<endingIndex;i++){
                if(array[i] > array[i + 1]){
                    isSorted=false;
                    int temp = array[i];
                    array[i]=array[i+1];
                    array[i+1] =temp;
                }
            }
            endingIndex --;
        }
        return array;
    }
}
