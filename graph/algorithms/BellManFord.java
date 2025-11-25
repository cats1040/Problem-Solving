package graph.algorithms;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BellManFord {
    class Graph {
        Integer[][] adj;
        int N;

        public Graph (int N) {
            this.N = N;
            this.adj = new Integer[N][N];
            for (int i = 0; i < N; i++) adj[i][i] = 0;
        }

        class QueueNode {
            public int currNode;
            public int currDistance;

            QueueNode(int currnode, int currDistance) {
                this.currNode = currnode;
                this.currDistance = currDistance;
            }
        }

        public void addEdge(int a, int b, int dist) {
            adj[a][b] = dist;
        }

        public Integer[] shortestDistanceFromGivenNode(int start) throws Exception {
            Integer[] shortestDistances = new Integer[N];
            shortestDistances[start] = 0;
         
            for (int K = 0; K < N - 1; K++) {
                
                // All edges covered
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (i == j || adj[i][j] == null) continue;

                        int src = i;
                        int dest = j;
                        int dist = adj[i][j];

                        if (shortestDistances[src] != null && (shortestDistances[dest] == null || shortestDistances[src] + dist < shortestDistances[dest])) {
                            shortestDistances[dest] = shortestDistances[src] + dist;
                        }
                    }
                }

                // To check for negative edge cycle
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (i == j || adj[i][j] == null) continue;

                        int src = i;
                        int dest = j;
                        int dist = adj[i][j];

                        if (shortestDistances[src] != null && (shortestDistances[dest] == null || shortestDistances[src] + dist < shortestDistances[dest])) {
                            shortestDistances[dest] = shortestDistances[src] + dist;
                            // negative edge cycle
                            throw new Exception("Negative edge cycle detected");
                        }
                    }
                }
            }

            return shortestDistances;
        }
    }

    public static void main(String[] args) {
       
    }
}
