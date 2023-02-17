package org.camilogo1200.algorithms.Basics;

import java.sql.SQLOutput;

public class Kangaroo implements Runnable {
    @Override
    public void run() {
        System.out.println(kangaroo(2, 1, 1, 2)); //YES
        System.out.println(kangaroo(0, 3, 4, 2)); //YES
        System.out.println(kangaroo(0, 2, 5, 3)); //NO
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        //https://www.hackerrank.com/challenges/kangaroo/problem
        if (x1 >= x2 && v1 > v2) return "NO";
        if (x2 >= x1 && v2 > v1) return "NO";
        int pos1 = 0;
        int pos2 = 0;
        int vPos1 = 0;
        int vPos2 = 0;
        if (x1 > x2) {
            pos1 = x2;
            pos2 = x1;
            vPos1 = v2;
            vPos2 = v1;
        } else {
            pos1 = x1;
            pos2 = x2;
            vPos1 = v1;
            vPos2 = v2;
        }

        while (pos1 < pos2) {
            pos1 += vPos1;
            pos2 += vPos2;
        }
        if (pos1 == pos2) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
