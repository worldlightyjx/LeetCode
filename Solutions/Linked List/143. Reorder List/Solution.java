/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode p1 = head, p2 = head;
        // find middle node
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // change list from 1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode mid = p1;
        ListNode a = mid.next;
        ListNode b = a.next;
        while (b != null) {
            ListNode tmp = b.next;
            b.next = a;
            a = b;
            b = tmp;
        }
        mid.next.next = b;
        mid.next = a;
        p1 = head;
        p2 = mid.next;

        while (p1 != mid) {
            mid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = mid.next;
        }

    }
}