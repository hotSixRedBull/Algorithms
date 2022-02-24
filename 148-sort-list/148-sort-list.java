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
    public ListNode sortList(ListNode head) {
        HashMap<Integer, List<ListNode>> map = new HashMap();
        ListNode cur = head;
        while (cur != null) {
            if (!map.containsKey(cur.val)) {
                map.put(cur.val, new ArrayList());
            }
            map.get(cur.val).add(new ListNode(cur.val));
            cur = cur.next;
        }
        
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);
        ListNode sentinel = new ListNode();
        cur = sentinel;
        for (int key : keys) {
            List<ListNode> nodes = map.get(key);
            for (ListNode node : nodes) {
                cur.next = node;
                cur = cur.next;
            }
        }
        return sentinel.next;
    }
}