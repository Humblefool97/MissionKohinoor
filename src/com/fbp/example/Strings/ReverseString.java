package com.fbp.example.Strings;

/**
 * Created by rajeevranganathan
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
    public static String reverseWords(String a) {
        if(a==null || a.isEmpty())
            return a;
        a = a.trim();
        String [] strings = a.split(" ");
        StringBuilder stringBuilder = new StringBuilder("");
        for(int i=(strings.length-1);i>=0;i--){
            if(strings[i].equals(" "))
                continue;
            stringBuilder.append(strings[i]).append(" ");
        }

        return stringBuilder.toString().trim();
    }
}
