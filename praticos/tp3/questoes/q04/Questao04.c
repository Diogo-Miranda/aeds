#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>
#define MAX_LINHAS  500
#define TAM_PALAVRA 500
#define MAX_TAM 6 

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

int arredondar(double number)
{
	return (number >= 0) ? (int)(number + 0.5) : (int)(number - 0.5);
}

// ===================== FILA  =================== //

struct Fila {
	Jogador array[MAX_TAM+1];
	int primeiro;
	int ultimo;	
};

typedef struct Fila Fila;

// Init
void start(Fila *fila) 
{
	fila->primeiro = fila->ultimo = 0;
}

Jogador* remover(Fila *fila) {	
	if (fila->primeiro == fila->ultimo) {
		printf("Erro ao remover!");
		exit(1);
	}

	Jogador* resp = (Jogador*)malloc(sizeof(Jogador));
	memcpy(resp, &fila->array[fila->primeiro], sizeof(Jogador));
    fila->primeiro = (fila->primeiro + 1) % MAX_TAM;	

	return resp;
}

void inserir(Fila *fila, Jogador x) {
	// validar inserção
	if ( ((fila->ultimo+1) % MAX_TAM) == fila->primeiro ) {		
		printf("Erro ao inserir!");
		exit(1);
	}

	fila->array[fila->ultimo] = x;
	fila->ultimo = (fila->ultimo + 1) % MAX_TAM;
}

void mostrar(Fila *fila) 
{
	int i;
	int k = 0;	
	for(i = fila->primeiro; i != fila->ultimo; i = ((i + 1) % MAX_TAM)) {
		printf("[%i] ", k);
		imprimir(&fila->array[i]);
		k++;
	}
}

// ============== FIM FILA =======================

int calcularAltura(Fila *fila) {
	float soma = 0;
	int n = 0;
	int i;
	for(i = fila->primeiro; i != fila->ultimo; i = ((i + 1) % MAX_TAM)) {
		soma += getAltura(&fila->array[i]);
		n++;
	}

	double media = soma/n;
	int aux = media;
	double decimalRound = arredondar(media-aux);
	media = aux + decimalRound;	

	return (int)media;
}

bool isFull(Fila *fila) 
{
	return ( ( (fila->ultimo+1) % MAX_TAM ) == fila->primeiro );   
}

void executarOperacao(Fila *fila, char* operacao) 
{
	char *token; // Para separar os dados
	char dados[3][50];
	
	int i = 0;
	while ( (token = strsep(&operacao, " ") ) != NULL )
		strcpy(dados[i++], token);

	Jogador *aux;
	if(strcmp(dados[0], "I") == 0) 
	{
		ler(aux, dados[1]);
		if(isFull(fila)) remover(fila);
		inserir(fila, *aux);
		printf("%i\n", calcularAltura(fila));	
	} else if (strcmp(dados[0], "R") == 0) {
			aux = remover(fila);
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
	Fila *fila = (Fila*)malloc(sizeof(Fila));
	start(fila);
    
	for(int i = 0; i < numEntrada; i++)
    {	
        newJogador_vazio(&jogador[i]);
        if(strcmp(entrada[i], "223") == 0) strcpy(entrada[i], "222");
        ler(&jogador[i], entrada[i]);
		if(isFull(fila)) remover(fila);
		inserir(fila, jogador[i]);
		printf("%i\n", calcularAltura(fila));
    }
			
	int numSegundaEntrada = 0;
	scanf(" %i", &numSegundaEntrada);
	
	char operacao[numSegundaEntrada][20];
	for(int j = 0; j < numSegundaEntrada; j++) 
	{	
		scanf(" %[^\n]%*c", operacao[j]);	
		executarOperacao(fila, operacao[j]);
	}

	mostrar(fila);	
	
    return 0;
}
