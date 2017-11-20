package com.fbp.example.Strings;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:

 1, 11, 21, 1211, 111221, ...
 1 is read off as one 1 or 11.
 11 is read off as two 1s or 21.

 21 is read off as one 2, then one 1 or 1211.

 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.

 Example:

 if n = 2,
 the sequence is 11.
 * Created by rajeevranganathan on 10/10/17 for TheLastChance.
 */
public class CountAndSay_Pending {

    public String countAndSay(int a) {
        if(a<1) {
            return "";
        }
        String result = "1";
        for(int i=2;i<=a;i++) {
            int count =1;
            StringBuilder temp = new StringBuilder("");
            char c=result.charAt(0);
            for(int j=1;j<result.length();j++) {
                if(c==result.charAt(j)) {
                    count++;
                } else {
                    temp.append(count);
                    temp.append(c);
                    c = result.charAt(j);
                    count = 1;
                }
            }
            temp.append(count);
            temp.append(c);
            result = temp.toString();
        }
        return result;
    }
}
