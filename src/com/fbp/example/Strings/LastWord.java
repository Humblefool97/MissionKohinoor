package com.fbp.example.Strings;

/**
 * Created by rajeevranganathan
 */
public class LastWord {
    public static void main(String[] args) {
        String s = "HelloWorld";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(final String a) {
        if (a == null || a.isEmpty())
            return 0;
        String[] strings = a.split(" ");
        int n = strings.length;
            if (n == 1)
            return 0;

        return strings[n - 1].length();
    }
}
