package com.fbp.example.arrays;

import java.util.ArrayList;

/**
 * Created by rajeevranganathan
 */
public class MatrixRotate {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix(a, 3);
        printMatrix(a, 3);
    }

    public static void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int arr[][] = new int[n][];


        for (int i = 0; i <n ; i++) {
            ArrayList<Integer> rows = a.get(i);
            for (int j = 0; j < n; j++) {
                arr[i][j] = rows.get(j);
            }
        }
        a.remove(0);
        a.remove(1);

        rotateMatrix(arr, n);
        for(int i=0;i<n;i++){
            ArrayList list = a.get(i);
            for(int j=0;j<n;j++){
                list.add(arr[i][j]);
            }
            a.set(i,list);
        }

    }


    public static void rotateMatrix(int[][] a, int n) {
        //Take Transpose of the matrix
        for (int i = 0; i < a.length; i++)
            for (int j = i; j < a[0].length; j++)
            {
                int temp = a[j][i];
                a[j][i] = a[i][j];
                a[i][j] = temp;
            }

        //Take reverse of each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = a[i][n - j-1];
                a[i][n - j-1] = a[i][j];
                a[i][j] = temp;
            }
        }

    }

    private static void printMatrix(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }


}
