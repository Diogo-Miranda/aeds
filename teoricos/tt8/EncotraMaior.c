#include <stdio.h>
#include <stdlib.h>
#define TAM 16

int main()
{
    int array[TAM];

    // Preencher Array com aleatorios
    for(int i = 0; i < TAM; i++)
    {
        array[i] = rand() % 100;
    }

    // Mostrar o array
    for(int i = 0; i < TAM; i++)
    {
        printf("[%i] = %i ", i, array[i]);
    }

    // Verificar o menor elemento do Array
    int maior = array[0];
    int menor = array[1];

    if(menor > maior) 
    {
        int aux = maior;
        maior = menor;
        menor = aux;
    }

    for(int i = 2; i < TAM; i++)
    {
        if(array[i] > maior)
            maior = array[i];
        else if(array[i] < menor)
            menor = array[i];
    }
        
    printf("\nMaior = %i", maior);
    printf("\nMenor = %i\n", menor);

    return 0;
}
