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
        // Handling case of an empty or one node list
        if(head==null || head.next==null) return false;

        // Creating slow and fast pointers
        ListNode slow = head;
        ListNode fast = head.next;

        // Loop for detecting the cycle
        while(slow!=fast){
            if(fast==null || fast.next==null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        // if loops condition hit true somehow then it is confirmed that there's a cycle exist.
        return true;
    }
}
