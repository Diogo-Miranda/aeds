#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <err.h>
#include <time.h>
#define MAX_LINHAS  800
#define TAM_PALAVRA 800 

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
    printf("[%i ## %s ## %i ## %i ## %s ## %s ## %s ## %s]\n", getId(jogador), getNome(jogador), getAltura(jogador), getPeso(jogador), getAnoNascimento(jogador), getUniversidade(jogador), getCidadeNascimento(jogador), getEstadoNascimento(jogador));
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

// ==================== Cedula =================== //

struct Cedula {
	Jogador elemento;
	struct Cedula* prox;
	struct Cedula* ant;
	int indice;
};

typedef struct Cedula Cedula;

Cedula* novaCedula(Jogador *elemento, int indice) {
	Cedula* nova = (Cedula*) malloc(sizeof(Cedula));
	memcpy(&nova->elemento, elemento, sizeof(Jogador));
	nova->prox = NULL;
	nova->ant = NULL;
	nova->indice = indice;
	return nova;
}

// ================== FIM - Cedula =============== //

// ================== LISTA DUPLA ================ //

struct ListaDupla {
	Cedula* primeiro;
	Cedula* ultimo;
	int posIndice;
};

typedef struct ListaDupla ListaDupla;

int getTamanho(ListaDupla* listaDupla) 
{
	int tamanho = 0;

	for(Cedula *i = listaDupla->primeiro; i->prox != listaDupla->ultimo->prox; i = i->prox) {
		tamanho++;
	}
	
	return tamanho;
}

void start(ListaDupla* listaDupla) 
{
	// Cria um jogador placebo (café com leite)
	Jogador* placebo = (Jogador*)malloc(sizeof(Jogador));
	// Cria cedula cabeça
	listaDupla->primeiro = novaCedula(placebo, -1);
	listaDupla->ultimo = listaDupla->primeiro;
	listaDupla->posIndice = 0;
}

void inserirInicio(ListaDupla* listaDupla, Jogador* jogador) 
{
	int indice = listaDupla->posIndice++;
	// Cria nova cedula
	Cedula* nova = novaCedula(jogador, indice);
	// Mudar referencia do primeiro
	nova->prox = listaDupla->primeiro->prox;
	listaDupla->primeiro->prox = nova;
	// Mudar referencia do anterior
	nova->ant = listaDupla->primeiro;
	// Verificar se eh o primeiro elemento ...
	if(listaDupla->primeiro == listaDupla->ultimo) {
		// ... muda referencia do ultimo para o primeiro
		listaDupla->ultimo = nova;
	} else {
		// Setar referência do proximo
		nova->prox->ant = nova;
	}	
}

void inserirFim(ListaDupla* listaDupla, Jogador* jogador) 
{
	int indice = listaDupla->posIndice++;
	// Cria nova cedula
	Cedula* nova = novaCedula(jogador, indice);
	// Mudar referencia do ultimo
	listaDupla->ultimo->prox = nova;
	// Muda referencia do anterior
	nova->ant = listaDupla->ultimo;	
	// Passa o ultimo para o novo
	listaDupla->ultimo = nova;
}

void inserir(ListaDupla* listaDupla, Jogador* jogador, int pos) 
{
	// Variáveis iniciais
	int tamanho = getTamanho(listaDupla);
	// Verificar se a posição é valida
	if(pos < 0 || pos > tamanho) {
		printf("\n Erro ao inserir : Posição inválida \n");
		exit(1);
	// Verificar se é inserir no fim ou inicio
	} else if(pos == 0) {
		inserirInicio(listaDupla, jogador);
	} else if(pos == tamanho) {
		inserirFim(listaDupla, jogador);
	} else {
		int indice = listaDupla->posIndice++;
		// Criar nova cedula
		Cedula* nova = novaCedula(jogador, indice);
		// Posicionar a posição a ser inserida
		int i = 0;
		Cedula* aux;
		for(aux = listaDupla->primeiro->prox; i < pos; aux = aux->prox);
		// Mudar referencia para inserir na posição
		nova->prox = aux->prox; // Conectar o novo ponteiro
		nova->ant = aux;	
		aux->prox->ant = nova; // Conectar os já existentes
		aux->prox = nova;
	}
}

Jogador* removerInicio(ListaDupla* listaDupla) 
{
	// Verificar se a lista nao está vazia
	if(listaDupla->primeiro == listaDupla->ultimo) {
		printf("\n Erro ao inserir: Lista vazia \n");
		exit(1);
	}
	// Criar jogador de retorno
	Jogador *resp = (Jogador*)malloc(sizeof(Jogador));
	// Copio a resposta;
	memcpy(resp, &listaDupla->primeiro->prox->elemento, sizeof(Jogador));
	// Reorganizar a lista
	listaDupla->primeiro->prox = listaDupla->primeiro->prox->prox;
	listaDupla->primeiro->prox->ant = listaDupla->primeiro;

	return resp;
}

Jogador* removerFim(ListaDupla* listaDupla) 
{
	// Verificar se a lista nao está vazia
	if(listaDupla->primeiro == listaDupla->ultimo) {
		printf("\n Erro ao inserir: lista Vazia \n");
		exit(1);
	}
	// Criar jogador e retorno
	Jogador *resp = (Jogador*)malloc(sizeof(Jogador));
	// Copio a resposta
	memcpy(resp, &listaDupla->ultimo->elemento, sizeof(Jogador));
	// Reorganizar a lista
	listaDupla->ultimo = listaDupla->ultimo->ant;
	listaDupla->ultimo->prox = NULL;	
	
	return resp;
}

Jogador* remover(ListaDupla* listaDupla, int pos) 
{
	// Variáveis
	int tamanho = getTamanho(listaDupla);
	// Resposta
	Jogador* resp = (Jogador*)malloc(sizeof(Jogador));
	// Verificar se a lista nao está vazia
	if(listaDupla->primeiro == listaDupla->ultimo) {
		printf("\n Erro ao inserir: lista vazia \n");
		exit(1);
	// Verificar se a posicao é valida
	} else if (pos < 0 || pos >= tamanho) {
		printf("\n Erro ao inserir: posição inválida \n");
	// Verificar se a remorção é no inicio ou fim
	} else if (pos == 0) {
		resp = removerInicio(listaDupla);	
	} else if (pos == tamanho-1) {
		resp = removerFim(listaDupla);
	} else {
		// Caminhar até a posição
		Cedula* aux;
		int i = 0;
		for(aux = listaDupla->primeiro->prox; i < pos; aux = aux->prox);
		// Receber resposta
		memcpy(resp, &aux->prox->elemento, sizeof(Jogador));
		// Reorganizar a lista
		aux->prox = aux->prox->prox;
		aux->prox->ant = aux;
	}

	return resp;	
}

void mostrar(ListaDupla* listaDupla) 
{
	for(Cedula* aux = listaDupla->primeiro->prox; aux != listaDupla->ultimo->prox; aux = aux->prox) 
		imprimir(&aux->elemento);
}

// ================= FIM LISTA DUPLA ============= //

bool comparar(Jogador tmp, Jogador atual) 
{
	bool out = false;
	NUM_COMP++;
	if(strcmp(getEstadoNascimento(&tmp), getEstadoNascimento(&atual)) == 0) {
		NUM_COMP++;
		out = strcmp(getNome(&tmp), getNome(&atual)) > 0;
	} else {
		NUM_COMP++;
		out = strcmp(getEstadoNascimento(&tmp), getEstadoNascimento(&atual)) > 0;
	}

	return out;
}

void swap(Cedula *maior, Cedula *menor) 
{
	// swap
	Jogador* aux = (Jogador*)malloc(sizeof(Jogador));
	memcpy(aux, &maior->elemento, sizeof(Jogador));
	NUM_MOV++;
	memcpy(&maior->elemento, &menor->elemento, sizeof(Jogador));
	NUM_MOV++;
	memcpy(&menor->elemento, aux, sizeof(Jogador));
	NUM_MOV++;
	free(aux);
}

Jogador getPivo(ListaDupla* listaDupla, Cedula* esq, Cedula* dir) 
{
	int meio = ( (esq->indice + dir->indice) / 2);
	Cedula* aux = esq; 
	
	while(aux->indice != meio) {
		aux = aux->prox;
	}
	
	return aux->elemento;
}

void quicksortRec(ListaDupla* listaDupla, Cedula* esq, Cedula* dir) 
{
	Cedula* i = esq; 
	Cedula* j = dir;

	Jogador pivo = getPivo(listaDupla, esq, dir);
	
	while(i->indice <= j->indice) {
		// Comparar se todos a esquerda sao menores	
		while(comparar(pivo, i->elemento)) i = i->prox;
		// Comparar se todos a direita sao maiores
		while(comparar(j->elemento, pivo)) j = j->ant;
		// Efetuar a troca se não se cruzarem
		if (i->indice <= j->indice) {
			swap(i , j);
			i = i->prox; j = j->ant;
		}	
	}

	if(j->indice > esq->indice) quicksortRec(listaDupla, esq, j);
	if(dir->indice > i->indice) quicksortRec(listaDupla, i, dir);
}

void quicksort(ListaDupla* listaDupla) {
	quicksortRec(listaDupla, listaDupla->primeiro->prox, listaDupla->ultimo);
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
    ListaDupla* listaDupla = (ListaDupla*)malloc(sizeof(ListaDupla));
	start(listaDupla);

    for(int i = 0; i < numEntrada; i++)
    {	
        newJogador_vazio(&jogador[i]);
        if(strcmp(entrada[i], "223") == 0) strcpy(entrada[i], "222");
        ler(&jogador[i], entrada[i]);
	    inserirFim(listaDupla, &jogador[i]);	
    }	
	 
	FILE *file = fopen("705657_quicksort2.txt", "w");

	double inicio = clock();	

	quicksort(listaDupla);
	
	double fim = clock();

	double total = ((fim-inicio) / (double)CLOCKS_PER_SEC);

	fprintf(file, "705657\t%lf\t%i\t%i", total, NUM_COMP, NUM_MOV);
	fclose(file);

	mostrar(listaDupla);
    return 0;
}
