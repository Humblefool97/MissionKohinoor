package com.fbp.example.Strings;

/**
 * Created by rajeevranganathan
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(integerToRoman(27));
    }

    public static String integerToRoman(int num) {
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 50, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < val.length; i++) {
            while (num >= val[i]) {
                num -= val[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }
}
