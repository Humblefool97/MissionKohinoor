package com.fbp.example.arrays;

import java.util.ArrayList;
import java.util.List;

/*
*
 *Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
  Sample Input:
 [3 4 1 4 1]
 Sample Output:
 1

 If there are multiple possible answers ( like in the sample case above ), output any one.
 If there is no duplicate, output -1

 * Created by rajeevranganathan on 07/10/17 for TheLastChance.
*/
public class DuplicateNumber {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(3);
        a.add(4);
        a.add(1);
        a.add(4);
        a.add(1);

        System.out.println(repeatedNumber(a));
    }

    public static int repeatedNumber(final List<Integer> a) {
        if (a == null || a.isEmpty())
            return -1;

        int[] A = new int[a.size() - 1];
        for (int i = 1; i < a.size(); i++) {
            A[i - 1] = a.get(i);
        }

        return findDuplicate(A);
    }

    private static int findDuplicate(int A[]) {
        if (A.length == 1)
            return A[0];
        int i = 0;
        int n = A.length - 1;
        while (i <= n) {
            if (A[i] < 0) {
                i++;
                continue;
            }

            int jumpIndex = A[i] - 1;
            if (A[jumpIndex] > 0) {
                A[i] = A[jumpIndex];
                A[jumpIndex] = -1;
            } else {
                return A[i];
            }
        }
        return -1;
    }
}
