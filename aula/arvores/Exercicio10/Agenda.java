public class Agenda {
    No raiz;

    public Agenda() {
        // inserir todas letras do alfabeto...
    }

    public No inserir(No no, Contato contato) {
        char characterFlag = Character.toUpperCase(contato.getNome().charAt(0));
        if (no == null) {
            no = new No(characterFlag);
            no.primeiro = no.ultimo = new Celula(); // Celula cabeça
            no.ultimo.prox = new Celula(contato);
            no.ultimo = no.ultimo.prox;
        }
    }

    public void inserir(Contato contato) throws Exception{
       if( Character.isLetter(contato.getNome().charAt(0)) {
           raiz = inserir(raiz, contato);
       } else {
           throw new Exception("Erro ao inserir");
       }
    }
}
