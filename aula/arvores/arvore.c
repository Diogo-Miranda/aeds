#include <stdio.h>
#include <stdlib.h>
#include <err.h>
#include <stdbool.h>

typedef struct No {
    int elemento;
    struct No *esq, *dir;
} No;

No* novoNo(int elemento) {
    No* novo = (No*) malloc(sizeof(No));
    novo->elemento = elemento;
    novo->esq = NULL;
    novo->dir = NULL;
    return novo;
}

No* raiz;

void start() {
    raiz = NULL;
}

bool pesquisarRec(int x, No* i) {
    bool resp;

    if (i == NULL) {
        resp = false;
    } else if (x == i->elemento) {
        resp = true;
    } else if (x < i->elemento) {
        resp = pesquisarRec(x, i->esq);
    } else {
        resp = pesquisarRec(x, i->dir);
    }

    return resp;
}

bool pesquisar(int x) {
    return pesquisarRec(x, raiz);
}

void inserirRec(int x, No** i) {
    if (*i == NULL) {
        *i = novoNo(x);
    } else if (x < (*i)->elemento) {
        inserirRec(x, &((*i)->esq));
    } else if (x > (*i)->elemento) {
        inserirRec(x, &((*i))->dir);
    } else {
        errx(1, "Erro ao inserir!");
    }
}

void inserir(int x) {
    inserirRec(x, &raiz);
}

void antecessor(No** i, No** j) {
    if ((*j)->dir != NULL) {
        antecessor(i, &((*j)->dir));
    } else {
        No* del = *j;
        (*i)->elemento = (*j)->elemento;
        (*j) = (*j)->esq;
        free(del);
    }
}

void removerRec(int x, No** i) {
    if(*i == NULL)  {
        errx(1, "Erro ao remover!");
    } else if (x < (*i)->elemento) {
        removerRec(x, &((*i)->esq));
    } else if (x > (*i)->elemento) {
        removerRec(x, &((*i)->dir));
    } else if ((*i)->dir == NULL) {
        No* del = *i;
        *i = (*i)->esq;
        free(del);
    } else if ((*i)->esq == NULL) {
        No* del = *i;
        *i = (*i)->dir;
        free(del);
    } else {
        antecessor(i, &((*i)->esq));
    }
}

void remover(int x) {
    removerRec(x, &raiz);
}


int main() {


}