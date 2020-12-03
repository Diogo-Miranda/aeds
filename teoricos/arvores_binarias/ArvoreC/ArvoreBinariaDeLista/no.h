typedef struct No {
    char elemento;
    struct No *esq, *dir;
} No;

No* novoNo(char elemento);