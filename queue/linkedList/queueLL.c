#include <stdio.h>
#include <stdlib.h>
#include "queuell.h"
#include "linkedlist.h"

void initQueue(Queue* q) {
    q->top = NULL;
    q->front = NULL;
}

int isEmpty(Queue *q) {
    return q->front == NULL;
}

void push(Queue *q, int val) {
    Node *newNode = createNode(val);

    if (!newNode) {
        printf("Memory allocation failed!\n");
        return;
    }

    if (q->top == NULL) {
        q->top = newNode;
    }
    else {
        q->top->next = newNode;
        q->top = newNode;
    }

    if (q->front == NULL) {
        q->front = newNode;
    }
}

int pop(Queue *q) {
    if (isEmpty(q)) {
        printf("Queue Underflow!\n");
        return -1;
    }

    Node *temp = q->front;
    int popped = temp->val;
    q->front = q->front->next;

    free(temp);

    return popped;
}

int peek(Queue *q) {
      if (isEmpty(q)) {
        printf("Queue is empty!\n");
        return -1;  
    }
    return q->front->val;
}

// for debugging
void printQueue(Queue *q) {
    Node* current = q->front;
    printf("Queue (front to back): ");
    while (current != q->top) {
        printf("%d -> ", current->val);
        current = current->next;
    }
    printf("%d -> ", current->val);
    printf("NULL\n");
}