#include <stdio.h>
 
void funcaoJogo();
void funcaoIncendio();
 
int main (void)
{
    int opcao;
    
    printf ("Menu de opcoes:\n");
    printf("1 - Para jogo da velha\n2 - Para simulacao de incendio\n");
    printf("Digite sua opcao: ");
    scanf("%d", &opcao);
    
    switch (opcao)
    {
        case 1 :
            funcaoJogo();
            break;
        
        case 2 :
            funcaoIncendio();
            break;
        
        default :
            printf ("Digite uma opcao valida!\n");
            return 0;
    }
}

//procedimento do jogo da vida
void funcaoJogo(){
    printf("\nCodigo do jogo");
    
}
//procedimento da simulação de icendio
void funcaoIncendio(){
    printf("\nCodigo incendio");
 
}