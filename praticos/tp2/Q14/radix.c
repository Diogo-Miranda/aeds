#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void sort(int array[], int k, int n, int tam) {
    int pval = (int)pow((double)k, (double)n);

    int size = tam;
    int index;
    index = (array[0] / pval) % k;
    int maior = array[index];
    // Verificar o maior elemento na pos indicada
    for(int i = 0; i < size; i++) {
        index = (array[0] / pval) % k;
        if(maior < array[index]) 
            maior = array[index];
    }

    // Criar vetor count
    int counting[maior+1];
    for(int i = 0; i <= maior; i++) counting[i] = 0; // init

    // Preencher o vetor count
    for(int i = 0; i < size; i++) {
        index = (array[i] / pval) % k;
        counting[index]++;
    }

    // Fazer couting acumular os elementos menores que ele
    for(int i = 1; i <= maior; i++)  counting[i] += counting[i-1];
    
    int ordenado[size];
    // Ordenação propriamente dita
    for(int i = (size-1); i >= 0; i--) {
        index = (array[i] / pval) % k;

        ordenado[counting[index]-1] = array[i];

        counting[index]--;
    }

    for(int i = 0; i < size; i++) {
        array[i] = ordenado[i];
    }

}

void radixSort(int array[], int tam) {
    // Quantidade maxima de dígitos
    int k = 10; // base 10
    for(int i = 0; i < 3; i++) {
        sort(array, k, i, tam);
    }

}

int main()
{
    int array[] = {100, 51, 10, 3, 202, 3};
    int tam = 6;

    radixSort(array, tam);

    for(int i = 0; i < tam; i++) {
        printf(" %i ", array[i]);
    }
    
    return 0;
}