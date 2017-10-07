package com.fbp.example.arrays;

/*
*
 * Given an array of real numbers greater than zero in form of strings.
 Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
 Return 1 for true or 0 for false.

 Example:

 Given [0.6, 0.7, 0.8, 1.2, 0.4] ,

 You should return 1

 as

 0.6+0.7+0.4=1.7

 1<1.7<2

 Hence, the output is 1.

 O(n) solution is expected.

 Note: You can assume the numbers in strings don’t overflow the primitive data type
 and there are no leading zeroes in numbers. Extra memory usage is allowed.

 * Created by rajeevranganathan on 07/10/17 for TheLastChance.
*/
public class TripletSum {
    public static void main(String[] args) {
        double[] a = {0.6, 0.7, 0.8, 1.2, 0.4};
        System.out.println(tripLetSumBruteForce(a));
        System.out.println(tripletSum(a));

    }

    public static int tripLetSumBruteForce(double a[]) {
        if (a == null || a.length == 1 || a.length < 3)
            return 0;
        int n = a.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = i + 2; k < n; k++) {
                    double sum = a[i] + a[j] + a[k];
                    if (sum > 1 && sum < 2)
                        return 1;
                }
            }
        }

        return 0;
    }

    public static int tripletSum(double[] A) {
        if (A.length < 3)
            return 0;

        double a = A[0];
        double b = A[1];
        double c = A[2];

        for (int i = 3; i < A.length; i++) {
            double sum = a + b + c;
            if (sum > 1 && sum < 2)
                return 1;

            double n = A[i];
            //if sum exceeds the limit,remove the one that contributes maximum to the sum & replace with the next element
            //in the array
            if (sum >= 2) {
                if (a > b && a > c)
                    a = n;
                else if (b > c)
                    b = n;
                else
                    c = n;
            } else {
                //else,remove the one that contributes least to the sum & replace with the next element
                //in the array
                if (a < b && a < c)
                    a = n;
                else if (b < c)
                    b = n;
                else
                    c = n;
            }

            if ((a + b + c) > 1 && (a + b + c) < 2)
                return 1;
        }

        return 0;

    }
}
