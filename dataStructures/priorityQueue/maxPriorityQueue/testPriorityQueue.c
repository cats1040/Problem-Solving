// Copyright 2025 Shreya Sharma

#include <assert.h>
#include <stdio.h>
#include "priorityQueue.h"

int main() {
    maxPriorityQueue pq;

    // Test default initialization
    initMaxPriorityQueue(&pq);
    assert(pq.capacity == 50);
    assert(pq.currSize == 0);
    assert(pq.arr != NULL);
    assert(isEmpty(&pq) == 1);

    // Test insertion of single element
    insert(&pq, 10);
    assert(pq.currSize == 1);
    assert(getMax(&pq) == 10);
    assert(isEmpty(&pq) == 0);

    // Test insertion maintaining max-heap property
    insert(&pq, 20);
    assert(pq.currSize == 2);
    assert(getMax(&pq) == 20);

    insert(&pq, 5);
    assert(pq.currSize == 3);
    assert(getMax(&pq) == 20);

    // Test delMax returns largest element
    int max = delMax(&pq);
    assert(max == 20);
    assert(pq.currSize == 2);
    assert(getMax(&pq) == 10);

    // Insert more elements to test heap ordering
    insert(&pq, 40);
    insert(&pq, 15);
    insert(&pq, 50);
    assert(getMax(&pq) == 50);

    // Test resizing on insert
    int originalCapacity = pq.capacity;
    for (int i = pq.currSize; i <= originalCapacity; i++) {
        insert(&pq, i + 100);
    }
    assert(pq.capacity > originalCapacity);

    // Test delMax until empty
    while (!isEmpty(&pq)) {
        int prevMax = getMax(&pq);
        int removed = delMax(&pq);
        assert(prevMax == removed);
    }
    assert(isEmpty(&pq) == 1);

    // Test init with custom capacity
    initMaxPriorityQueueCapacity(&pq, 5);
    assert(pq.capacity == 5);
    assert(pq.currSize == 0);

    freeMaxPriorityQueue(&pq);
    assert(pq.arr == NULL);

    return 0;
}

