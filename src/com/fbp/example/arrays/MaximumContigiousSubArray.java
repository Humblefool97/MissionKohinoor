package com.fbp.example.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaximumContigiousSubArray {
    public int maxSubArray(final List<Integer> a) {
        if (a != null && a.isEmpty())
            return 0;

        int[] arr = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            arr[i] = a.get(i);
        }

        int ans = arr[0], sum = 0;

        //If the array contains only negative elements
        //then max sum = max(a)
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, arr[i]);
        }

        //if array has atleast one +ve element,ans>0
        //else <0.Hence return the max of all -ve elements
        if (ans < 0)
            return ans;


        ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > 0)
                sum += arr[i];
            else
                sum = 0;//sum + arr[i] is -ve,discard sum for that index

            ans = Math.max(sum, ans);
        }

        return ans;
    }
}
