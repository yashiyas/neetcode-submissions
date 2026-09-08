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
    public ListNode mergeKLists(ListNode[] lists) {

        int k = lists.length;

        ListNode head = null;
        ListNode prev = null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(int i=0; i<k; i++){
            if(lists[i] != null){
                pq.offer(lists[i]);
            }
            
        }

        while(!pq.isEmpty()){
            ListNode top = pq.poll();

            if(head == null){
                head = top;
            }

            if(prev != null){
                prev.next = top;
            }

            ListNode temp = top.next;
            top.next = null;
            prev = top;

            if(temp != null){
                pq.offer(temp);
            }
        }

        return head;


    }
}
