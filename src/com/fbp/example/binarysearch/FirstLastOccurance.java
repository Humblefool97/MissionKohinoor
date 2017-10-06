package com.fbp.example.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FirstLastOccurance {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        System.out.println(searchRange(a,1));

    }

    public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (a == null || a.isEmpty())
            return null;
        a.remove(0);
        int arr[] = new int[a.size() - 1];
        for (int i = 0; i < a.size(); i++) {
            arr[i] = a.get(i);
        }

        int first = fistOccurance(arr, 0, arr.length - 1, b);
        int last = lastOccurance(arr, 0, arr.length - 1, b);
        resultList.add(first);
        resultList.add(last);
        return resultList;
    }

    private static int fistOccurance(int[] a, int low, int high, int b) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || (b > a[mid - 1])) && (a[mid] == b))
                return mid;
            else if (b > a[mid])
                high = mid + 1;
            else
                low = mid - 1;
        }

        return -1;
    }

    private static int lastOccurance(int[] a, int low, int high, int b) {
        int n = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == n || (b < a[mid + 1])) && (a[mid] == b))
                return mid;
            else if (b < a[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }
}
