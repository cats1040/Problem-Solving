// Copyright 2025 Shreya Sharma

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include <stdbool.h>

int *arr;
int front = 0;
int rear = 0;
int currSize = 0;
int maxSize = 1;

// Resize the array
void resizeArray(int newSize, int oldMaxSize) {
    int *newArr = (int *)malloc(sizeof(int) * newSize);

    for (int i = 0; i < currSize; i++) {
        newArr[i] = arr[(front + i) % oldMaxSize]; 
    }

    free(arr);
    arr = newArr;
    front = 0;
    rear = currSize;
    maxSize = newSize;
}

/**
 * Pushes a new item to the queue, also
 * resizes the array if it is full
 * 
 * @param val - val to be pushed into queue
 */
void push(int val) {
    arr[rear] = val;
    rear = (rear + 1) % maxSize;
    currSize++;

    if (currSize >= maxSize) {
        int temp = maxSize;
        maxSize *= 2;
        resizeArray(maxSize, temp);
    }
}

/**
 * Removes and returns the val most recently
 * added to the queue, also resizes the array
 * if it is half empty
 * 
 * @return val - val removed from the queue
 */
int pop() {
    if (currSize == 0) {
        return - 1;
    }

    int val = arr[front];
    front = (front + 1) % maxSize;
    currSize--;

    if (currSize <= maxSize/2 && maxSize > 1) {
        int temp = maxSize;
        maxSize = (3*maxSize)/4;
        resizeArray(maxSize, temp);
    }

    return val;
}

/**
 * Return the number of items in the queue
 * 
 * @return the number of items in the queue
 */
int size() {
    return currSize;
}

/**
 * Checks if the queue is empty or not
 * 
 * @return true if queue is empty
 */
bool isEmpty() {
    return currSize == 0;
}

// Test queue logic
void testQueue() {
    push(1);
    pop();

    assert(size() == 0);

    push(2);
    push(9);

    assert(size() == 2);
    assert(isEmpty() == false);

    assert(pop() == 2);
    assert(pop() == 9);
    assert(isEmpty() == true);

    for (int i = 0; i < 100; i++) {
        push(i);
    }

    for (int i = 0; i < 100; i++) {
        assert(pop() == i);
    }

    assert(isEmpty() == true);
}

int main() {
    arr = (int *)malloc(sizeof(int) * maxSize);
    testQueue();

    return 0;
}
