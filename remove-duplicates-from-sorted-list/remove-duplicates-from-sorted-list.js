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
var deleteDuplicates = function(head) {
    if (!head) {
        return head;
    }
    let nullHead = new ListNode(-101, head);
    let cur = nullHead;
    while (cur != null) {
        while (cur.next != null && cur.next.val == cur.val) {
            cur.next = cur.next.next;
        }
        cur = cur.next; 
    }
    
    return nullHead.next;
};