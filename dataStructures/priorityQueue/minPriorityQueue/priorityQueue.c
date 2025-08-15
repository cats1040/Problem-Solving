// Copyright 2025 Shreya Sharma

#include <stdio.h>
#include <stdlib.h>
#include "priorityQueue.h"

/**
 * Initialize the priority queue
 * with an initial capacity of 50.
 */
void initMinPriorityQueue(minPriorityQueue* minPQ) {
    minPQ->arr = (int *)malloc(sizeof(int) * 51);
    minPQ->currSize = 0;
    minPQ->capacity = 50;
}

/**
 * Initialize the priority queue
 * with an initial capacity given.
 */
void initMinPriorityQueueCapacity(minPriorityQueue* minPQ, int capacity) {
    minPQ->arr = (int *)malloc(sizeof(int) * (capacity + 1));
    minPQ->currSize = 0;
    minPQ->capacity = capacity;
}

void resize(minPriorityQueue* minPQ, int newCapacity) {
    int *newArray = (int *)malloc(sizeof(int) * (newCapacity + 1));

    for (int i = 1; i < minPQ->currSize + 1; i++) {
        newArray[i] = minPQ->arr[i];
    }

    free(minPQ->arr);
    minPQ->arr = newArray;
    minPQ->capacity = newCapacity;

    return;
}

void swim(minPriorityQueue* minPQ) {
    int n = minPQ->currSize;

    while (n > 1) {
        int parent = minPQ->arr[n / 2];
        int curr = minPQ->arr[n];

        // Swap if below condition true
        if (parent > curr) {
            minPQ->arr[n / 2] = curr;
            minPQ->arr[n] = parent;
        } else {
            break;
        }

        n = n / 2;
    }

    return;
}

void insert(minPriorityQueue* minPQ, int val) {
    int n = minPQ->currSize;

    // Insert at end
    minPQ->arr[n + 1] = val;

    // Update size of array
     minPQ->currSize++;

    /**
     * Then swim to top
     * Call swim function
     */
    swim(minPQ);

    // Resize if array is full
    if (n + 1 >= minPQ->capacity) {
        int newCapacity = 2 * minPQ->capacity;
        minPQ->capacity = newCapacity;
        resize(minPQ, newCapacity);
    }

    return;
}

void sink(minPriorityQueue* minPQ) {
    int n = minPQ->currSize;
    int curr = 1;

    while (2 * curr < n + 1) {
        int left = 2 * curr;
        int right = left + 1;

        int l = minPQ->arr[left];
        int c = minPQ->arr[curr];

        if (right < n + 1) {
            int r = minPQ->arr[right];

            if (l > r) {
                if (c > r) {
                    minPQ->arr[curr] = r;
                    minPQ->arr[right] = c;

                    curr = right;
                } else {
                    break;
                }
            } else {
                if (c > l) {
                    minPQ->arr[curr] = l;
                    minPQ->arr[left] = c;

                    curr = left;
                } else {
                    break;
                }
            }
        } else if (minPQ->arr[left] < minPQ->arr[curr]) {
            minPQ->arr[left] = c;
            minPQ->arr[curr] = l;

            curr = left;
        } else {
            break;
        }
    }

    return;
}

int delMin(minPriorityQueue* minPQ) {
    // First element is the minimum
    int maxEle = minPQ->arr[1];

    int n = minPQ->currSize;

    /**
     * Swap root with the last node
     * and then sink it down.
     */
    minPQ->arr[1] = minPQ->arr[n];
    minPQ->currSize--;
    sink(minPQ);

    /**
     * If the 3/4th of the arr is
     * empty, resize it. Reduce the
     * size by half.
     */
    if (minPQ->currSize <= (minPQ->capacity / 4) && minPQ->capacity > 4) {
        int newCapacity = minPQ->capacity / 2;
        resize(minPQ, newCapacity);
    }

    return maxEle;
}

int getMin(minPriorityQueue* minPQ) {
    return minPQ->arr[1];
}

int isEmpty(minPriorityQueue* minPQ) {
    return minPQ->currSize == 0;
}

void freeMinPriorityQueue(minPriorityQueue* minPQ) {
    free(minPQ->arr);
    minPQ->arr = NULL;
    minPQ->currSize = 0;
    minPQ->capacity = 50;
}
