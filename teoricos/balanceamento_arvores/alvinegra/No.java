class No {
    // Cor do Nó
    public boolean cor;
    // Elemento do nó
    public int elemento;
    public No esq, dir;
    
    public No() {
        this(-1);
    }

    public No(int elemento) {
        this(elemento, false, null, null);
    }

    public No(int elemento, boolean cor) {
        this(elemento, cor, null, null);
    }

    public No(int elemento, boolean cor, No esq, No dir) {
        this.cor = cor;
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}