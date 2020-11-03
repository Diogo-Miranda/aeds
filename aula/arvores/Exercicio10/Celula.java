public class Celula 
{
    Contato contato;
    Celula prox;

    Celula() {
        contato = null;
        prox = null;
    }

    Celula(Contato contato, Celula prox) {
        this.contato = contato;
        this.prox = prox;
    }

    Celula(Contato contato){
        this(contato, null);
    }
}
