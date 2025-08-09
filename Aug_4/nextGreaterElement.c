/**
* Problem Link:
* https://leetcode.com/problems/next-greater-element-ii/description/
*/

#include <stdio.h>
#include <stdlib.h>
#include "../stack/stackArray.h"

/**
* @return array of next greater elements
*/
int *nextGreater(int arr[], int n) {
    Stack stack;
    initStackCapacity(&stack, n);

    int *ans = (int *)malloc(sizeof(int) * n);
    
    for (int i = n - 1; i >= 0; i--) {
        if (isEmpty(&stack)) {
            ans[i] = -1;
            push(&stack, arr[i]);
        }
        else {
            while (!isEmpty(&stack) && peek(&stack) <= arr[i]) {
                pop(&stack);
            }
            
            if (!isEmpty(&stack)) {
                ans[i] = peek(&stack);
            }
            else {
                ans[i] = -1;
            }

            push(&stack, arr[i]);
        }
    }

    return ans;
}

void print(int *arr, int n) {
    for (int i = 0; i < n; i++) printf("%i ", arr[i]);
    printf("\n");

    return;
}

int main() {
    int arr[] = {6,5,4,3,2,1,7};
    int n = sizeof(arr)/sizeof(int);

    int *ans = nextGreater(arr, n); 

    print(ans, n);   

    return 0;
}
