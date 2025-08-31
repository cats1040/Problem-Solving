#ifndef LINKEDLIST_H
#define LINKEDLIST_H

typedef struct Node
{
    int val;
    struct Node *next;
} Node;

Node *createNode(int val);
void freeList(Node *head);

#endif