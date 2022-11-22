package com.core.java;

import java.util.HashSet;

public class Pairsum {
    public static void main(String[] args) {
        int a[] = {
            1, 4, 45, 6, 10, 8
        };
        int n   = 16;

        printpairs(a, n);
    }

    static void printpairs(int a[], int sum) {
        HashSet<Integer> s    = new HashSet<Integer>();
        int              temp = 0;

        for (int i = 0; i < a.length; i++) {
            temp = sum - a[i];

            if ((temp > 0) && s.contains(temp)) {
                System.out.println("Pair with given sum " + sum + " is (" + a[i] + ", " + temp + ")");
            }

            s.add(a[i]);
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
