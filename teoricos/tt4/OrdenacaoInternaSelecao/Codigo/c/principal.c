#include "bolha.h"
#include "countingsort.h"
#include "heapsort.h"
#include "insercao.h"
#include "mergesort.h"
#include "quicksort.h"
#include "selecao.h"
#include "shellsort.h"

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdlib.h>
//=============================================================================
int main(int argc, char **argv) {

    //Delcaracao de variaveis
    int n = (argc < 2) ? 1000 : atoi(argv[1]);
    int *array = (int*) malloc(n*sizeof(int));
    clock_t inicio, fim;
    double total;

    // Arquivo para salvar os dados
    FILE *file = fopen("decrescente.txt", "aw+"); 

    //Geracao do conjunto a ser ordenado
	 //aleatorio(array, n);
	 crescente(array, n);
	 //decrescente(array, n);


    //Mostrar o conjunto a ser ordenado
	 //mostrar(array, n);
		

    //Execucao do algoritmo de ordenacao
	 inicio = clock();
    //bolha(array, n);
    //countingsort(array, n);
    //heapsort(array, n);
    //insercao(array, n);
    //mergesort(array, n);
    //quicksort(array, n);
    //selecao(array, n);
    //shellsort(array, n);
    
    // Selecao 
    int numMov = 0;
    for(int i = 1; i < n; i++)
    {
        int tmp = array[i];
        int j = i - 1;
        while( j >= 0 && array[j] > tmp)
        {
            array[j + 1] = array[j];
            numMov++;
            j--;
        }
        numMov++;
        array[j+1] = tmp;
    }

	 fim = clock();

     // Contar num comparacoes
    //int numMov = 0;
    //int menor = 0;
    //int aux;
    //int numComp = 0;
    // n-(i+1) = n-i-1
    /*for(int i = 0; i < n-1; i++)
    {
        menor = i;
        for(int j = i+1; j < n; j++)
        {
            numComp++;
            if(array[menor] > array[j])
                menor = j;
        }
        // Swap
        aux = array[i];
        array[i] = array[menor];
        array[menor] = aux;
        numMov += 3;
    }*/

    printf("\nNumero de movimentacoes = %i\n", numMov);
    //printf("\nNumero de comparacoes = %i\n", numComp);
    total = ((double)(fim - inicio) / (double)CLOCKS_PER_SEC);    
    fprintf(file, "%lf\n", total);

    //fclose(file);
    //Mostrar o conjunto ordenado, tempo de execucao e status da ordenacao
	 //algoritmo.mostrar(array, n);
	 printf("Tempo para ordenar: %f s.\n", total);
	 printf("isOrdenado: %s\n", isOrdenado(array, n) ? "true" : "false");

    //Desalocar o espaco de memoria do array
    free(array);

    return 0;
}
