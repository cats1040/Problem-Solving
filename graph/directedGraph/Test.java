public class Test {
  public static void main(String[] args) {
    DirectedGraph g1 = new DirectedGraph(4);

    g1.addEdge(0, 1);
    g1.addEdge(1, 2);
    g1.addEdge(2, 3);

    assert g1.adj[0].contains(1) : "0 → 1 must exist";
    assert g1.adj[1].contains(2) : "1 → 2 must exist";
    assert g1.adj[2].contains(3) : "2 → 3 must exist";

    assert !g1.isCyclic() : "Acyclic";

    // ---------------------------------------------------
    DirectedGraph g2 = new DirectedGraph(3);
    g2.addEdge(0, 1);
    g2.addEdge(1, 2);
    g2.addEdge(2, 0);

    assert g2.isCyclic() : "Cyclic";

    // ---------------------------------------------------
    DirectedGraph g3 = new DirectedGraph(4);
    g3.addEdge(0, 1);
    g3.addEdge(0, 2);
    g3.addEdge(1, 3);
    g3.addEdge(2, 3);

    assert !g3.isCyclic() : "Acyclic";

    // ---------------------------------------------------
    DirectedGraph g4 = new DirectedGraph(5);
    g4.addEdge(0, 1);
    g4.addEdge(1, 2);
    g4.addEdge(2, 3);
    g4.addEdge(3, 1);

    assert g4.isCyclic() : "Cyclic";

    // ---------------------------------------------------
    DirectedGraph g5 = new DirectedGraph(3);
    g5.addEdge(0, 1);

    assert !g5.isCyclic() : "Acyclic";

    // ---------------------------------------------------
    System.out.println("All DirectedGraph tests passed!");
  }
}
