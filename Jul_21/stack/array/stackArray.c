#include <stdlib.h>
#include <stdio.h>
#include "stackArray.h"

void initStack(Stack *s) {
    s->arr = (int *)malloc(100 * sizeof(int));
    s->top = -1;
    s->n = 100;
}

void initStackSize(Stack *s, int size) {
    s->arr = (int *)malloc(size * sizeof(int));
    s->top = -1;
    s->n = size;
}

bool isEmpty(Stack *s) {
    return s->top == -1;
}

void push(Stack *s, int val) {
    if (s->top + 1 == s->n) {
        printf("Stack Overflow!\n");
        return;
    }
    s->arr[++(s->top)]= val;
}

int top(Stack *s) {
    if (s->top == -1) {
        printf("Stack is empty!\n");
        return -1;
    }
    return s->arr[s->top];
}

void pop(Stack* s) {
    if (s->top == -1) {
        printf("Stack is empty!\n");
        return;
    }
    s->top--;
}

void printStack(Stack *s) {
    printf("Printing stack from top to bottom: ");
    int temp = s->top;
    while (temp >= 0) {
        printf("%i ", s->arr[temp--]);
    }
    printf("\n");
}

void freeStack(Stack *s) {
    free(s->arr);
    s->arr = NULL;
    s->top = -1;
    s->n = 0;
}