#include <stdio.h>

void write(FILE *file)
{
    int qnt, num;

    printf("\nInforme quantidade de numeros : ");
    scanf("%i", &qnt);
    
    for(int i = 0; i < qnt; i++)
    {
       
        printf("\nInforme o um numero inteiro: ");
        scanf("%i", &num);
        fwrite(&num, sizeof(int), 1, file);
    }
} // end write

void read(FILE *file)
{
    int num;
    
    fread(&num, sizeof(int), 1, file);
    while(!feof(file))
    {
        printf("\n%i", num);
        fread(&num, sizeof(int), 1, file);
    }
}

int main()
{
    FILE *file = fopen("teste.txt", "wb");
    write(file);
    fclose(file);

    file = fopen("teste.txt", "rb");
    read(file);
    fclose(file);
    return 0;   
}
