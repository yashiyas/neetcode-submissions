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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode* pointer1 = list1;
        ListNode* pointer2 = list2;
        ListNode* head;
        ListNode* curr;
        if(list1 == NULL){
            return list2;
        }
        if(list2 == NULL){
            return list1;
        }
        if(list1->val < list2->val){
            head = list1;
            pointer1 = pointer1->next;
        }
        else{
            head = list2;
            pointer2 = pointer2->next;
        }
        curr = head;

        while(pointer1 != NULL && pointer2 != NULL){
            if(pointer1-> val < pointer2-> val){
                curr->next = pointer1;
                pointer1=pointer1->next;
                curr=curr->next;
            }
            else{
                curr->next = pointer2;
                pointer2=pointer2->next;
                curr=curr->next;
            }
        }
        if(pointer2 != NULL){
            curr->next = pointer2;
        }
        else{
            curr->next = pointer1;
        }
        return head;
    }
};
