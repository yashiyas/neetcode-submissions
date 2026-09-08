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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(n == 1 && head -> next == NULL){
            return NULL;
        }

        ListNode* right = head;
        ListNode* left = head;
        ListNode* prev = NULL;

        while(n > 0){
            if(left -> next == NULL){
                return head->next;
            }
            left = left->next;
            n--;
        }

        while(left != NULL){
            prev = right;
            right = right->next;
            left = left->next;
        }

        prev -> next = right -> next;
        return head;

    }
};
