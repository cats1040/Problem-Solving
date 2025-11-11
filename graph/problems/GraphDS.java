import java.util.*;

class GraphDS {
  Map<Integer, Set<Integer>> edgeMap;
  private List<String> tempPaths;
  private Set<Integer> visited;

  GraphDS() {
    edgeMap = new HashMap<>();
  }

  void addEdge(int u, int v) {
    if (!edgeMap.containsKey(u)) {
      edgeMap.put(u, new HashSet<>());
    }
    edgeMap.get(u).add(v);

    if (!edgeMap.containsKey(v)) {
      edgeMap.put(v, new HashSet<>());
    }
    edgeMap.get(v).add(u);
  }

  List<String> getAllPaths(int startNode) {
    StringBuilder path = new StringBuilder("");
    tempPaths = new ArrayList<String>();
    visited = new HashSet<Integer>();
    helperGetAllPaths(startNode, path);

    return tempPaths;
  }

  private void helperGetAllPaths(int node, StringBuilder path) {
    visited.add(node);

    int isLeafNode = 0;
    if (edgeMap.get(node).size() == 1) isLeafNode = 1;
    
    path.append(node);
    path.append("->");


    for (int child: edgeMap.get(node)) {
      if (!visited.contains(child)) {
        helperGetAllPaths(child, path);
      }
    }
    
    if (isLeafNode == 1) {
      tempPaths.add(path.toString());
    }

    path.deleteCharAt(path.length() - 1);
    path.deleteCharAt(path.length() - 1);
    path.deleteCharAt(path.length() - 1);      
  }

  public boolean isCycleDetected() {
    visited = new HashSet<Integer>();
    
    /*
    for (Map.Entry<Integer, Set<Integer>> entry: edgeMap.entrySet()) {
      if (!visited.contains(entry.getKey()) && helperIsCycleDetected(entry.getKey(), null)) return true;
    }
    */

    for (Map.Entry<Integer, Set<Integer>> entry: edgeMap.entrySet()) {
      if (!visited.contains(entry.getKey()) && helperIsCycleDetectedBFS(entry.getKey())) return true;
    }

    return false;
  }

  private boolean helperIsCycleDetected(int node, Integer parent) {
    visited.add(node);
    boolean flag = false;

    for (int child: edgeMap.get(node)) {
      if (visited.contains(child) && parent != child) return true;
      else if (!visited.contains(child)) {
        flag = helperIsCycleDetected(child, node);
        if (flag) return true;        
      }
    }

    return flag;
  }

  private boolean helperIsCycleDetectedBFS(int node) {
    Queue<Integer> nodes = new LinkedList<>();
    Queue<Integer> parent = new LinkedList<>();
    nodes.add(node);
    parent.add(-1);
    
    while (!nodes.isEmpty()) {
      int curr = nodes.poll();
      int p = parent.poll();

      visited.add(curr);

      for (int child: edgeMap.get(curr)) {
        if (visited.contains(child) && p != child) {
          return true;
        }
        else if (!visited.contains(child)) {
          nodes.add(child);
          parent.add(curr);
        }
      }
    }

    return false;
  }
}

public class GraphDS {
  public static void main(String[] args) {
    GraphDS g = new GraphDS();

    g.addEdge(1, 2);
    g.addEdge(2, 5);
    g.addEdge(2, 3);
    g.addEdge(3, 6);
    g.addEdge(3, 7);
    g.addEdge(3, 4);

    System.out.println(g.getAllPaths(1));
    System.out.println(g.getAllPaths(3));

    g.addEdge(6, 7);

    System.out.println(g.isCycleDetected());
  }
}
