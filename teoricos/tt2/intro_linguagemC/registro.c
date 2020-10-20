#include <stdio.h>
#define MAXTAM    100

/*
 *
 * Registro 
*/


struct Funcionario {
        int matricula;
        char nome[MAXTAM];
};

int main()
{
    struct Funcionario f;

    printf("\nEntre com a matricula: ");
    scanf("%d", &f.matricula);
    fflush(stdin);

    printf("\nEntre com o nome: ");
    
    scanf("%s", f.nome);

    printf("\nMatricula: %d", f.matricula);
    printf("\nNome: %s", f.nome);

   
    return 0;
}
