package org.camilogo1200.algorithms.dfs;

import java.util.*;

public class DepthFirstSearch implements Runnable {
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
        System.out.println("========== DepthFirstSearch ==========");
        //depthFirstPrint(graph, "a");
        depthFirstPrintVisitedNodes(graph, "a");
    }

    private void depthFirstPrintVisitedNodes(Map<String, List<String>> graph, String source) {
        Stack<String> stack = new Stack<>();
        Set<String> visitedNodes = new HashSet<String>();
        stack.push(source);
        String currentNode = "";
        List<String> childs = null;
        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            visitedNodes.add(currentNode);
            System.out.print(" [" + currentNode + "] ");
            graph.get(currentNode)
                    .forEach(stack::push);
            System.out.println("Visited Nodes => " + visitedNodes);
        }

    }

    public void depthFirstPrint(Map<String, List<String>> graph, String source) {
        Stack<String> stack = new Stack<>();

        stack.push(source);
        String currentNode = "";
        List<String> childs = null;
        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            System.out.print(" [" + currentNode + "] ");
            graph.get(currentNode)
                    .forEach(stack::push);
        }

    }

}
