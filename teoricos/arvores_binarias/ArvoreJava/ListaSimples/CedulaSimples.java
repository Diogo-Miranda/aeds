package ListaSimples;

public class CedulaSimples {
    public int elemento;
    public CedulaSimples prox;

    public CedulaSimples() {
        this(0);
    }

    public CedulaSimples(int elemento) {
        this.elemento = elemento;
        this.prox = null;
    }
}
 