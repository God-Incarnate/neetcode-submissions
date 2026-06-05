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
        if (head == null) return null;

    Map<Node, Node> map = new HashMap<>();

    // Step 1: Create all nodes
    Node curr = head;
    while (curr != null) {
        map.put(curr, new Node(curr.val));
        curr = curr.next;
    }

    // Step 2: Assign next and random
    curr = head;
    while (curr != null) {
        Node copy = map.get(curr);
        copy.next = map.get(curr.next);      // handles null automatically
        copy.random = map.get(curr.random);  // handles null automatically
        curr = curr.next;
    }

    return map.get(head);
    }
}
