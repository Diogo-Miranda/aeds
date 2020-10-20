#include <stdio.h>
#include <stdlib.h>

typedef struct Celula {
    int elemento;
    struct celular *prox;

} Celula;

Celula *novaCelula(int elemento) {
    Celula *nova = (Celula*)malloc(sizeof(Celula));
    nova->elemento = elemento;
    nova->prox = NULL;

    return nova;
};

int main()
{
    Celula *celula = novaCelula(3);
    return 0;
}
