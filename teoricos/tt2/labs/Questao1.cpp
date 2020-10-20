#include <iostream>
#include <stdbool.h>

using namespace std;

// Faça um método que receba um array de inteiros e um
// número inteiro x e retorne um valor booleano informando se o
// elemento x está contido no array

bool estaContido(int array[], int num)
{
    bool achou = false;
    
    int i = 0;

    while(!achou && i < sizeof(array))
    {
        if(num == array[i]) achou = true;
        i++;
    }

    return achou;
}

int main()
{
    int array[5] = {1,2,3,4,5};
    int num = 0;    
    bool flag = estaContido(array, num);

    cout << "\n" << flag << "\n";

    return 0;
}
