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
    return min(root).key;
  }

  private Node min(Node x) {
    if (x == null) {
      return null;
    }

    if (x.left == null) {
      return x;
    }

    return min(x.left);
  }

  public Key max() {
    return max(root).key;
  }

  private Node max(Node x) {
    if (x == null) {
      return null;
    }
    
    if (x.right == null) {
      return x;
    }

    return max(x.right);
  }

  public Key floor(Key key) {
    return floor(root, key);
  }

  private Key floor(Node x, Key key) {
    if (x == null) {
      return null;
    }

    int cmp = key.compareTo(x.key);
    
    if (cmp == 0) {
      return x.key; 
    }

    if (cmp < 0) {
      return floor(x.left, key);
    } else {
      Key rightFloor = floor(x.right, key);
      return (rightFloor != null) ? rightFloor : x.key;
    }
  }

  public Key ceil(Key key) {
    return ceil(root, key);
  }

  private Key ceil(Node x, Key key) {
    if (x == null) {
      return null;
    }

    int cmp = key.compareTo(x.key);
    
    if (cmp == 0) {
      return x.key; 
    }

    if (cmp < 0) {
      Key leftCeil = ceil(x.left, key);
      if (leftCeil != null) return leftCeil;
      return x.key;
    } else {
      return ceil(x.right, key);
    }
  }

  public void delMin() {
    root = delMin(root);
  }

  private Node delMin(Node x) {
    if (x == null) {
      return null;
    }

    if (x.left == null) {
      return x.right;
    }

    x.left = delMin(x.left);

    return x;
  }

  public void delMax() {
    root = delMax(root);
  }

  private Node delMax(Node x) {
    if (x == null) {
      return null;
    }

    if (x.right == null) {
      return x.left;
    }

    x.right = delMax(x.right);

    return x;
  }

  public void delete(Key key) {
    root = delete(root, key);
  }

  private Node delete(Node x, Key key) {
    if (x == null) {
      return null;
    }

    int cmp = key.compareTo(x.key);

    if (cmp == 0) {
      if (x.left == null) {
        return x.right;
      }
      else {
        /**
         * get the maximum from
         * the left, and replace
         * the data with current,
         * also remove it from its
         * og position.
         */
        Node t = max(x.left); // get max
        delMax(x.left); // del max
        x.key = t.key;
        x.value = t.value;
      }
    }
    else if (cmp < 0) {
      return delete(x.right, key);
    }
    else {
      return delete(x.left, key);
    }

    return x;
  }

  public int rank(Key key) {
    return -1; 
  }

  private int rank(Node x, Key key) {
    if (x == null) {
      return 0;
    }

    return -1;
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
    
    bst.delMax();
    
    assert(bst.get(65) == null);

    bst.delete(2);
    
    assert(bst.get(2) == null);
  }
}
