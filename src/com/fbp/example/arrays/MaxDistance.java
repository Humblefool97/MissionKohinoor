package com.fbp.example.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 * Not efficant
 * Created by rajeevranganathan on 26/10/17 for TheLastChance.
 */
public class MaxDistance {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(5);
        a.add(4);
        a.add(2);

        System.out.println(maximumGap(a));
    }
    //find the maximum of i - j subjected to the constraint of A[j] <= A[i]
    public static int maximumGap(final List<Integer> a) {
        if(a==null || a.isEmpty())
            return -1;

        int result = -1;
        int n=a.size();
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(a.get(j)<=a.get(i)){
                    result=Math.max(result,i-j);
                }
            }
        }

        return result;
    }

    int maxIndexDiff(List<Integer>arr, int n)
    {
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr.get(0);
        for (i = 1; i < n; ++i)
            LMin[i] = min(arr.get(i), LMin[i - 1]);

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr.get(n - 1);
        for (j = n - 2; j >= 0; --j)
            RMax[j] = max(arr.get(j), RMax[j + 1]);

        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0; j = 0; maxDiff = -1;
        while (j < n && i < n)
        {
            if (LMin[i] < RMax[j])
            {
                maxDiff = max(maxDiff, j - i);
                j = j + 1;
            }
            else
                i = i + 1;
        }

        return maxDiff;
    }
    int max(int x, int y)
    {
        return x > y ? x : y;
    }

    int min(int x, int y)
    {
        return x < y ? x : y;
    }
}
