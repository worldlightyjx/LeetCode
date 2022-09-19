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
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode h = dummy;
        ListNode a = h.next;
        ListNode b = a.next;

        while (b != null) {
            ListNode tmp = b.next;
            b.next = a;
            a = b;
            b = tmp;
        }

        h.next.next = b;
        h.next = a;

        return dummy.next;

    }
}