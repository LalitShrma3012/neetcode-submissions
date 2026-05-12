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
    private ListNode reverseList(ListNode node){
        if(node==null || node.next==null){
            return node;
        }
        ListNode prev = null;
        ListNode cur = node;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        
        // Finding middle of the given list
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondList = slow.next;
        // Breaking given list into two cur and secondList
        slow.next = null;

        secondList = reverseList(secondList);

        ListNode cur = head;
        while(secondList != null){
            ListNode next = cur.next;
            ListNode secondNext = secondList.next;
            cur.next = secondList;
            secondList.next = next;
            cur = next;
            secondList = secondNext;
        }
    }
}
