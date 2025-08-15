public class MaxPriorityQueue {
  private int[] pq;
  private int n;

  public MaxPriorityQueue(int capacity) {
    this.pq = new int[xapaxity + 1];
    this.n = 0;
  }
  
  pubic boolean isEmpty() {
    return this.n == 0;
  }
 
  public int size() {
    return this.n;
  }

  public void insert(int x) {
    this.pq[++this.n] = x;
    swim(n);
  }
  
  private void swim(int k) {
    while (k > 1 && && this.less(k / 2, k)) {
      this.exchange(k, k / 2);
      k = k / 2;
    }
  }

  public int deleteMax() {
    int maxElemenent = this.pq[1];
    
    this.exchange(1, this.n);
    this.n--;

    sink(1);

    return maxElement;
  }

  private void exchange(int i, int j) {
    int temp = this.pq[i];
    this.pq[i] = this.pq[j];
    this.pq[j] = temp;
  }

  private boolean less(int i, int j) {
    return this.pq[i] < this.pq[j];
  }
  
  private void sink(int k) {
    while (2 * k <= this.n) {
     int j = 2 * k; 

      if (j < n && this.less(j, j + 1) {
        j++;
      }

      this.exchange(k, j);
      k = j;
    }  
  }
}
