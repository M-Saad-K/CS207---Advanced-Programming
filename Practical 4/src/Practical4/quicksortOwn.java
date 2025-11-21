/**
 * @ Author : Muhammad Saad Khan
 * @ Date : 2025 / 10 / 28
 * @ Title : quicksortOwn.java
 * **/

package Practical4;
import java.util.Random;

public class quicksortOwn{

    // Swap method
    public static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // This one partitions it into less and more than
    public static int partition(int[] arr, int start, int end) {

        // Takes in an array of int
        // Sets the first index as pivotInx
        int pivotInx = start;

        // Set last element as pivot

        /// Implementation of choosing a random pivot
        Random ram = new Random();

        /* Why are be adding 1 and start
        * start-end is 0->(n-1)
        * start = 0 and end = 7-1 -> 6, but actually 7
        * Furthermore, the +start is for ranges when start != 0
        * */
        int randNum = ram.nextInt(end-start+1)+start;
        int pivot = arr[randNum];

        //DEBUG
        System.out.println("Pivot: " + pivot + " Pivot's Index : " + randNum);
        // Place the pivot at the end of the array
        swap(arr, randNum, end);

        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pivotInx);
                pivotInx++;
            }
        }
        // Add this here b/c it never reaches the pivot
        swap(arr, pivotInx, end);
        return pivotInx;

    }


    // This is for when partition happens
    public static void quicksort(int[] arr, int start, int end){
        if(start < end){
            int pivotIdx = partition(arr, start, end);
            // This is after it is sorted, we're now sorting the sub areas
            // Recursion, that is why we need the parameters
            quicksort(arr, start, pivotIdx-1);
            quicksort(arr, pivotIdx+1, end);
        }
    }
}

