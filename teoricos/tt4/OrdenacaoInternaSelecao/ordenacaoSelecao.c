#include <stdio.h>
#define TAM 6

void swap(int array[], int menor, int i)
{
    int aux = array[i];
    array[i] = array[menor];
    array[menor] = aux;
}

int main()
{
    int array[TAM] = {101, 115, 30, 63, 47, 20};
    int n = TAM;
    int menor;
    int mov = 0;
    for(int i = 0; i < n-1; i++) {
        menor = i;
        for(int j = i + 1; j < n; j++) {
            if(array[menor] > array[j]) 
                menor = j;
        }
        swap(array, menor, i);
        mov += 3;
    }

    printf("%i", mov);

    return 0;
}
