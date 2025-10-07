// package binarySearchTree;

public class BST<Key extends Comparable<Key>, Value> {
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

  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node x, Key key) {
    if (x == null) return null;

    int cmp = key.compareTo(x.key);

    if (cmp == 0) return x.value;
    if (cmp < 0) {
      return get(x.left, key);
    }
    return get(x.right, key);
  }

  public void put(Key key, Value value) {
    root = put(root, key, value);
  }

  private Node put(Node x, Key key, Value value) {
    if (x == null) {
      return new Node(key, value);
    }

    int cmp = key.compareTo(x.key);

    if (cmp < 0) {
      x.left = put(x.left, key, value);
    }
    else if (cmp == 0) {
     /**
      * do not allow duplicate keys
      * update the value
      */
      x.value = value;
    }
    else {
      x.right = put(x.right, key, value);
    }

    return x;
  }

  public Key min() {
    return min(root);
  }

  private Key min(Node x) {
    if (x == null) {
      return null;
    }

    if (x.left == null) {
      return x.key;
    }

    return min(x.left);
  }

  public Key max() {
    return max(root);
  }

  private Key max(Node x) {
    if (x == null) {
      return null;
    }
    
    if (x.right == null) {
      return x.key;
    }

    return max(x.right);
  }

  public Key floor(Key key) {
    Node locateKey = locate(root, key);
    return floor(locateKey.left, key);
  }

  private Node locate(Node x, Key key) {
    if (x == null) {
      return null;
    }

    int cmp = key.compareTo(x.key);

    if (cmp == 0) {
      return x;
    }
    
    if (cmp < 0) {
      return locate(x.left, key);
    }

    return locate(x.right, key);
  }

  private Key floor(Node x, Key key) {
    if (x == null) {
      return null;
    }

    if (x.right == null) {
      return x.right.key;
    }

    return floor(x.right, key);
  }

  public Key ceil(Key key) {
    Node locateKey = locate(root, key);
    return ceil(locateKey.right, key);
  }

  private Key ceil(Node x, Key key) {
    if (x == null) {
      return null;
    }

    if (x.left == null) {
      return x.left.key;
    }

    return ceil(x.left, key);
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
  }
}
