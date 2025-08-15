// Copyright 2025 Shreya Sharma

#ifndef DATASTRUCTURES_PRIORITYQUEUE_MINPRIORITYQUEUE_PRIORITYQUEUE_H_
#define DATASTRUCTURES_PRIORITYQUEUE_MINPRIORITYQUEUE_PRIORITYQUEUE_H_

typedef struct {
    int *arr;
    int currSize;
    int capacity;
} minPriorityQueue;

void initMinPriorityQueue(minPriorityQueue* minPQ);
void initMinPriorityQueueCapacity(minPriorityQueue* minPQ, int capacity);
void insert(minPriorityQueue* minPQ, int val);
int delMin(minPriorityQueue* minPQ);
int getMin(minPriorityQueue* minPQ);
int isEmpty(minPriorityQueue* minPQ);
void freeMinPriorityQueue(minPriorityQueue* minPQ);

#endif  // DATASTRUCTURES_PRIORITYQUEUE_MINPRIORITYQUEUE_PRIORITYQUEUE_H_


