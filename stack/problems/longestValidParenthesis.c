// Copyright 2025 Shreya Sharma

/**
 * Problem Link:
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "../dataStructures/stack/stackArray.h"

int longestValidParenthesis(const char* s) {
    if (!s) return 0;

    int maxLength = 0;
    int n = (int)strlen(s);

    if (n == 0) return 0;

    Stack stack;
    initStackCapacity(&stack, n);

    int *lenAtCurrentIndex = (int *)calloc(n, sizeof(int));
    if (!lenAtCurrentIndex) {
        printf("calloc failed!\n");
        freeStack(&stack);
        exit(1);
    }

    for (int i = 0; i < n; i++) {
        if (s[i] == '(') {
            push(&stack, i);
            lenAtCurrentIndex[i] = 0;
        } else {
            if (isEmpty(&stack)) {
                lenAtCurrentIndex[i] = 0;
            } else {
                int start = pop(&stack);

                int curLen = i - start + 1;

                if (start > 0) {
                    int prevIdx = start - 1;
                    curLen += lenAtCurrentIndex[prevIdx];
                }

                lenAtCurrentIndex[i] = curLen;

                if (curLen > maxLength) maxLength = curLen;
            }
        }
    }

    free(lenAtCurrentIndex);
    freeStack(&stack);

    return maxLength;
}

int main() {
    char *s = NULL;
    size_t len = 0;

    if (getline(&s, &len, stdin) != -1) {
        size_t n = 0;
        while (s[n] && s[n] != '\n') n++;
        s[n] = '\0';

        int ans = longestValidParenthesis(s);
        printf("%i\n", ans);
    }

    free(s);
    return 0;
}
