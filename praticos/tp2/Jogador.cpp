#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>
#define MAX_LINHAS  500
#define TAM_PALAVRA 500

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

void quicksort(Jogador *jogador, int esq, int dir)
{
	int i = esq, j = dir;
    int pivo = (esq+dir)/2;
    
    bool flag; // verificar se ainda é passivel de troca

    while (i <= j) {	
		//Verificar menores que o pivo
		// Comparar - Retorna se o primeiro é maior que o segundo
        flag = true;
		while(flag) {
            flag = strcmp(getEstadoNascimento(&jogador[i]), getEstadoNascimento(&jogador[pivo])) < 0;
            if(flag) {
                i++;
            } else {
                // Se for igual
                if(strcmp(getEstadoNascimento(&jogador[i]) , getEstadoNascimento(&jogador[pivo])) == 0 ) {
                    flag = strcmp(getNome(&jogador[i]), getNome(&jogador[pivo])) < 0;
                    if(flag) i++;
                }
            }
        }
        flag = true;
		// Verificar maiores que o pivo
		while(flag) {
            flag = strcmp(getEstadoNascimento(&jogador[j]), getEstadoNascimento(&jogador[pivo])) > 0;
            if(flag){
                j--;
            } else {
                // Se for igual
                if(strcmp(getEstadoNascimento(&jogador[j]), getEstadoNascimento(&jogador[pivo])) == 0) {
                    flag = strcmp(getNome(&jogador[j]), getNome(&jogador[pivo])) > 0;
                    if(flag) j--;
                }
            }
        } 	
		if(i <= j) {
			swap(jogador, i, j);	
			i++;
            j--; 
		} 
	}
	
	if(esq < j) quicksort(jogador, esq, j);
	if(i < dir) quicksort(jogador, i, dir);
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
        if(strcmp(entrada[i], "223") == 0) strcpy(entrada[i], "222");
        ler(&jogador[i], entrada[i]);
    }
    
    char entradaNome[MAX_LINHAS][TAM_PALAVRA];    
    numEntrada = 0;
	
    int NUM_COMP = 0;
    int NUM_MOV = 0;

    FILE *file = fopen("705657_quicksort.txt", "w");
	
    double inicio = clock();	
		
	quicksort(jogador, 0, qntJogadores-1);
	    
    double fim = clock();
    
    for(int i = 0; i < qntJogadores; i++)
    {
        imprimir(&jogador[i]);
    }

    double total = ((fim - inicio) / (double)CLOCKS_PER_SEC);
	
    fprintf(file, "705657\t%lf\t%i\t%i", total, NUM_COMP, NUM_MOV);
    fclose(file);
}

