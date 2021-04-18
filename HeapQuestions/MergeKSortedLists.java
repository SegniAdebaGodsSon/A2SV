import java.util.*;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = new ListNode(0);

        PriorityQueue<ListNode> heap = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.val, n2.val));

        for (ListNode n : lists)
            if (n != null) heap.offer(n);

        ListNode curr = node;

        while (!heap.isEmpty()) {
            curr.next = heap.poll();
            curr = curr.next;
            if (curr.next != null) heap.offer(curr.next);
        }

        return node.next;
    }
}