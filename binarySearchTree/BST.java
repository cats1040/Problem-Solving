// package binarySearchTree;

public class BST<Key extends Comparable<Key>, Value> {
  // why extends comparable and not implements comparable
  // what is the difference?
  
  private Node root;

  private class Node {
    Key key;
    Value value;
    Node left;
    Node right;

    Node(Key key, Value value) {
      this.key = key;
      this.value = value;
    }
  }

  public void put(Key key, Value value) {
    root = put(root, key, value);
    return;
  }

  // helper function to put node in a bst
  private Node put(Node node, Key key, Value value) {
    if (node == null) {
      return new Node(key, value);
    }

    // compare
    int cmp = key.compareTo(node.key);

    if (cmp == -1) {
      // left
      node.left = put(node.left, key, value);
    }
    else if (cmp == 0) {
      // update value
      node.value = value;
    }
    else {
      // right
      node.right = put(node.right, key, value);
    }

    return node;
  }

  // get the value corresponding to the key
  public Value get(Key key) {
    Node node = root;
      
    while (node != null) {
      int cmp = key.compareTo(node.key);

      if (cmp == 0) {
        // bingo !
        return node.value;
      }

      if (cmp < 0) {
        node = node.left;
      }
      else {
        node = node.right;
      }
    }

    return null;
  }

  // get the minimum key
  public Key min() {
    Node node = root;

    if (node == null) return null;

    while (node.left != null) {
      node = node.left;
    }

    return node.key;
  }

  // get the maximum key
  public Key max() {
    Node node = root;

    if (node == null) return null;

    while (node.right != null) {
      node = node.right;
    }

    return node.key;   
  }

  // floor - largest key smaller than the given key
  public Key floor(Key key) {
    return floor(root, key);
  }

  private Key floor(Node node, Key key) {
    if (node == null) return null;

    int cmp = key.compareTo(node.key);

    if (cmp == 0) {
      return node.key;
    }

    if (cmp < 0) {
      return floor(node.left, key);
    }

    Key right = floor(node.right, key);
    if (right == null) right = node.key;
    
    return right;
  }

  // ceil - smallest key larger than the given key
  public Key ceil(Key key) {
    return ceil(root, key);
  }

  private Key ceil (Node node, Key key) {
    if (node == null) return null;

    int cmp = key.compareTo(node.key);

    if (cmp == 0) {
      return node.key;
    }

    if (cmp > 0) {
      return ceil(node.right, key);
    }

    Key left = ceil(node.left, key);
    if (left == null) left = node.key;

    return left;
  }

  public int rank(Key key) {
    return -1;
  }

  public void delete(Key key) {
    root = delete(root, key);
    return;
  }

  private Node delete(Node node, Key key) {
    if (node == null) return null;

    int cmp = key.compareTo(node.key);

    if (cmp == 0) {
      // YAYAY!!

      // delete
      // find the maximum from node.left
      // or the minimum from node.right
      // your choice :)

      if (node.right == null) return node.left;
      if (node.left == null) return node.right;

      // Imma go with the first one
      Node mini = node.right;
      while (mini != null && mini.left != null) {
        mini = mini.left;
      }

      node.key = mini.key;
      node.value = mini.value;
      
      // now recursively dlete the mini.key from node.right
      node.right = delete(node.right, mini.key);
    }
    else if (cmp < 0) {
      node.left = delete(node.left, key);
    }
    else {
      node.right = delete(node.right, key);
    }

    return node;
  }

  public static void main(String[] args) {
    BST<Integer, String> bst = new BST<Integer, String>();

    bst.put(4, "A");
    bst.put(2, "B");
    bst.put(65, "C");
    bst.put(44, "D");
    bst.put(4, "E");
    bst.put(9, "F");

    assert(bst.get(4) == "E");
    assert(bst.get(9) == "F");

    bst.put(3, "P");

    assert(bst.get(3) == "P");
  
    assert(bst.min() == 2);
    assert(bst.max() == 65);

    assert(bst.ceil(43) == 44);
    assert(bst.floor(3) == 3);
    
    assert(bst.get(65) == "C");

    bst.delete(2);
    
    assert(bst.get(2) == null);

    BST<Integer, Integer> bst1 = new BST<>();
    bst1.put(50, 50);
    bst1.put(30, 50);
    bst1.put(20, 50);
    bst1.put(40, 50);

    System.out.println(bst1.floor(31));
  }
}
