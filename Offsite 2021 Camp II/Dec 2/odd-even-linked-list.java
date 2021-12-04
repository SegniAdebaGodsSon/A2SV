// https://leetcode.com/problems/odd-even-linked-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode evenHead = head.next, currEven = evenHead, currOdd = head;
        
        while(currEven!=null && currEven.next!=null){
            currOdd.next = currEven.next;
            currOdd = currOdd.next;
            
            currEven.next = currEven.next.next;
            currEven = currEven.next;
        }
    

        currOdd.next = evenHead;
        return head;
    }
    
    
}