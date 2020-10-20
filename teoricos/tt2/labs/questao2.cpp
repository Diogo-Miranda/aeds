#include <iostream>
#include <stdbool.h>

using namespace std;

/* Repita o exercício acima considerando que os elementos do
array estão ordenados de forma crescente. Uma sugestão
seria começar a pesquisa pelo meio do array
*/

bool estaContido(int array[], int num)
{
    bool contem = false;

    int i = 0;
    for(; i < sizeof(array)/2; i++) 
    {
        if(num == array[i])
        {
            contem = true;
            i = sizeof(array);
        } else 
        {
            if(num > array[i])
            {
                int j = sizeof(array)/2;
                for(;j < sizeof(array); j++)
                {
                    if(num == array[j])
                    {
                        contem = true;
                        j = sizeof(array);
                        i = sizeof(array);
                    }
                }
            }
        }
    }

    return contem;
}

int main()
{
    int array[5] = {1,2,3,4,5};
    int num = 5;
    bool contem = estaContido(array, num);
    cout << contem;

    return 0;
}

    


