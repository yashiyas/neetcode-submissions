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
    public ListNode reverseKGroup(ListNode head, int k) {

        int n = 0;

        ListNode curr = head;

        while(curr != null){
            n++;
            curr = curr.next;
        }

        if(n<k){
            return head;
        }

        int i=0;

        curr  = head;
        ListNode prev = null;

        while (i+k<=n){
            
            List<ListNode> reversed = reverse(curr,k);
            if(prev == null){
                head = reversed.get(0);
            }else{
                prev.next = reversed.get(0);
            }
            prev = reversed.get(1);
            i = i+k;
            curr = prev.next;
            
        }

        return head;


        
    }

    private List<ListNode> reverse(ListNode head, int k){
        ListNode curr = head;
        ListNode prev = null;
        while(k>0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            k--;
        }
        head.next = curr;
        return List.of(prev,head);

    }
}
