#ifndef STACKARRAY_H
#define STACKARRAY_H

#include <stdbool.h>

typedef struct Stack
{
    int *arr;
    int n, top;
} Stack;

void initStack(Stack *s);
void initStackSize(Stack *s, int size);
void push(Stack *s, int val);
void pop(Stack *s);
int top(Stack *s);
bool isEmpty(Stack *s);
void printStack(Stack *s); 
void freeStack(Stack *s);

#endif