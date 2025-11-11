import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class BFS {
  private boolean[] marked;
  private int[] edgeTo;
  private int s;

  BFS(Graph g, int s) {
    this.marked = new boolean[g.V()];
    this.edgeTo = new int[g.V()];
    this.s = s;
    bfs(g, s);
  }

  private void bfs(Graph g, int v) {
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(v);
    marked[v] = true;

    while(!q.isEmpty()) {
      int w = q.poll();
      
      for (int z: g.adj[w]) {
        if (marked[z]) continue;
        marked[z] = true;
        edgeTo[z] = w;
        q.add(z);
      }
    }
  }

  public boolean isConnected(int v) {
    return this.marked[v];
  }

  public void printPath(int target) {
    if (!isConnected(target)) return;

    Stack<Integer> st = new Stack<>();

    int t = target;
    while (t != s) {
      st.push(t);
      t = edgeTo[t];
    }
    st.push(t);

    while (!st.isEmpty()) {
      System.out.println(st.pop());
    }
  }
}
