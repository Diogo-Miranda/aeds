#include "no.h"
#define bool  short
#define true  1
#define false 0

bool pesquisarRec(char , No*);
void caminharCentralRec(No*);
void caminharPreRec(No*);
void caminharPosRec(No*);
void inserirRec(char x, No** i);
void removerRec(char, No**);
void antecessor(No**, No**);
void removerRecSucessor(char, No**);
void sucessor(No**, No**);

void start();
bool pesquisar(char* x);
void caminharCentral();
void caminharPre();
void caminharPos();
void inserir(char);
void remover(char);
void removerSucessor(char);