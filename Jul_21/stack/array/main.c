#include <stdlib.h>
#include <stdio.h>
#include "stackArray.h"

int main() {
    Stack *s= (Stack *)malloc(sizeof(Stack));

    initStackSize(s, 100);
    push(s, 3);
    push(s, 2);
    push(s, 9);
    push(s, 10);
    push(s, 4);
    push(s, 7);

    printStack(s);

    freeStack(s);

    return 0;
}