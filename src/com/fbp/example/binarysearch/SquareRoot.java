package com.fbp.example.binarysearch;

public class SquareRoot {
    public static void main(String[] args) {
        int a = 2147483647;
        System.out.println(sqrt(a));
    }

    public static int sqrt(int A) {
        int low, high, root;
        int mid;
        int num;

        low = 1;
        high = A;
        root = 0;

        while (low <= high) {

            mid = (low + high) / 2;
            if (mid == A / mid)
                return mid;

            if (mid <= A / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return high;

        /*int low,high,mid;
        low=1;    high=elt;
        while(low<=high)
        {
            mid = (low+high)>>1;
            if(mid*mid == elt) return mid;
            if(mid*mid > elt)            high = mid -1 ;
            else            low = mid + 1;
        }
        return high;*/
    }
}
