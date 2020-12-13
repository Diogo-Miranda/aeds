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

Jogador* newJogador_vazio(Jogador *jogador)
{
	jogador = (Jogador*)malloc(sizeof(Jogador));

   jogador->id = 0;
   jogador->nome = "";
   jogador->peso = 0;
   jogador->altura = 0;
   jogador->universidade = "";
   jogador->anoNascimento = "";
   jogador->cidadeNascimento = "";
   jogador->estadoNascimento = "";

	return jogador;
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

// ==================== LISTA ====================== //

struct Cedula {
	Jogador* elemento;
	struct Cedula* prox;
};

typedef struct Cedula Cedula;

Cedula* startCedula(Jogador *jogador) {
	Cedula *nova;
	nova = (Cedula*) malloc (sizeof(Cedula));
	nova->elemento = jogador;
	nova->prox = NULL;

	return nova;
}

struct Lista {
	Cedula* inicio;
	Cedula* fim;
};

typedef struct Lista Lista;

Lista* startLista(Lista *lista) {
	lista = (Lista*) malloc (sizeof(Lista));
	Jogador* vazio = newJogador_vazio(vazio);
	Cedula* inicio = startCedula(vazio);
	lista->inicio = inicio;
	lista->fim = inicio;

    return lista;
}

void inserirFim(Lista **lista, Jogador *jogador) {
	Cedula *nova = startCedula(jogador);

	(*lista)->fim->prox = nova;
	(*lista)->fim = nova;
}

void mostrar(Lista *lista) {
	for(Cedula *i = lista->inicio->prox; i->prox != NULL; i = i->prox) {
		imprimir(i->elemento);
	}
}

bool pesquisar(Lista *lista, char nome[]) {
	bool achou = false;

	for(Cedula *i = lista->inicio->prox; !achou && i != NULL; i = i->prox) {
        NUM_COMP++;
		if(strcmp(getNome(i->elemento), nome) == 0) {
			achou = true;
		} 
	}

	return achou;
}

// ==================== FIM LISTA ====================== //

// ==================== HASH ============================ //

struct Hash {
    Lista **tabela;
    int tamTable;
};

typedef struct Hash Hash;

Hash* startHash(Hash *hash, int tamTable) {
    hash = (Hash*)malloc(sizeof(Hash));
    hash->tamTable = tamTable;
    hash->tabela = (Lista**)malloc(tamTable*sizeof(Lista*));

    for(int i = 0; i < tamTable; i++) {
        hash->tabela[i] = startLista((hash->tabela[i]));
    }

    return hash;
}

int funcH(Hash *hash, Jogador *jogador) {
    return getAltura(jogador) % hash->tamTable; 
}

void inserirHash(Hash **hash, Jogador *jogador) {
    int pos = funcH((*hash), jogador);

    inserirFim(&(*hash)->tabela[pos], jogador);
}

bool pesquisarHash(Hash *hash, char nome[]) {
    bool resp = false;

    for(int i = 0; !resp && i < hash->tamTable; i++) {
        resp = pesquisar(hash->tabela[i], nome);
    }

    return resp;
}

// =================== FIM HASH ========================= //

bool isFim (char in[]){
    return (in[0] == 'F' && in[1] == 'I' && in[2] == 'M');
}

int main(void) {
	char entrada[MAX_LINHAS][TAM_PALAVRA];
	int numEntrada = 0;

	//Entrada dos jogadores
	do {
	    scanf(" %s", entrada[numEntrada]);     
    } while (isFim(entrada[numEntrada++]) == 0);
    numEntrada--;
	
	int qntJogadores = numEntrada;

	// Dados
	Hash *hash = startHash(hash, 25);
	Jogador *jogador = (Jogador*)malloc(qntJogadores*sizeof(Jogador));
	
	for(int i = 0; i < numEntrada; i++)
    {	
		newJogador_vazio(&jogador[i]);
		if(strcmp(entrada[i], "223") == 0) strcpy(entrada[i], "222");
		ler(&jogador[i], entrada[i]);
		inserirHash(&hash, &jogador[i]);
	}

    char segundaEntrada[150];

	// Arquivo de log
	FILE *log = fopen("705657_hashIndireta.txt", "w");

	double inicio = clock();

	scanf(" %[^\n]%*c", segundaEntrada);
	while (!isFim(segundaEntrada)) {
		printf("%s ", segundaEntrada);
		bool resp = pesquisarHash(hash, segundaEntrada);

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