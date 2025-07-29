#ifndef QUEUELL_H
#define QUEUELL_H

#include "linkedlist.h"

typedef struct Queue
{
    Node *top;
    Node *front;
} Queue;

void initQueue(Queue *q);
int isEmpty(Queue *q);
void push(Queue *q, int data);
int pop(Queue *q);
int peek(Queue *q);
void printQueue(Queue *q);

#endif