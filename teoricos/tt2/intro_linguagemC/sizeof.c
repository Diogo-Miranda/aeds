#include <stdio.h>
/*
 *
 * Exemplo de argumentos em c
*/
int main(int argc, char *argv[])
{   
    int a = sizeof(char),
        b = sizeof(int),
        c = sizeof(double),
        d = sizeof(float);

    printf("tamanhos: %i ---- %i ---- %i ---- %i", a, b , c ,d);

    printf("\nargc = %i", argc);

    printf("\n*argv[1] = %s\n", argv[1]);

    return 0;
}
