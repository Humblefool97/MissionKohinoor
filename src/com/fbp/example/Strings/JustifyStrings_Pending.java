package com.fbp.example.Strings;

import java.util.ArrayList;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 You should pack your words in a greedy approach; that is, pack as many words as you can in each line.

 Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
 Extra spaces between words should be distributed as evenly as possible.
 If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 For the last line of text, it should be left justified and no extra space is inserted between words.

 Your program should return a list of strings, where each string represents a single line.

 Example:

 words: ["This", "is", "an", "example", "of", "text", "justification."]

 L: 16.

 Return the formatted lines as:

 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Note: Each word is guaranteed not to exceed L in length.
 * Created by rajeevranganathan on 01/11/17 for TheLastChance.
 */
public class JustifyStrings_Pending {
    public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
        ArrayList<String> result = new ArrayList<>();

        if(a == null || a.size() == 0) {
            return result;
        }

        int count = 0;
        int last = 0;
        for(int i = 0; i < a.size(); i++) {
            count = count + a.get(i).length();

            if(count + i - last > b) {
                int wordsLen = count - a.get(i).length();
                int spaceLen = b - wordsLen;
                int eachLen = 1;
                int extraLen = 0;

                if(i - last - 1 > 0) {
                    eachLen = spaceLen / (i - last - 1);
                    extraLen = spaceLen % (i - last - 1);
                }

                StringBuilder sb = new StringBuilder();

                for(int k = last; k < i - 1; k++) {
                    sb.append(a.get(k));

                    int ce = 0;
                    while(ce < eachLen) {
                        sb.append(" ");
                        ce++;
                    }

                    if(extraLen > 0) {
                        sb.append(" ");
                        extraLen--;
                    }
                }

                sb.append(a.get(i - 1));
                while(sb.length() < b) {
                    sb.append(" ");
                }

                result.add(sb.toString());

                last = i;
                count = a.get(i).length();
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = last; i < a.size() - 1; i++) {
            count = count + a.get(i).length();
            sb.append(a.get(i)).append(" ");
        }

        sb.append(a.get(a.size() - 1));
        while(sb.length() < b) {
            sb.append(" ");
        }
        result.add(sb.toString());

        return result;

    }
}
