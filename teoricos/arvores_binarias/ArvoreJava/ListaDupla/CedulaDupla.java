package ListaDupla;

public class CedulaDupla {
    public int elemento;
    public CedulaDupla ant;
    public CedulaDupla prox;

    public CedulaDupla() {
        this(0);
    }

    public CedulaDupla(int elemento) {
        this.elemento = elemento;
        this.ant = null;
        this.prox = null;
    }
}
 