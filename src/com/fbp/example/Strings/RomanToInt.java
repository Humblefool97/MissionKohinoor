package com.fbp.example.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rajeevranganathan
 */
public class RomanToInt {

    public static void main(String[] args) {
        RomanToInt instance = new RomanToInt();
        System.out.println(instance.convertToInt("MCMIV"));
    }

    int convertToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int res = 0;
        int s1 = 0, s2 = 0;
        int n = s.length();
        Map<Character, Integer> map = fillMap();

        for (int i = 0; i < n; i++) {
            s1 = map.get(s.charAt(i));
            if (i + 1 < n) {
                s2 = map.get(s.charAt(i + 1));
                if (s1 >= s2) {
                    res += s1;
                } else {
                    res += s2 - s1;
                    i++;
                }
            } else {
                res += s1;
            }
        }
        return res;
    }

    Map<Character, Integer> fillMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }


}
