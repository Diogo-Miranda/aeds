#include <stdio.h>

int write(FILE *file)
{
    int num, qnt;

    printf("\nInforme a quantidade de numeros: ");
    scanf("%i", &qnt);

    for(int i = 0; i < qnt; i++)
    {
        printf("\nInforme um numero: ");
        scanf("%i", &num);
        fwrite(&num, sizeof(int), 1, file);
    }

    return qnt;
} // end write

void somarNumeros(FILE *file, int qnt)
{
    int numUm, numDois, result; 
      
    int size = sizeof(int);
    for(int i = 0; i < qnt; i++)
    { 
        fseek(file, i*size, SEEK_SET);
        fread(&numUm, sizeof(int), 1, file);
    
        fseek(file, -((i+1)*size), SEEK_END); // Fim
        fread(&numDois,sizeof(int), 1, file);
        
        result = numUm + numDois; 
        printf("\n%i", result);
    }   

}

int main()
{
    FILE *file = fopen("teste.txt", "wb");
    int qnt = write(file);
    fclose(file);

    file = fopen("teste.txt", "rb");
    somarNumeros(file, qnt);
    fclose(file);
    return 0;
}
