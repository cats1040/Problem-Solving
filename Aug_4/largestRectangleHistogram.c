/**
* Problem Link:
* https://leetcode.com/problems/largest-rectangle-in-histogram
*/

#include <stdio.h>
#include <stdlib.h>
#include "../stack/stackArray.h"

int largestRectangleArea(int *arr, int n) {
    Stack *stack = (Stack *)malloc(sizeof(Stack));
    initStackCapacity(stack, n);

    int ans = 0;

    for (int i = 0; i < n; i++) {
        while (!isEmpty(stack) && (i == n || arr[i] < arr[peek(stack)])) {
            int height = arr[pop(stack)];
            int width = isEmpty(stack) ? i : i - peek(stack) - 1;
            if (ans < height * width) ans = height * width;
        }   
        push(stack, i);
    }    

    return ans;
}

int main() {
    int arr[] = {2, 1, 5, 6, 2, 3};
    int n = sizeof(arr)/sizeof(int);    

    int ans = largestRectangleArea(arr, n);

    printf("%i\n", ans);    

    return 0;
}
