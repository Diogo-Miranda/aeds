
//TIPO CELULA ===================================================================
typedef struct Celula {
	char elemento[100];        // Elemento inserido na celula.
	struct Celula* prox; // Aponta a celula prox.
} Celula;

Celula* novaCelula(char* elemento);