#ifndef QUEUEARRAY_H
#define QUEUEARRAY_H

#include <stdbool.h>

typedef struct Queue
{
    int *arr;
    int front, back;
    int size;
} Queue;

void initQueue(Queue *q);
void initQueueSize(Queue *q, int size);
void push(Queue *q, int val);
int peek(Queue *q);
void pop(Queue *q);
bool isEmpty(Queue *q);
void printQueue(Queue *q);
void freeQueue(Queue *q);

#endif