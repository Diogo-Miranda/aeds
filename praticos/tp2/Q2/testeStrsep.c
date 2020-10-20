#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct Jogador {
	int id;	
	char *nome;
	int idade;
	int altura;
	int peso;
	char *universidade;
	char *anoNascimento;
	char *cidadeNascimento;
	char *estadoNascimento;
};

typedef struct Jogador Jogador;

int main(void)
{
	char *string, *found;

	string = strdup("2,Diogo,175,70,,2000,,");
	
	char *dados[8];
		
	int i  = 0;
	while ( (found = strsep(&string, ",")) != NULL )
		dados[i++] = found; 	
		
	// Tratar a string;
	if(strcmp(dados[4], " ")) dados[4] = "nao informado";
	if(strcmp(dados[6], " ")) dados[6] = "nao informado";
	if(strcmp(dados[7], " ")) dados[7] = "nao informado";	

	Jogador *jogador = (Jogador*)malloc(sizeof(Jogador));
	jogador->id = atoi(dados[0]);
	jogador->nome = dados[1];
	jogador->altura = atoi(dados[2]);
	jogador->peso = atoi(dados[3]);
	jogador->universidade = dados[4];
	jogador->anoNascimento = dados[5];
	jogador->cidadeNascimento = dados[6];
	jogador->estadoNascimento = dados[7];
	printf("[ %i ## %s ## %i ## %i ## %s ## %s ## %s ## %s ]", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->universidade, jogador->anoNascimento, jogador->cidadeNascimento, jogador->estadoNascimento); 
	return 0;
}
