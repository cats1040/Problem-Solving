import java.util.LinkedList;
import java.util.Queue;
  
public class Graph {
  private int V;
  private int E;
  public LinkedList<Integer>[] adj;  

  public Graph(int V) {
    this.V = V;
    // Initializing the array. Size of array is number of vertices.
    this.adj = new LinkedList[V];
    this.E = 0;
    for (int i = 0; i < V; i++) {
      // Initializing each adjacency list.
      this.adj[i] = new LinkedList<Integer>();
    }
  }

  public void addEdge(int v, int w) {
    this.adj[v].add(w);
    this.adj[w].add(v);
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

    int[] degree = new int[V + 1];
    for (int i = 0; i < V; i++) {
      degree[i] = adj[i].size();
      
      if (degree[i] == 1) {
        q.add(i);
      }
    }
    
    while (!q.isEmpty()) {
      int curr = q.poll();
      
      nodes++;
      
      for (int child: adj[curr]) {
        degree[child]--;
        if (degree[child] == 1) {
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
