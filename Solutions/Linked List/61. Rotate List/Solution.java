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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }

        int t = k % n;
        if (t == 0)
            return head;

        // find the new head and new tail
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        ListNode nHead = head;
        for (int i = 0; i < n - t - 1; i++) {
            nHead = nHead.next;
        }
        ListNode res = nHead.next;
        nHead.next = null;
        tail.next = head;
        return res;

    }
}