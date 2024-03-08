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
    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> cnt = new HashMap();
        while (head != null) {
            if (cnt.containsKey(head.val) == false) {
                cnt.put(head.val, 0);
            }
            int cur = cnt.get(head.val);
            cnt.put(head.val, cur+1);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int key : cnt.keySet()) {
            cur.next = new ListNode(cnt.get(key));
            cur = cur.next;
        }
        return dummy.next;
    }
}