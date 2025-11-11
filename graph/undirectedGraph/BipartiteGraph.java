import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

  public BipartiteGraph() {
    
  }

  public boolean isBipartite(Graph g) {
    // BFS
    int v = g.V();
    if (v == 0) return true;
    int[] marked = new int[v + 1];
    
    for (int i = 0; i < v; i++) {
      if (marked[i] == 0) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        marked[i] = 1;

        while (!q.isEmpty()) {
          int node = q.poll();

          if (marked[node] == 1) {
            // mark children 2
            for (int child: g.adj[node]) {
              if (marked[child] == 1) return false;
              if (marked[child] == 2) continue;
              marked[child] = 2;
              q.add(child);
            }
          }
          else {
            // mark children 1
            for (int child: g.adj[node]) {
              if (marked[child] == 2) return false;
              if (marked[child] == 1) continue;
              marked[child] = 1;
              q.add(child);
            }
          }
        }
      }
    }

    return true;
  }

  public void printSetOfVertices(Graph g) {
    if (!isBipartite(g)) {
      System.out.println("Not a Bipartite graph");
      return;
    }

    // BFS
    int v = g.V();
    int[] marked = new int[v + 1];

    for (int i = 0; i < v; i++) {
      if (marked[i] == 0) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        marked[i] = 1;

        while (!q.isEmpty()) {
          int node = q.poll();

          if (marked[node] == 1) {
            // mark children 2
            for (int child: g.adj[node]) {
              if (marked[child] == 2) continue;
              marked[child] = 2;
              q.add(child);
            }
          }
          else {
            // mark children 1
            for (int child: g.adj[node]) {
              if (marked[child] == 1) continue;
              marked[child] = 1;
              q.add(child);
            }
          }
        }
      }
    }

    for (int i = 0; i < v; i++) {
      if (marked[i] == 2) continue; 
      System.out.print(i + " ");
    }

    System.out.println();

    for (int i = 0; i < v; i++) {
      if (marked[i] == 1) continue; 
      System.out.print(i + " ");
    }

    System.out.println();

    return;
  }

  public static void main(String[] args) {
    BipartiteGraph bg = new BipartiteGraph();

    Graph g1 = new Graph(2);
    g1.addEdge(0, 1);
    assert bg.isBipartite(g1) == true;

    Graph g2 = new Graph(4);
    g2.addEdge(0, 1);
    g2.addEdge(1, 2);
    g2.addEdge(2, 3);
    g2.addEdge(3, 0);
    assert bg.isBipartite(g2) == true;

    Graph g3 = new Graph(3);
    g3.addEdge(0, 1);
    g3.addEdge(1, 2);
    g3.addEdge(2, 0);
    assert bg.isBipartite(g3) == false;

    Graph g4 = new Graph(6);
    g4.addEdge(0, 1);
    g4.addEdge(2, 3);
    g4.addEdge(4, 5);
    assert bg.isBipartite(g4) == true;
    bg.printSetOfVertices(g4);

    Graph g5 = new Graph(6);
    g5.addEdge(0, 1);
    g5.addEdge(1, 2);
    g5.addEdge(2, 0);
    g5.addEdge(3, 4);
    assert bg.isBipartite(g5) == false;

    Graph g6 = new Graph(1);
    assert bg.isBipartite(g6) == true;

    Graph g7 = new Graph(0);
    assert bg.isBipartite(g7) == true;

    Graph g8 = new Graph(5);
    g8.addEdge(0, 1);
    g8.addEdge(0, 2);
    g8.addEdge(0, 3);
    g8.addEdge(0, 4);
    assert bg.isBipartite(g8) == true;

    System.out.println("All test cases passed."); 
  }
}
