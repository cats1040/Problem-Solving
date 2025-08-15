// Copyright 2025 Shreya Sharma

/**
 * Problem Link:
 * https://leetcode.com/problems/find-median-from-data-stream/?envType=problem-list-v2&envId=heap-priority-queue
 */

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include "../../dataStructures/priorityQueue/maxPriorityQueue/priorityQueue.h"
#include "../../dataStructures/priorityQueue/minPriorityQueue/priorityQueue.h"

double *medianFinder(int *arr, int n) {
    /**
     * Intition:
     * Max heap stores the low numbers
     * Min hep stores the high numbers
     * So their tops represent the middle
     * elements.
     */

    double *ans = (double *)malloc(sizeof(double) * n);

    maxPriorityQueue maxPQ;
    minPriorityQueue minPQ;

    initMaxPriorityQueue(&maxPQ);
    initMinPriorityQueue(&minPQ);

    for (int i = 0; i < n; i++) {
        int ele = arr[i];

        insert(&maxPQ, ele);
        insert(&minPQ, delMax(&maxPQ));

        if (maxPQ.currSize < minPQ.currSize) {
            insert(&maxPQ, delMin(&minPQ));
        }

        if (maxPQ.currSize > minPQ.currSize) {
            ans[i] = (double)getMax(&maxPQ);
        } else {
            double median = (getMax(&maxPQ) + getMin(&minPQ)) / 2.0;
            ans[i] = median;
        }
    }

    return ans;
}

void testMedianFinder() {
    int arr[] = {5, 15, 1, 3};
    int n = sizeof(arr) / sizeof(arr[0]);

    double *medians = medianFinder(arr, n);

    // Expected medians step-by-step:
    double expected[] = {5.0, 10.0, 5.0, 4.0};

    for (int i = 0; i < n; i++) {
        assert(medians[i] == expected[i]);
    }

    free(medians);
}


int main() {
    testMedianFinder();

    return 0;
}
