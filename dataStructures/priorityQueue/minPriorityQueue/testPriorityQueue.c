// Copyright 2025 Shreya Sharma

#include <assert.h>
#include <stdio.h>
#include "priorityQueue.h"

void testMinPQ() {
    minPriorityQueue pq;

    // Test initialization
    initMinPriorityQueue(&pq);
    assert(pq.capacity == 50);
    assert(pq.currSize == 0);
    assert(isEmpty(&pq) == 1);

    // Test insert and getMin
    insert(&pq, 10);
    assert(getMin(&pq) == 10);

    insert(&pq, 5);
    assert(getMin(&pq) == 5);

    insert(&pq, 20);
    assert(getMin(&pq) == 5);

    // Test deletion of min
    assert(delMin(&pq) == 5);
    assert(getMin(&pq) == 10);

    // Insert more elements
    insert(&pq, 1);
    insert(&pq, 15);
    insert(&pq, 0);
    assert(getMin(&pq) == 0);

    // Delete until empty
    while (!isEmpty(&pq)) {
        int prevMin = getMin(&pq);
        int removed = delMin(&pq);
        assert(prevMin == removed);
    }
    assert(isEmpty(&pq) == 1);

    // Free resources
    freeMinPriorityQueue(&pq);
}

int main() {
    testMinPQ();
    printf("✅ All MinPQ tests passed successfully!\n");
    return 0;
}

