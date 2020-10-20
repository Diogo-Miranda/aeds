#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>
#define MAX_LINHAS  400
#define TAM_PALAVRA 400

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

void swap(Jogador *jogador, int i, int j)
{
	Jogador aux = jogador[i];
	jogador[i] = jogador[j];
	jogador[j] = aux;
} 

int quicksort (Jogador *jogador, int esq, int dir)
{
	int numComp = 0;
	int i = esq, j = dir;	
	char *pivo = getNome(&jogador[(esq+dir)/2]); // pego a primeira letra do nome do jogador do meio
 	while(i <= j) {
		while(strcmp(getNome(&jogador[i]), pivo) < 0) {
			numComp++; i++;	
		}
		while(strcmp(getNome(&jogador[j]), pivo) > 0)  {
			numComp++; j--;
		}
		if( i <= j) {
			swap(jogador, i, j);
			i++;
			j--;
		}
	}	
	if(esq < j) numComp += quicksort(jogador, esq, j);
	if(i < dir) numComp += quicksort(jogador, i, dir);		
	
	return numComp;	
}

int buscaBinaria(Jogador *jogador, char *nomePesq, int tam)
{
	int numComp = 0;
	bool resp = false;
	int dir = tam-1, esq = 0, meio;	
	
	char *nome;
	char *auxNome; // Gurda um ponteiro para a string contida
	while(esq <= dir) {
		meio = (esq + dir) / 2;
		nome = getNome(&jogador[meio]);
		// Retorna NULL se nao houver nenhuma semelhanca
		auxNome = strstr(nome, nomePesq); // Contains	
		// Se houver alguma semelhanca entre as duas Strings
		if(auxNome != NULL) {
			numComp++;
			resp = true;
			esq = dir + 1;
		} else if (strcmp(nomePesq, nome) > 0) {
			numComp++;
			esq = meio + 1;
		} else {
			dir = meio - 1;
		} 
	}
	
	if(resp) printf ("SIM\n");
		else printf ("NAO\n");		
	return numComp;	
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
    for(int i = 0; i < numEntrada; i++)
    {	
        newJogador_vazio(&jogador[i]);
        ler(&jogador[i], entrada[i]);
    }
	
	char entradaNome[MAX_LINHAS][TAM_PALAVRA];    
	numEntrada = 0;

    //Entrada do nome de pesquisa 
    do {
		scanf(" %[^\n]%*c", entradaNome[numEntrada]);	
    } while (isFim(entradaNome[numEntrada++]) == 0);
    numEntrada--;
	
	FILE *file = fopen("705657_binaria.txt", "w");
	
	double inicio = clock();
		
	int numComp = 0;	

	numComp += quicksort(jogador, 0, qntJogadores-1); 
	
	for(int i = 0; i < numEntrada; i++) 
	{		
		numComp += buscaBinaria(jogador, entradaNome[i], qntJogadores);
	} 
	
	double fim = clock();
	
	double total = ((fim - inicio) / (double)CLOCKS_PER_SEC);
	
	fprintf(file, "705657\t%lf\t%i", total, numComp);
	fclose(file);
}

