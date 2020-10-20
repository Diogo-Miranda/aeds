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

void inverseRead(FILE *file, int qnt)
{
    int num;

    int size = sizeof(int);
    fseek(file, -(size) , SEEK_END);
    for(int i = 0; i < qnt; i++)
    {
        fread(&num, sizeof(int), 1, file);
        printf("\n%i", num);   
        size += sizeof(int);
        fseek(file, -(size), SEEK_END);
    }
} // end inverseRead

int main()
{
    FILE *file = fopen("teste.txt", "wb");
    int qnt = write(file);
    fclose(file);

    file = fopen("teste.txt", "rb");
    inverseRead(file, qnt);
    fclose(file);

    return 0;
}
