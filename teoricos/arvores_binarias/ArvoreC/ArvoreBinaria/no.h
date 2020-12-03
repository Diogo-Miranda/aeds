typedef struct No {
    int elemento;
    struct No *esq, *dir;
} No;

No* novoNo(int elemento);