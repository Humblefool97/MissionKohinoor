package com.fbp.example.binarysearch;

import java.util.ArrayList;

public class InsertSortedPosition {

    public int searchInsert(ArrayList<Integer> a, int target) {
        if (a == null)
            return -1;
        if (target > a.get(a.size() - 1)) {
            return a.size();
        }
        int nums[] = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            nums[i] = a.get(i);
        }

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;

            if (target > nums[mid]) {
                i = mid + 1;
            } else if (target < nums[mid]) {
                j = mid - 1;
            } else {
                return mid;
            }
        }

        return i;
    }

    public int searchInsertFastest(ArrayList<Integer> a, int b) {
        int n = a.size();

        int start = 0;
        int end = n - 1;

        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (a.get(mid) == b) return mid;
            if (a.get(mid) < b) start = mid + 1;
            else end = mid - 1;
        }

        return start;
    }


}
