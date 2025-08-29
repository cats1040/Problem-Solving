// Copyright 2025 Shreya Sharma

import java.util.*;

/**
 * This program prints the optimal drug
 * dosage for a patient using a priority queue.
 */
public class Main {

  static void solve(Scanner sc) {
    int n = sc.nextInt();
    int k = sc.nextInt();

    /**
     * Stores medicine currTime, priority, frequency
     * and medicine name.
     */
    PriorityQueue<Pair> meds = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      String med = sc.next();
      int freq = sc.nextInt();

      meds.add(new Pair(new int[]{freq, i, freq}, med));
    }

    while (k > 0) {
      Pair top = meds.poll();

      String med = top.medicine;
      int time = top.data[0];     // current time
      int priority = top.data[1]; // priority
      int freq = top.data[2];     // original freq to add to current time

      System.out.println(time + " " + med);

      meds.add(new Pair(new int[]{freq + time, priority, freq}, med));

      k--;
    }

    return;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    while (t-- > 0) {
      solve(sc);
    }
    sc.close();
  }
}

/**
 * Helper class to store (vector<int>, string)
 * and compare lexicographically like C++ pair.
 */
class Pair implements Comparable<Pair> {
  int[] data;     // {time, priority, freq}
  String medicine;

  Pair(int[] data, String medicine) {
    this.data = data;
    this.medicine = medicine;
  }

  @Override
  public int compareTo(Pair other) {
    // Compare lexicographically: first by time, then by priority
    if (this.data[0] != other.data[0]) {
      return Integer.compare(this.data[0], other.data[0]);
    }
    if (this.data[1] != other.data[1]) {
      return Integer.compare(this.data[1], other.data[1]);
    }
    return this.medicine.compareTo(other.medicine);
  }
}

