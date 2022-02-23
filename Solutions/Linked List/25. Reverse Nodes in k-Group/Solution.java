/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (ListNode p = dummy;;) {
            ListNode q = p;
            for (int i = 0; i < k && q != null; i++) {
                q = q.next;
            }
            if (q == null)
                break;
            ListNode a = p.next;
            ListNode b = a.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode tmp = b.next;
                b.next = a;
                a = b;
                b = tmp;
            }
            ListNode c = p.next;
            c.next = b;
            p.next = a;
            p = c;
        }
        return dummy.next;

    }
}