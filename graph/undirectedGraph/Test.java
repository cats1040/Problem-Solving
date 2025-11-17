public class Test {
  public static void main(String[] args) {
    Graph g1 = new Graph(4);

    g1.addEdge(0, 1);
    g1.addEdge(1, 2);
    g1.addEdge(2, 3);

    assert !g1.isCyclic() : "Cyclic";

    // ---------------------------
    Graph g2 = new Graph(3);
    g2.addEdge(0, 1);
    g2.addEdge(1, 2);
    g2.addEdge(2, 0);

    assert g2.isCyclic() : "Cyclic";

    // ---------------------------
    Graph g3 = new Graph(5);
    g3.addEdge(0, 1);
    g3.addEdge(0, 2);
    g3.addEdge(1, 3);
    g3.addEdge(1, 4);

    assert !g3.isCyclic() : "Not cyclic";

    // ---------------------------
    Graph g4 = new Graph(4);
    g4.addEdge(0, 1);
    g4.addEdge(1, 2);
    g4.addEdge(2, 3);
    g4.addEdge(3, 0);

    assert g4.isCyclic() : "Cyclic";

    // ---------------------------
    System.out.println("All tests passed successfully!");
  }
}
