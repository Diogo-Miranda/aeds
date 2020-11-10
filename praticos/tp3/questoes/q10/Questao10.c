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

// ===================== PILHA =================== //

struct Cedula {
	Jogador jogador;
	struct Cedula* prox;
};

typedef struct Cedula Cedula;

Cedula* novaCedula(Jogador* jogador) 
{
	Cedula* nova = (Cedula*)malloc(sizeof(Cedula));
	memcpy(&nova->jogador, jogador, sizeof(Jogador));
	nova->prox = NULL;
	
	return nova;
}

struct Pilha {
	Cedula* topo;
};

typedef struct Pilha Pilha;

// Init
void start(Pilha *pilha) 
{
	Jogador* cabeca = (Jogador*)malloc(sizeof(Jogador)); 
	pilha->topo = novaCedula(cabeca);
}

void inserirFim(Pilha *pilha, Jogador* x) 
{
	Cedula* nova = novaCedula(x);
	
	nova->prox = pilha->topo;
	pilha->topo = nova;
}

Jogador* removerFim(Pilha *pilha) 
{
	Cedula* topo = pilha->topo;

	Jogador* resp = (Jogador*)malloc(sizeof(Jogador));
	memcpy(resp, &topo->jogador, sizeof(Jogador));
		
	pilha->topo = pilha->topo->prox;
	
	free(topo);
	return resp;
}

int mostrarRec(Cedula* i, int pos) 
{
	if(getAltura(&i->jogador) != 0) {
		pos = mostrarRec(i->prox, pos);
		printf("[%i] ", pos-1);
		imprimir(&i->jogador);
	}

	return pos+1;
}

void mostrar(Pilha* pilha) 
{
	mostrarRec(pilha->topo, 0);
}



// ============== FIM PILHA =======================

void executarOperacao(Pilha* pilha, char* operacao) 
{
	char *token; // Para separar os dados
	char dados[3][40];
	
	int i = 0;
	while ( (token = strsep(&operacao, " ") ) != NULL )
		strcpy(dados[i++], token);

	Jogador *aux = (Jogador*)malloc(sizeof(Jogador));	
	if (strcmp(dados[0], "I") == 0) {
		ler(aux, dados[1]);
		inserirFim(pilha, aux);
	} else if (strcmp(dados[0], "R") == 0) {
		aux = removerFim(pilha);
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
	Pilha *pilha = (Pilha*)malloc(sizeof(Pilha));
	start(pilha);
    
	for(int i = 0; i < numEntrada; i++)
    {	
        newJogador_vazio(&jogador[i]);
        if(strcmp(entrada[i], "223") == 0) strcpy(entrada[i], "222");
        ler(&jogador[i], entrada[i]);
		inserirFim(pilha, &jogador[i]);
    }
			
	int numSegundaEntrada = 0;
	scanf(" %i", &numSegundaEntrada);
	
	char operacao[numSegundaEntrada][20];
	for(int j = 0; j < numSegundaEntrada; j++) 
	{	
		scanf(" %[^\n]%*c", operacao[j]);	
		executarOperacao(pilha, operacao[j]);
	}

	mostrar(pilha);	
	
    return 0;
}
