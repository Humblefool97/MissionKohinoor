package com.fbp.example.Strings;

/**
 * Created by rajeevranganathan
 */
public class AtoI {

    public static void main(String[] args) {
        System.out.println(atoi("+7"));
    }

    public static int atoi(final String a) {
        if (a == null || a.isEmpty())
            return 0;

        String s = a.trim();
        int n = s.length();
        String sign = "+";
        int i = 0;
        if (s.charAt(i) == '-'){
            sign = "-";
            i++;
        }else if (s.charAt(i) == '+'){
            i++;
        }

        double result = 0d;
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            result = result * 10 + (s.charAt(i) - '0');
            i++;
        }

        if ("-".equals(sign))
            result = -result;

        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;

    }
}
