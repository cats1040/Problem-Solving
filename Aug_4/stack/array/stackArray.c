#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include "stack.h"

int *arr;
int currSize = 0;
int maxSize = 1;

// Resize the array
void resizeArray(int newSize) {
    int *newArr = (int *)malloc(sizeof(int) * newSize);

    for (int i = 0; i < currSize; i++) {
        newArr[i] = arr[i]; 
    }

    free(arr);
    arr = newArr;

    return;
}

/**
 * Pushes a new item to the stack, also
 * resizes the array if it is full
 * 
 * @param val - val to be pushed into stack
 */
void push(int val) {
    arr[currSize++] = val;

    if (currSize >= maxSize) {
        maxSize *= 2;
        resizeArray(maxSize);
    }

    return;
}

/**
 * Removes and returns the val most recently
 * added to the stack, also resizes the array
 * if it is half empty
 * 
 * @return val - val removed from the stack
 */
int pop() {
    int val = arr[--currSize];

    if (currSize <= maxSize/2) {
        maxSize = (3*maxSize)/4;
        resizeArray(maxSize);
    }

    return val;
}

/**
 * Return the number of items in the stack
 * 
 * @return the number of items in the stack
 */
int size() {
    return currSize;
}

/**
 * Checks if the stack is empty or not
 * 
 * @return true if stack is empty
 */
bool isEmpty() {
    return currSize == 0;
}

void testStack() {
    push(1);
    pop();

    assert(size() == 0);

    push(2);
    push(9);

    assert(size() == 2);
    assert(isEmpty() == false);

    assert(pop() == 9);
    assert(pop() == 2);
    assert(isEmpty() == true);
}

int main() {
    arr = (int *)malloc(sizeof(int) * maxSize);
    testStack();
	    
    return 0;	
}
