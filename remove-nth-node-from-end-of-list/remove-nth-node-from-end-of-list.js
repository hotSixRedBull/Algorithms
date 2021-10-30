/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    let cur = head;
    let prev = null;
    let length = 0;
    while (cur != null) {
        cur = cur.next;
        length++;
    }
    cur = head;
    let cnt = 0;
    while (cnt < length-n) {
        prev = cur;
        cur = cur.next;
        cnt++;
    }
    if (length != n) {
        prev.next = cur.next;
    }
    else if (prev != null) {
        head = prev.next;
    }
    else {
        head = cur.next;
    }
    return head;
};