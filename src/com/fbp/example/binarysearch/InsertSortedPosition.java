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


}
