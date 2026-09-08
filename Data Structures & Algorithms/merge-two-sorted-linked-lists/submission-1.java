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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode head = null;
        ListNode prev = null;

        while(curr1 != null && curr2 != null){
            if(curr1.val < curr2.val){
                if(head == null){
                    head = curr1;
                    prev=curr1;
                curr1=curr1.next;
                } else{
                prev.next=curr1;
                prev=curr1;
                curr1=curr1.next;}
            } else{
                if(head == null){
                    head = curr2;
                    prev=curr2;
                curr2=curr2.next;
                }else{
                prev.next=curr2;
                prev=curr2;
                curr2=curr2.next;}
            }
        }

        if(curr2 != null){
            prev.next=curr2;
        }

        if(curr1 != null){
            prev.next = curr1;
        }

        return head;

        
    }
}