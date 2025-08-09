#include <assert.h>
#include <stdio.h>
#include "stackArray.h"

int main() {
    Stack st;
    initStack(&st);  // start small to test resizing quickly
    assert(isEmpty(&st) == 1);

    // Push elements and check top
    push(&st, 10);
    assert(peek(&st) == 10);
    assert(isEmpty(&st) == 0);

    push(&st, 20);
    assert(peek(&st) == 20);

    // Trigger grow
    push(&st, 30);
    assert(st.capacity >= 3);  // should have grown
    assert(peek(&st) == 30);

    // Pop elements and check
    assert(pop(&st) == 30);
    assert(peek(&st) == 20);

    assert(pop(&st) == 20);
    assert(pop(&st) == 10);
    assert(isEmpty(&st) == 1);

    // Push & pop more to test shrink
    for (int i = 1; i <= 16; i++) push(&st, i);
    assert(st.capacity >= 16);

    for (int i = 0; i < 14; i++) pop(&st);
    assert(st.capacity < 16); // should have shrunk

    freeStack(&st);

    return 0;
}
