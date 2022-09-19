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
        ListNode dummy = new ListNode();
        dummy.next = head;
        right -= left;

        ListNode h = dummy;
        while (left-- > 1)
            h = h.next;
        ListNode a = h.next;
        ListNode b = a.next;

        while (right-- > 0) {
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