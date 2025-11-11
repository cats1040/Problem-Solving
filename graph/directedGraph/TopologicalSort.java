import java.util.Stack;

public class TopologicalSort {
  private boolean[] marked;
  private Stack<Integer> reversePostOrder;

  public TopologicalSort(DirectedGraph g) {
    reversePostOrder = new Stack<Integer>();
    marked = new boolean[g.V()];

    for (int i = 0; i < g.V(); i++) {
      if (!marked[i]) {
        dfs(i, g);
      }
    }
  }

  public Stack<Integer> order() {
    return reversePostOrder;
  }

  private void dfs(int node, DirectedGraph g) {
    marked[node] = true;

    for (int child: g.adj[node]) {
      if (!marked[child]) {
        dfs(child, g);
      }
    }

    reversePostOrder.push(node);
  }

  public static void main(String[] args) {
    DirectedGraph dg = new DirectedGraph(7);
    dg.addEdge(0, 5);
    dg.addEdge(0, 2);
    dg.addEdge(0, 1);
    dg.addEdge(3, 6);
    dg.addEdge(3, 5);
    dg.addEdge(5, 2);
    dg.addEdge(6, 4);
    dg.addEdge(6, 0);
    dg.addEdge(3, 2);
    dg.addEdge(1, 4);
 
    TopologicalSort ts = new TopologicalSort(dg);
    
    Stack<Integer> s = ts.order();

    while (!s.empty()) {
      System.out.print(s.pop() + " ");
    }

    System.out.println();
  }
}
