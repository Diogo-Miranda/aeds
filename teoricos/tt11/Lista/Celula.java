class Celula {
	public Celula prox;
	public int elemento;

	public Celula() {
		this(0);
	}

	public Celula(int elemento) {
		this.elemento = elemento;
		this.prox = null;
	}
	

}
