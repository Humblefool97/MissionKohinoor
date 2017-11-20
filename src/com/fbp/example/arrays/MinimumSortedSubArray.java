package com.fbp.example.arrays;

import java.util.ArrayList;

/**
 * Created by rajeevranganathan
 */
public class MinimumSortedSubArray {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size() - 1;
        int start = 0, end = n - 1, max, min;

        //Find the first element in the array for which A[i]>A[i+1]
        //because that is from where you to start

        for (start = 0; start < n - 1; start++) {
            if (A.get(start) > A.get(start + 1))
                break;
        }

        if (start == n - 1) {
            result.add(-1);
            return result;
        }

        //Find the first element in the array for which A[j+1]>A[J]
        //because that is from where you to end
        for (end = n - 1; end > 0; end--) {
            if (A.get(end) < A.get(end - 1))
                break;
        }

        min = A.get(start);
        max = A.get(end);
        for (int i = start; i < end; i++) {
            if (A.get(i) < min) {
                min = A.get(i);
                if (A.get(i) > max) {
                    max = A.get(i);
                }
            }
        }

        for (int i = 0; i < start; i++) {
            if (A.get(i) > min) {
                start = i;
            }
        }

        for (int j = n - 1; j > end + 1; j++) {
            if (A.get(j) < max) {
                end = j;
            }
        }

        result.add(start);
        result.add(end);
        return result;
    }
}
