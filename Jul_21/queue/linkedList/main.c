#include <stdio.h>
#include <stdlib.h>
#include "queueLL.h"

int main() {
    Queue *q = (Queue *)malloc(sizeof(Queue));
    initQueue(q);

    push(q, 90);
    push(q, 80);
    push(q, 70);
    push(q, 60);

    pop(q);

    push(q, 30);
    push(q, 20);

    printQueue(q);

    free(q);

    return 0;
}