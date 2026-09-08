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

        ArrayDeque<ListNode> stack = new ArrayDeque();

        ListNode curr = head;

        int n = 0;

        Set<ListNode> visited = new HashSet();

        while(curr != null){
            stack.push(curr);
            curr = curr.next;
            n++;
        }

        curr = head;

        ListNode prev = null;

        while(visited.size() < n){

            ListNode top = stack.pop();

            ListNode temp = curr.next;

            if(prev != null){
                prev.next = curr;
            }

            visited.add(curr);
            visited.add(top);

            curr.next = top;

            curr = temp;
            prev = top;

        }

        prev.next = null;



        
    }
}
