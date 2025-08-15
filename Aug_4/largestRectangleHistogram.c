// Copyright 2025 Shreya Sharma

/**
* Problem Link:
* https://leetcode.com/problems/largest-rectangle-in-histogram
*/

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include "../dataStructures/stack/stackArray.h"

/**
 * Calculates the largest rectangular area in
 * the given histogram
 * 
 * @param arr, An array epresenting heights in
 * the histogram
 * @param n, The size of the arr
 * @return The arae of the largest rectangle.
 */
int largestRectangleArea(int *arr, int n) {
    Stack *stack = malloc(sizeof(Stack));
    initStackCapacity(stack, n);

    int ans = 0;

    for (int i = 0; i <= n; i++) {
        while (!isEmpty(stack) && (i == n || arr[i] < arr[peek(stack)])) {
            int height = arr[pop(stack)];

            /**
             * For width calculation, if the stack is
             * empty after popping, it means the popped
             * element was the smallest so far, so the
             * width extends from 0 to i - 1, else width
             * is from element after the new top of the
             * stack to i - 1.
             */
            int width = isEmpty(stack) ? i : i - peek(stack) - 1;

            if (ans < height * width) ans = height * width;
        }

        push(stack, i);
    }

    return ans;
}

/**
 * Testing the largestRectangleArea function
 */
void testLRA() {
    int arr1[] = {2, 1, 5, 6, 2, 3};
    assert(largestRectangleArea(arr1, 6) == 10);

    int arr2[] = {2, 4};
    assert(largestRectangleArea(arr2, 2) == 4);

    int arr3[] = {1, 3, 1};
    assert(largestRectangleArea(arr3, 3) == 3);

    int arr4[] = {1, 2, 1};
    assert(largestRectangleArea(arr4, 3) == 3);

    int arr5[] = {5, 4, 3, 2, 1};
    assert(largestRectangleArea(arr5, 5) == 9);

    int arr6[] = {1, 2, 3, 4, 5};
    assert(largestRectangleArea(arr6, 5) == 9);

    int arr7[] = {5, 5, 5, 5};
    assert(largestRectangleArea(arr7, 4) == 20);

    int arr8[] = {3};
    assert(largestRectangleArea(arr8, 1) == 3);
}

int main() {
    testLRA();

    int arr[] = {4, 3, 2, 1};
    int n = sizeof(arr) / sizeof(int);

    int ans = largestRectangleArea(arr, n);

    printf("%i\n", ans);

    return 0;
}
