#include <stdio.h>
#include <stdlib.h>
#include "stackLL.h"

int main() {
    Stack *s = (Stack *)malloc(sizeof(Stack));
    initStack(s);

    push(s, 90);
    push(s, 80);
    push(s, 70);
    push(s, 60);

    pop(s);

    push(s, 30);
    push(s, 20);

    printStack(s);

    free(s);

    return 0;
}

// compile 
// gcc main.c stackLL.c linkedList.c -o stack
// run
// ./stack