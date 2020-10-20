#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x2; int *x1; int *x3;
   
    x1 = (int*) malloc(sizeof(int));
    *x1 = 20;
    printf("\n x1: %i ", *x1);    
    
    x2 = *x1;
    printf("\n x1: %i x2: %i", *x1, x2);

    *x3 = x2 * *x1;
    printf("\n x1: %i x2: %i x3: %i", *x1, x2, *x3);

    x3 = &x2;
    printf("\n x1: %i x2: %i x3: %i", *x1, x2, *x3);

    x2 = 15;
    printf("\n x1: %i x2: %i x3: %i", *x1, x2, *x3);

    x2 = 13 & 3; // onde tem 0 e 1 vira 0  1101 0011
    printf("\n x1: %i x2: %i x3: %i", *x1, x2, *x3);

    x2 = 13 | 3; // ontem tem 0 e 1 vira 1 1101 0011 
    printf("\n x1: %i x2: %i x3: %i", *x1, x2, *x3);
    
    x2 = 13 >> 1;
    printf("\n x1: %i x2: %i x3: %i", *x1, x2, *x3);

    x2 = 13 << 1;
    printf("\n x1: %i x2: %i x3: %i", *x1, x2, *x3);

    return 0;
}
