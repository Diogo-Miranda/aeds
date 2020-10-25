#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#define MAX_LINHAS  500
#define TAM_PALAVRA 500
#define MAX_TAM     1000

// GLOBAIS
int NUM_COMP = 0;
int NUM_MOV = 0;
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

bool isFim (char in[])
{
    return (in[0] == 'F' && in[1] == 'I' && in[2] == 'M');
}

// ===================== LISTA =================== //

struct Lista {
	Jogador array[MAX_TAM]; // Elementos
	int n;              // Quantidade 
};

typedef struct Lista Lista;

// Init
void start(Lista *lista) 
{
	lista->n = 0;
}

/**
 * Inserir elemento da primeira posicao da lista
 * @param int x elemento a ser inserido
 * @param Lista lista - lista a ser inserido
*/
void inserirInicio(Lista *lista, Jogador x) 
{
	if(lista->n >= MAX_TAM) {
		printf("Erro ao inserir!");
		exit(1);
	}

	// Levar elementos para fim do array
	int i;
	for(i = lista->n; i > 0; i--) {
		lista->array[i] = lista->array[i-1];
	}

	lista->array[0] = x;
	lista->n = lista->n + 1;
}

void inserirFim(Lista *lista, Jogador x) 
{
	if(lista->n >= MAX_TAM) {
		printf("Erro ao inserir!");
		exit(1);
	}

	lista->array[lista->n] = x;
	lista->n = lista->n + 1;
}

void inserir(Lista *lista, Jogador x, int pos) 
{
	if (lista->n >= MAX_TAM || pos < 0 || pos > lista->n) {
		printf("Erro ao inserir!");
		exit(1);
	}

	// Levar elementos para a posicao
	int i;
	for(i = lista->n; i > pos; i--) {
		lista->array[i] = lista->array[i-1];
	}	

	lista->array[pos] = x;
	lista->n = lista->n + 1;
}

Jogador* removerInicio(Lista *lista) 
{
	if(lista->n == 0) {
		printf("Erro ao remover!");
		exit(1);
	}

	Jogador *resp = (Jogador*)malloc(sizeof(Jogador));
	memcpy(resp, &lista->array[0], sizeof(Jogador));
	lista->n = lista->n - 1;

	int i;
	for(i = 0; i < lista->n; i++) 
		lista->array[i] = lista->array[i+1];

	return resp;
}

Jogador* removerFim(Lista *lista) 
{
	if(lista->n == 0) {
		printf("Erro ao remover!");
		exit(1);
	}
	
	Jogador* resp = (Jogador*)malloc(sizeof(Jogador));
	memcpy(resp, &lista->array[lista->n-1], sizeof(Jogador));

	lista->n = lista->n - 1;
	return resp;
}

Jogador* remover(Lista *lista, int pos) 
{
	if(lista->n == 0 || pos < 0 || pos >= lista->n) {
		printf("Erro ao remover!");
		exit(1);
	}

	Jogador* resp = (Jogador*)malloc(sizeof(Jogador));
	memcpy(resp, &lista->array[pos], sizeof(Jogador));
	lista->n--;

	int i;
	for(i = pos; i < lista->n; i++) { 
		lista->array[i] = lista->array[i+1];
	}

	return resp;
}

void mostrar(Lista *lista) 
{
	int i;
	for(i = 0; i < lista->n; i++) {
		printf("[%i] ", i);
		imprimir(&lista->array[i]);
	}
}

// ============== FIM LISTA =======================

void executarOperacao(Lista *lista, char* operacao) 
{
	char *token; // Para separar os dados
	char dados[3][10];
	
	int i = 0;
	while ( (token = strsep(&operacao, " ") ) != NULL )
		strcpy(dados[i++], token);

	Jogador *aux;
	if(strcmp(dados[0], "II") == 0) 
	{
		ler(aux, dados[1]);
		inserirInicio(lista, *aux);	
	} else if (strcmp(dados[0], "IF") == 0) {
			ler(aux, dados[1]);
			inserirFim(lista, *aux);
	} else if (strcmp(dados[0], "I*") == 0) {
			ler(aux, dados[2]);
			inserir(lista, *aux, atoi(dados[1]));
	} else if (strcmp(dados[0], "RI") == 0) {
			aux = removerInicio(lista);
			printf("(R) ");
			printf("%s\n", getNome(aux));
	} else if (strcmp(dados[0], "RF") == 0) {
			aux = removerFim(lista);
			printf("(R) ");
			printf("%s\n", getNome(aux));
	} else if (strcmp(dados[0], "R*") == 0) {
			aux = remover(lista, atoi(dados[1]));
			printf("(R) ");
			printf("%s\n", getNome(aux));
	}	
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

    Jogador *jogador = (Jogador*)malloc(qntJogadores*sizeof(Jogador));
	Lista *lista = (Lista*)malloc(sizeof(Lista));
	start(lista);
    
	for(int i = 0; i < numEntrada; i++)
    {	
        newJogador_vazio(&jogador[i]);
        if(strcmp(entrada[i], "223") == 0) strcpy(entrada[i], "222");
        ler(&jogador[i], entrada[i]);
		inserirFim(lista, jogador[i]);
    }
			
	int numSegundaEntrada = 0;
	scanf(" %i", &numSegundaEntrada);
	
	char operacao[numSegundaEntrada][20];
	for(int j = 0; j < numSegundaEntrada; j++) 
	{	
		scanf(" %[^\n]%*c", operacao[j]);	
		executarOperacao(lista, operacao[j]);
	}

	mostrar(lista);	
	
    return 0;
}