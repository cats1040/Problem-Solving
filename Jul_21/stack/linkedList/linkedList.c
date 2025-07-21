#include <stdlib.h>
#include "linkedList.h"

Node *createNode(int val) {
    Node *newNode = (Node *)malloc(sizeof(Node));
    
    if (!newNode) {
        return NULL;
    }

    newNode->val = val;
    newNode->next = NULL;

    return newNode;
} 

void freeList(Node* head) {
    while (head) {
        Node* temp = head;
        head = head->next;
        free(temp);
    }
}