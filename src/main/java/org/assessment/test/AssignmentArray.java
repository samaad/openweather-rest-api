package org.assessment.test;

import java.util.Arrays;

public class AssignmentArray {

    private static int[] mergeAndSort(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        int cnt = 0;

        // Merge First array to the final array (mergedArray) and return the count
        cnt = mergeArray(arr1, mergedArray, cnt);
        // Merge secound array to the final array (mergedArray)
        mergeArray(arr2, mergedArray, cnt);

        // Sort the final array and return it.
        Arrays.sort(mergedArray);
        return mergedArray;
    }

    private static int mergeArray(int[] arr, int[] mergedArray, int cnt){
        for (int i = 0; i < arr.length; i++){
            mergedArray[cnt] = arr[i];
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int UnsortedArrayA[] = new int [] {1, 3, 5, 7, 8};
        int UnsortedArrayB[] = new int [] {2, 4, 6, 9, 10};
        int[] mergedArray = mergeAndSort(UnsortedArrayA, UnsortedArrayB);

        System.out.print("Element of UnsortedArrayA  ");
        System.out.println(Arrays.toString(UnsortedArrayA));
        System.out.print("Element of UnsortedArrayB  ");
        System.out.println(Arrays.toString(UnsortedArrayB));

        System.out.println("Merged Array : " + Arrays.toString(mergedArray));

    }
}
