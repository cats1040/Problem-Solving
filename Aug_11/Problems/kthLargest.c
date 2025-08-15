// Copyright 2025 Shreya Sharma

/**
 * Problem Link:
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=problem-list-v2&envId=heap-priority-queue
 */

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include "../../dataStructures/priorityQueue/minPriorityQueue/priorityQueue.h"

int findKthLargest(int *arr, int n, int k) {
    minPriorityQueue *minPQ = (minPriorityQueue *)malloc(sizeof(minPriorityQueue));

    initMinPriorityQueue(minPQ);

    for (int i = 0; i < n; i++) {
        insert(minPQ, arr[i]);
        if (minPQ->currSize > k) {
            delMin(minPQ);
        }
    }

    return getMin(minPQ);
}


void testFindKthLargest() {
    int arr1[] = {3, 2, 1, 5, 6, 4};
    int n1 = sizeof(arr1) / sizeof(arr1[0]);
    assert(findKthLargest(arr1, n1, 2) == 5);  // 2nd largest

    int arr2[] = {7, 10, 4, 3, 20, 15};
    int n2 = sizeof(arr2) / sizeof(arr2[0]);
    assert(findKthLargest(arr2, n2, 3) == 10);  // 3rd largest

    int arr3[] = {1};
    int n3 = sizeof(arr3) / sizeof(arr3[0]);
    assert(findKthLargest(arr3, n3, 1) == 1);  // only element

    printf("All test cases passed!\n");
}

int main() {
    testFindKthLargest();

    return 0;
}
