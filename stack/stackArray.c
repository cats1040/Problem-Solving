#include <stdio.h>
#include <stdlib.h>
#include "stackArray.h"

void initStack(Stack *st) {
    st->arr = (int *)malloc(sizeof(int) * 1);
    st->top = 0;
    st->capacity = 1;
}

void initStackCapacity(Stack *st, int capacity) {
    st->arr = (int *)malloc(sizeof(int) * capacity);
    st->top = 0;
    st->capacity = capacity;
}

void resize(Stack *st, int new_capacity) {
    int *new_array = (int *)malloc(sizeof(int) * new_capacity);

    for (int i = 0; i < st->top; i++) {   
        new_array[i] = st->arr[i];
    }

    free(st->arr);
    st->arr = new_array;
    st->capacity = new_capacity;          
}

void push(Stack *st, int val) {
    if (st->top >= st->capacity) {         
        resize(st, st->capacity * 2);
    }

    st->arr[st->top++] = val;              
}

int pop(Stack *st) {
    if (st->top == 0) {
        fprintf(stderr, "Stack underflow!\n");
        exit(EXIT_FAILURE);
    }

    return st->arr[--st->top];
}

int isEmpty(Stack *st) {
    return st->top == 0;               
}

int peek(Stack *st) {
    if (st->top == 0) {
        fprintf(stderr, "Stack is empty!\n");
        exit(EXIT_FAILURE);
    }
    
    return st->arr[st->top - 1];
}

void freeStack(Stack *st) {
    free(st->arr);
    st->arr = NULL;
    st->capacity = 0;
    st->top = 0;
}