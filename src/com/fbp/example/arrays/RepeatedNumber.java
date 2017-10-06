package com.fbp.example.arrays;

import java.util.Arrays;

public class RepeatedNumber {
    public static void main(String[] args) {
        int[] A = {3, 1, 2, 5, 3};
        int[] B = repeatedNumber(A);
        System.out.println(Arrays.toString(B));
    }

    public static int[] repeatedNumber(final int[] A) {
        if (A == null)
            return null;
        int resultArr[] = new int[2];

        int i = 0;
        int n = A.length;

        while (i < n) {
            //if the element is already processed,then continue to next element
            if (A[i] < 0) {
                i++;
                continue;
            }

            int index = A[i] - 1;

            //if the element is not processed
            if (A[index] > 0) {
                //Copy
                A[i] = A[index];
                //Mark it is as visited
                A[index] = -1;
            } else {
                //if the element is processed but occured again,decrement the counter again
                A[index]--;
                //we are yet to see element i
                A[i] = 0;
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (A[j] == -2) {
                resultArr[0] = j + 1;
            } else if (A[j] == 0) {
                resultArr[1] = j + 1;
            }
        }
        return resultArr;

    }
}
