package lintcode;

public class NSquareSorting {
    public static void main(String[] args) {
        int[] A = new int[]{3,2,1,4,5};
        selectionSort(A);
        for (int i:A) {
            System.out.print(i + " ");
        }

    }

    public static int[] selectionSort(int[] A){
        for(int i=0;i<A.length;i++){
            int min = A[i];
            int minIndex = i;
            int temp=0;
            for(int j=i;j<A.length;j++){
                if(A[j]<min){
                    minIndex = j;
                    min = A[j];
                }
            }
            if(minIndex != i){
                temp = A[minIndex];
                A[minIndex] = A[i];
                A[i] = temp;
            }

        }
        return A;
    }
}
