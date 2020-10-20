class Celula {
	public Celula prox;
	public Celula ant;
	public Celula sup;
	public Celula inf;
	public int elemento;	
	
	public Celula() {
		this(0);
	}
		
	public Celula(int elemento) {
		this.elemento = elemento;
		this.prox = null;
		this.ant = null;
		this.sup = null;
		this.inf = null;
	}
}
