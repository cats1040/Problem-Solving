public class HashTable<Key, Value> {
  static class Node {
    Object key;
    Object value;
    Node next;

    Node (Object key, Object value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  private int M = 32;
  private Node[] ht = new Node[M];

  public int hash (Key key) {
    // good if the class implements it's own hashCode
    // for better performance
    return (key.hashCode() & 0x7fffffff) % M;
  }

  public void put(Key key, Value value) {
    if (key == null) return;

    int hashVal = hash(key);

    for (Node x = ht[hashVal]; x != null; x = x.next) {
      if (x.key.equals(key)) {
        x.value = value;
        return;
      }
    }

    // Insert a node at the start of the linked list
    ht[hashVal] = new Node(key, value, ht[hashVal]);
  }

  public Value get(Key key) {
    if (key == null) return null;

    int hashVal = hash(key);

    for (Node x = ht[hashVal]; x != null; x = x.next) {
      if (x.key.equals(key)) {
        return (Value)x.value;
      }
    }

    return null;
  }
}
