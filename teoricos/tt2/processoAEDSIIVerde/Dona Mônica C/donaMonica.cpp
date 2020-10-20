#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//Prototipação
void leitura(int entrada[][3], int numEntrada);
bool isFim(int entrada[][3], int numEntrada);

int main()
{
    int entrada[1000][3];
    int numEntrada = 0;
    bool fim = false;


    do
    {
        leitura(entrada, numEntrada);
        fim = isFim(entrada, numEntrada);
        numEntrada++;  
    }
    while (fim == false);
    
    numEntrada--;

    int idadeFilhoVelho;

    for(int m = 0; m < numEntrada; m++)
    {
        idadeFilhoVelho = entrada[m][0] - entrada[m][1] - entrada[m][2];
        printf("%i\n", idadeFilhoVelho);
    }


    return 0;
}

void leitura(int entrada[][3], int numEntrada)
{
    bool fim = false;
    int i = 0;
    while(fim == false && i < 3)
    {
        scanf("%i", &entrada[numEntrada][i]);
        i++;
        fim = isFim(entrada, numEntrada);
    }
}

bool isFim(int entrada[][3], int numEntrada)
{
    bool sair;
    if(entrada[numEntrada][0] == 0)
    {
        sair = true;
    }else
    {
        sair = false;
    }

    return sair;
    
}