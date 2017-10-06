package com.fbp.example.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddOne {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(9);
        a.add(9);
        a.add(9);
        a.add(9);
        a.add(9);


        a = plusOne(a);
        System.out.println(a.toString());
    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        if (a == null || a.isEmpty())
            return a;

        int carry = 1;
        int len = a.get(0);
        ArrayList<Integer> result = new ArrayList<>(len);
        for (int i = a.size() - 1; i >= 1; i--) {
            int res = a.get(i) + carry;
            if (res > 9)
                carry = 1;
            else
                carry = 0;

            res = res % 10;
            result.add(res);

        }

        if (carry == 1)
            result.add(1);
        Collections.reverse(result);

        return result;
    }
}
