package commonSenseDataStructureBook;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{0,5,2,1,6,3};
//        System.out.println(partition(array,0,array.length-1));
//        System.out.println(codeSchoolPartition(array,0,array.length-1));

        quickSort(array,0,array.length-1);
        PracticeHelper.printArray(array);

    }

    public static void quickSort(int[] array, int start, int end){
        //base case
        if(start>= end ){
            return;
        }

        int pivot = partition(array,start,end);
        quickSort(array,start, pivot -1);
        quickSort(array,pivot+1,end);
    }

//    this method is to pick the rightest value as pivot
//    compare from the left till the pivot with 2 pointers
//    if left pointer value > right pointer value, swap them
//    then move the pointers towards each other
//    repeat till the left pointer exceed the right pointer
//    move the pivot to the last left pointer location
//    then the pivot value is at its right position

    //NOT WORKING !!!
    public static int partition(int[] array,int leftPointer,int rightPointer){
        int pivotPos = rightPointer;
        int pivotValue = array[rightPointer];

        rightPointer -=1;
        while(true){
            while(array[leftPointer] < pivotValue){
                leftPointer ++;
            }

            while(array[rightPointer] > pivotValue){
                rightPointer--;
            }

            if(leftPointer >= rightPointer){
                break;
            }else {
                int temp = array[leftPointer];
                array[leftPointer] = array[rightPointer];
                array[rightPointer] = temp;
            }
        }

        int temp = array[pivotPos];
        array[pivotPos] = array[leftPointer];
        array[leftPointer] = temp;

        //returning the new pivot position
        return leftPointer;
    }

//    https://www.youtube.com/watch?v=COk73cpQbFQ
    public static int codeSchoolPartition(int[] array, int start,int end){
        int pivot = array[end];
        int sortedIndex = start;
        for(int i=start;i<end;i++){
            if(array[i]<pivot){
                swap(array,i,sortedIndex);
                sortedIndex ++;
            }
        }
        swap(array,sortedIndex,end);
        return sortedIndex;
    }

    public static void swap(int[] array,int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
