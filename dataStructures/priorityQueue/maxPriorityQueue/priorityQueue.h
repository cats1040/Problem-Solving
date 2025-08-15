// Copyright 2025 Shreya Sharma

#ifndef DATASTRUCTURES_PRIORITYQUEUE_MAXPRIORITYQUEUE_PRIORITYQUEUE_H_
#define DATASTRUCTURES_PRIORITYQUEUE_MAXPRIORITYQUEUE_PRIORITYQUEUE_H_

typedef struct {
    int *arr;
    int currSize;
    int capacity;
} maxPriorityQueue;

void initMaxPriorityQueue(maxPriorityQueue *maxPQ);
void initMaxPriorityQueueCapacity(maxPriorityQueue *maxPQ, int capacity);
void insert(maxPriorityQueue *maxPQ, int val);
int delMax(maxPriorityQueue *maxPQ);
int getMax(maxPriorityQueue *maxPQ);
int isEmpty(maxPriorityQueue *maxPQ);
int size(maxPriorityQueue *maxPQ);
void freeMaxPriorityQueue(maxPriorityQueue *maxPQ);

#endif  // DATASTRUCTURES_PRIORITYQUEUE_MAXPRIORITYQUEUE_PRIORITYQUEUE_H_
