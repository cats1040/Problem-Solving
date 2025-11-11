import java.util.LinkedList;
  
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

  public Iterable<Integer> adj(int v) {
    return this.adj[v];
  }
}
