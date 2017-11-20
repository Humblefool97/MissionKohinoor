package com.fbp.example.arrays;

import java.util.ArrayList;

/**
 * Created by rajeevranganathan
 */
public class SpiralOrder2 {
    public static void main(String[] args) {
        int n = 3;
        int[][] result = spiralOrder(n);
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            resultList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            ArrayList list = resultList.get(i);
            for (int j = 0; j < n; j++) {
                list.add(result[i][j]);
            }
            resultList.set(i, list);
        }

        System.out.println("asdasd");
    }

    private static int[][] spiralOrder(int n) {
        int[][] a = new int[n][n];
        int k = 1;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        while (k <= n * n) {
            //Start top
            for (int i = left; i <= right; i++) {
                a[top][i] = k++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                a[i][right] = k++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                a[bottom][i] = k++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                a[i][left] = k++;
            }
            left++;
        }

        return a;

    }
}
