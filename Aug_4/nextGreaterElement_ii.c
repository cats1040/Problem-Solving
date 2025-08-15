// Copyright 2025 Shreya Sharma

/**
 * Problem Link:
 * https://leetcode.com/problems/next-greater-element-ii/description/
*/

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include "../dataStructures/stack/stackArray.h"

/**
 * Finds the next greater element for each
 * index in a circular array
 *
 * 
 * @return array of next greater elements
 */
int *nextGreater(int arr[], int n) {
    Stack stack;
    initStackCapacity(&stack, n);

    int *ans = malloc(sizeof(int) * n);

    for (int i = (2 * n) - 1; i >= 0; i--) {
        int idx = (i + 1) % n;

        if (isEmpty(&stack)) {
            ans[idx] = -1;
            push(&stack, arr[idx]);
        } else {
            while (!isEmpty(&stack) && peek(&stack) <= arr[idx]) {
                pop(&stack);
            }

            if (!isEmpty(&stack)) {
                ans[idx] = peek(&stack);
            } else {
                ans[idx] = -1;
            }

            push(&stack, arr[idx]);
        }
    }

    return ans;
}

void print(int *arr, int n) {
    for (int i = 0; i < n; i++) printf("%i ", arr[i]);
    printf("\n");

    return;
}

void testNG() {
    int arr1[] = {6, 5, 4, 3, 2, 1, 7};
    int expected1[] = {7, 7, 7, 7, 7, 7, -1};
    int *ans = nextGreater(arr1, 7);
    for (int i = 0; i < 7; i++) {
        assert(ans[i] == expected1[i]);
    }
    free(ans);

    int arr2[] = {3, 8, 4, 1, 2};
    int expected2[] = {8, -1, 8, 2, 3};
    ans = nextGreater(arr2, 5);
    for (int i = 0; i < 5; i++) {
        assert(ans[i] == expected2[i]);
    }
    free(ans);
}

int main() {
    testNG();

    int arr[] = {6, 5, 4, 3, 2, 1, 7};
    int n = sizeof(arr)/sizeof(int);

    int *ans = nextGreater(arr, n);

    print(ans, n);

    return 0;
}
