#ifndef STACKARRAY_H
#define STACKARRAY_H

typedef struct {
    int *arr;
    int top;
    int capacity;
} Stack;

void initStack(Stack *st);
void initStackCapacity(Stack *st, int capacity);
void push(Stack *st, int val);
int pop(Stack *st);
int peek(Stack *st);
int isEmpty(Stack *st);
void freeStack(Stack *st);

#endif
