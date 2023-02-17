package org.camilogo1200.algorithms.bfs;

import java.util.*;

public class BreathFirstSearch implements Runnable {
    @Override
    public void run() {
        Map<String, List<String>> graph = Map.of(
                "a", List.of("b", "c"),
                "b", List.of("d"),
                "c", List.of("e"),
                "d", List.of("f"),
                "e", List.of(),
                "f", List.of()
        );
        System.out.println("========== BreathFirstSearch ==========");
        breathFirstPrint(graph, "a");
        breathFirstPrintVisitedNodes(graph, "a");
    }

    private void breathFirstPrintVisitedNodes(Map<String, List<String>> graph, String source) {
        Queue<String> queue = new PriorityQueue<String>();
        queue.add(source);

        String currentNode = "";
        List<String> childs = null;
        Set<String> visitedNode = new HashSet<>();
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            System.out.print(" [" + currentNode + "] ");
            visitedNode.add(currentNode);
            queue.addAll(graph.get(currentNode));
            System.out.println("Visited Nodes => " + visitedNode);
        }

    }

    private void breathFirstPrint(Map<String, List<String>> graph, String source) {
        Queue<String> queue = new PriorityQueue<String>();
        queue.add(source);
        String currentNode = "";
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            System.out.print(" [" + currentNode + "] ");
            queue.addAll(graph.get(currentNode));
        }
        System.out.println();
    }
}
