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
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode a = head, b = head.next;
        while(b!=null){
            ListNode tmp = b.next;
            b.next = a;
            a = b;
            b = tmp;
        }
        head.next = null;
        return a;
        
    }
}