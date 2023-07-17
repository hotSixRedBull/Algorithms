import java.math.BigInteger;
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger val1 = BigInteger.valueOf(0);
        while (l1 != null) {
            val1 = val1.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf((long)l1.val));
            l1 = l1.next;
        }
        BigInteger val2 = BigInteger.valueOf(0);
        while (l2 != null) {
            val2 = val2.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf((long)l2.val));
            l2 = l2.next;
        }
        val1 = val1.add(val2);
        String str = val1.toString(10);
        ListNode sentinel = new ListNode();
        ListNode cur = sentinel;        
        for (int i=0; i<str.length(); i++) {
            cur.next = new ListNode(str.charAt(i)-'0');
            cur = cur.next;
        }
        return sentinel.next;
    }
}