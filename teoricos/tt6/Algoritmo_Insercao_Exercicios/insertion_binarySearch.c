#include <stdio.h>
#include <stdbool.h>
#define SIZE 11

bool isOrdenado(int array[])
{
    bool ordenado = true;
    
    int menor = array[0];
    for(int i = 1; i < SIZE && ordenado == true; i++)
    {
        if(array[i] < menor)
        {
            ordenado = false;
        } else
        {
            menor = array[i];
        }
    }

    return ordenado;

}

int main()
{
    int array[] = {1, 785452, 5, 2, 25, 2, 115, 0, 0, 10, 5};

    for(int i = 1; i < SIZE; i++)
    {
        int tmp = array[i];
        int j = i - 1;
        int left = 0;  // Esquerda da busca binária 
        int right = j; // Direita da busca binária
        while( (j >= 0) && (array[j] > tmp))
        {
            int middle = (right+left)/2;
            // Se for maior que meu temporario eu desloco e continuo a busca pela metade do array
            if(array[middle] >= tmp)
            {
                for(int k = j; k >= middle; k--)
                {
                    array[k+1] = array[k];
                }
                j = middle - 1;
                right = j;
            } else {     
                // Se não for eu desloco minha busca para o grupo mais a direita do array
                left = middle + 1; 
            } 
        }
        array[j+1] = tmp;
    }

    

    printf("\nisOrdenado : %i\n", isOrdenado(array));

    return 0;
}
