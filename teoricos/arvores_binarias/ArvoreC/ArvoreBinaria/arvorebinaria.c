#include <err.h>
#include <stdlib.h>
#include <stdio.h>
#include "arvorebinaria.h"

No* raiz;

void start() {
    raiz = NULL;
}

bool pesquisar(int x) {
    return pesquisarRec(x, raiz);
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

void caminharCentral() {
    printf("[ ");
    caminharCentralRec(raiz);
    printf("]\n");
}

void caminharCentralRec(No* i) {
    if (i != NULL) {
        caminharCentralRec(i->esq);
        printf("%d ", i->elemento);
        caminharCentralRec(i->dir);
    }
}

void caminharPre() {
    printf("[ ");
    caminharPreRec(raiz);
    printf("]\n");
}

void caminharPreRec(No* i) {
    if(i != NULL) {
        printf("%d", i->elemento);
        caminharPreRec(i->esq);
        caminharPreRec(i->dir);
    }
}

void caminharPos() {
    printf("[ ");
    caminharPosRec(raiz);
    printf("]\n");
}

void caminharPosRec(No* i) {
    if(i != NULL) {
        caminharPosRec(i->esq);
        caminharPosRec(i->dir);
        printf("%d ", i->elemento);
    }
}

void inserir(int x) {
    inserirRec(x, &raiz);
}

void inserirRec(int x, No** i) {
    if(*i == NULL) {
        *i = novoNo(x);
    } else if (x < (*i)->elemento) {
        inserirRec(x, &((*i)->esq));
    } else if (x > (*i)->elemento) {
        inserirRec(x, &((*i)->dir));
    } else {
        errx(1, "Erro ao inserir!");
    }
}

void remover(int x) {
    removerRec(x, &raiz);
}

void removerRec(int x, No** i) {
    if(*i == NULL) {
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

void removerSucessor(int x) {
    removerRecSucessor(x, &raiz);
} 

void removerRecSucessor(int x, No** i) {
    if(*i == NULL) {
        errx(1, "Erro ao remover!");
    } else if(x < (*i)->elemento) {
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
        sucessor(i, &((*i)->dir));
    }
}

void sucessor(No** i, No** j) {
    if ((*j)->esq != NULL) {
        sucessor(i, &((*j)->esq));
    } else {
        No* del = *j;
        (*i)->elemento = (*j)->elemento;
        (*j) = (*j)->dir;
        free(del);
    }
}