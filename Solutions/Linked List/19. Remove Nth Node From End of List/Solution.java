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
    public ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int num = 0;
        for (ListNode p = dummy; p != null; p = p.next) {
            num++;
        }
        ListNode p = dummy;
        for (int i = 0; i < num - k - 1; i++) {
            p = p.next;

        }
        p.next = p.next.next;
        return dummy.next;

    }
}