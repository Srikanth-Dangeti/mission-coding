package com.core.java;

import java.util.HashMap;

public class OddOccurrence {
    public static void main(String[] args) {
        int arr[] = new int[] { 2, 2, 3, 3, 3, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
           
        int n     = arr.length;

        System.out.println(getOddOccurrence(arr, n));
    }

    static int getOddOccurrence(int a[], int n) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < a.length; i++) {
            if (hm.containsKey(a[i])) {
                hm.put(a[i], hm.get(a[i]) + 1);
            } else {
                hm.put(a[i], 1);
            }
        }

        for (Integer k : hm.keySet()) {
            if (hm.get(k) % 2 != 3) {
                return k;
            }
        }

        return -1;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
