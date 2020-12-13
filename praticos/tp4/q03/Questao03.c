#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>
#define MAX_LINHAS  500
#define TAM_PALAVRA 500
#define MAX_TAM     1000

// GLOBAIS
int NUM_COMP = 0;
// ======= Estrutura Jogador ======== //

struct jogador {
    int id;
    char *nome;
    int peso;
    int altura;
    char *universidade;
    char *anoNascimento;
    char *cidadeNascimento;
    char *estadoNascimento;
};

typedef struct jogador Jogador;

// ======= Construtores ============ //

void newJogador(Jogador *jogador, int id, char *nome, int peso, int altura, char *universidade, char *anoNascimento, char *cidadeNascimento, char *estadoNascimento)
{
   jogador = (Jogador*)malloc(sizeof(Jogador));

   jogador->id = id;
   jogador->nome = nome;
   jogador->peso = peso;
   jogador->altura = altura;
   jogador->universidade = universidade;
   jogador->anoNascimento = anoNascimento;
   jogador->cidadeNascimento = cidadeNascimento;
   jogador->estadoNascimento = estadoNascimento;
}

void newJogador_vazio(Jogador *jogador)
{
   jogador->id = 0;
   jogador->nome = "";
   jogador->peso = 0;
   jogador->altura = 0;
   jogador->universidade = "";
   jogador->anoNascimento = "";
   jogador->cidadeNascimento = "";
   jogador->estadoNascimento = "";

}

// ========= Fim Construtores ============= //

// ========== Get Sets ==================== //

void setId(Jogador *jogador, int id)
{
    jogador->id = id;
}

int getId(Jogador *jogador)
{
    return jogador->id;
}

void setNome(Jogador *jogador, char *nome)
{
    jogador->nome = nome;
}

char* getNome(Jogador *jogador)
{
    return jogador->nome;
}

void setAltura(Jogador *jogador, int altura)
{
    jogador->altura = altura;
}

int getAltura(Jogador *jogador)
{
    return jogador->altura;
}

void setPeso(Jogador *jogador, int peso)
{
    jogador->peso = peso;
}

int getPeso(Jogador *jogador)
{
    return jogador->peso;
}

void setUniversidade(Jogador *jogador, char *universidade)
{
    jogador->universidade = universidade;
}

char* getUniversidade(Jogador *jogador)
{
    return jogador->universidade;
}

void setAnoNascimento(Jogador *jogador, char *anoNascimento)
{
    jogador->anoNascimento = anoNascimento;
}

char* getAnoNascimento(Jogador *jogador)
{
    return jogador->anoNascimento;
}

void setCidadeNascimento(Jogador *jogador, char *cidadeNascimento)
{
    jogador->cidadeNascimento = cidadeNascimento;
}

char* getCidadeNascimento(Jogador *jogador)
{
    return jogador->cidadeNascimento;
}

void setEstadoNascimento(Jogador *jogador, char *estadoNascimento)
{
    jogador->estadoNascimento = estadoNascimento;
}

char* getEstadoNascimento(Jogador *jogador)
{
    return jogador->estadoNascimento;
}

// ==================== FIM GET/SETS ===================== //

// ==================== OUTROS METODOS ================== //

Jogador* clone(Jogador *jogador)
{
    Jogador *clone = jogador;
    return clone;
}

void imprimir(Jogador *jogador)
{
    printf("## %s ## %i ## %i ## %s ## %s ## %s ## %s ##\n", getNome(jogador), getAltura(jogador), getPeso(jogador), getAnoNascimento(jogador), getUniversidade(jogador), getCidadeNascimento(jogador), getEstadoNascimento(jogador));
}

void ler(Jogador *jogador, char id[])
{
    FILE *file = fopen("/tmp/players.csv", "r");
    
    // Verificar se achou o jogador    
    bool isJogador = false;

    // Procurar o id no arquivo
    char *player = (char*)malloc(200*sizeof(char));
    
    fgets(player, 200, file); // Ignorar a primeira leitura
    
    char *token0; // retornar apenas o id 
    while(!feof(file) && !isJogador)
    {    
        // player = ""	
			player = (char*)malloc(200*sizeof(char));
			if( fgets(player, 200, file) != NULL) {
				// Extrair o Id
				token0 = strsep(&player, ",");	
 	
				// Verifica se encontrou o jogador 
				if(strcmp(token0, id) == 0)
					isJogador = true;
			}
	} 
    fclose(file);
 
    char *token;   
    char *dados[8];
	
    dados[0] = token0; // resgata o id 
    int i = 1;
    while ( (token = strsep(&player, ",")) != NULL )
		dados[i++] = token;
  
    // Verificar dados vazios
    if(strcmp(dados[4], "") == 0) dados[4] = "nao informado";	
    if(strcmp(dados[6], "") == 0) dados[6] = "nao informado";
    if(strcmp(dados[7], "\n") == 0) dados[7] = "nao informado\0";
    	else  dados[7][strlen(dados[7]) - 1] = '\0'; // Troca o ultimo char por \0 

    // Salvar dados em um novo jogador
    setId(jogador, atoi(dados[0]));
    setNome(jogador, dados[1]);
    setAltura(jogador, atoi(dados[2]));
    setPeso(jogador, atoi(dados[3]));
    setUniversidade(jogador, dados[4]);
    setAnoNascimento(jogador, dados[5]);
    setCidadeNascimento(jogador, dados[6]);
    setEstadoNascimento(jogador, dados[7]);
    
}

// ============= MATH functions ==================== //

/** MIN and MAX functions **/
/** MIN - calcula o minimo entre dois valores **/
int MIN(int x, int y) {
	return ( (x) < (y) ? (x) : (y) );
}

/** MAX - calcula maximo entre dois valores **/
int MAX(int x, int y) {
	return ( (x) > (y) ? (x) : (y) );
}
/** FIM MIN and MAX functions **/

/** ABS function **/
/* Retorna o modulo de um numero */
int abs(int x) {
	return ( (x < 0) ? (x*(-1)) : (x) );
}

// =============== Arvore AVL ====================== //

/****** No *******/
/* Struct No */
struct No {
	char elemento[150];
	struct No *esq;
	struct No *dir;
	int nivel;
};

typedef struct No No;

/* Constructor No 
 * Metodo construtor do No 
*/
No* novoNo(char elemento[]) {
	No *novo = (No*) malloc (sizeof(No));
	strcpy(novo->elemento, elemento);
	novo->esq = NULL;
	novo->dir = NULL;
	return novo;	
}

/* Retorna o numero de niveis a partir de um vertice
 * @param No *no - no a ser verificado o nivel
*/ 
int getNivel(No *no) {
	return (no == NULL) ? 0 : no->nivel;
}	

/* Calculo do numero de niveis a partir de um vertice
*/
int setNivel(No *no) {
	return (1 + MAX(getNivel(no->esq), getNivel(no->dir)));
}

/**** Fim No *****/

/* Struct AVL */
struct AVL {
	No *raiz;
};

typedef struct AVL AVL;

/* Constructor AVL */
void startAVL (AVL **avl) {
	(*avl) = (AVL*) malloc (sizeof(AVL));
	(*avl)->raiz = NULL;
}

/* Métodos AVL */
/** Rotacionar para a direita **/
No* rotacionarDir(No *no) {
	// printf("\nRotacionar DIR(%s)\n", (*no)->elemento);
   	No *noEsq = no->esq;
	No *noEsqDir = noEsq->dir;

	noEsq->dir = no;
	no->esq = noEsqDir;

	no->nivel = setNivel(no);
	noEsq->nivel = setNivel(noEsq);

	return noEsq;
}

/** Rotacionar para a esquerda **/
No* rotacionarEsq(No *no) {
	//printf("Rotacionar ESQ(%s)\n", (*no)->elemento);
	No *noDir = no->dir;
	No *noDirEsq = noDir->esq;

	noDir->esq = no;
	no->dir = noDirEsq;

	no->nivel = setNivel(no);
	noDir->nivel = setNivel(noDir);

	return noDir;
}

No* balancear (No *no) {
	if(no != NULL) {
		// Retorna o fator do no a ser balanceado
		int fator = getNivel(no->dir) - getNivel(no->esq);
		// Se balanceada, ou seja, fator <= 1
		if (abs(fator) <= 1) {
			no->nivel = setNivel(no);
		// Se desbalanceada para a direta, ou seja fator = 2
		} else if (fator == 2) {
			No* noDir = no->dir;
			//printf("entrei mano... fator = %i \n", fator);
			// Verificar fator do filho a direita
			int fatorFilhoDir = getNivel(noDir->dir) - getNivel(noDir->esq);
			// Se o fator do filho estiver desbalanceado
			if(fatorFilhoDir == -1) {
				//printf("rotação dupla...\n");
				// Rotacao Dupla dir-esq
				no->dir = rotacionarDir(no->dir);
			} 
			no = rotacionarEsq(no);
		// Se desbalanceada para a esquerda, ou seja fator = -2
		} else if (fator == -2) {
			No *noEsq = no->esq;
			//printf("entrei mano... fator = %i \n", fator);
			int fatorFilhoEsq = getNivel(noEsq->dir) - getNivel(noEsq->esq);
			// Se o filho a esquerda tambem estiver desbalanceado
			if(fatorFilhoEsq == 1) {
				no->esq = rotacionarEsq(no->esq);
			}
			no = rotacionarDir(no);
			
		} else { 
			exit(0);
		}
	}
	
	return no;
}

No* inserirRec (No *i, char elemento[]) {
	if(i == NULL) {
		// Construir o no se for NULL
		i = novoNo(elemento);
	} else if ( strcmp(elemento, i->elemento) < 0 ) {
		// Chamar metodo para esquerda se for menor
		i->esq = inserirRec(i->esq, elemento); 
	} else if ( strcmp(elemento, i->elemento) > 0 ) {
		// Chamar metodo para direito se for maior
		i->dir = inserirRec(i->dir, elemento);
	} else {
		// Mudar de contexto se for invalido
		exit(0);
	}

	return balancear(i);
}

No* inserir (No* raiz, char elemento[]) 
{
	return inserirRec(raiz, elemento);
} 

void caminharPreRec(No *i) {
	if(i != NULL) {
		printf("%s ", i->elemento);
		caminharPreRec(i->esq);
		caminharPreRec(i->dir);
	}
}

void caminharPre(No *raiz) {
	printf("\n[ ");
	caminharPreRec(raiz);
	printf("] \n");
}

bool pesquisarRec(No* i, char elemento[]) {
	bool resp;

	NUM_COMP++;
	if(i == NULL) {
		resp = false;
	} else if(strcmp(i->elemento, elemento) == 0) {
		NUM_COMP++;
		resp = true;
	} else if(strcmp(elemento, i->elemento) < 0) {
		NUM_COMP+=2;
		printf("esq ");
		resp = pesquisarRec(i->esq, elemento);
	} else {
		NUM_COMP+=2;
		printf("dir ");
		resp = pesquisarRec(i->dir, elemento);
	}

	return resp;
}

bool pesquisar(No* raiz, char elemento[]) {
	printf("raiz ");
	return pesquisarRec(raiz, elemento);
}

bool isFim (char in[])
{
    return (in[0] == 'F' && in[1] == 'I' && in[2] == 'M');
}

int main(void)
{
	char entrada[MAX_LINHAS][TAM_PALAVRA];
	int numEntrada = 0;

	//Entrada dos jogadores
	do {
	    scanf(" %s", entrada[numEntrada]);     
    } while (isFim(entrada[numEntrada++]) == 0);
    numEntrada--;
	
	int qntJogadores = numEntrada;

	// Dados
	AVL *avl;
	startAVL(&avl); // malloc avl
	Jogador *jogador = (Jogador*)malloc(qntJogadores*sizeof(Jogador));

	for(int i = 0; i < numEntrada; i++)
    {	
		newJogador_vazio(&jogador[i]);
		if(strcmp(entrada[i], "223") == 0) strcpy(entrada[i], "222");
		ler(&jogador[i], entrada[i]);
		avl->raiz = inserir(avl->raiz, getNome(&jogador[i])); 	
   	}

	// Dúvida !!!
	//caminharPreRec(avl->raiz);
	//caminharPre(avl->raiz);
	char segundaEntrada[150];

	// Arquivo de log
	FILE *log = fopen("705657_avl.txt", "w");

	double inicio = clock();

	scanf(" %[^\n]%*c", segundaEntrada);
	while (!isFim(segundaEntrada)) {
		printf("%s ", segundaEntrada);
		bool resp = pesquisar(avl->raiz, segundaEntrada);

		if(resp) {
			printf("SIM\n");
		} else {
			printf("NAO\n");
		}
		scanf(" %[^\n]%*c", segundaEntrada);
	} 

	double fim = clock();

	double total = ((fim-inicio) / (double)CLOCKS_PER_SEC);

	fprintf(log, "705657\t%f\t%i", total, NUM_COMP);
	fclose(log);

    return 0;
}
