#include <stdlib.h>
#include "no.h"
#include "lista.h"

No* novoNo(char elemento) {
    No* novo = (No*) malloc(sizeof(No));
    novo->elemento = elemento;
    novo->esq = NULL;
    novo->dir = NULL;
    return novo;
}