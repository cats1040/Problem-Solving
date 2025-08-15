// Copyright 2025 Shreya Sharma

#include <stdio.h>
#include <stdlib.h>
#include "priorityQueue.h"

/**
 * Initialize the priority queue
 * with an initial capacity of 50.
 */
void initMaxPriorityQueue(maxPriorityQueue *maxPQ) {
    maxPQ->arr = (int *)malloc(sizeof(int) * 51);
    maxPQ->currSize = 0;
    maxPQ->capacity = 50;
}

/**
 * Initialize the priority queue
 * with an initial capacity given.
 *
 * @param pointer to datatype maxPriorityQueue and 
 * capacity - initial capacity of the priority queue
 */
void initMaxPriorityQueueCapacity(maxPriorityQueue *maxPQ, int capacity) {
    maxPQ->arr = (int *)malloc(sizeof(int) * (capacity + 1));
    maxPQ->currSize = 0;
    maxPQ->capacity = capacity;
}

/**
 * Resize function to resize the binary heap
 *
 * @param pointer to datatype maxPriorityQueue and
 * newCapacity - new capacity of the priority quwue
 */
void resize(maxPriorityQueue *maxPQ, int newCapacity) {
    int *newArray = (int *)malloc(sizeof(int) * (newCapacity + 1));

    for (int i = 1; i < maxPQ->currSize + 1; i++) {
        newArray[i] = maxPQ->arr[i];
    }

    free(maxPQ->arr);
    maxPQ->arr = newArray;
    maxPQ->capacity = newCapacity;

    return;
}

/**
 * Swims an element at index k,
 * to its correct position.
 */
void swim(maxPriorityQueue *maxPQ, int k) {
    int n = k;

    while (n > 1) {
        int parent = maxPQ->arr[n / 2];
        int curr = maxPQ->arr[n];

        // Swap if below condition true
        if (parent < curr) {
            maxPQ->arr[n / 2] = curr;
            maxPQ->arr[n] = parent;
        } else {
            break;
        }

        n = n / 2;
    }

    return;
}

/**
 * Inserts an element into the priority queue
 * and if needed, adjusts the array elements
 * to ensure the binary heap property of the
 * max queue is maintained.
 */
void insert(maxPriorityQueue *maxPQ, int val) {
    int n = maxPQ->currSize;

    // Insert at end
    maxPQ->arr[n + 1] = val;

    // Update size of array
    maxPQ->currSize++;

    /**
     * Then swim to top
     * Call swim function
     */
    swim(maxPQ, maxPQ->currSize);

    // Resize if array is full
    if (n + 1 >= maxPQ->capacity) {
        int newCapacity = 2 * maxPQ->capacity;
        maxPQ->capacity = newCapacity;
        resize(maxPQ, newCapacity);
    }

    return;
}

/**
 * Sink an element from the top to
 * its correct position. 
 */
void sink(maxPriorityQueue *maxPQ) {
    int n = maxPQ->currSize;
    int curr = 1;

    while (2 * curr < n + 1) {
        int left = 2 * curr;
        int right = left + 1;

        int l = maxPQ->arr[left];
        int c = maxPQ->arr[curr];

        if (right < n + 1) {
            int r = maxPQ->arr[right];

            if (l < r) {
                if (c < r) {
                    maxPQ->arr[curr] = r;
                    maxPQ->arr[right] = c;

                    curr = right;
                } else {
                    break;
                }
            } else {
                if (c < l) {
                    maxPQ->arr[curr] = l;
                    maxPQ->arr[left] = c;

                    curr = left;
                } else {
                    break;
                }
            }
        } else if (maxPQ->arr[left] > maxPQ->arr[curr]) {
            maxPQ->arr[left] = c;
            maxPQ->arr[curr] = l;

            curr = left;
        } else {
            break;
        }
    }

    return;
}

/**
 * Delete and return the maximum element
 * from the priority queue.
 *
 * @return maximum elemnt in the queue
 */
int delMax(maxPriorityQueue *maxPQ) {
    // First element is the maximum
    int maxEle = maxPQ->arr[1];

    int n = maxPQ->currSize;

    /** 
     * Swap root with the last node
     * and then sink it down.
     */
    maxPQ->arr[1] = maxPQ->arr[n];
    maxPQ->currSize--;
    sink(maxPQ);

    /**
     * If the 3/4th of the arr is
     * empty, resize it. Reduce the
     * size by half. 
     */
    if (maxPQ->currSize <= (maxPQ->capacity / 4) && maxPQ->capacity > 4) {
        int newCapacity = maxPQ->capacity / 2;
        resize(maxPQ, newCapacity);
    }

    return maxEle;
}

/**
 * Returns the topmost i.e. the maximum
 * element.
 *
 * @return the maximum element 
 */
int getMax(maxPriorityQueue *maxPQ) {
    return maxPQ->arr[1];
}

/**
 * Returns if the priority queue is empty 
 * or not.
 *
 * @return true if priority queue is empty,
 * false otherwise
 */
int isEmpty(maxPriorityQueue *maxPQ) {
    return maxPQ->currSize == 0;
}

/**
 * Returns the number of elements present
 * in priority queue.
 *
 * @return size of the priority queue
 */
int size(maxPriorityQueue *maxPQ) {
    return maxPQ->currSize;
}

void freeMaxPriorityQueue(maxPriorityQueue *maxPQ) {
    free(maxPQ->arr);
    maxPQ->arr = NULL;
    maxPQ->currSize = 0;
    maxPQ->capacity = 50;
}
