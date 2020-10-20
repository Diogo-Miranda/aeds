
class Pilha {
    private String[] pilha;
    private int qntElementos;
    
    public Pilha()
    {
        pilha = new String[1000];
        qntElementos = 0;
    }
    
    public String[] getPilha()
    {
        return pilha;
    }

    public int getQntElementos()
    {
        return qntElementos;
    }

    public void listar()
    {
       for(int i = 0; i < qntElementos; i++)
       {
           MyIO.println(pilha[i]);
       }
    }
    
    public void remover()
    {
        pilha[qntElementos-1] = "";
        qntElementos--;
    }

    public void inserir(String elemento)
    {
        if(qntElementos <= pilha.length){
            pilha[qntElementos] = elemento;
            qntElementos++;
        }   
    }

}
