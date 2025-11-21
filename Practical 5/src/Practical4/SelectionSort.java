package Practical4;

public class SelectionSort {

    public static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i; // Take index pos of min
            // J takes i+2 as it will be the front runner value
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Changing the new min to be j
                }
            }
            swap(arr, i, minIndex);
        }
    }
}
