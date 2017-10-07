package com.fbp.example.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example:

 Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.

 * Created by rajeevranganathan on 07/10/17 for TheLastChance.
 */
public class LargestNum {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(30);
        a.add(0);
        a.add(5);
        a.add(9);

        System.out.println(largestNumber(a));

    }

    public static String largestNumber(final List<Integer> a) {
        List<String> strs = new ArrayList<String>();
        for (Integer i : a) {
            strs.add(String.valueOf(i));
        }

        Collections.sort(strs,new MyCompartor());

        StringBuilder strBuf = new StringBuilder();
        for (String s : strs) {
            //if input "0000" it should not append the string
            if (!"0".equals(s)|| strBuf.length() != 0) {
                strBuf.append(s);
            }
        }
        //if input "0000",result should be "0" not "0000" hence added only here
        if (strBuf.length() == 0) {
            strBuf.append(0);
        }

        return strBuf.toString();
    }


}

class MyCompartor implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        String first = s1 + s2;
        String second = s2 + s1;
        return second.compareTo(first);
    }
}
