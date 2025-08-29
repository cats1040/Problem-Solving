#ifndef STACKLL_H
#define STACKLL_H

#include "linkedlist.h"

typedef struct Stack
{
    Node *top;
} Stack;

void initStack(Stack *s);
int isEmpty(Stack *s);
void push(Stack *s, int data);
int pop(Stack *s);
int peek(Stack *s);
void printStack(Stack *s);

#endif