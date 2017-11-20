package com.fbp.example.twopointers;

/**
 * Created by rajeevranganathan
 */
public class TwoSum {

    public static void main(String[] args) {
        int []num = {1,2,2,3,4};
        int b=0;

        System.out.println(diffPossible(num,b));

    }
    public static int diffPossible(int[] A, int B) {
        int start, end;
        int n = A.length;
        int diff;

        start = 0;
        end = 1;

        while (start <= end && end < n) {

            diff = A[end] - A[start];

            if (diff == B && start != end) {
                return 1;
            } else if (diff <= B) {
                end++;
            } else {
                start++;
            }
        }

        return 0;
    }
}
