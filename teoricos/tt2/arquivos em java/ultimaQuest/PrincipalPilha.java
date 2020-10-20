
/*
 * Esta classe tem a função de oferecer opções para manipulação de uma pilha
 * salva em um arquivo pilha.dat
*/
class PrincipalPilha {
    
    /*
     * Salvar os elementos de uma pilha em um arquivo
     * @param Pilha pilha - a pilha a ser salva
    */
    public static void salvarElementosArq(Pilha pilha)
    {
        Arq arq = new Arq();

        arq.openWrite("pilha.dat");
        
        String[] aux = pilha.getPilha();
        int tam = pilha.getQntElementos();

        String conteudo = "";
        for(int i = 0; i < tam; i++)
        {
            conteudo = conteudo + aux[i] + "\n";
        }

        arq.println(conteudo);

        arq.close();
    }
    
    /*
     * Carregar os elementos de um arquivo em uma pilha
     * @param Pilha pilha - pilha a ser salva os elementos
    */
    public static void carregarElementosArq(Pilha pilha)
    {   
        Arq arq = new Arq();

        arq.openRead("pilha.dat");

        while(arq.hasNext())
        {
            pilha.inserir(arq.readLine());
        }

        arq.close();
    }

    public static void main (String[] args)
    {
        Pilha pilha = new Pilha();
        carregarElementosArq(pilha);
         
        boolean sair = false;
        int opt = 0;
        do
        {
            MyIO.println("(1) - Inserir");
            MyIO.println("(2) - Remover");
            MyIO.println("(3) - Listar");
            MyIO.println("(4) - Sair : ");
            opt = MyIO.readInt();
            switch (opt) {
                case 1 :
                    pilha.inserir(MyIO.readLine("Informe elemento a ser inserido: "));
                    break;
                case 2 :
                    pilha.remover();
                    break;
                case 3 :
                    pilha.listar();
                    break;
                case 4 :
                    sair = true;
                    break;
                default :
                    MyIO.println("Inválido");
                    break;
            }            
        
        }while(!sair);
        
        salvarElementosArq(pilha);

        
    }
}
