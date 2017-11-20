package com.fbp.example.dp;

/**
 * Created by rajeevranganathan
 */
public class LongestBitonicSequence {


    private static int lbs(int arr[], int n) {
        //1.Find the lis of arr[] from left to right
        int lis[] = new int[n];
        for (int i = 0; i < n; i++)
            lis[i] = 1;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] > arr[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        //2.find the lis from right to left
        int lds[] = new int[n];
        for (int i = 0; i < n; i++)
            lds[i] = 1;

        for (int i = n - 2; i > 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int max = lis[0] + lds[0] - 1;//because u have counted twice
        for (int i = 0; i < n; i++) {
            if (lis[i] + lds[i] - 1 > max) {
                max = lis[i] + lds[i] - 1;
            }
        }

        return max;
    }
}
