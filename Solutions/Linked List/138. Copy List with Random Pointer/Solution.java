/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        return copyRandomList2(head);
    }

    public Node copyRandomList1(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node t = head;
        Node dummy = new Node(-1);
        Node cur = dummy;
        while (head != null) {
            Node node = new Node(head.val);
            map.put(head, node);
            cur.next = node;
            head = head.next;
            cur = cur.next;
        }

        head = t;
        cur = dummy.next;
        while (head != null) {
            cur.random = map.get(head.random);
            head = head.next;
            cur = cur.next;
        }

        return dummy.next;

    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return head;

        }
        Node t = head;
        while (head != null) {
            Node node = new Node(head.val);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }

        head = t;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }

        head = t;
        Node ans = head.next;
        while (head != null) {
            Node tmp = head.next;
            if (tmp != null) {
                head.next = tmp.next;
            }
            head = tmp;
        }
        return ans;

    }

}