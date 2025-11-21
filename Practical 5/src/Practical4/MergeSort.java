package Practical4;

public class MergeSort {

    public static void merge(int[] arr, int start, int mid, int end) {
        // Make a new array with elements between start and end, + 1
        int[] sortedArr = new int[end - start + 1];
        // Set the leftI = start
        int leftIndex = start;
        // Set the rightI = mid+1, for the other array's first element
        int rightIndex = mid+1;

        int checkI = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            if(arr[leftIndex] <= arr[rightIndex]) {
                sortedArr[checkI++] = arr[leftIndex++];
            } else {
                sortedArr[checkI++] = arr[rightIndex++];
            }
        }
        // When the other array is completed, finish off the second array
        while (leftIndex <= mid) {
            sortedArr[checkI++] = arr[leftIndex++];
        }
        while (rightIndex <= end) {
            sortedArr[checkI++] = arr[rightIndex++];
        }
        // Then we need to copy all the elements into their positions back into OG array
        for(int curr = 0; curr < sortedArr.length; curr++) {
            /// Why is this used, b/c sorted arr is not the same size at the original array, that is why we are doing this
            // It takes a slice of the array, not the whole thing
            // curr over passes sortedArr, when it is at end, no more adding to the OG
            arr[start+curr] = sortedArr[curr];
        }

    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
}
