
/**
 * The MaxPriorityQueue class represents a priority
 * Queue for generic data types. It supports the
 * usual insert and delet the maximum operations.
 * It also supports the methods for peeking at a
 * maximum key, cheecking if the priority queue is
 * empty and the number of elements in the queue.
 */
public class MaxPriorityQueue<T extends Comparable<T>> {
  private T[] pq; // binary heap using 1-based indexing
  private int size; // number of elements in the queue

  /**
   * Initializes and empty priority queue.
   *
   * @param capacity - initial size of the queue.
   */
  public MaxPriorityQueue(int capacity) {
    this.pq = (T []) new Comparable[capacity + 1];
    this.size = 0;
  }

  /**
   * Returns true if the priority queue is empty.
   *
   * @return true if priority queue empty;
   *        false otherwise.
   */
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Returns the size of priority queue.
   *
   * @return the number of items in the queue.
   */
  public int size() {
    return this.size;
  }

  // Helper function
  private void swap(int i, int j) {
    T temp = this.pq[i];
    this.pq[i] = this.pq[j];
    this.pq[j] = temp;
  }

  // Helper function
  private boolean less(int i, int j) {
    return ((T) pq[i]).compareTo((T) pq[j]) < 0;
  }

  /**
   * Inserts an element into the priority queue
   * and if needed adjusts the array elements to
   * ensure binary heap order for max queue is
   * maintained.
   */
  public void insert(T val) {
    this.pq[++size] = val;
    swim(size);
  }

  // Swims n element to its rightful position.
  private void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      swap(k, k / 2);
      k = k / 2;
    }
  }

  /**
   * Returns and delete the maximum element in the
   * priority queue.
   *
   * @returns maximum element in the queue.
   */
  public T delMax() {
    T ele = this.pq[1];
    swap(1, size--);
    sink(1);

    return ele;
  }

  /**
   * Sinks an element from the top to its
   * rightful position.
   */
  private void sink(int k) {
    while (2 * k <= size) {
      int j = 2 * k;

      if (j < size && less(j, j + 1)) {
        j++;
      }

      if (!less(k, j)) {
        break;
      }

      swap(k, j);
      k = j;
    }
  }

  /**
   * Entry point of the application.
   *
   * @param args - not used
   */
  public static void main(String[] args) {
    MaxPriorityQueue<Integer> pq = new MaxPriorityQueue<Integer>(32);
    pq.insert(2);
    pq.insert(7);
    pq.insert(4);
    pq.insert(5);
    pq.insert(3);
    pq.insert(3);
    pq.insert(2);
    pq.insert(9);

    assert pq.delMax() == 9;
    
    pq.insert(8);

    assert pq.isEmpty() == false;
    assert pq.size() == 8;
    assert pq.delMax() == 8;
    assert pq.delMax() == 7;
    assert pq.delMax() == 5;
    assert pq.delMax() == 4;
    assert pq.delMax() == 3;
    assert pq.delMax() == 3;
    assert pq.delMax() == 2;
    assert pq.delMax() == 2;

    System.out.println("All good!");
  }
}
