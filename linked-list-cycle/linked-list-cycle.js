/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
    let map = new Map();
    while (head != null) {
        //console.log(`head: ${head}, head.val: ${head.val}, map[head]: ${map.get(head)}`);
        //console.log(map);
        if (map.has(head)) {
           return true;
        }
        else {
            map.set(head, 1);
        }
        head = head.next;
    }
    return false;
};