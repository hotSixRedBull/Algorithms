/**
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
var swapPairs = function(head) {
    if (head == null) {
        return null;
    }
    
    let first = head; // 1
    let second = head.next; //2
    let ans = null;
    let prev = null;
    while (first != null && second != null) {
        //console.log('first', first, 'second', second);
        let next = second.next; // 3
        if (prev != null) {
            prev.next = second;
        }
        else {
            ans = second;
        }
        second.next = first; // 2->1
        first.next = next; // 1->3
        //console.log('ans',ans);
        prev = first;
        first = first.next; // 3
        if (first != null) {
            second = first.next;// 4    
        }
    }
    //console.log('prev',prev,'first',first,'second',second)
    if (ans == null) {
        return head;
    }
    return ans;
};