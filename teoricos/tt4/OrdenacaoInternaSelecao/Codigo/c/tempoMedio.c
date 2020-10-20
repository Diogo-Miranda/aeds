#include <stdio.h>

int main()
{   
    // Ler aquivo
    FILE *arq = fopen("decrescente10000.txt", "r");


    double num = 0;
    double media = 0;
    int count = 0;

    fscanf(arq, "%lf", &num);
    count++;
    while(!feof(arq))
    { 
        media += num; 

        fscanf(arq, "%lf", &num);
        count++;
    }
    count--; // tira a leitura do fim do arquivo 
        
    media = media/count;

    fclose(arq);

    printf("\n%lf\n", media);
    return 0;
}
