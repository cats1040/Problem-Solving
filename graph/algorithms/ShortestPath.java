package graph.algorithms;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPath {
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

        // O(E * log(V))
        public Integer[] shortestDistanceFromGivenNode(int a) {
            Integer[] shortestDistances = new Integer[N];

            PriorityQueue<QueueNode> q = new PriorityQueue<>((q1, q2) -> {
                return Integer.compare(q1.currDistance, q2.currDistance);
            });

            q.add(new QueueNode(a, 0));

            while (!q.isEmpty()) {
                QueueNode qNode = q.poll();

                if (shortestDistances[qNode.currNode] == null ||
                    shortestDistances[qNode.currNode] > qNode.currDistance)  {
                    shortestDistances[qNode.currNode] = qNode.currDistance;
                }
                else {
                    continue;
                }

                int newNode = qNode.currNode;

                for (int i = 0; i < N; i++) {
                    if (newNode != i && this.adj[newNode][i] != null) {
                        int newDistance = this.adj[newNode][i] + qNode.currDistance;
                        if (shortestDistances[i] == null || newDistance < shortestDistances[i]) {
                            q.add(new QueueNode(i, this.adj[newNode][i] + qNode.currDistance));
                        }
                    }
                }
            }

            return shortestDistances;
        }
    }

    public static void main(String[] args) {
        ShortestPath sp = new ShortestPath();
        ShortestPath.Graph g = sp.new Graph(3);

        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 2);
        g.addEdge(2, 1, 3);

        Integer[] d = g.shortestDistanceFromGivenNode(0);

        for (int i: d) System.out.print(i + " ");
        System.out.println();
    }
}
