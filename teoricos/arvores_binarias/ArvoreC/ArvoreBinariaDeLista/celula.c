#include <stdio.h>
#include <stdlib.h>
#include <celula.h>

Celula* novaCelula(char* elemento) {
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   strcpy(nova->elemento, elemento);
   nova->prox = NULL;
   return nova;
}