#include <stdio.h>
#include <stdlib.h>
#include "queueArray.h"

int main() {
    Queue *q = (Queue *)malloc(sizeof(Queue));
    initQueueSize(q, 5);

    push(q, 10);
    push(q, 20);
    push(q, 30);
    printQueue(q);

    printf("Front element is: %d\n", peek(q));
    pop(q);
    printQueue(q);

    push(q, 40);
    push(q, 50);
    push(q, 60);  
    printQueue(q);

    freeQueue(q);
    return 0;
}
