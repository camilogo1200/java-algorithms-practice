package org.camilogo1200.algorithms.interviews;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PickingTickets implements Runnable {
    @Override
    public void run() {
        //System.out.println(maxTickets(List.of(8, 5, 4, 8, 4)));
        //System.out.println(maxTickets(List.of(4, 4, 13, 2, 3)));
        //System.out.println(maxTickets(List.of(5, 10, 12, 1, 10, 4)));
    }

    public static int maxTickets(List<Integer> tickets) {
        List<Integer> lSorted = tickets.stream().sorted().collect(Collectors.toList());
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(lSorted);

        int subarray = 0;
        for (int i = 0, j = i + 1; i < lSorted.size() && j < lSorted.size(); i++, j++) {
            int diff = lSorted.get(j) - lSorted.get(i);
            if (diff < 0 || diff > 1) {
                addElement(map, subarray);
                subarray++;
            }
            addElement(map, subarray);
        }

        System.out.println(map);
        return map.values().stream().max(Comparator.comparingInt(item -> item)).orElse(0);

    }

    private static void addElement(Map<Integer, Integer> map, int subarray) {
        if (!map.containsKey(subarray)) {
            map.put(subarray, 0);
        }
        map.put(subarray, map.get(subarray) + 1);
    }
}
