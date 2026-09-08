/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode currA = headA;
        boolean travelB = false;
        ListNode currB = headB;
        boolean travelA = false;

        while(currA != currB){
            if(currA == null || currB == null){
                return null;
            }
            currA = currA.next;
            if(currA == null && !travelB){
                travelB = true;
                currA = headB;
            }
            currB = currB.next;
            if(currB == null && !travelA){
                currB = headA;
            }
        }

        return currA;


        
    }
}