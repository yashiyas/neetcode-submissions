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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode proxy = new ListNode();
        proxy.next = head;

        ListNode fast = proxy;
        ListNode slow = proxy;
        ListNode prev = slow;

        int k = 0;

        while(k < n-1){
            fast = fast.next;
            k++;
        }

        while(fast.next != null){

            fast = fast.next;
            prev = slow;
            slow = slow.next;

        }

        prev.next = slow.next;

        return proxy.next;



    }
}
