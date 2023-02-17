package org.camilogo1200.algorithms.Basics;

import java.util.List;

public class CountApplesAndOranges implements Runnable{
    @Override
    public void run() {
        countApplesAndOranges(7, 10, 4, 12, List.of(2, 3, -4), List.of(3, -2, -4));
    }


    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        //https://www.hackerrank.com/challenges/apple-and-orange/problem
        long applesCount = apples.stream()
                .map((apple) -> a + apple)
                .filter((appleDistance) -> appleDistance >= s && appleDistance <= t)
                .count();

        var orangeCount = oranges.stream()
                .map((orange) -> b + orange)
                .filter((distance) -> distance >= s && distance <= t)
                .count();

        System.out.println(applesCount);
        System.out.println(orangeCount);
    }
}
