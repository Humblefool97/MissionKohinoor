package com.fbp.example.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array of integers, sort the array into a wave like array and return it,
 In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

 Example

 Given [1, 2, 3, 4]

 One possible answer : [2, 1, 4, 3]
 Another possible answer : [4, 1, 3, 2]
 NOTE : If there are multiple answers possible, return anyone

 * Created by rajeevranganathan on 07/10/17 for TheLastChance.
 */
public class Wave {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        System.out.println(wave(a));
    }

    public static ArrayList<Integer> wave(ArrayList<Integer> a) {
        if (a == null || a.isEmpty())
            return a;

        Collections.sort(a);

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = a.size() - 1; i >= (a.size() / 2); i--) {
            result.add(a.get(i));
            result.add(a.get((a.size() - 1) - i));
        }

        return result;
    }
}
