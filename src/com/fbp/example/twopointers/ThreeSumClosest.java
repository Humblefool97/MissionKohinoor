package com.fbp.example.twopointers;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by rajeevranganathan
 */
public class ThreeSumClosest{
    public static void main(String[] args) {
        int num[]={-1,2,1,-4};
        int target = 1;

        System.out.println(threeSumClosest(num,target));
    }
    public static int threeSumClosest(int[] num, int target) {
        int n = num.length;
        if (n < 3)
            return -1;
        int closest = num[0] + num[1] + num[2];
        int diff = Math.abs(closest - target);
        if (diff == 0)
            return closest;

        Arrays.sort(num);

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                int newDiff = Math.abs(sum - target);
                if (newDiff < diff) {
                    diff = newDiff;
                    closest = sum;
                }

                if (sum < target)
                    j++;
                else
                    k--;
            }
        }

        return closest;

    }
}
