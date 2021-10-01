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
    ListNode* middleNode(ListNode* head) {
        ListNode* point = head;

        while(point != NULL) {
            point = point->next;
            count++;
        }

        int middle = (count / 2);

        ListNode* result;
        point = head;
        for (int i = 0; i < count; i++) {
            if (middle == i) {
                result = point;
                break;
            }
            point = point->next;
        }

        return result;
    }
};