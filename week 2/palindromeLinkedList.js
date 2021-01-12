/**
 * link: https://leetcode.com/problems/palindrome-linked-list/
 *
 * Solution 1
 * TC - O(n), n is the size of the ListNode
 *      O(n)   -   populating the count hashMap
 *      O(n/2) -   checking for in-equality traversing halfway form last and first
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
    let map = new Map(), count=0;
    curr = head;
    while(curr != null){
        map.set(count, curr[Object.keys(curr)[0]]);
        curr=curr.next;
        count++;
    }
    console.log(map)
    let lim=Math.trunc(count/2);
    for(let i=0, j=count-1; i<lim ;j--, i++){
        if(map.get(i) != map.get(j)){
            return false;
        }
    }
    return true;
};