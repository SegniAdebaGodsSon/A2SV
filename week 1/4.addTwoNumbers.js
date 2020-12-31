/**
 * link: https://leetcode.com/problems/add-two-numbers/
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    let tempHead = new ListNode(0);
    let curr = tempHead,
        carry = 0;
    
    while(l1 !== null || l2 !== null){
        let a = (l1 !== null) ? l1.val: 0;
        let b = (l2 !== null) ? l2.val: 0;

        let sum = a + b + carry;
        carry = ~~(sum/10);

        curr.next = new ListNode(sum%10);
        curr = curr.next;

        if(i != null) i = i.next;
        if(j != null) j = j.next;
    }
    if(carry > 0){
        curr.next = new ListNode(carry); 
    }
    return tempHead.next;
};