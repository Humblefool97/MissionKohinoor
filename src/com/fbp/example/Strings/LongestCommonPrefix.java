package com.fbp.example.Strings;

/**
 * Created by rajeevranganathan
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String arr[] = {"geeksforgeeks", "geeks",
                "geek", "geezer"};

        System.out.println(longestCommonPrefix(arr));
    }

    public static String longestCommonPrefix(String[] a) {
        if (a == null)
            return null;
        if (a.length == 1)
            return a[0];
        String prefix;
        prefix = a[0];
        int n = a.length;
        for (int i = 1; i <= n - 1; i++)
            prefix = longestCommonPrefixUtil(prefix, a[i]);

        return prefix;
    }

    /**
     * Checks for common characters the prefix & the string repeatedly
     * @param prefix
     * @param string
     * @return
     */
    private static String longestCommonPrefixUtil(String prefix, String string) {
        StringBuilder result = new StringBuilder("");
        int n1 = prefix.length();
        int n2 = string.length();

        for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
            if (prefix.charAt(i) != string.charAt(j))
                break;
            result.append(prefix.charAt(i));
        }

        return result.toString();
    }
}
