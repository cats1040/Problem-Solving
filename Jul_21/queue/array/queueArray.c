#include <stdlib.h>
#include <stdio.h>
#include "queueArray.h"

void initQueue(Queue *q) {
    q->size = 100;
    q->arr = (int *)malloc(q->size * sizeof(int));
    q->front = -1, q->back = -1;
}

void initQueueSize(Queue *q, int size) {
    q->size = size;
    q->arr = (int *)malloc(q->size * sizeof(int));
    q->front = -1, q->back = -1;
}

void push(Queue *q, int val){
    if (q->front == -1) {
        q->arr[0] = val;
        q->front = 0;
        q->back = 0;
        return;
    }

    if (q->back == q->size - 1) {
        if (q->front == 0) {
            printf("Overflow!");
            return;
        }

        q->arr[0] = val;
        q->back = 0;
    }
    else if (q->back < q->front) {
        if (q->back + 1 >= q->front) {
            printf("Overflow!");
            return;
        }

        q->arr[q->back + 1] = val;
        q->back++;
    }
    else {
        // normal case
        if (q->back + 1 >= q->size) {
            printf("Overflow!");
            return;
        }

        q->arr[q->back + 1] = val;
        q->back++;
    }
}

int peek(Queue *q){
    if (q->front == -1) {
        printf("Underflow!");
        return -1;
    }

    return q->arr[q->front];
}

void pop(Queue *q){
    if (q->front == -1) {
        printf("Underflow!");
        return;
    }

    int popped = q->arr[q->front];

    if (q->front == q->back) {
        q->front = -1;
        q->back = -1;
        return;
    }

    if (q->front == q->size - 1) {
        q->front = 0;
        return;
    }

    q->front++;

    if (q->front == q->back) {
        q->arr[0] = q->arr[q->back];
        q->front = 0;
        q->back = 0;
    }

    return;
}

bool isEmpty(Queue *q) {
    return q->front == -1;
}

void printQueue(Queue *q){
    if (isEmpty(q)) {
        printf("Empty!");
        return;
    }

    printf("Front to back: ");

    if (q->front > q->back) {
        int f = q->front;
        while (f < q->size) {
            printf("%i ", q->arr[f++]);
        }

        int b = q->back;
        while (b < q->front) {
            printf("%i ", q->arr[b++]);
        }
        printf("\n");
        return;
    }

    int f = q->front, b = q->back;
    while (f <= b) {
        printf("%i ", q->arr[f++]);
    }
    printf("\n");
}

void freeQueue(Queue *q){
    free(q->arr);
    q->arr = NULL;
    q->size = 0;
    q->front = q->back = -1;
}
