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
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode oneStep=head;
        ListNode twoStep=head.next;
        while(twoStep!=null && twoStep.next!=null){
            if(oneStep==twoStep){
                return true;
            }
            oneStep=oneStep.next;
            twoStep=twoStep.next.next;
        }
        return false;
    }
}
