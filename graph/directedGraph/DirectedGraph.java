import java.util.LinkedList;
import java.util.Queue;
  
public class DirectedGraph {
  private int V;
  private int E;
  public LinkedList<Integer>[] adj;  

  public DirectedGraph(int V) {
    this.V = V;
    // Initializing the array. Size of array is number of vertices.
    this.adj = new LinkedList[V];
    this.E = 0;
    for (int i = 0; i < V; i++) {
      // Initializing each adjacency list.
      this.adj[i] = new LinkedList<Integer>();
    }
  }

  public Graph reverse() {
    return null;
  }

  public void addEdge(int v, int w) {
    this.adj[v].add(w);
    this.E++;
  }

  public int V() {
    return this.V;
  }

  public int E() {
    return this.E;
  }

  public boolean isCyclic() {
    int nodes = 0;
    
    /**
     * using topological sort
     * push all nodes having indegree == 0,
     * or simple degree in case of undirected graphs
     * so, degree == 1, is same as indegree 0 in directed
     * graphs.
     */
    
    Queue<Integer> q = new LinkedList<>();

    int[] indegree = new int[V + 1];
    for (int i = 0; i < V; i++) {
      for (int child: adj[i]) {
        indegree[child]++;
      }
    }

    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }
    
    while (!q.isEmpty()) {
      int curr = q.poll();
      
      nodes++;
      
      for (int child: adj[curr]) {
        indegree[child]--;
        if (indegree[child] == 0) {
          q.add(child);
        }
      }
    }
    
    return nodes != V;
  }

  public Iterable<Integer> adj(int v) {
    return this.adj[v];
  }
}
