#include <stdio.h>
#include <stdlib.h>
#include "stackll.h"
#include "linkedlist.h"

void initStack(Stack* s) {
    s->top = NULL;
}

int isEmpty(Stack* s) {
    return s->top == NULL;
}

void push(Stack*s, int val) {
    Node *newNode = createNode(val);

    if (!newNode) {
        printf("Memory allocation failed!\n");
        return;
    }

    newNode->next = s->top;
    s->top = newNode;
}

int pop(Stack* s) {
    if (isEmpty(s)) {
        printf("stack Underflow!\n");
        return -1;
    }

    Node *temp = s->top;
    int popped = temp->val;
    s->top = s->top->next;

    free(temp);

    return popped;
}

int peek(Stack* s) {
      if (isEmpty(s)) {
        printf("Stack is empty!\n");
        return -1;  
    }
    return s->top->val;
}

// for debugging
void printStack(Stack* s) {
    Node* current = s->top;
    printf("Stack (top to bottom): ");
    while (current) {
        printf("%d -> ", current->val);
        current = current->next;
    }
    printf("NULL\n");
}