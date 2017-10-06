package com.fbp.example.arrays;

import java.util.ArrayList;

public class MaxAbsoluteDifference {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(2);
        a.add(2);
        a.add(2);

        System.out.println(maxArr(a));

    }

    public static int maxArr(ArrayList<Integer> a) {
        if(a==null)
            return 0;

        int sum = 0;
        int[] A = new int[a.size()-1];
        for (int i = 1; i < a.size(); i++) {
            A[i-1] = a.get(i);
        }

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE,max3 = Integer.MIN_VALUE, max4 = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int size = A.length;
        for (int i = 0; i<size; ++i)
        {
            max1 = Math.max(max1, A[i] + i);
            max2 = Math.max(max2, -A[i] + i);
            max3 = Math.max(max3, A[i] - i);
            max4 = Math.max(max4, -A[i] - i);
        }
        for (int i = 0; i<size; ++i)
        {
            ans = Math.max(ans, max1 - A[i] - i);
            ans = Math.max(ans, max2 + A[i] - i);
            ans = Math.max(ans, max3 - A[i] + i);
            ans = Math.max(ans, max4 + A[i] + i);
        }
        return ans;
    }
}
