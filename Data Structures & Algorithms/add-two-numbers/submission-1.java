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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ans=new ListNode();
        int carry = 0;

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode prev = ans;

        while(l1 != null & l2 != null){
            ListNode temp = new ListNode();
            int val = carry + l1.val+l2.val;
            temp.val = val%10;
            carry = val/10;
            prev.next = temp;
            prev=temp;
            l1=l1.next;
            l2=l2.next;
        }

        while(l1!= null){
            ListNode temp = new ListNode();
            int val = carry + l1.val;
            temp.val = val%10;
            carry = val/10;
            prev.next = temp;
            prev=temp;
            l1=l1.next;
        }

        while(l2!= null){
            ListNode temp = new ListNode();
            int val = carry + l2.val;
            temp.val = val%10;
            carry = val/10;
            prev.next = temp;
            prev=temp;
            l2=l2.next;
        }

        if(carry > 0){
            ListNode temp = new ListNode(carry,null);
            prev.next = temp;
        }

        return ans.next;
        
    }
}
