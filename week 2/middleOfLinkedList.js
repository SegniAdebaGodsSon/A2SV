/**
 * link: https://leetcode.com/problems/middle-of-the-linked-list/
 * 
 * Solution 1 
 * TC - O(n), n is the number of nodes of the @param {ListNode} head
 *      O(n) to traverse every node and store the ListNodes left
 *      
 * Solution 2
 * TC - O(n), n is the number of nodes of the @param {ListNode} head
 *      O(n), traversing until the fast pointer reaches the last node
 * 
 * 
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
// SOLUTION 1
var middleNode1 = function(head) {
    let map = new Map(), count=0;
    curr = head;
    while(curr != null){
        map.set(count, curr);
        curr=curr.next;
        count++;
    }
    
    return map.get(Math.trunc(count/2));
};

// SOLUTION 2
var middleNode2 = function(head){
    let fast = head , slow = head;
    while(fast.next != null && (fast.next || fast.next.next)){
        if(!fast.next.next) {
            fast = fast.next;
            slow = slow.next;
            continue;
        }
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
}
