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

        ListNode head = null;
        ListNode prev = null;
        if(lists.length == 0){
            return head;
        }

        int k = lists.length;

        ListNode [] pointers = new ListNode[k];

        for(int i=0; i<k; i++){
            pointers[i] = lists[i];
        }

        boolean flag = false;

        while(true){
            int index = -1;
            for(int i=0; i<k ;i++){
                if(pointers[i] == null){
                    continue;
                }else{
                        flag = true;
                        if(index == -1 || pointers[i].val < pointers[index].val){
                            index = i;
                        }
                }
            }

            if(flag){
                ListNode curr = pointers[index];
                if(head == null){
                    head = curr;
                }else{
                    prev.next = curr;
                }
                pointers[index] = curr.next;
                curr.next = null;
                prev = curr;
                flag = false;
            }else{
                break;
            }

        }

        return head;

        

    }
}
