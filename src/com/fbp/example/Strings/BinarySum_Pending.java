package com.fbp.example.Strings;

/**
 * Given two binary strings, return their sum (also a binary string).

 Example:

 a = "100"

 b = "11"
 Return a + b = “111”.
 * Created by rajeevranganathan on 26/10/17 for TheLastChance.
 */
public class BinarySum_Pending {
    public static void main(String[] args) {
        System.out.println(addBinary("100","11"));
    }
    public static String addBinary(String a, String b) {
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        StringBuilder buf = new StringBuilder();
        int carry = 0;
        while (p1 >= 0 || p2 >= 0) {
            int sum = carry;
            if (p1 >= 0) {
                sum += a.charAt(p1) - '0';
                p1--;
            }
            if (p2 >= 0) {
                sum += b.charAt(p2) - '0';
                p2--;
            }
            carry = sum >> 1;
            sum = sum & 1;
            buf.append(sum == 0 ? '0' : '1');
        }
        if (carry > 0) {
            buf.append('1');
        }
        buf.reverse();
        return buf.toString();
    }


}
