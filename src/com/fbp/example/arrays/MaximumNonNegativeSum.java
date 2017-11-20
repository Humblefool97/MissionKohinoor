package com.fbp.example.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by rajeevranganathan
 */
public class MaximumNonNegativeSum {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(-1);
        input.add( -1);
        input.add(-1);
        input.add(-1);

        System.out.println(maxset(input));

    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int max = 0;
        int internalSum = 0;
        int n = a.size();

        for (int i = 1; i < n; i++) {
            if (a.get(i) >= 0 && a.get(i - 1) >= 0) {
                if (internalSum == 0) {
                    int l = a.get(i);
                    int m = a.get(i - 1);
                    internalSum = l + m;
                    temp.add(m);
                    temp.add(l);
                } else {
                    internalSum += a.get(i);
                    temp.add(a.get(i));
                }
            } else {
                if (max <= internalSum && !temp.isEmpty() && temp.size()>result.size()) {
                    max = internalSum;
                    result=temp;
                    temp=new ArrayList<>();
                    internalSum = 0;
                }
            }
        }

        if(result.isEmpty()){
            Collections.sort(a);
            if(a.get(a.size()-1)>0){
                result.add(a.get(a.size()-1));
            }
        }

        return result;
    }

}
