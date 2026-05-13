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
    private ListNode reverseKNodes(ListNode head, int k){
        //Checks whether the list has k nodes or not and returning original head in case of not having k nodesabstract
        ListNode temp = head;
        int cnt = 0;
        while(cnt<k){
            if(temp==null) return head;
            cnt++;
            temp = temp.next;
        }

        // Recursively call the function to reverse next K nodes first
        ListNode nextHead = reverseKNodes(temp, k);

        // Reversing the current k group and merging with next group
        cnt = 0;
        temp = head;
        while(cnt<k){
            ListNode next = temp.next;
            temp.next = nextHead;
            nextHead = temp;
            temp = next;
            cnt++;
        }

        return nextHead;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseKNodes(head, k);
    }
}
