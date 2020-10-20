#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//Prototipação
void leEntrada(int entrada[][1], int numEntrada);
bool isFim(int entrada[][1], int numEntrada);
int calculaAno(int ano);

int main()
{
    int entrada[1000][1];
    int numEntrada = 0;
    
    bool continuar;
    do
    {   
        leEntrada(entrada, numEntrada);
        continuar = isFim(entrada, numEntrada);
        numEntrada++;

    } while (continuar);
    
    numEntrada--;

    int anoCometa;

    for(int m = 0; m < numEntrada; m++)
    {
        anoCometa = calculaAno(entrada[m][0]);
        printf("%i\n", anoCometa);
    }

    return 0;
}

void leEntrada(int entrada[][1], int numEntrada)
{
   scanf("%i", &entrada[numEntrada][0]); 
}

bool isFim(int entrada[][1], int numEntrada)
{
    bool continuar = true;
    if( entrada[numEntrada][0] == 0) continuar = false;
    return continuar;
}

int calculaAno(int ano)
{
    int ultimaPassagem = 1986;

    while(ultimaPassagem <= ano)
    {
        ultimaPassagem += 76;
    }

    if(ultimaPassagem == ano)
    {
        ultimaPassagem += 76;
    }

    return ultimaPassagem;
}