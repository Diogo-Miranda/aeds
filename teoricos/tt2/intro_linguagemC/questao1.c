#include <stdio.h>
#include <stdlib.h>


/*
 *
 * Ponteiros
*/
int main()
{
    int *x1; int x2; int *x3;

    x1 = (int *)malloc(sizeof(int));
    printf("\nx1(%p)(%i)(%p) x2(%i)(%p) x3(%p)(%i)(%p)", x1, *x1, &x1, x2, &x2, x3, *x3, &x3);
    
    /**
     * Testes
    int a = 2;
    
    printf("\nteste a  - %p", &a);                    // teste a  - 78b

    printf("\nteste x1 - %p %p %i \n", x1, &x1, *x1); // teste x1 - 51c 62h 0 
    x1 = &a;                                          // x1 vai apontar pro endereço de memória de a
    printf("\nteste a  - %p", &a);                    // teste a  - 78b
    printf("\nteste x1 - %p %p %i", x1, &x1, *x1);    // teste x1 - 78b 62h 2    
    */
    return 0;

}
