package com.fbp.example.Strings;

/**
 * Created by rajeevranganathan
 */
public class PalindromeString {
    public static void main(String[] args) {
        String a = "A man, a plan, a canal: Panama";
        String b = "race a car";

        System.out.println(isPalindrome(a));
        System.out.println(isPalindrome(b));
    }

    private static int isPalindrome(String a) {
        if (a == null || a.isEmpty()) {
            return 0;
        }
        a=a.toLowerCase();
        int n = a.length();
        int i = 0;
        int j = n - 1;
        StringBuilder stringBuilder = new StringBuilder(a);
        while (i < j) {
            Character c = stringBuilder.charAt(i);
            Character d = stringBuilder.charAt(j);
            if (isAlphaNumeric(c) && isAlphaNumeric(d)) {
                if (!c.equals(d))
                    return 0;
                i++;
                j--;
            } else {
                if (!isAlphaNumeric(c))
                    i++;
                else
                    j--;
            }
        }

        return 1;
    }


    private static boolean isAlphaNumeric(Character c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }

    /**
     * Fastest Run time
     * @param a
     * @return
     */
    public int isPalindromeFastest(String a) {
        char[] arr = a.toLowerCase().toCharArray();
        int i=0;int j=arr.length-1;
        while(i<j){
            if(!((arr[i]>='a' && arr[i]<='z') || (arr[i]>='0' && arr[i]<='9'))){i++;continue;}
            if(!((arr[j]>='a' && arr[j]<='z') || (arr[j]>='0' && arr[j]<='9'))){j--;continue;}
            if(arr[i++]!=arr[j--])return 0;
        }
        return 1;
    }
}
