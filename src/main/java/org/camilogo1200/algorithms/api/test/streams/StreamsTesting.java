package org.camilogo1200.algorithms.api.test.streams;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTesting implements Runnable {
    @Override
    public void run() {
        List<Integer> lInts = Stream.of(-1, 7, 8, 9, -2, 1, 2, 5, 4, 6).toList();
        List<Integer> lShortInts = Stream.of(-1, 9, -2, 1, 2, 0).collect(Collectors.toList());
        System.out.println("Original List");
        System.out.println(lShortInts);
        //streamApiTest();
        reverseList(lShortInts);
        generateListRange();
    }

    private static void generateListRange() {
        var intStream = IntStream.generate(() -> (int) (Math.random() * 10000));
        var l = intStream.limit(3)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(l);
        System.out.println("position [0] => " + l.get(0));
    }

    private static void reverseList(List<Integer> lInts) {
        Collections.reverse(lInts);
        System.out.println(" Reversed List");
        System.out.println(lInts);
    }

    private static void streamApiTest() {
        List<Integer> lInts = Stream.of(1, 2, 5, 4, 6, 78, 67, 12, 43, 5, 6567, 1, -9, -98, 0, 123, 1234, 11, 6, 7)
                .collect(Collectors.toList());
        System.out.println("== List ==");
        System.out.println(lInts);

        lInts.sort(Comparator.comparingInt(item -> item));
        System.out.println(lInts);

        lInts.sort(Comparator.reverseOrder());
        System.out.println(lInts);


        List<Integer> newEvens = lInts.stream().filter((item) -> item % 2 == 0).collect(Collectors.toList());
        System.out.println(newEvens);

        Long evenLength = lInts.stream()
                .filter((item) -> item % 2 == 0)
                .count();
        System.out.println(evenLength);

        List<Integer> mappedList = lInts.stream()
                .filter((item) -> item % 2 == 0)
                .map((item) -> item * 2)
                .collect(Collectors.toList());

        System.out.println(mappedList);

        List<Integer> mappedDistinct = lInts.stream()
                .filter((item) -> item % 2 == 0)
                .map((item) -> item * 2)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(mappedDistinct);

        List<Integer> mappedDropped = lInts.stream()
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(mappedDropped);

        List<Integer> peekList = lInts.stream()
                .takeWhile(item -> item > 0)
                .collect(Collectors.toList());

        System.out.println(peekList);


        var max = lInts.stream()
                .max(Comparator.comparingInt(item -> item));

        System.out.println("Max => " + max.orElse(-1));

        var min = lInts.stream()
                .min(Comparator.comparingInt(item -> item));

        System.out.println("Min => " + min.orElse(-1));
    }
}
