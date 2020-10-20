class Celula {
	public int elemento;
	public Celula ant;
	public Celula prox;

	public Celula() {
		this(0);
	}
		
	public Celula(int elemento) {
		this.elemento = elemento;
		ant = null;
		prox = null;	
	}

}
