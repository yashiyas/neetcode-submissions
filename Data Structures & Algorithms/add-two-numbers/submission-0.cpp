/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carry = 0;

        ListNode* curr1 = l1;
        ListNode* curr2 = l2;
        ListNode* newHead = NULL;
        ListNode* prev = NULL;

        while(curr1 != NULL && curr2 != NULL){
            int sum = curr1->val + curr2-> val + carry;
            int digit = sum%10;
            carry = sum/10;

            if(newHead == NULL){
                newHead = new ListNode(digit);
                prev = newHead;
            }
            else{
                prev->next = new ListNode(digit);
                prev = prev->next;
            }
            curr1 = curr1->next;
            curr2 = curr2->next;
        }

        while(curr1 != NULL){
            int sum = curr1->val+carry;
            int digit = sum%10;
            carry = sum/10;
            if(newHead == NULL){
                newHead = new ListNode(digit);
                prev = newHead;
            }
            else{
                prev->next = new ListNode(digit);
                prev = prev->next;
            }
            curr1 = curr1->next;
        }

        while(curr2!=NULL){
            int sum = curr2->val+carry;
            int digit = sum%10;
            carry = sum/10;
            if(newHead == NULL){
                newHead = new ListNode(digit);
                prev = newHead;
            }
            else{
                prev->next = new ListNode(digit);
                prev = prev->next;
            }
            curr2 = curr2->next;
        }

        if(carry > 0){
            prev->next = new ListNode(carry);
        }
        return newHead;
    }
};
