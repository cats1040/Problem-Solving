import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Program to merge k sorted lists.
 */
public class MergeKSortedLists {
  /**
   * This function megerges k sorted list.
   *
   * @param lists array of the sorted ListNodes
   * @return ListNode containing all the elements
   *     in sorted order.
   */
  public static ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);

    for (ListNode list : lists) {
      if (list == null) {
        continue;
      }
      pq.offer(list);
    }

    ListNode head = null;
    ListNode tail = null;

    while (!pq.isEmpty()) {
      ListNode curr = pq.poll();

      if (head == null) {
        head = curr;
        tail = curr;
      } else {
        tail.next = curr;
        tail = curr;
      }

      if (curr.next != null) {
        pq.offer(curr.next);
      }
    }

    return head;
  }

  /**
   * Helper: convert linked list to array.
   */
  private static int[] toArray(ListNode head) {
    List<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    return list.stream().mapToInt(i -> i).toArray();
  }

  /**
   * Testing mergeKLists method.
   */
  public static void test() {
    ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
    ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode l3 = new ListNode(2, new ListNode(6));
    ListNode[] lists1 = {l1, l2, l3};
    int[] expected1 = {1, 1, 2, 3, 4, 4, 5, 6};
    int[] result1 = toArray(mergeKLists(lists1));
    assert result1.length == expected1.length : "Length mismatch in test1";
    for (int i = 0; i < expected1.length; i++) {
      assert result1[i] == expected1[i] : "Mismatch at test1 index " + i;
    }

    // Test case 2: all lists empty
    ListNode[] lists2 = {null, null};
    int[] expected2 = {};
    int[] result2 = toArray(mergeKLists(lists2));
    assert result2.length == expected2.length : "Length mismatch in test2";

    // Test case 3: single list
    ListNode[] lists3 = {new ListNode(1, new ListNode(2, new ListNode(3)))};
    int[] expected3 = {1, 2, 3};
    int[] result3 = toArray(mergeKLists(lists3));
    assert result3.length == expected3.length : "Length mismatch in test3";
    for (int i = 0; i < expected3.length; i++) {
      assert result3[i] == expected3[i] : "Mismatch at test3 index " + i;
    }

    // Test case 4: multiple empty + one non-empty list
    ListNode[] lists4 = {null, new ListNode(7, new ListNode(8)), null};
    int[] expected4 = {7, 8};
    int[] result4 = toArray(mergeKLists(lists4));
    assert result4.length == expected4.length : "Length mismatch in test4";
    for (int i = 0; i < expected4.length; i++) {
      assert result4[i] == expected4[i] : "Mismatch at test4 index " + i;
    }

    System.out.println("All assert tests passed.");
  }

  /**
   * Entry point of the program.
   */
  public static void main(String[] args) {
    test();
  }
}
