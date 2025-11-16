/**
 * https://cses.fi/book/book.pdf
 * Page 173
 * 
 * An Eulerian Path is a path that goes 
 * exactly once through each EDGE of the graph.
 * 
 * An Eulerian circuit is an EP that starts
 * ans ends at the same node.
 * 
 * For an undirected graph, Eulerian path exists
 * iff:
 * 1. All the edges belomg to the same connected
 *    component
 * 2. The degree of each is even (In this case, Eulerian
 *    path is also Eulerian circuit)
 *              OR
 *    The degree of exactly 2 nodes is odd, and 
 *    the degree of all other nodes is even.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EulerianPath {
    public void printEulerianPath(Graph g) {
        // check if possible
        int n = g.V();
        int[] degree = new int[n + 1];

        for (int i = 0; i < n; i++) {
            for (int child: g.adj[i]) {
                degree[child]++;
            }
        }

        int odd = 0;
        int start_node = -1;

        for (int i = 0; i < n; i++) {
            if (degree[i]%2 == 1) {
                odd++;
                start_node = i;
            }
        }

        if (odd == 1 || odd > 2) {
            System.out.println("Not possible");
            return;
        }

        class Pair {
            int first;
            int second;

            Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }

        int[][] done = new int[n + 1][n + 1];

        // if odd == 2, start with odd, else start with any
        if (odd == 2) {
            // dfs
            dfs(start_node, g, done);
            return;
        }

        dfs(0, g, done);
    }

    private void dfs(int node, Graph g, int[][] done) {
        System.out.print(node + " ");

        for (int child: g.adj[node]) {
            if (done[node][child] == 1 || done[child][node] == 1) continue;
            done[node][child] = 1;
            done[child][node] = 1;

            dfs(child, g, done);
        }
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(4);
        // g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(0, 2);
        g1.addEdge(1, 3);

        new EulerianPath().printEulerianPath(g1);
    }
}
