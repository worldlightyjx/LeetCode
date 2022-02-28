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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 0; i < left - 1; i++) {
            p = p.next;
        }
        ListNode a = p;
        ListNode b = a.next;
        ListNode c = b.next;
        for (int i = left; i < right; i++) {
            ListNode tmp = c.next;
            c.next = b;
            b = c;
            c = tmp;

        }
        a.next.next = c;
        a.next = b;
        return dummy.next;

    }
}