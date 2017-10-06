package com.fbp.example.binarysearch;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int n = arr.length;
        int key = 6;
        int i = search(arr, 0, n-1, key);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }

    private static int search(int[] a, int low, int high, int key) {
        if (a == null || a.length == 0)
            return -1;

        int mid = (low + high) / 2;

        if (a[mid] == key)
            return mid;

        //Arrays is sorted from [low...mid]
        if (a[low] <= a[mid]) {
            if (key >= a[low] && key < a[mid])
                return search(a, low, mid - 1, key);

            return search(a, mid + 1, high, key);
        } else {
            //Array is sorted from[mid..high]
            if (key > a[mid] && key <= a[high])
                return search(a, mid + 1, high, key);

            return search(a, low, mid - 1, key);
        }
    }
}
