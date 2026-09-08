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
        // count nodes
        int n = 0;

        ListNode curr = head;

        while(curr != null){
            curr = curr.next;
            n++;
        }

        // edge case

        if(k>n || k == 1){
            return head;
        }

        if(k == n){
            return reverse(head,k).get(0);
        }

        // normal scenarios

        curr = head;
        ListNode prev = null;
        ListNode newHead = null;

        int groups = n/k;


        for(int i=0; i<groups; i++){
            List<ListNode> revNodes = reverse(curr, k);
            if(newHead == null){
                newHead = revNodes.get(0);
            }
            if(prev != null){
                prev.next = revNodes.get(0);
            }
            prev = revNodes.get(1);
            curr = prev.next;
        }

        return newHead;
        
    }


    private List<ListNode> reverse(ListNode node, int k){
        List<ListNode> ans = new ArrayList();

        ListNode curr = node;
        ListNode prev = null;

        int i = 0;
        

        while(i < k){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            i++;
        }

        node.next = curr;
        ans.add(prev);
        ans.add(node);

        return ans;
    }
}
