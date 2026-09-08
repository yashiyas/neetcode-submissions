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

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = slow;
        ListNode second = slow.next;

        slow.next = null;

        ListNode right = reverseList(second);


        ListNode dummy = new ListNode(0, head);
        ListNode left = head;

        prev = dummy;

        while(right !=null && left != null){
            prev.next = left;
            ListNode temp = left.next;
            prev.next.next = right;
            left = temp;
            prev = right;
            right = right.next;
        }
        if(left != null) {
            prev.next = left;
        }
        else {
            prev.next = null;
        }

        head = dummy.next;

        
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}
