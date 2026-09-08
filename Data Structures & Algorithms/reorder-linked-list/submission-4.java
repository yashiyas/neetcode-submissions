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
    public void reorderList(ListNode head) {

        if(head.next == null){
            return;
        }

        ListNode slow = head;
        ListNode prev = null;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revHead = reverse(slow);

        prev.next = null;

        ListNode curr1 = head;
        ListNode curr2 = revHead;
        prev = null;

        // merge

        while(curr1 != null){
            ListNode temp = curr1.next;
            ListNode temp2 = curr2.next;

            if(prev != null){
                prev.next = curr1;
            }
            curr1.next = curr2;
            prev = curr2;
            curr1 = temp;
            curr2 = temp2;
        }

        if(curr2 != null){
            prev.next = curr2;
        }
        
    }

    private ListNode reverse(ListNode node){
        ListNode curr = node;
        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
