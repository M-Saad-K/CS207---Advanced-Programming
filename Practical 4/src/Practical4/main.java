/**
 * @ Author : Muhammad Saad Khan
 * @ Date : 2025 / 10 / 28
 * @ Title : main.java
 * **/

package Practical4;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        quicksortOwn sorting = new quicksortOwn();
        // Test array, pre determined
        int[] arr = {4, 20, 25, 15, 27, 12, 1, 8};
        sorting.quicksort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
